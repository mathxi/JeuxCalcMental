-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 20 oct. 2019 à 22:58
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jeuxcalcmental`
--

-- --------------------------------------------------------

--
-- Structure de la table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE IF NOT EXISTS `result` (
  `id_result` int(11) NOT NULL AUTO_INCREMENT,
  `points` int(11) NOT NULL,
  `date_result` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_result`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `result`
--

INSERT INTO `result` (`id_result`, `points`, `date_result`, `id_user`) VALUES
(1, 8, '2019-10-17 12:58:23', 3),
(2, 2, '2019-10-17 13:00:28', 1),
(3, 6, '2019-10-17 13:00:39', 3),
(4, 4, '2019-10-17 13:00:53', 1),
(5, 6, '2019-10-17 13:01:03', 2),
(6, 9, '2019-10-17 13:01:47', 1),
(7, 1, '2019-10-17 13:01:57', 1),
(8, 6, '2019-10-17 13:02:06', 1),
(9, 7, '2019-10-17 13:02:19', 3),
(10, 10, '2019-10-17 13:02:42', 1),
(11, 8, '2019-10-17 13:02:52', 1),
(12, 8, '2019-10-17 13:02:59', 3),
(13, 7, '2019-10-17 13:03:16', 3);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `top_result` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `login`, `password`, `top_result`) VALUES
(1, 'Admin', 'Admin', 0),
(2, 'jackie', 'michel', 0),
(3, 'clement', 'moreau', 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
