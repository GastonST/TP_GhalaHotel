package vista;

import java.util.Scanner;
import clase.Cliente;
import clase.Reserva;
import clase.Pago;
import clase.Personal;
import dao.ClienteDAO;
import dao.MetodoPagoDAO;
import dao.PersonalDAO;
import dao.ReservaDAO;
import java.time.LocalDate;
import java.util.List;
import java.util.InputMismatchException;


public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("------------------------------------");
            System.out.println("Menu Principal: Ghala Hotel Salta");
            System.out.println("------------------------------------");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar personal");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Gestionar reserva");
            System.out.println("5. Registrar estacionamiento");
            System.out.println("6. Gestionar estacionamiento");
            System.out.println("7. Salir");
            System.out.println("------------------------------------");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextLine().trim();

            try {
                if (opcion.isEmpty()) {
                    System.out.println("Entrada vacía, por favor ingrese una opción.");
                    continue;
                }

                switch (opcion) {
                    case "1":
                        registrarCliente();
                        break;
                    case "2":
                        registrarPersonal();
                        break;
                    case "3":
                        realizarReserva();
                        break;
                    case "4":
                        mostrarSubmenuReserva();
                        break;
                    case "5":
                        registrarEstacionamiento();
                        break;
                    case "6":
                        mostrarSubmenuEstacionamiento();
                        break;
                    case "7":
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (!opcion.equals("7")); // Verifica si la opción es diferente de 7
    }

    private void registrarCliente() {
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();
        System.out.print("DNI: ");
        String dni = scanner.nextLine().trim();
        System.out.print("Número de contacto: ");
        String numeroContacto = scanner.nextLine().trim();
        System.out.print("Correo: ");
        String correo = scanner.nextLine().trim();

        Cliente cliente = new Cliente(nombre, apellido, dni, numeroContacto, correo);
        ClienteDAO clienteDAO = new ClienteDAO();

        boolean exito = clienteDAO.registrarCliente(cliente);
        if (exito) {
            System.out.println("Cliente registrado exitosamente.");
        } else {
            System.out.println("Hubo un problema al registrar el cliente.");
        }
    }

    // Método de registro de personal
    private void registrarPersonal() {
        System.out.println("Registro de nuevo personal");

        System.out.print("Número de empleado: ");
        String numeroEmpleado = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Turno: ");
        String turno = scanner.nextLine();

        System.out.print("ID del cargo: ");
        int idCargo = Integer.parseInt(scanner.nextLine());

        // Crear un objeto Personal con los datos ingresados
        Personal personal = new Personal(numeroEmpleado, nombre, apellido, dni, telefono, turno, idCargo);

        PersonalDAO personalDAO = new PersonalDAO();
        if (personalDAO.registrarPersonal(personal)) {
            System.out.println("Personal registrado exitosamente.");
        } else {
            System.out.println("Error al registrar personal.");
        }
    }
    //reserva
    private void realizarReserva() {
        // Se captura los datos necesarios para crear una reserva
        System.out.println("Ingrese fecha de ingreso (YYYY-MM-DD) ej: 2024-11-01: ");
        String fechaIngresoStr = scanner.nextLine();
        LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr);

        System.out.println("Ingrese fecha de salida (YYYY-MM-DD) ej: 2024-11-05: ");
        String fechaSalidaStr = scanner.nextLine();
        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);

        System.out.println("Ingrese cantidad de huéspedes: ");
        int cantidadHuesped = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese ID del cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese ID de la habitación: ");
        int idHabitacion = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese ID del estacionamiento (0 si no aplica): ");
        int idEstacionamiento = Integer.parseInt(scanner.nextLine());


        // Mostrar métodos de pago
        MetodoPagoDAO metodoPagoDAO = new MetodoPagoDAO();
        List<Pago> metodosPago = metodoPagoDAO.obtenerMetodosPago();
        System.out.println("Seleccione un método de pago:");

        for (int i = 0; i < metodosPago.size(); i++) {
            Pago pago = metodosPago.get(i);
            System.out.println((i + 1) + ". " + pago.getMetodoPago());
        }

        int seleccion;
        do {
            System.out.print("Ingrese el número del método de pago: ");
            seleccion = Integer.parseInt(scanner.nextLine());
        } while (seleccion < 1 || seleccion > metodosPago.size()); // Validar selección

        // Obtener el ID del método de pago seleccionado
        int idPago = metodosPago.get(seleccion - 1).getIdPago();



        // Crear objeto reserva
        Reserva reserva = new Reserva(fechaIngreso, fechaSalida, "Confirmado", cantidadHuesped, idCliente, idHabitacion, idEstacionamiento, idPago);

        ReservaDAO reservaDAO = new ReservaDAO();
        if (reservaDAO.registrarReserva(reserva)) {
            System.out.println("Reserva registrada exitosamente.");
        } else {
            System.out.println("Error al registrar la reserva.");
        }
    }


    private void registrarEstacionamiento() {
        System.out.println("Función de registro de estacionamiento.");
        // Implementar la lógica de registro de estacionamiento
    }

    private void mostrarSubmenuReserva() {
        String opcionSubmenu;
        do {
            System.out.println("------------------------------");
            System.out.println("---- Gestión de Reservas ----");
            System.out.println("------------------------------");
            System.out.println("1. Ver lista de reservas");
            System.out.println("2. Modificar una reserva");
            System.out.println("3. Borrar una reserva");
            System.out.println("4. Volver");
            System.out.println("------------------------------");
            System.out.print("Ingrese una opción: ");

            opcionSubmenu = scanner.nextLine().trim();

            try {
                if (opcionSubmenu.isEmpty()) {
                    System.out.println("Entrada vacía, por favor ingrese una opción.");
                    continue;
                }

                switch (opcionSubmenu) {
                    case "1":
                        verListaReservas();
                        break;
                    case "2":
                        modificarReserva();
                        break;
                    case "3":
                        borrarReserva();
                        break;
                    case "4":
                        System.out.println("Volviendo al menú principal.");
                        break;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (!opcionSubmenu.equals("4")); // Verifica si la opción es diferente de 4
    }


    private void verListaReservas() {
        ReservaDAO reservaDAO = new ReservaDAO();
        List<Reserva> reservas = reservaDAO.obtenerReserva();

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            // Imprimir encabezados de la tabla
            System.out.printf("%-5s %-15s %-15s %-10s %-15s %-10s %-10s %-15s %-10s%n",
                    "ID", "Fecha Ingreso", "Fecha Salida", "Estado", "Huéspedes", "ID Cliente", "N°Habitación", "N°Estacionamiento", "Forma de Pago");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");

            // Imprimir cada reserva en formato de tabla
            for (Reserva reserva : reservas) {
                System.out.printf("%-5d %-15s %-15s %-15s %-15d %-10d %-10d %-15d %-20d%n",
                        reserva.getIdReserva(),
                        reserva.getFechaIngreso(),
                        reserva.getFechaSalida(),
                        reserva.getEstadoReserva(),
                        reserva.getCantidadHuesped(),
                        reserva.getIdCliente(),
                        reserva.getIdHabitacion(),
                        reserva.getIdEstacionamiento(),
                        reserva.getIdPago());
            }
        }
    }
//---------------------Modificacion Reserva-----------------------
private void modificarReserva() {
    ReservaDAO reservaDAO = new ReservaDAO();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el ID de la reserva que desea modificar: ");
    int idReserva = scanner.nextInt();
    scanner.nextLine(); // Limpiar el buffer

    // Buscar la reserva
    Reserva reserva = reservaDAO.obtenerReservaPorId(idReserva);
    if (reserva == null) {
        System.out.println("No se encontró una reserva con ese ID.");
        return;
    }

    boolean continuar = true;

    while (continuar) {
        // Mostrar datos actuales de la reserva
        System.out.println("Datos actuales de la reserva:");
        System.out.printf("1. ID: %d%n", reserva.getIdReserva());
        System.out.printf("2. Fecha Ingreso: %s%n", reserva.getFechaIngreso());
        System.out.printf("3. Fecha Salida: %s%n", reserva.getFechaSalida());
        System.out.printf("4. Estado: %s%n", reserva.getEstadoReserva());
        System.out.printf("5. Cantidad de Huéspedes: %d%n", reserva.getCantidadHuesped());
        System.out.printf("6. ID Cliente: %d%n", reserva.getIdCliente());
        System.out.printf("7. ID Habitación: %d%n", reserva.getIdHabitacion());
        System.out.printf("8. ID Estacionamiento: %d%n", reserva.getIdEstacionamiento());
        System.out.printf("9. ID Pago: %d%n", reserva.getIdPago());

        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Fecha de Ingreso");
        System.out.println("2. Fecha de Salida");
        System.out.println("3. Estado");
        System.out.println("4. Cantidad de Huéspedes");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese la nueva fecha de ingreso (YYYY-MM-DD): ");
                String nuevaFechaIngresoStr = scanner.nextLine();
                LocalDate nuevaFechaIngreso = LocalDate.parse(nuevaFechaIngresoStr); // Convierte el String a LocalDate
                reserva.setFechaIngreso(nuevaFechaIngreso);
                break;
            case 2:
                System.out.print("Ingrese la nueva fecha de salida (YYYY-MM-DD): ");
                String nuevaFechaSalidaStr = scanner.nextLine();
                LocalDate nuevaFechaSalida = LocalDate.parse(nuevaFechaSalidaStr); // Convierte el String a LocalDate
                reserva.setFechaSalida(nuevaFechaSalida);
                break;
            case 3:
                System.out.print("Ingrese nuevo estado de la reserva (Confirmado/Cancelado): ");
                String nuevoEstado = scanner.nextLine();
                reserva.setEstadoReserva(nuevoEstado);
                break;
            case 4:
                System.out.print("Ingrese nueva cantidad de huéspedes: ");
                int nuevaCantidadHuesped = scanner.nextInt();
                reserva.setCantidadHuesped(nuevaCantidadHuesped);
                scanner.nextLine(); // Limpiar el buffer
                break;
            case 5:
                continuar = false;
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }

        // Mostrar un mensaje de confirmación
        if (continuar) {
            System.out.println("Modificación realizada con éxito.");
        }
    }

    // Guardar los cambios
    reservaDAO.actualizarReserva(reserva);
    System.out.println("Reserva modificada con éxito.");
}

//---------------------------------Borrado de reserva------------------------------------------

    private void borrarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la reserva que desea borrar: ");
        int idReserva = scanner.nextInt();

        ReservaDAO reservaDAO = new ReservaDAO();

        // Verifica si la reserva existe antes de intentar borrarla
        Reserva reserva = reservaDAO.obtenerReservaPorId(idReserva);

        if (reserva == null) {
            System.out.println("No se encontró una reserva con ese ID.");
            return; // Sale del método si no se encontró la reserva
        }

        // Procede a borrar la reserva
        boolean eliminado = reservaDAO.borrarReserva(idReserva);

        if (eliminado) {
            System.out.println("Reserva con ID " + idReserva + " ha sido eliminada exitosamente.");
        } else {
            System.out.println("Ocurrió un error al intentar eliminar la reserva.");
        }
    }

    public void mostrarSubmenuEstacionamiento() {
        String opcionSubmenu;
        do {
            System.out.println("------------------------------------");
            System.out.println("---- Gestión de Estacionamiento ----");
            System.out.println("------------------------------------");
            System.out.println("1. Ver lugares disponibles");
            System.out.println("2. Ver lugares ocupados");
            System.out.println("3. Listar estacionamiento");
            System.out.println("4. Modificar lugar");
            System.out.println("5. Borrar lugar");
            System.out.println("6. Volver");
            System.out.println("------------------------------------");
            System.out.print("Ingrese una opción: ");

            opcionSubmenu = scanner.nextLine().trim();

            try {
                if (opcionSubmenu.isEmpty()) {
                    System.out.println("Entrada vacía, por favor ingrese una opción.");
                    continue;
                }

                switch (opcionSubmenu) {
                    case "1":
                        verLugaresDisponibles();
                        break;
                    case "2":
                        verLugaresOcupados();
                        break;
                    case "3":
                        listarEstacionamiento();
                        break;
                    case "4":
                        modificarLugar();
                        break;
                    case "5":
                        borrarLugar();
                        break;
                    case "6":
                        System.out.println("Volviendo al menú principal.");
                        break;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (!opcionSubmenu.equals("6")); // Verifica si la opción es diferente de 6
    }


    private void verLugaresDisponibles() {
        System.out.println("Mostrando lugares disponibles.");

    }

    private void verLugaresOcupados() {
        System.out.println("Mostrando lugares ocupados.");

    }

    private void listarEstacionamiento() {
        System.out.println("Mostrando listado de estacionamiento.");

    }

    private void modificarLugar() {
        System.out.println("Función para modificar un lugar de estacionamiento.");

    }

    private void borrarLugar() {
        System.out.println("Función para borrar un lugar de estacionamiento.");

    }
}
