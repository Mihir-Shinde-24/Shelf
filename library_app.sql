-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2023 at 06:46 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passcode` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `name`, `passcode`, `role`) VALUES
(1, 'super@admin.com', 'super', '$2a$10$.hRLLMvQ5iAjjud8f5ovcuJd7sUTyzBowNrm2hnINXImrZtCTlvrW', 'ROLE_SUPER'),
(2, 'riya@admin.com', 'riya', '$2a$10$io8ad7L4eWBRAADjzTXi1.Ukv4Pf.3YfXvA1Oet03uVgOC.Qd.kyi', 'ROLE_ADMIN'),
(3, 'mona@admin.com', 'mona', '$2a$10$kOI14y9xdrdbvu3JJnFPleib3.pfh7knTBl1rlJA7NWAM0CoXBbYK', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_available` bit(1) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `customer_email`, `description`, `is_available`, `price`, `title`) VALUES
(1, 'akshay@gmail.com', 'Spider-Man is a superhero appearing in American comic books published by Marvel Comics. Created by writer-editor Stan Lee and artist Steve Ditko, he first appeared in the anthology comic book Amazing Fantasy #15 in the Silver Age of Comic Books.', b'0', 500, 'Spider-Man'),
(2, NULL, 'Batman is a superhero appearing in American comic books published by DC Comics. The character was created by artist Bob Kane and writer Bill Finger, and debuted in the 27th issue of the comic book Detective Comics on March 30, 1939', b'1', 600, 'Batman'),
(3, 'aamir@gmail.com', 'The Hulk is a superhero appearing in American comic books published by Marvel Comics. Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the debut issue of The Incredible Hulk (May 1962).', b'0', 600, 'Hulk'),
(4, 'shahrukh@gmail.com', 'Harry James Potter is a fictional character and the titular protagonist in JK Rowling\'s series of eponymous novels.The majority of the books\' plot covers seven years in the life of the orphan Harry, who, on his eleventh birthday, learns he is a wizard. ', b'0', 700, 'Harry-Potter'),
(5, 'sunny@gmail.com', 'The Panchatantra is an ancient Indian collection of interrelated animal fables in Sanskrit verse and prose, arranged within a frame story. The surviving work is dated to about 200 BCE, but the fables are likely much more ancient.', b'0', 250, 'The Panchatantra'),
(6, NULL, 'Wings of Fire, is the autobiography of the Missile Man of India and President of India, Dr. A. P. J. Abdul Kalam. It was written by him and Arun Tiwari.', b'1', 350, 'Wings of Fire');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `has_taken_book` bit(1) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `book_name`, `email`, `first_name`, `has_taken_book`, `last_name`) VALUES
(1, '', 'salman@gmail.com', 'Salman', b'0', 'Khan'),
(2, 'Spider-Man', 'akshay@gmail.com', 'Akshay', b'1', 'Kumar'),
(3, 'Harry-Potter', 'shahrukh@gmail.com', 'Shahrukh', b'1', 'Khan'),
(4, 'Hulk', 'aamir@gmail.com', 'Aamir', b'1', 'Khan'),
(5, 'The Panchatantra', 'sunny@gmail.com', 'Sunny', b'1', 'Deol');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
