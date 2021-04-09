-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.7.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para netberry
CREATE DATABASE IF NOT EXISTS `netberry` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `netberry`;

-- Volcando estructura para tabla netberry.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `1` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(255) DEFAULT NULL,
  `id_tarea` int(20) unsigned NOT NULL,
  PRIMARY KEY (`1`),
  KEY `id_tarea` (`id_tarea`),
  CONSTRAINT `FK_TAREA` FOREIGN KEY (`id_tarea`) REFERENCES `tarea` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla netberry.tarea
CREATE TABLE IF NOT EXISTS `tarea` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_tarea` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
