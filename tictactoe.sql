/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.14-MariaDB : Database - tictactoe
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tictactoe` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `tictactoe`;

/*Table structure for table `igra` */

DROP TABLE IF EXISTS `igra`;

CREATE TABLE `igra` (
  `idIgre` int(11) NOT NULL AUTO_INCREMENT,
  `idKorisnika` int(11) DEFAULT NULL,
  `pobeda` tinyint(1) DEFAULT NULL,
  `brojPoteza` int(11) DEFAULT NULL,
  `datumOdigravanja` datetime DEFAULT NULL,
  PRIMARY KEY (`idIgre`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

/*Data for the table `igra` */

insert  into `igra`(`idIgre`,`idKorisnika`,`pobeda`,`brojPoteza`,`datumOdigravanja`) values 
(1,0,0,0,'2021-04-06 00:00:00'),
(2,0,0,0,'2021-04-06 00:00:00'),
(3,0,0,0,'2021-04-06 00:00:00'),
(4,0,0,0,'2021-04-06 00:00:00'),
(5,0,0,0,'2021-04-06 00:00:00'),
(6,1,0,0,'2021-04-06 00:00:00'),
(7,1,0,0,'2021-04-06 00:00:00'),
(8,1,0,0,'2021-04-08 00:00:00'),
(9,1,0,0,'2021-04-08 00:00:00'),
(10,1,0,0,'2021-04-08 00:00:00'),
(11,1,0,0,'2021-04-08 00:00:00'),
(12,1,0,0,'2021-04-08 00:00:00'),
(13,1,0,0,'2021-04-08 00:00:00'),
(14,1,0,0,'2021-04-08 00:00:00'),
(15,1,1,5,'2021-04-08 00:00:00'),
(16,1,1,5,'2021-04-08 00:00:00'),
(17,1,0,0,'2021-04-08 00:00:00'),
(18,1,0,0,'2021-04-08 00:00:00'),
(19,1,1,5,'2021-04-08 00:00:00'),
(20,1,1,5,'2021-04-08 00:00:00'),
(21,1,0,0,'2021-04-10 00:00:00'),
(22,1,1,5,'2021-04-11 00:00:00'),
(23,1,1,5,'2021-04-11 00:00:00'),
(24,1,0,6,'2021-04-11 00:00:00'),
(25,1,1,7,'2021-04-11 00:00:00'),
(26,1,1,8,'2021-04-11 00:00:00');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `idKorisnika` int(11) NOT NULL AUTO_INCREMENT,
  `korisnickoIme` varchar(100) DEFAULT NULL,
  `sifra` varchar(15) DEFAULT NULL,
  `datumPrijavljivanja` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idKorisnika`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `korisnik` */

insert  into `korisnik`(`idKorisnika`,`korisnickoIme`,`sifra`,`datumPrijavljivanja`,`email`) values 
(1,'luka','123','2021-02-25 00:00:00',NULL),
(2,'lukaluka','1','2021-04-04 00:00:00','orlovic@mail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
