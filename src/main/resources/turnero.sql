-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2024 a las 13:38:19
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citizen`
--

CREATE TABLE `citizen` (
  `ID` int(11) NOT NULL,
  `AGE` int(11) DEFAULT NULL,
  `IDENTIFICATION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `citizen`
--

INSERT INTO `citizen` (`ID`, `AGE`, `IDENTIFICATION`, `NAME`) VALUES
(1, 24, '111111111A', 'Fede'),
(2, 14, '121212121B', 'Rogelio'),
(3, 35, '965874123C', 'Alfonso'),
(4, 40, '874563214S', 'Bruce'),
(10, 22, '545454545L', 'Claudia'),
(11, 33, '333353333F', 'Fernando'),
(12, 62, '363546879R', 'Rosa'),
(13, 19, '415785536L', 'Lucia'),
(14, 29, '652254458K', 'Cristina'),
(15, 35, '654456987M', 'Maria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turn`
--

CREATE TABLE `turn` (
  `ID` int(11) NOT NULL,
  `ATTENDED` tinyint(1) DEFAULT 0,
  `DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `citizen_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `turn`
--

INSERT INTO `turn` (`ID`, `ATTENDED`, `DATE`, `DESCRIPTION`, `citizen_id`) VALUES
(9, 0, '2024-01-30 12:30:00', 'Robo', 1),
(10, 0, '2024-01-31 12:30:00', 'Renovar identificacion', 1),
(11, 0, '2024-01-30 15:30:00', 'Denuncia', 2),
(12, 0, '2024-02-02 10:30:00', 'Robo', 2),
(13, 0, '2024-01-25 14:30:00', 'Denuncia', 3),
(14, 0, '2024-01-22 14:30:00', 'Robo', 3),
(15, 0, '2024-01-30 08:30:00', 'Denuncia', 12),
(16, 1, '2024-01-19 12:32:00', 'Denuncia', 11),
(17, 1, '2024-01-19 12:33:00', 'Robo', 10),
(18, 0, '2024-01-19 15:30:00', 'Burocracia', 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `user`, `password`) VALUES
(1, 'batman', 'nosoybrucewayne');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citizen`
--
ALTER TABLE `citizen`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `IDENTIFICATION` (`IDENTIFICATION`);

--
-- Indices de la tabla `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indices de la tabla `turn`
--
ALTER TABLE `turn`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TURN_citizen_id` (`citizen_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citizen`
--
ALTER TABLE `citizen`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `turn`
--
ALTER TABLE `turn`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turn`
--
ALTER TABLE `turn`
  ADD CONSTRAINT `FK_TURN_citizen_id` FOREIGN KEY (`citizen_id`) REFERENCES `citizen` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
