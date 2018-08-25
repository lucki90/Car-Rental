--
-- Table structure for table `car`
--
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_brand` varchar(255) NOT NULL,
  `car_model` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `id_car_class` bigint(20) NOT NULL,
  `id_car_specification` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3xr3f4rmrdshd645wfb87v9iq` (`id_car_class`),
  KEY `FKj8yjmum0h6pooxcv2cn22b8sw` (`id_car_specification`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `car`
--
LOCK TABLES `car` WRITE;
INSERT INTO `car` VALUES
(1,'BMW','M3',120,3,2),
(2,'Audi','Q7',200,12,1),
(3,'Fiat','126p',50,1,3),
(4,'Mercedes','SLR',250,6,5),
(5,'Ford','Galaxy',100,9,4);
UNLOCK TABLES;

--
-- Table structure for table `car_class`
--
DROP TABLE IF EXISTS `car_class`;
CREATE TABLE `car_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `segment` varchar(255) NOT NULL,
  `segment_description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_37k2g4cswkl03cy2p53de6oxp` (`segment`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `car_class`
--
LOCK TABLES `car_class` WRITE;
INSERT INTO `car_class` VALUES
(1,'A','Mini'),
(2,'B','City'),
(3,'C','Compact'),
(4,'D','Middle'),
(5,'E','Higher'),
(6,'F','Luxury'),
(7,'Van A','Micro'),
(8,'Van B','Middle'),
(9,'Van C','Big'),
(10,'Suv A','Micro'),
(11,'Suv B','Middle'),
(12,'Suv C','Big');
UNLOCK TABLES;

--
-- Table structure for table `car_specification`
--
DROP TABLE IF EXISTS `car_specification`;
CREATE TABLE `car_specification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body_type` varchar(255) NOT NULL,
  `colour` varchar(255) NOT NULL,
  `engine_capacity` double NOT NULL,
  `horse_power` int(11) NOT NULL,
  `production_year` date NOT NULL,
  `seats` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `car_specification`
--
LOCK TABLES `car_specification` WRITE;
INSERT INTO `car_specification` VALUES
(1,'Suv','black',3,200,'2017-01-01',6),
(2,'Coupe','silver',2.2,100,'2016-01-01',5),
(3,'hatchback','blue',1,50,'2012-01-01',4),
(4,'Van','silver',2,150,'2017-01-01',5),
(5,'Cabriolet','blue',5,300,'2018-01-01',2);
UNLOCK TABLES;

--
-- Table structure for table `logged_user`
--
DROP TABLE IF EXISTS `logged_user`;
CREATE TABLE `logged_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3tqh4qk3nb7i5tyy5d89y4j1f` (`login`),
  UNIQUE KEY `UK_b8jl1pwos3nxw52asjbeyj5lx` (`mail`),
  KEY `FK6uf14m5258jk8k40hdx8jwqjn` (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logged_user`
--
LOCK TABLES `logged_user` WRITE;
INSERT INTO `logged_user` VALUES
(1,'tom123','tom@gmail.com','1234',1),
(2,'mike22','mike@gmail.com','2222',3);
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reserved_from` datetime NOT NULL,
  `reserved_to` datetime NOT NULL,
  `id_car` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKevbx68glv1rnq9th5petwly67` (`id_car`),
  KEY `FKb3e2n5wgmx0lvpg0dvxjf7n1l` (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation`
--
LOCK TABLES `reservation` WRITE;
INSERT INTO `reservation` VALUES
(1,'2018-08-01 10:00:00','2018-08-02 10:00:00',1,1),
(2,'2018-08-04 10:00:00','2018-08-14 10:00:00',4,2),
(3,'2018-08-20 10:00:00','2018-08-30 10:00:00',2,4);
UNLOCK TABLES;

--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `surname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4bgmpi98dylab6qdvf9xyaxu4` (`phone_number`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES
(1,'Tom',123456789,'ttt'),
(2,'Michal',111111111,'mmm'),
(3,'Sandra',222222222,'sss'),
(4,'Michal',333333333,'mmm'),
(5,'Ania',444444444,'aaa');
UNLOCK TABLES;

--
-- Table structure for table `user_reservations`
--
DROP TABLE IF EXISTS `user_reservations`;
CREATE TABLE `user_reservations` (
  `user_id` bigint(20) NOT NULL,
  `reservations_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_hmrw1d5ofg54egqj3dmb5cxb4` (`reservations_id`),
  KEY `FKchw6vjt64fd1qvbmdef1tjv9y` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
--
-- Dumping data for table `user_reservations`
--

LOCK TABLES `user_reservations` WRITE;
INSERT INTO `user_reservations` VALUES
(1,1),
(2,2),
(4,3);
UNLOCK TABLES;

-- Dump completed on 2018-08-12 12:26:24
