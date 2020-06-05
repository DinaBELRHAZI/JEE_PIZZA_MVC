-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 22 mai 2020 à 21:37
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `test`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_pizza`
--

DROP TABLE IF EXISTS `t_pizza`;
CREATE TABLE IF NOT EXISTS `t_pizza` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `DesignPizz` varchar(255) DEFAULT NULL,
  `TarifPizz` decimal(5,2) DEFAULT NULL,
  `Description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=480 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Déchargement des données de la table `t_pizza`
--

INSERT INTO `t_pizza` (`id`, `DesignPizz`, `TarifPizz`, `Description`) VALUES
(1, 'La Regina', '10.00', ''),
(2, 'La Seguin', '13.50', ''),
(3, 'La From', '14.50', ''),
(4, 'La Fermière', '12.50', ''),
(5, 'Le Chausson', '13.00', ''),
(6, 'La Provençale', '12.50', ''),
(7, 'La Caramba', '14.50', ''),
(8, 'La tomate', '14.50', ''),
(9, 'La Gourmande', '14.50', ''),
(10, 'La primeure', '12.50', ''),
(11, 'La Péloponèse', '14.50', ''),
(12, 'La Savoyarde', '14.50', ''),
(13, 'la Pêcheur', '13.50', ''),
(472, 'greenwinch', '65.00', ''),
(471, 'La camenbert', '45.00', ''),
(473, 'saumon', '27.00', ''),
(474, 'saumon fumé ', '37.50', ''),
(478, 'saumon fumé new', '120.00', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
