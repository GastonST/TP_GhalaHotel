package dao;

import clase.Reserva;
import bd.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ReservaDAO {
    private Connection conexion;

    public ReservaDAO() {
        this.conexion = ConexionBD.obtenerConexion();
    }

    public boolean registrarReserva(Reserva reserva) {
        // Consulta para insertar una nueva reserva
        String sqlInsert = "INSERT INTO Reserva (fecha_ingreso, fecha_salida, estado_reserva, cantidad_huesped, id_cliente, id_habitacion, id_estacionamiento, id_pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Consulta para verificar disponibilidad de la habitación
        String sqlCheck = "SELECT COUNT(*) FROM Reserva WHERE id_habitacion = ? AND (fecha_ingreso <= ? AND fecha_salida >= ?)";

        try (PreparedStatement checkStmt = conexion.prepareStatement(sqlCheck);
             PreparedStatement insertStmt = conexion.prepareStatement(sqlInsert)) {

            // Verificar si la habitación está ocupada
            checkStmt.setInt(1, reserva.getIdHabitacion());
            checkStmt.setDate(2, java.sql.Date.valueOf(reserva.getFechaSalida()));
            checkStmt.setDate(3, java.sql.Date.valueOf(reserva.getFechaIngreso()));

            ResultSet resultSet = checkStmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            // Si la habitación está ocupada, no se registra la reserva
            if (count > 0) {
                System.out.println("La habitación está ocupada en las fechas seleccionadas.");
                return false;
            }

            // Preparar la consulta para insertar la nueva reserva
            insertStmt.setDate(1, java.sql.Date.valueOf(reserva.getFechaIngreso()));
            insertStmt.setDate(2, java.sql.Date.valueOf(reserva.getFechaSalida()));
            insertStmt.setString(3, "Confirmado"); // Establecer el estado como "Confirmado"
            insertStmt.setInt(4, reserva.getCantidadHuesped());
            insertStmt.setInt(5, reserva.getIdCliente());
            insertStmt.setInt(6, reserva.getIdHabitacion());
            insertStmt.setInt(7, reserva.getIdEstacionamiento());
            insertStmt.setInt(8, reserva.getIdPago());

            int rowsAffected = insertStmt.executeUpdate();
            return rowsAffected > 0; // Retorna verdadero si se insertó correctamente
        } catch (SQLException e) {
            System.out.println("Error al registrar reserva: " + e.getMessage());
            return false; // Retorna falso en caso de error
        }
    }

    // Método para obtener todas las habitaciones
    public List<Integer> obtenerTodasLasHabitaciones() {
        List<Integer> habitaciones = new ArrayList<>();
        String query = "SELECT id_habitacion FROM habitaciones";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idHabitacion = resultSet.getInt("id_habitacion");
                habitaciones.add(idHabitacion);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener habitaciones: " + e.getMessage());
        }

        return habitaciones;
    }

    // Método para obtener habitaciones disponibles
    public List<Integer> obtenerHabitacionesDisponibles(LocalDate fechaIngreso, LocalDate fechaSalida) {
        List<Integer> habitacionesDisponibles = new ArrayList<>();
        List<Integer> todasLasHabitaciones = obtenerTodasLasHabitaciones();

        // Consulta SQL para encontrar habitaciones ocupadas en las fechas solicitadas
        String query = "SELECT id_habitacion FROM reservas WHERE (fecha_ingreso <= ? AND fecha_salida >= ?)";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, java.sql.Date.valueOf(fechaSalida));
            statement.setDate(2, java.sql.Date.valueOf(fechaIngreso));
            ResultSet resultSet = statement.executeQuery();

            // Almacena las habitaciones ocupadas
            List<Integer> habitacionesOcupadas = new ArrayList<>();
            while (resultSet.next()) {
                habitacionesOcupadas.add(resultSet.getInt("id_habitacion"));
            }

            // Verifica las habitaciones disponibles
            for (int idHabitacion : todasLasHabitaciones) {
                if (!habitacionesOcupadas.contains(idHabitacion)) {
                    habitacionesDisponibles.add(idHabitacion);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener habitaciones disponibles: " + e.getMessage());
        }

        return habitacionesDisponibles;
    }


    // Método para obtener todas las reservas
    public List<Reserva> obtenerReserva() {
        List<Reserva> reservas = new ArrayList<>();
        String query = "SELECT * FROM reserva";

        try (PreparedStatement ps = conexion.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("id_reserva"));
                reserva.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
                reserva.setFechaSalida(rs.getDate("fecha_salida").toLocalDate());
                reserva.setEstadoReserva(rs.getString("estado_reserva"));
                reserva.setCantidadHuesped(rs.getInt("cantidad_huesped"));
                reserva.setIdCliente(rs.getInt("id_cliente"));
                reserva.setIdHabitacion(rs.getInt("id_habitacion"));
                reserva.setIdEstacionamiento(rs.getInt("id_estacionamiento"));
                reserva.setIdPago(rs.getInt("id_pago"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas: " + e.getMessage());
        }

        return reservas;
    }

    // Método para obtener una reserva por su ID
    public Reserva obtenerReservaPorId(int idReserva) {
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva WHERE id_reserva = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idReserva);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("id_reserva"));
                reserva.setFechaIngreso(resultSet.getDate("fecha_ingreso").toLocalDate());
                reserva.setFechaSalida(resultSet.getDate("fecha_salida").toLocalDate());
                reserva.setEstadoReserva(resultSet.getString("estado_reserva"));
                reserva.setCantidadHuesped(resultSet.getInt("cantidad_huesped"));
                reserva.setIdCliente(resultSet.getInt("id_cliente"));
                reserva.setIdHabitacion(resultSet.getInt("id_habitacion"));
                reserva.setIdEstacionamiento(resultSet.getInt("id_estacionamiento"));
                reserva.setIdPago(resultSet.getInt("id_pago"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserva;
    }

    // Método para actualizar una reserva existente
    public void actualizarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET fecha_ingreso = ?, fecha_salida = ?, estado_reserva = ?, cantidad_huesped = ?, id_cliente = ?, id_habitacion = ?, id_estacionamiento = ?, id_pago = ? WHERE id_reserva = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setDate(1, java.sql.Date.valueOf(reserva.getFechaIngreso()));
            statement.setDate(2, java.sql.Date.valueOf(reserva.getFechaSalida()));
            statement.setString(3, reserva.getEstadoReserva());
            statement.setInt(4, reserva.getCantidadHuesped());
            statement.setInt(5, reserva.getIdCliente());
            statement.setInt(6, reserva.getIdHabitacion());
            statement.setInt(7, reserva.getIdEstacionamiento());
            statement.setInt(8, reserva.getIdPago());
            statement.setInt(9, reserva.getIdReserva());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean borrarReserva(int idReserva) {
        String sql = "DELETE FROM reserva WHERE id_reserva = ?";
        try (Connection connection = ConexionBD.obtenerConexion(); //
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idReserva);
            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0; // Devuelve true si se eliminó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si hubo un error
        }
    }



}
