-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-07-2020 a las 06:32:49
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alejandroTellezTest`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `money_transfer`
--

CREATE TABLE `money_transfer` (
  `transfer_id` bigint(20) NOT NULL,
  `ammount` double NOT NULL,
  `from_account` bigint(20) NOT NULL,
  `sent_at` datetime NOT NULL,
  `to_account` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `money_transfer`
--

INSERT INTO `money_transfer` (`transfer_id`, `ammount`, `from_account`, `sent_at`, `to_account`) VALUES
(1, 10, 1, '2020-07-25 18:51:26', 2),
(2, 10, 1, '2020-07-25 18:55:08', 2),
(3, 1566, 1, '2020-07-25 18:55:39', 2),
(4, 1566, 1, '2020-07-25 18:59:45', 2),
(5, 1566, 1, '2020-07-25 19:28:57', 2),
(6, 1566, 5, '2020-07-25 19:54:19', 2),
(7, 1566, 5, '2020-07-25 20:43:15', 4),
(8, 1566, 6, '2020-07-25 20:48:30', 5),
(9, 1000000, 1, '2020-07-25 21:45:08', 9),
(10, 100, 1, '2020-07-25 22:06:08', 2),
(11, 100, 1, '2020-07-25 22:07:33', 2),
(12, 300, 1, '2020-07-25 22:10:13', 2),
(13, 100, 1, '2020-07-25 22:14:30', 2),
(14, 1000, 1, '2020-07-25 22:15:43', 2),
(15, 1000, 1, '2020-07-25 22:16:22', 2),
(16, 100, 1, '2020-07-25 22:19:54', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_account`
--

CREATE TABLE `user_account` (
  `account_id` bigint(20) NOT NULL,
  `balance` double DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `owner` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user_account`
--

INSERT INTO `user_account` (`account_id`, `balance`, `created_at`, `owner`) VALUES
(1, 0, '2020-07-25 18:51:26', 222),
(2, 1200, '2020-07-25 02:10:06', 222),
(3, 2000, '2020-07-26 00:04:21', 333);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `money_transfer`
--
ALTER TABLE `money_transfer`
  ADD PRIMARY KEY (`transfer_id`);

--
-- Indices de la tabla `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`account_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `money_transfer`
--
ALTER TABLE `money_transfer`
  MODIFY `transfer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `user_account`
--
ALTER TABLE `user_account`
  MODIFY `account_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
