-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2024 a las 22:28:11
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ghala_hotel_salta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL,
  `tipo_cargo` varchar(50) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `tipo_cargo`, `descripcion`) VALUES
(1, 'Recepcionista', 'Encargado de la atención al cliente y gestión de reservas'),
(2, 'Conserje', 'Encargado de recibir a los huéspedes y gestionar el estacionamiento'),
(3, 'Gerente', 'Encargado de la administración del hotel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `numero_contacto` varchar(20) DEFAULT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `dni`, `numero_contacto`, `correo`) VALUES
(1, 'Juan', 'Pérez', '12345678', '123456789', 'juan.perez@example.com'),
(2, 'María', 'González', '87654321', '987654321', 'maria.gonzalez@example.com'),
(3, 'Carlos', 'Ramírez', '11223344', '456789123', 'carlos.ramirez@example.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estacionamiento`
--

CREATE TABLE `estacionamiento` (
  `id_estacionamiento` int(11) NOT NULL,
  `numero_plaza` varchar(11) NOT NULL,
  `estado_plaza` varchar(20) NOT NULL,
  `precio_hora` decimal(10,2) NOT NULL,
  `precio_dia` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estacionamiento`
--

INSERT INTO `estacionamiento` (`id_estacionamiento`, `numero_plaza`, `estado_plaza`, `precio_hora`, `precio_dia`) VALUES
(1, 'A01', 'Disponible', '5.00', '20.00'),
(2, 'A02', 'Ocupado', '5.00', '20.00'),
(3, 'A03', 'Disponible', '5.00', '20.00'),
(4, 'A04', 'Ocupado', '5.00', '20.00'),
(5, 'A05', 'Disponible', '5.00', '20.00'),
(6, 'A06', 'Ocupado', '5.00', '20.00'),
(7, 'A07', 'Disponible', '5.00', '20.00'),
(8, 'A08', 'Ocupado', '5.00', '20.00'),
(9, 'A09', 'Disponible', '5.00', '20.00'),
(10, 'A10', 'Ocupado', '5.00', '20.00'),
(11, 'B01', 'Disponible', '5.00', '20.00'),
(12, 'B02', 'Ocupado', '5.00', '20.00'),
(13, 'B03', 'Disponible', '5.00', '20.00'),
(14, 'B04', 'Ocupado', '5.00', '20.00'),
(15, 'B05', 'Disponible', '5.00', '20.00'),
(16, 'B06', 'Ocupado', '5.00', '20.00'),
(17, 'B07', 'Disponible', '5.00', '20.00'),
(18, 'B08', 'Ocupado', '5.00', '20.00'),
(19, 'B09', 'Disponible', '5.00', '20.00'),
(20, 'B10', 'Ocupado', '5.00', '20.00'),
(21, 'C01', 'Disponible', '5.00', '20.00'),
(22, 'C02', 'Ocupado', '5.00', '20.00'),
(23, 'C03', 'Disponible', '5.00', '20.00'),
(24, 'C04', 'Ocupado', '5.00', '20.00'),
(25, 'C05', 'Disponible', '5.00', '20.00'),
(26, 'C06', 'Ocupado', '5.00', '20.00'),
(27, 'C07', 'Disponible', '5.00', '20.00'),
(28, 'C08', 'Ocupado', '5.00', '20.00'),
(29, 'C09', 'Disponible', '5.00', '20.00'),
(30, 'C10', 'Ocupado', '5.00', '20.00'),
(31, 'D01', 'Disponible', '5.00', '20.00'),
(32, 'D02', 'Ocupado', '5.00', '20.00'),
(33, 'D03', 'Disponible', '5.00', '20.00'),
(34, 'D04', 'Ocupado', '5.00', '20.00'),
(35, 'D05', 'Disponible', '5.00', '20.00'),
(36, 'D06', 'Ocupado', '5.00', '20.00'),
(37, 'D07', 'Disponible', '5.00', '20.00'),
(38, 'D08', 'Ocupado', '5.00', '20.00'),
(39, 'D09', 'Disponible', '5.00', '20.00'),
(40, 'D10', 'Ocupado', '5.00', '20.00'),
(41, 'E01', 'Disponible', '5.00', '20.00'),
(42, 'E02', 'Ocupado', '5.00', '20.00'),
(43, 'E03', 'Disponible', '5.00', '20.00'),
(44, 'E04', 'Ocupado', '5.00', '20.00'),
(45, 'E05', 'Disponible', '5.00', '20.00'),
(46, 'E06', 'Ocupado', '5.00', '20.00'),
(47, 'E07', 'Disponible', '5.00', '20.00'),
(48, 'E08', 'Ocupado', '5.00', '20.00'),
(49, 'E09', 'Disponible', '5.00', '20.00'),
(50, 'E10', 'Ocupado', '5.00', '20.00'),
(51, 'F01', 'Disponible', '5.00', '20.00'),
(52, 'F02', 'Ocupado', '5.00', '20.00'),
(53, 'F03', 'Disponible', '5.00', '20.00'),
(54, 'F04', 'Ocupado', '5.00', '20.00'),
(55, 'F05', 'Disponible', '5.00', '20.00'),
(56, 'F06', 'Ocupado', '5.00', '20.00'),
(57, 'F07', 'Disponible', '5.00', '20.00'),
(58, 'F08', 'Ocupado', '5.00', '20.00'),
(59, 'F09', 'Disponible', '5.00', '20.00'),
(60, 'F10', 'Ocupado', '5.00', '20.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id_habitacion` int(11) NOT NULL,
  `numero_habitacion` int(11) NOT NULL,
  `tipo_habitacion` varchar(50) NOT NULL,
  `precio_noche` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id_habitacion`, `numero_habitacion`, `tipo_habitacion`, `precio_noche`) VALUES
(1, 1, 'Individual', '50.00'),
(2, 2, 'Doble', '80.00'),
(3, 3, 'Suite', '150.00'),
(4, 4, 'Individual', '50.00'),
(5, 5, 'Doble', '80.00'),
(6, 6, 'Suite', '150.00'),
(7, 7, 'Individual', '50.00'),
(8, 8, 'Doble', '80.00'),
(9, 9, 'Suite', '150.00'),
(10, 10, 'Individual', '50.00'),
(11, 11, 'Doble', '80.00'),
(12, 12, 'Suite', '150.00'),
(13, 13, 'Individual', '50.00'),
(14, 14, 'Doble', '80.00'),
(15, 15, 'Suite', '150.00'),
(16, 16, 'Individual', '50.00'),
(17, 17, 'Doble', '80.00'),
(18, 18, 'Suite', '150.00'),
(19, 19, 'Individual', '50.00'),
(20, 20, 'Doble', '80.00'),
(21, 21, 'Suite', '150.00'),
(22, 22, 'Individual', '50.00'),
(23, 23, 'Doble', '80.00'),
(24, 24, 'Suite', '150.00'),
(25, 25, 'Individual', '50.00'),
(26, 26, 'Doble', '80.00'),
(27, 27, 'Suite', '150.00'),
(28, 28, 'Individual', '50.00'),
(29, 29, 'Doble', '80.00'),
(30, 30, 'Suite', '150.00'),
(31, 31, 'Individual', '50.00'),
(32, 32, 'Doble', '80.00'),
(33, 33, 'Suite', '150.00'),
(34, 34, 'Individual', '50.00'),
(35, 35, 'Doble', '80.00'),
(36, 36, 'Suite', '150.00'),
(37, 37, 'Individual', '50.00'),
(38, 38, 'Doble', '80.00'),
(39, 39, 'Suite', '150.00'),
(40, 40, 'Individual', '50.00'),
(41, 41, 'Doble', '80.00'),
(42, 42, 'Suite', '150.00'),
(43, 43, 'Individual', '50.00'),
(44, 44, 'Doble', '80.00'),
(45, 45, 'Suite', '150.00'),
(46, 46, 'Individual', '50.00'),
(47, 47, 'Doble', '80.00'),
(48, 48, 'Suite', '150.00'),
(49, 49, 'Individual', '50.00'),
(50, 50, 'Doble', '80.00'),
(51, 51, 'Suite', '150.00'),
(52, 52, 'Individual', '50.00'),
(53, 53, 'Doble', '80.00'),
(54, 54, 'Suite', '150.00'),
(55, 55, 'Individual', '50.00'),
(56, 56, 'Doble', '80.00'),
(57, 57, 'Suite', '150.00'),
(58, 58, 'Individual', '50.00'),
(59, 59, 'Doble', '80.00'),
(60, 60, 'Suite', '150.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_estacionamiento`
--

CREATE TABLE `historial_estacionamiento` (
  `id_historialest` int(11) NOT NULL,
  `tiempo` varchar(50) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_estacionamiento` int(11) DEFAULT NULL,
  `id_personal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_estacionamiento`
--

INSERT INTO `historial_estacionamiento` (`id_historialest`, `tiempo`, `id_cliente`, `id_estacionamiento`, `id_personal`) VALUES
(1, '2 horas', 1, 1, 1),
(2, '5 horas', 3, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_pago`
--

CREATE TABLE `historial_pago` (
  `id_historialpago` int(11) NOT NULL,
  `num_transaccion` varchar(50) NOT NULL,
  `fecha_pago` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `estado_pago` varchar(20) NOT NULL,
  `id_reserva` int(11) DEFAULT NULL,
  `id_pago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_pago`
--

INSERT INTO `historial_pago` (`id_historialpago`, `num_transaccion`, `fecha_pago`, `estado_pago`, `id_reserva`, `id_pago`) VALUES
(1, 'TX001', '2024-10-12 03:00:00', 'Pagado', 1, 1),
(2, 'TX002', '2024-10-18 03:00:00', 'Pendiente', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_reserva`
--

CREATE TABLE `historial_reserva` (
  `id_hisreserva` int(11) NOT NULL,
  `id_reserva` int(11) DEFAULT NULL,
  `fecha_modificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `estado_anterior` varchar(20) DEFAULT NULL,
  `estado_actual` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_reserva`
--

INSERT INTO `historial_reserva` (`id_hisreserva`, `id_reserva`, `fecha_modificacion`, `estado_anterior`, `estado_actual`) VALUES
(1, 1, '2024-10-01 03:00:00', 'Pendiente', 'Confirmada'),
(2, 2, '2024-10-05 03:00:00', 'Reservada', 'Pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_pago` int(11) NOT NULL,
  `metodo_pago` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id_pago`, `metodo_pago`) VALUES
(1, 'Tarjeta de crédito'),
(2, 'Transferencia bancaria'),
(3, 'Efectivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `id_personal` int(11) NOT NULL,
  `numero_empleado` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `turno` varchar(20) DEFAULT NULL,
  `id_cargo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`id_personal`, `numero_empleado`, `nombre`, `apellido`, `dni`, `telefono`, `turno`, `id_cargo`) VALUES
(1, 'E001', 'Ana', 'López', '34567890', '234567890', 'Mañana', 1),
(2, 'E002', 'Luis', 'Martínez', '56789012', '345678901', 'Tarde', 2),
(3, 'E003', 'Sandra', 'Gómez', '78901234', '456789012', 'Noche', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `estado_reserva` varchar(20) NOT NULL,
  `cantidad_huesped` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_habitacion` int(11) DEFAULT NULL,
  `id_estacionamiento` int(11) DEFAULT NULL,
  `id_pago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `fecha_ingreso`, `fecha_salida`, `estado_reserva`, `cantidad_huesped`, `id_cliente`, `id_habitacion`, `id_estacionamiento`, `id_pago`) VALUES
(1, '2024-10-10', '2024-10-12', 'Confirmada', 1, 1, 1, 1, 1),
(2, '2024-10-15', '2024-10-18', 'Pendiente', 2, 2, 2, NULL, 2),
(3, '2024-10-20', '2024-10-25', 'Confirmada', 3, 3, 3, 3, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `estacionamiento`
--
ALTER TABLE `estacionamiento`
  ADD PRIMARY KEY (`id_estacionamiento`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id_habitacion`);

--
-- Indices de la tabla `historial_estacionamiento`
--
ALTER TABLE `historial_estacionamiento`
  ADD PRIMARY KEY (`id_historialest`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_estacionamiento` (`id_estacionamiento`),
  ADD KEY `id_personal` (`id_personal`);

--
-- Indices de la tabla `historial_pago`
--
ALTER TABLE `historial_pago`
  ADD PRIMARY KEY (`id_historialpago`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `id_pago` (`id_pago`);

--
-- Indices de la tabla `historial_reserva`
--
ALTER TABLE `historial_reserva`
  ADD PRIMARY KEY (`id_hisreserva`),
  ADD KEY `id_reserva` (`id_reserva`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id_pago`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id_personal`),
  ADD UNIQUE KEY `numero_empleado` (`numero_empleado`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `id_cargo` (`id_cargo`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_habitacion` (`id_habitacion`),
  ADD KEY `id_estacionamiento` (`id_estacionamiento`),
  ADD KEY `id_pago` (`id_pago`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estacionamiento`
--
ALTER TABLE `estacionamiento`
  MODIFY `id_estacionamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `historial_estacionamiento`
--
ALTER TABLE `historial_estacionamiento`
  MODIFY `id_historialest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `historial_pago`
--
ALTER TABLE `historial_pago`
  MODIFY `id_historialpago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `historial_reserva`
--
ALTER TABLE `historial_reserva`
  MODIFY `id_hisreserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `id_personal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial_estacionamiento`
--
ALTER TABLE `historial_estacionamiento`
  ADD CONSTRAINT `historial_estacionamiento_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `historial_estacionamiento_ibfk_2` FOREIGN KEY (`id_estacionamiento`) REFERENCES `estacionamiento` (`id_estacionamiento`),
  ADD CONSTRAINT `historial_estacionamiento_ibfk_3` FOREIGN KEY (`id_personal`) REFERENCES `personal` (`id_personal`);

--
-- Filtros para la tabla `historial_pago`
--
ALTER TABLE `historial_pago`
  ADD CONSTRAINT `historial_pago_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
  ADD CONSTRAINT `historial_pago_ibfk_2` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`);

--
-- Filtros para la tabla `historial_reserva`
--
ALTER TABLE `historial_reserva`
  ADD CONSTRAINT `historial_reserva_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id_habitacion`),
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`id_estacionamiento`) REFERENCES `estacionamiento` (`id_estacionamiento`),
  ADD CONSTRAINT `reserva_ibfk_4` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
