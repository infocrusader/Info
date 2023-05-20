-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2022 at 10:48 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `group5`
--

-- --------------------------------------------------------

--
-- Table structure for table `claimed`
--

CREATE TABLE `claimed` (
  `c_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `wattage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `claimed`
--

INSERT INTO `claimed` (`c_id`, `username`, `wattage`) VALUES
(1, 'john', 30),
(2, 'john', 20),
(3, 'john', 24),
(4, 'john', 20),
(5, 'john', 45);

-- --------------------------------------------------------

--
-- Table structure for table `generate`
--

CREATE TABLE `generate` (
  `g_id` int(11) NOT NULL,
  `requester` varchar(255) NOT NULL,
  `requester_id` int(11) NOT NULL,
  `wattage` int(11) NOT NULL,
  `requested_from` varchar(255) NOT NULL,
  `requested_from_id` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `generated`
--

CREATE TABLE `generated` (
  `gen_id` int(11) NOT NULL,
  `receiver` varchar(255) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `wattage` int(11) NOT NULL,
  `sender` varchar(255) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `generated`
--

INSERT INTO `generated` (`gen_id`, `receiver`, `receiver_id`, `wattage`, `sender`, `sender_id`, `location`) VALUES
(1, 'john', 2, 24, 'new company', 1, 'Newark, New Jersey'),
(2, 'john', 2, 20, 'new company', 1, 'Newark, New Jersey'),
(3, 'john', 2, 45, 'Relativity Nuclear', 1, 'Newark, New Jersey');

-- --------------------------------------------------------

--
-- Table structure for table `hydropower`
--

CREATE TABLE `hydropower` (
  `company_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hydropower`
--

INSERT INTO `hydropower` (`company_id`, `name`, `email`, `description`, `password`, `logo`) VALUES
(1, 'new company', 'email@newcompany.com', 'New Hydro Company.', '$2y$10$HyTLNAgb0GVNeYY6L91swuIj3N4rnEIZoqCzuivt8rGjSLgj4YaDq', '1652104801-peng.jpg'),
(2, 'Westinghouse Corporation', 'email@westing.com', 'The Westinghouse corporation is the oldest green energy supplier and one of the first in the hydro power industry, it is trusted by over 20 million people world wide.', '$2y$10$qDRH7LBigV8aTwGK4NhWa.jKtCpC4nsQOgnSbAze3ZMRzWp.VZ0Pi', '1655231588-company1.png');

-- --------------------------------------------------------

--
-- Table structure for table `nuclearpower`
--

CREATE TABLE `nuclearpower` (
  `company_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nuclearpower`
--

INSERT INTO `nuclearpower` (`company_id`, `name`, `email`, `description`, `password`, `logo`) VALUES
(1, 'Relativity Nuclear', 'email@relativity.com', 'Relativity Nuclear is a large scale  nuclear power generation company currently servicing more that 1.5 million people world wide.', '$2y$10$O3i5hLRyCV/neWyBFekDZO21hzs9XsIbBOHQAioRNPm1oG2a3RR7q', '1655231098-company5.png');

-- --------------------------------------------------------

--
-- Table structure for table `pendingrequests`
--

CREATE TABLE `pendingrequests` (
  `request_id` int(11) NOT NULL,
  `requester` varchar(255) NOT NULL,
  `requester_id` int(11) NOT NULL,
  `wattage` int(11) NOT NULL,
  `requested_from` varchar(255) NOT NULL,
  `requested_from_id` int(11) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pendingrequests`
--

INSERT INTO `pendingrequests` (`request_id`, `requester`, `requester_id`, `wattage`, `requested_from`, `requested_from_id`, `location`) VALUES
(15, 'john', 2, 30, 'premier solar company', 1, 'Newark, New Jersey');

-- --------------------------------------------------------

--
-- Table structure for table `processedrequests`
--

CREATE TABLE `processedrequests` (
  `pr_id` int(11) NOT NULL,
  `requester` varchar(255) NOT NULL,
  `requester_id` int(11) NOT NULL,
  `wattage` int(11) NOT NULL,
  `requested_from` varchar(255) NOT NULL,
  `requested_from_id` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `processedrequests`
--

INSERT INTO `processedrequests` (`pr_id`, `requester`, `requester_id`, `wattage`, `requested_from`, `requested_from_id`, `status`, `location`) VALUES
(9, 'john', 2, 24, 'new company', 1, 'GRANTED', 'Newark, New Jersey'),
(10, 'john', 2, 20, 'new company', 1, 'GRANTED', 'Newark, New Jersey'),
(11, 'john', 2, 45, 'Relativity Nuclear', 1, 'GRANTED', 'Newark, New Jersey');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `questioner` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `timestamp` varchar(255) NOT NULL,
  `thread_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`question_id`, `questioner`, `text`, `timestamp`, `thread_id`) VALUES
(1, 'john', 'How can i reduce my footprint', '2022-05-17 19:11:20', 1),
(2, 'john', 'hello', '2022-05-17 19:32:38', 1),
(3, 'sadiq', 'hey john I can suggest solar power', '2022-05-19 14:30:24', 1),
(4, 'new company', 'Get your wattage from us', '2022-05-22 18:47:04', 1),
(5, 'john', 'test test', '2022-06-14 19:58:30', 1),
(6, 'new company', 'Fucking use my company', '2022-06-14 22:31:08', 1),
(7, 'john', 'Ok i will fucking use your company', '2022-06-14 22:32:07', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sentwatt`
--

CREATE TABLE `sentwatt` (
  `sw_id` int(11) NOT NULL,
  `receiver` varchar(255) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `wattage` int(11) NOT NULL,
  `sender` varchar(255) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `solarpower`
--

CREATE TABLE `solarpower` (
  `company_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `solarpower`
--

INSERT INTO `solarpower` (`company_id`, `name`, `email`, `description`, `password`, `logo`) VALUES
(1, 'premier solar company', 'email@premiersolar.com', 'We at premier solar aim to provide customers with efficient power supply with as little carbon footprint as possible.', '$2y$10$CMCr7Blx4ajufnkKmvLYIeZOLZdhEs08zT9rTN6Oi7859csdNBVru', '1653245326-letter-a-logoa.jpg'),
(2, 'FX solar', 'email@fxsolar.com', 'FX solar is the leading supplier of solar energy.', '$2y$10$VffD21SYXj4WhmhtQZjCF.HSDqHsN43DWDpwKU6r6/WRfhmQ.5an.', '1655137904-company4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `threads`
--

CREATE TABLE `threads` (
  `thread_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `timestamp` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `threads`
--

INSERT INTO `threads` (`thread_id`, `name`, `timestamp`) VALUES
(1, 'How to reduce footprint', '2022-05-17 18:58:16');

-- --------------------------------------------------------

--
-- Table structure for table `uniquecodes`
--

CREATE TABLE `uniquecodes` (
  `code_id` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `uniquecodes`
--

INSERT INTO `uniquecodes` (`code_id`, `user`, `code`) VALUES
(8, 'john', '$2y$10$ErLYqVsdnYpcFkwUC7tJ2ODT2sUaJjPhoqPmi3ZZ439F47.wEVnZO'),
(9, 'john', '$2y$10$weQ/YMaGFTweUc0vLWL/6eKzyTld0nfPOFGlarYx5VMLZbwj3eQae');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password_hash`) VALUES
(1, 'sadiq', 'sadiq@example.com', '$2y$10$pVNV7fXY/RIL96BC280HluIiBFsC9Wkn4A82vHswSXRwnDEXVpysq'),
(2, 'john', 'john@example.com', '$2y$10$onCrJxZ4ZhT5pCVl.phWtOeyzg.PQl6o9QI6LYO.hzwtdijspYO2i'),
(4, 'sadiq', 'sadiq@sadiq.com', '$2y$10$ThJ6iwRAcdjo9yfklfv/r.b2mywB6zW.A3mDA4KVn7Mo5GliFOCqa');

-- --------------------------------------------------------

--
-- Table structure for table `windpower`
--

CREATE TABLE `windpower` (
  `company_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `windpower`
--

INSERT INTO `windpower` (`company_id`, `name`, `email`, `description`, `password`, `logo`) VALUES
(1, 'Pertubation Inc.', 'email@pertubation.com', 'PT Inc is the biggest multi-national wind power generation company, with subsidiaries in 4 different continents servicing almost 13 million people world wide.', '$2y$10$jvtlzqJe.dOX7pRG8Bt1W.X4bjyFmWNjTllOS7PiRTPOn2CWf2f3K', '1655231386-company3.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `claimed`
--
ALTER TABLE `claimed`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `generate`
--
ALTER TABLE `generate`
  ADD PRIMARY KEY (`g_id`);

--
-- Indexes for table `generated`
--
ALTER TABLE `generated`
  ADD PRIMARY KEY (`gen_id`);

--
-- Indexes for table `hydropower`
--
ALTER TABLE `hydropower`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `nuclearpower`
--
ALTER TABLE `nuclearpower`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `pendingrequests`
--
ALTER TABLE `pendingrequests`
  ADD PRIMARY KEY (`request_id`);

--
-- Indexes for table `processedrequests`
--
ALTER TABLE `processedrequests`
  ADD PRIMARY KEY (`pr_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`);

--
-- Indexes for table `sentwatt`
--
ALTER TABLE `sentwatt`
  ADD PRIMARY KEY (`sw_id`);

--
-- Indexes for table `solarpower`
--
ALTER TABLE `solarpower`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `threads`
--
ALTER TABLE `threads`
  ADD PRIMARY KEY (`thread_id`);

--
-- Indexes for table `uniquecodes`
--
ALTER TABLE `uniquecodes`
  ADD PRIMARY KEY (`code_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `windpower`
--
ALTER TABLE `windpower`
  ADD PRIMARY KEY (`company_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `claimed`
--
ALTER TABLE `claimed`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `generate`
--
ALTER TABLE `generate`
  MODIFY `g_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `generated`
--
ALTER TABLE `generated`
  MODIFY `gen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `hydropower`
--
ALTER TABLE `hydropower`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nuclearpower`
--
ALTER TABLE `nuclearpower`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pendingrequests`
--
ALTER TABLE `pendingrequests`
  MODIFY `request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `processedrequests`
--
ALTER TABLE `processedrequests`
  MODIFY `pr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sentwatt`
--
ALTER TABLE `sentwatt`
  MODIFY `sw_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `solarpower`
--
ALTER TABLE `solarpower`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `threads`
--
ALTER TABLE `threads`
  MODIFY `thread_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `uniquecodes`
--
ALTER TABLE `uniquecodes`
  MODIFY `code_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `windpower`
--
ALTER TABLE `windpower`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
