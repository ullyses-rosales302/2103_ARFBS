-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2024 at 06:39 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `semprojdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `appusers`
--

CREATE TABLE `appusers` (
  `UserID` int(11) NOT NULL,
  `Username` text NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appusers`
--

INSERT INTO `appusers` (`UserID`, `Username`, `Email`, `Password`) VALUES
(1, 'injelmey', 'injelmey@gmail.com', 'injelmey143'),
(2, 'apol', 'apol@gmail.com', 'apol');

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `BillID` int(11) NOT NULL,
  `TenantID` int(11) NOT NULL,
  `WaterBillingID` int(11) NOT NULL,
  `ElectricityBillingID` int(11) NOT NULL,
  `PMID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `electricitybilling`
--

CREATE TABLE `electricitybilling` (
  `ElectricityBillingID` int(11) NOT NULL,
  `UnitID` int(11) NOT NULL,
  `ElectricityRate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `parkingmanagement`
--

CREATE TABLE `parkingmanagement` (
  `PMID` int(11) NOT NULL,
  `TenantID` int(11) NOT NULL,
  `Amount` double NOT NULL,
  `PMType` text NOT NULL,
  `PlateNo` varchar(20) NOT NULL,
  `VehicleName` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentID` int(11) NOT NULL,
  `TenantID` int(11) NOT NULL,
  `PaymentDate` date NOT NULL,
  `AmountPaid` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tenant`
--

CREATE TABLE `tenant` (
  `TenantID` int(11) NOT NULL,
  `LastName` text NOT NULL,
  `FirstName` text NOT NULL,
  `MiddleInitial` text NOT NULL,
  `ContactInfo` int(13) NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `unittype`
--

CREATE TABLE `unittype` (
  `UnitID` int(11) NOT NULL,
  `Category` text NOT NULL,
  `Amount` double NOT NULL,
  `Capacity` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `waterbilling`
--

CREATE TABLE `waterbilling` (
  `WaterBillingID` int(11) NOT NULL,
  `UnitID` int(11) NOT NULL,
  `ElectricityRate` int(11) NOT NULL,
  `WaterRate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appusers`
--
ALTER TABLE `appusers`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`BillID`),
  ADD UNIQUE KEY `TenantID` (`TenantID`),
  ADD UNIQUE KEY `WaterBillingID` (`WaterBillingID`),
  ADD UNIQUE KEY `ElectricityBillingID` (`ElectricityBillingID`),
  ADD UNIQUE KEY `PMID` (`PMID`);

--
-- Indexes for table `electricitybilling`
--
ALTER TABLE `electricitybilling`
  ADD PRIMARY KEY (`ElectricityBillingID`),
  ADD UNIQUE KEY `UnitID` (`UnitID`);

--
-- Indexes for table `parkingmanagement`
--
ALTER TABLE `parkingmanagement`
  ADD PRIMARY KEY (`PMID`),
  ADD UNIQUE KEY `TenantID` (`TenantID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `tenant`
--
ALTER TABLE `tenant`
  ADD PRIMARY KEY (`TenantID`);

--
-- Indexes for table `unittype`
--
ALTER TABLE `unittype`
  ADD PRIMARY KEY (`UnitID`);

--
-- Indexes for table `waterbilling`
--
ALTER TABLE `waterbilling`
  ADD PRIMARY KEY (`WaterBillingID`),
  ADD UNIQUE KEY `UnitID` (`UnitID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appusers`
--
ALTER TABLE `appusers`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `BillID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `electricitybilling`
--
ALTER TABLE `electricitybilling`
  MODIFY `ElectricityBillingID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `parkingmanagement`
--
ALTER TABLE `parkingmanagement`
  MODIFY `PMID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tenant`
--
ALTER TABLE `tenant`
  MODIFY `TenantID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `unittype`
--
ALTER TABLE `unittype`
  MODIFY `UnitID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `waterbilling`
--
ALTER TABLE `waterbilling`
  MODIFY `WaterBillingID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
