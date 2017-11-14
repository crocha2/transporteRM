-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2017 a las 05:45:35
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `transporterm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nit` varchar(100) NOT NULL,
  `tipo_persona` varchar(100) NOT NULL,
  `nombre` varchar(500) NOT NULL,
  `departamento` varchar(200) NOT NULL,
  `municipio` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `contacto` varchar(100) NOT NULL,
  `email_contacto` varchar(100) NOT NULL,
  `telefono_contacto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nit`, `tipo_persona`, `nombre`, `departamento`, `municipio`, `direccion`, `contacto`, `email_contacto`, `telefono_contacto`) VALUES
(1, '802014568-9', 'JURIDICA', 'TECNOGLASS S.A', 'ATLANTICO', 'BARRANQUILLA', 'VIA 40', 'LUIS PEREZ', 'LOGISTICA@TECNOGLASS.COM', '3656969'),
(3, '8020123496', 'JURIDICA', 'CPU SYSTEM SERVICE S.A.S', 'ATLANTICO', 'BARRANQUILLA', 'CALLE 75B NO. 41D - 52', 'FRANCISCO SERRANO SERRANO', 'FRANCISCO.SERRANO@CPU-SYS.COM', '3202565'),
(4, '', 'JURIDICA', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductores`
--

CREATE TABLE `conductores` (
  `id_conductor` int(11) NOT NULL,
  `cedula` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `departamento` varchar(200) NOT NULL,
  `municipio` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `numero_licencia` varchar(100) NOT NULL,
  `clase_categoria` varchar(50) NOT NULL,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `conductores`
--

INSERT INTO `conductores` (`id_conductor`, `cedula`, `nombre`, `departamento`, `municipio`, `direccion`, `fecha_ingreso`, `email`, `telefono`, `numero_licencia`, `clase_categoria`, `estado`) VALUES
(1, '1055858969', 'FERNANDO REDONDO', 'ATLANTICO', 'BARRANQUILLA', 'VIA 40 CON 70', '2017-07-01', 'FERNANDO@GMAIL.COM', '3252624', '1454747', 'C3', 'ACTIVO'),
(3, '1045725445', 'RICARDO MELENDEZ', 'ATLANTICO', 'BARRANQUILLA', 'CRA 35 NO 45 - 84', '2017-11-12', 'RICAR@GMAIL.COM', '3021458', '1458565', 'C3', 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuentos`
--

CREATE TABLE `descuentos` (
  `id_descuento` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` text NOT NULL,
  `unidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `descuentos`
--

INSERT INTO `descuentos` (`id_descuento`, `fecha`, `descripcion`, `unidad`, `precio`, `total`) VALUES
(1, '2017-11-13', 'PARQUEO', 1, 14000, 14000),
(2, '2017-11-14', 'COMBUSTIBLE', 40, 7670, 306800),
(3, '2017-11-13', 'GASTOS CONDUCTOR', 1, 1500, 1500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liquidaciones`
--

CREATE TABLE `liquidaciones` (
  `id_liquidacion` int(11) NOT NULL,
  `nombre` varchar(500) NOT NULL,
  `fecha` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `sub_total` int(11) NOT NULL,
  `gran_total` int(11) NOT NULL,
  `id_descuento` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_viaje` int(11) NOT NULL,
  `id_vehiculo` int(11) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `id_propietario` int(11) NOT NULL,
  `identificacion` varchar(50) NOT NULL,
  `nombre_propietario` varchar(100) NOT NULL,
  `departamento` varchar(100) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`id_propietario`, `identificacion`, `nombre_propietario`, `departamento`, `municipio`, `direccion`, `fecha_ingreso`, `email`, `telefono`, `estado`) VALUES
(1, 'AA', 'AA', 'AA', 'AA', 'AA', '2017-11-03', 'AA', 'AA', 'ACTIVO'),
(2, 'BB', 'BB', 'BB', 'BB', 'BB', '2017-11-01', 'BB', 'BB', 'INACTIVO'),
(4, 'CC', 'CC', 'CC', 'CC', 'CC', '2017-11-12', 'CC', 'CC', 'ACTIVO'),
(5, '714641234', 'DEMONIO', '+89', '4', '89', '2017-03-30', '89', '1401', 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recorridos`
--

CREATE TABLE `recorridos` (
  `id_recorrido` int(11) NOT NULL,
  `recorrido` varchar(200) NOT NULL,
  `km_recorridos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recorridos`
--

INSERT INTO `recorridos` (`id_recorrido`, `recorrido`, `km_recorridos`) VALUES
(11, 'LA GRANJA - UF5', 11),
(12, 'UF6 - BOTADERO', 22),
(13, 'UF6 - MECO', 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipo_usuario`, `nombre`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'OPERADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(20) NOT NULL,
  `password_usuario` varchar(50) NOT NULL,
  `id_tipo_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `password_usuario`, `id_tipo_usuario`) VALUES
(1, 'crocha2', 'colombia16', 1),
(4, 'kmende3', '12345', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `id_vehiculo` int(11) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `año_modelo` varchar(10) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `clase` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `color` varchar(50) NOT NULL,
  `metros_cubicos` varchar(10) NOT NULL,
  `propio` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `id_conductor` int(11) NOT NULL,
  `id_propietario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`id_vehiculo`, `placa`, `año_modelo`, `fecha_ingreso`, `clase`, `marca`, `modelo`, `color`, `metros_cubicos`, `propio`, `estado`, `id_conductor`, `id_propietario`) VALUES
(2, 'KYC - 243', '2015', '2017-11-01', 'DOBLE TROQUE', 'HINO', 'STRONG', 'BLANCO', '16', 'NO', 'ACTIVO', 3, 2),
(3, 'CPU - 123', '2015', '2017-11-12', 'DOBLE TROQUE', 'HINO', 'HINO STRONG', 'BLANCO', '17', 'NO', 'ACTIVO', 3, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viajes`
--

CREATE TABLE `viajes` (
  `id_viaje` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `placa` varchar(10) NOT NULL,
  `dia` varchar(10) NOT NULL,
  `recorrido` varchar(200) NOT NULL,
  `unidad` int(11) NOT NULL,
  `valor_m3` int(11) NOT NULL,
  `m3` int(11) NOT NULL,
  `km` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `id_vehiculo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `viajes`
--

INSERT INTO `viajes` (`id_viaje`, `fecha`, `placa`, `dia`, `recorrido`, `unidad`, `valor_m3`, `m3`, `km`, `total`, `id_vehiculo`) VALUES
(1, '2017-10-13', 'KYC - 243', 'LUNES', 'LA GRANJA - UF5', 7, 400, 17, 11, 523600, 2),
(3, '2017-11-14', 'CPU - 123', 'MARTES', 'UF6 - BOTADERO', 7, 390, 17, 22, 1021020, 3),
(4, '2017-11-15', 'CPU - 123', 'MIERCOLES', 'UF6 - MECO', 10, 390, 17, 22, 1458600, 3),
(5, '2017-11-16', 'KYC - 243', 'JUEVES', 'UF6 - MECO', 11, 400, 17, 22, 1645600, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `conductores`
--
ALTER TABLE `conductores`
  ADD PRIMARY KEY (`id_conductor`);

--
-- Indices de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD PRIMARY KEY (`id_descuento`);

--
-- Indices de la tabla `liquidaciones`
--
ALTER TABLE `liquidaciones`
  ADD PRIMARY KEY (`id_liquidacion`),
  ADD KEY `id_descuento` (`id_descuento`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_viaje` (`id_viaje`),
  ADD KEY `id_vehiculo` (`id_vehiculo`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`id_propietario`);

--
-- Indices de la tabla `recorridos`
--
ALTER TABLE `recorridos`
  ADD PRIMARY KEY (`id_recorrido`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `id_tipo_usuario` (`id_tipo_usuario`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`id_vehiculo`),
  ADD KEY `id_conductor` (`id_conductor`),
  ADD KEY `id_propietario` (`id_propietario`);

--
-- Indices de la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD PRIMARY KEY (`id_viaje`),
  ADD KEY `id_vehiculo` (`id_vehiculo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `conductores`
--
ALTER TABLE `conductores`
  MODIFY `id_conductor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  MODIFY `id_descuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `liquidaciones`
--
ALTER TABLE `liquidaciones`
  MODIFY `id_liquidacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  MODIFY `id_propietario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `recorridos`
--
ALTER TABLE `recorridos`
  MODIFY `id_recorrido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  MODIFY `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `viajes`
--
ALTER TABLE `viajes`
  MODIFY `id_viaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `liquidaciones`
--
ALTER TABLE `liquidaciones`
  ADD CONSTRAINT `liquidaciones_ibfk_1` FOREIGN KEY (`id_descuento`) REFERENCES `descuentos` (`id_descuento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `liquidaciones_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `liquidaciones_ibfk_3` FOREIGN KEY (`id_viaje`) REFERENCES `viajes` (`id_viaje`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `liquidaciones_ibfk_4` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`id_vehiculo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`id_conductor`) REFERENCES `conductores` (`id_conductor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehiculos_ibfk_2` FOREIGN KEY (`id_propietario`) REFERENCES `propietarios` (`id_propietario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD CONSTRAINT `viajes_ibfk_1` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`id_vehiculo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
