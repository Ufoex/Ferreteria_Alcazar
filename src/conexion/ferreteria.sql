-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2020 a las 06:14:10
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ferreteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `idcompra` int(11) NOT NULL,
  `precio_unitario` float NOT NULL,
  `cantidad_producto` int(4) NOT NULL,
  `fecha` date NOT NULL,
  `total` float NOT NULL,
  `idproducto` int(11) NOT NULL,
  `idempleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`idcompra`, `precio_unitario`, `cantidad_producto`, `fecha`, `total`, `idproducto`, `idempleado`) VALUES
(1, 50, 3, '2019-02-26', 150, 1, 2),
(2, 800, 1, '2018-09-15', 800, 2, 3),
(3, 1500, 1, '2019-08-06', 1500, 2, 1),
(5, 234, 234, '2020-12-12', 23423, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido_paterno` varchar(24) NOT NULL,
  `apellido_materno` varchar(24) NOT NULL,
  `telefono` int(10) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `rfc` varchar(13) NOT NULL,
  `turno` varchar(1) NOT NULL,
  `colonia` varchar(15) NOT NULL,
  `calle` varchar(22) NOT NULL,
  `numero` int(10) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `usuario` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `nombre`, `apellido_paterno`, `apellido_materno`, `telefono`, `sexo`, `fecha_ingreso`, `rfc`, `turno`, `colonia`, `calle`, `numero`, `password`, `usuario`) VALUES
(1, 'Isaias', 'Sanchez', 'Diaz', 2147483647, 'M', '2018-05-06', 'CADD851115LOI', 'M', 'Centro', 'Av.Alvaro Obregon', 13, '9450476b384b32d8ad8b758e76c98a69', 'isaias'),
(2, 'Ana', 'Perales', 'Molares', 2147483647, 'F', '2019-06-28', 'PEMA981203AU5', 'V', 'centro', 'Hidalgo', 150, 'b59c67bf196a4758191e42f76670ceba', 'ana'),
(3, 'Andre', 'Perez', 'Garcia', 2147483647, 'M', '2019-08-16', 'PEGA950115BH5', 'M', 'centro', 'Colon', 7, 'b59c67bf196a4758191e42f76670ceba', 'andre'),
(5, 'Alfonzo', 'Diaz', 'Mora', 338484394, 'F', '2019-04-23', '34365gdfgdgsd', 'V', 'Soledo', 'Del andador', 18, NULL, NULL),
(6, 'Isaias', 'Sanchez', 'Diaz', 2147483647, 'M', '2018-05-06', 'CADD851115LOI', 'M', 'Centro', 'Av.Alvaro Obregon', 13, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `idproducto` int(11) NOT NULL,
  `stock` int(4) NOT NULL,
  `categoria` varchar(27) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`idproducto`, `stock`, `categoria`) VALUES
(2, 10, 'pinzas'),
(1, 34, 'desarmadores'),
(4, 10, 'pinzas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(24) NOT NULL,
  `marca` varchar(22) NOT NULL,
  `precio_unitario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombre`, `marca`, `precio_unitario`) VALUES
(1, 'pinzas', 'Truper', 50),
(2, 'Taladro', 'stanley', 800),
(3, 'motosierras', 'Stihl', 1500),
(4, 'Taladro', 'stanley', 800);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `idproveedor` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido_paterno` varchar(24) NOT NULL,
  `apellido_materno` varchar(24) NOT NULL,
  `rfc` varchar(13) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `mail` varchar(32) DEFAULT NULL,
  `estado` varchar(15) NOT NULL,
  `ciudad` varchar(15) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `colonia` varchar(15) NOT NULL,
  `calle` varchar(25) NOT NULL,
  `numero` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`idproveedor`, `nombre`, `apellido_paterno`, `apellido_materno`, `rfc`, `telefono`, `mail`, `estado`, `ciudad`, `cp`, `colonia`, `calle`, `numero`) VALUES
(1, 'Francisco', 'Camacho', 'Zepeda', 'CAZF891224POL', '3319562710', 'francamacho@gmail.com', 'Jalisco', 'Guadalajara', '44100', 'Centro', 'Venustiano Carranza', 220),
(2, 'Alma', 'Torres', 'Lopez', 'TOLA921008AU8', '3339622715', 'altorreslira@hotmail.com', 'Zapopan, Guadal', 'Amatitan', '45380', 'Centro', 'Emilio Carranza', 170),
(3, 'Eduardo', 'Melendrez', 'Cardenas', 'CAME800412', '3331956387', 'francamacho@gmail.com', 'Tlaquepaque, Ja', 'Guadalajara', '44100', 'Centro', 'Juarez', 10),
(4, 'Eduardo', 'Melendrez', 'Cardenas', 'CAME800412', '3331956387', 'francamacho@gmail.com', 'Tlaquepaque, Ja', 'Guadalajara', '44100', 'Centro', 'Juarez', 10),
(6, 'Eduardo', 'Melendrez', 'Cardenas', 'CAME800412', '3331956387', 'francamacho@gmail.com', 'Tlaquepaque, Ja', 'Guadalajara', '44100', 'Centro', 'Juarez', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idventas` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` int(4) NOT NULL,
  `precio_publico` float NOT NULL,
  `total` float NOT NULL,
  `idproducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idventas`, `fecha`, `cantidad`, `precio_publico`, `total`, `idproducto`) VALUES
(1, '2017-09-25', 2, 70, 140, 1),
(2, '2018-07-02', 1, 1800, 1800, 3),
(3, '2018-07-02', 1, 1800, 1800, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`idcompra`),
  ADD KEY `idproducto` (`idproducto`),
  ADD KEY `idempleado` (`idempleado`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idempleado`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD KEY `idproducto` (`idproducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`idproveedor`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idventas`),
  ADD KEY `idproducto` (`idproducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `idcompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idempleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `idproveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idventas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`),
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`idventas`) REFERENCES `empleado` (`idempleado`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
