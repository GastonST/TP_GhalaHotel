package clase;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String estadoReserva;
    private int cantidadHuesped;
    private int idCliente;
    private int idHabitacion;
    private int idEstacionamiento;
    private int idPago;

    // Constructor vacío
    public Reserva() {}

    // Constructor con parámetros
    public Reserva(LocalDate fechaIngreso, LocalDate fechaSalida, String estadoReserva, int cantidadHuesped, int idCliente, int idHabitacion, int idEstacionamiento, int idPago) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estadoReserva = estadoReserva;
        this.cantidadHuesped = cantidadHuesped;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.idEstacionamiento = idEstacionamiento;
        this.idPago = idPago;
    }

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getCantidadHuesped() {
        return cantidadHuesped;
    }

    public void setCantidadHuesped(int cantidadHuesped) {
        this.cantidadHuesped = cantidadHuesped;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(int idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
}
