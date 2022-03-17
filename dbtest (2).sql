-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 14, 2022 at 04:21 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtest`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

DROP TABLE IF EXISTS `adminlogin`;
CREATE TABLE IF NOT EXISTS `adminlogin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(13) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`username`, `password`, `Name`, `email`, `contact`) VALUES
('admin', '123', 'Admin', 'admin@thirdeyestudio.com', '0111111111'),
('tsetUser', 'rar123', 'User', 'user@domain.com', '0');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `BillNo` int(11) NOT NULL AUTO_INCREMENT,
  `totalPrice` int(11) DEFAULT NULL,
  `billDate` date DEFAULT NULL,
  `billTime` time DEFAULT NULL,
  PRIMARY KEY (`BillNo`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`BillNo`, `totalPrice`, `billDate`, `billTime`) VALUES
(1, 4500, '2022-03-15', '38:51:47');

-- --------------------------------------------------------

--
-- Table structure for table `client_payments`
--

DROP TABLE IF EXISTS `client_payments`;
CREATE TABLE IF NOT EXISTS `client_payments` (
  `cpID` int(11) NOT NULL AUTO_INCREMENT,
  `ClientID` int(11) DEFAULT NULL,
  `paymentAmount` int(11) DEFAULT NULL,
  `billNumber` int(11) DEFAULT NULL,
  `payemntDate` date DEFAULT NULL,
  PRIMARY KEY (`cpID`),
  KEY `billNumber` (`billNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client_types`
--

DROP TABLE IF EXISTS `client_types`;
CREATE TABLE IF NOT EXISTS `client_types` (
  `TID` varchar(10) NOT NULL,
  `TypeName` varchar(20) DEFAULT NULL,
  `minimumPointNeed` int(11) DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client_types`
--

INSERT INTO `client_types` (`TID`, `TypeName`, `minimumPointNeed`) VALUES
('CL001', 'PLATINUM', 0),
('CL002', 'GOLD', 10000),
('CL003', 'PREMIUM', 50000),
('CL004', 'LUXERY', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(4) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nic` varchar(13) DEFAULT NULL,
  `tel` varchar(13) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cID`)
) ENGINE=MyISAM AUTO_INCREMENT=118 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cID`, `title`, `first_name`, `last_name`, `email`, `nic`, `tel`, `address`) VALUES
(111, 'Mr', 'Ramesh', 'Rukshan', 'rar@gmail.com', '200030100436', '+94716980110', 'Thelijjawila, Matara'),
(112, 'Mr.', 'RSA', '', 'rsa@gmail.com', '200030120485', '+94765248745', 'Gangodawila, Nugegoda'),
(116, 'Mr.', 'Anfas', 'Arshad', 'anfasarshad@gmail.com', '200023600026', '0788999196', 'Watthala'),
(114, 'Mr.', 'Thilina', 'Lakshan', 'yfadjs@jha', '325678', '25678904', 'hadkcva'),
(115, 'Mr.', 'Ramesh', 'A', 'ramesh@domain.com', '200010300456', '0716711234', 'Matara'),
(117, 'Mr.', 'umesh', 'hadunduwa', 'umeshhadunduwa6@gmail.com', '199917501769', '0710612733', 'no41 buddaloka mw suwarapola piliyandala');

-- --------------------------------------------------------

--
-- Table structure for table `inventry`
--

DROP TABLE IF EXISTS `inventry`;
CREATE TABLE IF NOT EXISTS `inventry` (
  `invID` int(11) NOT NULL AUTO_INCREMENT,
  `prodID` int(11) DEFAULT NULL,
  `stocks` int(11) DEFAULT NULL,
  `inventryStatus` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`invID`),
  KEY `prodID` (`prodID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventry`
--

INSERT INTO `inventry` (`invID`, `prodID`, `stocks`, `inventryStatus`) VALUES
(1, 1111, 0, 'Low Stocks'),
(2, 1112, 500, 'In Stocks'),
(3, 1114, 20, 'In Stocks'),
(4, 1115, 1, 'Low Stocks'),
(5, 1116, 520, 'In Stocks');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `pID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`pID`)
) ENGINE=MyISAM AUTO_INCREMENT=1117 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pID`, `ProductName`, `price`, `description`) VALUES
(1111, 'iPad mini 3', 36000, 'Used ipad mini 3 in superb condition, no damages or errors, battery is perfect, no scratches or dents\r\n16 gb wifi only'),
(1112, 'TestProd', 3000, 'Test Product for development purpose'),
(1113, 'TestTwoProduct', 200, 'developemt test product'),
(1115, 'iMac Early 2015', 75000, 'MacBook pro Earlt 2015, 8GB RAM, 121 SSD'),
(1116, 'TestProduct', 500, 'uyjfscbjds sdbjbv  dvbj.jdb ');

-- --------------------------------------------------------

--
-- Table structure for table `product_purchase`
--

DROP TABLE IF EXISTS `product_purchase`;
CREATE TABLE IF NOT EXISTS `product_purchase` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `pID` int(11) DEFAULT NULL,
  `billNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`row_id`),
  KEY `pID` (`pID`),
  KEY `billNo` (`billNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
