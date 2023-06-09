-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 30, 2023 lúc 06:44 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `foodstore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `about`
--

CREATE TABLE `about` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `subTitle` text NOT NULL,
  `description` text NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `about`
--

INSERT INTO `about` (`id`, `title`, `subTitle`, `description`, `address`) VALUES
(4, 'sdaf', 'dsaf', 'sdfdf', 'dà');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `about_seq`
--

CREATE TABLE `about_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `about_seq`
--

INSERT INTO `about_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `content1` text NOT NULL,
  `content2` text NOT NULL,
  `position` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `foodId` int(11) NOT NULL,
  `quantity` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart_seq`
--

CREATE TABLE `cart_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `cart_seq`
--

INSERT INTO `cart_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(2, 'Fruit');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category_seq`
--

CREATE TABLE `category_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `category_seq`
--

INSERT INTO `category_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` float NOT NULL,
  `description` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `isSale` tinyint(1) NOT NULL DEFAULT 0,
  `discountPrice` float NOT NULL DEFAULT 0,
  `price` float NOT NULL,
  `beginSale` datetime DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  `endSale` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `food`
--

INSERT INTO `food` (`id`, `categoryId`, `name`, `quantity`, `description`, `image`, `isSale`, `discountPrice`, `price`, `beginSale`, `status`, `endSale`) VALUES
(102, 2, 'Banana', 5.2, 'This is banana', 'd3d427e96a6a4573af6c0517f8ef30af.jpg', 1, 0, 2.1, NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food_seq`
--

CREATE TABLE `food_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `food_seq`
--

INSERT INTO `food_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `shortDes` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `news`
--

INSERT INTO `news` (`id`, `title`, `description`, `date`, `shortDes`) VALUES
(2, 'U22 Việt Nam dẫn trước Lào 1-0', '<p>&nbsp;</p><p>&nbsp;</p><ul><li>&nbsp;</li><li>&nbsp;</li></ul><figure class=\"image\"><img src=\"https://znews-photo.zingcdn.me/w1920/Uploaded/yrfjpyvslyr/2023_04_30/VT_zing.jpg\" alt=\"\"></figure><figure class=\"table\"><table><tbody><tr><td><figure class=\"image\"><img src=\"https://znews-photo.zingcdn.me/w960/Uploaded/yrfjpyvslyr/2023_04_30/VT_zing.jpg\" alt=\"\"></figure></td></tr><tr><td>Văn Tùng, cầu thủ của CLB Hà Nội, ghi bàn thắng đầu tiên cho U22 Việt Nam ở SEA Games 32. Ảnh: <i>Quang Thịnh.</i></td></tr></tbody></table></figure><p>Ngay phút thứ 2, U22 Việt Nam có bàn mở tỷ số. Từ pha tạt bóng chính xác của Nguyễn Thanh Nhàn, Văn Tùng bật cao đánh đầu hiểm hóc, không cho thủ môn Thilavong cơ hội cản phá.</p><p>Sau bàn thắng, đoàn quân của HLV Philippe Troussier chơi bóng tự tin, tạo ra một thế trận áp đảo. U22 Việt Nam có nhiều cơ hội ngon ăn nhưng chưa có thêm bàn thắng khi thủ môn Thilavong chơi ấn tượng và các cú dứt điểm của Lê Văn Đô hay Nguyễn Thanh Nhàn chưa thực sự sắc bén.</p><p>Ở chiều ngược lại, U22 Lào cho thấy họ không dễ bắt nạt khi tích cực tổ chức vây ráp, phản công. Họ khiến U22 Việt Nam có nửa sau hiệp một tương đối khó khăn. Tuy nhiên, do phụ thuộc khá nhiều vào Roman Angot, đoàn quân của HLV Michael Weiss chưa gây được sóng gió thực sự cho khung thành U22 Việt Nam.</p>', '2023-04-30 20:17:23', 'fhfjfjh'),
(3, '2, U22 Việt Nam có bàn mở tỷ số. Từ ph', '<p>&nbsp;</p><p>&nbsp;</p><ul><li>&nbsp;</li><li>&nbsp;</li></ul><figure class=\"image\"><img src=\"https://znews-photo.zingcdn.me/w1920/Uploaded/yrfjpyvslyr/2023_04_30/VT_zing.jpg\" alt=\"\"></figure><figure class=\"table\"><table><tbody><tr><td><figure class=\"image\"><img src=\"https://znews-photo.zingcdn.me/w960/Uploaded/yrfjpyvslyr/2023_04_30/VT_zing.jpg\" alt=\"\"></figure></td></tr><tr><td>Văn Tùng, cầu thủ của CLB Hà Nội, ghi bàn thắng đầu tiên cho U22 Việt Nam ở SEA Games 32. Ảnh: <i>Quang Thịnh.</i></td></tr></tbody></table></figure><p>Ngay phút thứ 2, U22 Việt Nam có bàn mở tỷ số. Từ pha tạt bóng chính xác của Nguyễn Thanh Nhàn, Văn Tùng bật cao đánh đầu hiểm hóc, không cho thủ môn Thilavong cơ hội cản phá.</p><p>Sau bàn thắng, đoàn quân của HLV Philippe Troussier chơi bóng tự tin, tạo ra một thế trận áp đảo. U22 Việt Nam có nhiều cơ hội ngon ăn nhưng chưa có thêm bàn thắng khi thủ môn Thilavong chơi ấn tượng và các cú dứt điểm của Lê Văn Đô hay Nguyễn Thanh Nhàn chưa thực sự sắc bén.</p><p>Ở chiều ngược lại, U22 Lào cho thấy họ không dễ bắt nạt khi tích cực tổ chức vây ráp, phản công. Họ khiến U22 Việt Nam có nửa sau hiệp một tương đối khó khăn. Tuy nhiên, do phụ thuộc khá nhiều vào Roman Angot, đoàn quân của HLV Michael Weiss chưa gây được sóng gió thực sự cho khung thành U22 Việt Nam.</p>', '2023-04-30 20:19:45', 'kjhvxuin'),
(52, 'sdaf', '<p>ds</p>', '2023-04-30 23:32:09', 'fds');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news_seq`
--

CREATE TABLE `news_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `news_seq`
--

INSERT INTO `news_seq` (`next_val`) VALUES
(151);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderfood`
--

CREATE TABLE `orderfood` (
  `id` int(11) NOT NULL,
  `orderDate` datetime NOT NULL DEFAULT current_timestamp(),
  `shippingFee` float NOT NULL DEFAULT 25,
  `status` varchar(10) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `total` float NOT NULL,
  `user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `orderfood`
--

INSERT INTO `orderfood` (`id`, `orderDate`, `shippingFee`, `status`, `note`, `total`, `user`) VALUES
(52, '2023-04-30 21:20:31', 20, 'shipping', NULL, 2, 303),
(53, '2023-04-30 21:20:50', 20, 'shipping', NULL, 2, 303);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderfood_seq`
--

CREATE TABLE `orderfood_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `orderfood_seq`
--

INSERT INTO `orderfood_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderunit`
--

CREATE TABLE `orderunit` (
  `id` int(11) NOT NULL,
  `foodId` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  `quatity` float NOT NULL,
  `unitPrice` float NOT NULL,
  `orderFoodId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `orderunit`
--

INSERT INTO `orderunit` (`id`, `foodId`, `orderId`, `quatity`, `unitPrice`, `orderFoodId`) VALUES
(1, 102, 52, 1, 2, 0),
(2, 102, 53, 1, 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderunit_seq`
--

CREATE TABLE `orderunit_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `orderunit_seq`
--

INSERT INTO `orderunit_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  `paymentType` varchar(255) NOT NULL,
  `amount` float NOT NULL,
  `status` tinyint(1) NOT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tag`
--

CREATE TABLE `tag` (
  `newId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `token`
--

CREATE TABLE `token` (
  `id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL,
  `tokenType` varchar(255) NOT NULL DEFAULT 'BEARER',
  `revoked` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `token`
--

INSERT INTO `token` (`id`, `token`, `tokenType`, `revoked`, `expired`, `user_id`) VALUES
(1, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjNAZ21haWwuY29tIiwiaWF0IjoxNjgxODk3NDIzLCJleHAiOjE2ODE4OTc0ODN9.UWe81IkZ1kMHqHO8YKAf1Ir4j_1AorjTPFvmL4K-qKk', 'BEARER', 1, 1, 252),
(2, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjNAZ21haWwuY29tIiwiaWF0IjoxNjgxODk3OTMxLCJleHAiOjE2ODE4OTc5OTF9.2dQzFfo-rkFq9reKab8dyJoSve6uWGRiK6PodGupmHE', 'BEARER', 0, 0, 252),
(52, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjMxNTYxOCwiZXhwIjoxNjgyMzE1Njc4fQ.B10_AXJ4tq89x3_59JeCGf9-3_hXAbAEHFdaMzIJkc4', 'BEARER', 1, 1, 303),
(53, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjMxNTYyNywiZXhwIjoxNjgyMzE1Njg3fQ.QLelOgmpPM-rPpFFc7Jpw5EonSDUkniF3vMGLIAKFL4', 'BEARER', 1, 1, 303),
(102, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjMxNzI1NiwiZXhwIjoxNjgyMzE3MzE2fQ.SeBhlqbjq9wIuXDZ754HWG2BFzltY8Drjw9d3cQl4eQ', 'BEARER', 1, 1, 303),
(103, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjMxNzUwMSwiZXhwIjoxNjgyMzE3NTYxfQ.po8rM-wBOT0cirUbZy1F-TcXmJjc-ajZA_lqk1zsnYA', 'BEARER', 1, 1, 303),
(152, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM1MDAwNywiZXhwIjoxNjgyMzUwMDY3fQ.IdYX2KSfvT0OAewfj5M9Mb1FtTXM5Hfr6Eb_lw1W6oI', 'BEARER', 1, 1, 303),
(153, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM1MDAxMSwiZXhwIjoxNjgyMzUwMDcxfQ.AXKqL1UrcJWgJOAqKESh0N1sDehe2P-Xc7sGhhPoKLc', 'BEARER', 1, 1, 303),
(202, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM1MDA5NCwiZXhwIjoxNjgyMzUwMTU0fQ.nKvA_COYi-LHYWP-YHu3zLvmevgPPXD_LBYUoqw1Sbg', 'BEARER', 1, 1, 303),
(252, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM1NDk2NiwiZXhwIjoxNjgyMzU1MDI2fQ.ZKG8k93tZHqV-UNq1_z9AtoH4wGtPv31RQ7-G68r3Tc', 'BEARER', 1, 1, 303),
(302, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM5NTQ0MSwiZXhwIjoxNjgyMzk1NTAxfQ.HY5KCbLKw-qgTDh6wJka4YuBnH_i7c87GFulOTkrrqU', 'BEARER', 1, 1, 303),
(303, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM5NTc0MywiZXhwIjoxNjgyMzk1ODAzfQ.CzvvgU-g63JgDMh4d_QcWFAYy8PoH9s7_1TtNCF4Ppk', 'BEARER', 1, 1, 303),
(352, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM5NzY3OCwiZXhwIjoxNjgyMzk3NzM4fQ.g_G_SDAOuL7t9WPIjLVmHlC60jpk_Me3cyGIOhkDzFU', 'BEARER', 1, 1, 303),
(353, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM5ODMzMywiZXhwIjoxNjgyMzk4MzkzfQ.tXlOlcmjI-r43YU_DXNjrUJkd7I0qcKDBUHfOo9dh9k', 'BEARER', 1, 1, 303),
(354, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjM5ODM2MywiZXhwIjoxNjgyMzk4NDIzfQ.stcNHZR-8Z2F5DYbxGKdhsl9S1xI8EFW5tMpNdfn4-A', 'BEARER', 1, 1, 303),
(402, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjQ3ODc5OSwiZXhwIjoxNjgyNDc4ODU5fQ.fScmJjAWFkPGsB1eYENWYkxnKy5XNlWyoX7Epc4tWCw', 'BEARER', 1, 1, 303),
(452, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjQ3ODk2MSwiZXhwIjoxNjgyNDc5MDIxfQ.aqWXW1czOB4KAfmjz7xUzDisSgKuokBLH64EOpoipaU', 'BEARER', 1, 1, 303),
(502, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUwMjk3MCwiZXhwIjoxNjgyNTAzMDMwfQ.prMDkW0LBOwlkJd6YpYViUYGKKyO80gz2TcMWInEsBg', 'BEARER', 1, 1, 303),
(552, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUwMzMxMSwiZXhwIjoxNjgyNTAzMzcxfQ.o9YAMcBk47mzmFszguOY7ylHrVVm-DmSZiP4eSLITR8', 'BEARER', 1, 1, 303),
(553, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUwMzYzMSwiZXhwIjoxNjgyNTAzNjkxfQ.7v2h3RZukYxz-eNHAHQqCHbw0ENo1pyHR2DQ32y0uZE', 'BEARER', 1, 1, 303),
(602, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUwMzY0MSwiZXhwIjoxNjgyNTAzNzAxfQ.TixhJ0ucypyHL3ld5esXPhnZJmcdT2yIq3wTVcs5FFE', 'BEARER', 1, 1, 303),
(652, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUwMzcxMiwiZXhwIjoxNjgyNTAzNzcyfQ.GH_QdMXCUkmRJgIJUNqCLG4DcfB2xlwV7R9UTvRx7LE', 'BEARER', 1, 1, 303),
(702, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUwMzczMiwiZXhwIjoxNjgyNTAzNzkyfQ.dS3Mwjyzj38S9FLb0pGPxnYNnRIYAhpv8Z2YZPAzy3Q', 'BEARER', 1, 1, 303),
(752, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzMjU3NSwiZXhwIjoxNjgyNTMyNjM1fQ.qTSSYqxupLxavx88Q0OkdzaZ1Gzqu6tUJ-rFPIgXxiE', 'BEARER', 1, 1, 303),
(802, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzMzg3NywiZXhwIjoxNjgyNTMzOTM3fQ.4PQzycuoTjb2Dmq2z7oBFTFsO9E3eFtaOGBs_HqgeRg', 'BEARER', 1, 1, 303),
(852, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzNDU3NiwiZXhwIjoxNjgyNTM0NjM2fQ.bIsPR7yu3G_a2P2wmwBwS0LfjJF0fF1IVGb8ay7ehfY', 'BEARER', 1, 1, 303),
(853, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzNDYxOSwiZXhwIjoxNjgyNTM0Njc5fQ.kt4PLag-SUtNojVAXtfAUVDVAt5Bh1uZcM1CnjDLhQE', 'BEARER', 1, 1, 303),
(902, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzNTA1MCwiZXhwIjoxNjgyNTM1MTEwfQ.CEe-i6v07po714PpRXcBApBoZgE9ynd_yqriVw5YpFE', 'BEARER', 1, 1, 303),
(952, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzNTg5OCwiZXhwIjoxNjgyNTM1OTU4fQ.RdLcaz8dJFj2lU76ERnxN-jpCnRVBo3CbH2oSqaz9ug', 'BEARER', 1, 1, 303),
(1002, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzNTkzNCwiZXhwIjoxNjgyNTM1OTk0fQ.Z25haKdtULo-m1ADkEJOdC9dxdKjZjN-BHs5wYcDuMw', 'BEARER', 1, 1, 303),
(1003, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzNTk0OCwiZXhwIjoxNjgyNTM2MDA4fQ.Z-GB2e_pHieHF1SpOMI6k8wBX-9tjzRSjhTDSWSGHmc', 'BEARER', 1, 1, 303),
(1052, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzNjQ3NSwiZXhwIjoxNjgyNTM2NTM1fQ.6P-3bDOGZPqhHMEuJZRjgH_U52ddVGbG4pCFAOVswMY', 'BEARER', 1, 1, 303),
(1102, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzODY0MiwiZXhwIjoxNjgyNTM4NzAyfQ.iVphF63lWK2-gyShCDV3bMbrIyLYI8YZhhCv3jCNEcQ', 'BEARER', 1, 1, 303),
(1152, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzOTM3NiwiZXhwIjoxNjgyNTM5NDM2fQ.NIJYKZjxjt_JfRqSTppLUFeJaQ9ouEmHhzFej1hnhz4', 'BEARER', 1, 1, 303),
(1153, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjUzOTM4NSwiZXhwIjoxNjgyNTM5NDQ1fQ.7xrnhqAxvVlVmXZ_OdctulcSKVP1PdA5-1EuXsDho9I', 'BEARER', 1, 1, 303),
(1202, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYwMzExOCwiZXhwIjoxNjgyNjAzMTc4fQ.90ONYJ-45EpJlRG1Dp7beQV3dJuZ4kVJ-767kpLsoXg', 'BEARER', 1, 1, 303),
(1252, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYwMzI4NCwiZXhwIjoxNjgyNjAzMzQ0fQ.cvXCSX0CZSIkq_nsE8pOUUqRQkh9hYmt6yNkLbf_aBQ', 'BEARER', 1, 1, 303),
(1302, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYwMzkyNSwiZXhwIjoxNjgyNzc2NzI1fQ.RcnqMBHzcP4uqA9HGOdTo4zj_cZlGPPKbVsSa782RRo', 'BEARER', 1, 1, 303),
(1352, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYwNjM3OCwiZXhwIjoxNjgyNzc5MTc4fQ.qXkdGzltZC3DCvnXv6fsbtspqQfnDaCioM6h9g2goys', 'BEARER', 1, 1, 303),
(1402, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNDM1NSwiZXhwIjoxNjgyNzg3MTU1fQ.KaLQnhcJbUX3k88gJD3JJ9dEmUXu2545J8StxNAdrUE', 'BEARER', 1, 1, 303),
(1403, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNDM1NiwiZXhwIjoxNjgyNzg3MTU2fQ.v0DaVRkwg2iaJ_rNUkb-S0TVq2_r72_9A4vfvehZM1U', 'BEARER', 1, 1, 303),
(1452, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNTY3MiwiZXhwIjoxNjgyNzg4NDcyfQ.Npa6Aoa2ZRh2dbnMPrODZyvTuuVhhGVfu9D_EuT5gXg', 'BEARER', 1, 1, 303),
(1453, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNTgyMSwiZXhwIjoxNjgyNzg4NjIxfQ.sDbVFbfhTXJY5OYiuD_OnqSo-GcAwYI0aKx7DR7z9VM', 'BEARER', 1, 1, 303),
(1454, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNTgzOSwiZXhwIjoxNjgyNzg4NjM5fQ.k5ztuFe6_s1ZnYpeTo6trAQuL7_kTex_RUb-v64Lp7Y', 'BEARER', 1, 1, 303),
(1455, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNTk4OSwiZXhwIjoxNjgyNzg4Nzg5fQ.pjCm3WDUGF03LZpIzOsuslYVdaq_OaZUZMGgHxmvJVE', 'BEARER', 1, 1, 303),
(1456, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNjE2OCwiZXhwIjoxNjgyNzg4OTY4fQ.MtAy7ElPVGWoEYouqma5AzgaCNBHxSIWncKI2MJOyH4', 'BEARER', 1, 1, 303),
(1457, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNjE5OSwiZXhwIjoxNjgyNzg4OTk5fQ._uxeGIJrSDzOiv499cHYZ6MO3R1gpbyIXw7bSTmPhtM', 'BEARER', 1, 1, 303),
(1458, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNjMwMCwiZXhwIjoxNjgyNzg5MTAwfQ.sfWkUwGxj_GoBLUFUn_NqBWi_7UtAXOJtd27ri-dIm8', 'BEARER', 1, 1, 303),
(1459, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNjczMSwiZXhwIjoxNjgyNzg5NTMxfQ.zUcub66KadN3jQwcKseC2CWNQrtJAOzcASQ6tE_sJHQ', 'BEARER', 1, 1, 303),
(1502, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjYxNzQ0NCwiZXhwIjoxNjgyNzkwMjQ0fQ.-GihuogjsmTFD7VPe6TNYVTTVytyyEYH0fPdzPJRJFU', 'BEARER', 1, 1, 303),
(1552, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0c3NAZ21haW9sIiwiaWF0IjoxNjgyNjE5NjM4LCJleHAiOjE2ODI3OTI0Mzh9.FDUrNX7lFaVCKBdjTiJLLgrOCQGT2wIMWoF3MV7CAl8', 'BEARER', 0, 0, 352),
(1553, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0c3NAZ21haW9sMSIsImlhdCI6MTY4MjYxOTg5OCwiZXhwIjoxNjgyNzkyNjk4fQ.2x-6I7ne3aEFCD42bnR2hWJuQpdjj0InYb0JXXFZYfs', 'BEARER', 0, 0, 353),
(1602, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0c3NAZ21haW9sMTIiLCJpYXQiOjE2ODI2MTk5NjYsImV4cCI6MTY4Mjc5Mjc2Nn0.5P131LpIAcCCrfSiL9-jo6AU9PjiFmJk7YqHiyrt0uk', 'BEARER', 0, 0, 402),
(1603, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXNlcjFAZ21haWwuY29tIiwiaWF0IjoxNjgyNjIxMTE4LCJleHAiOjE2ODI3OTM5MTh9.P4uWhqM2D3wY71X6jnQRhSN5mgcvb7-S586ksux65Zg', 'BEARER', 1, 1, 403),
(1652, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXNlcjFAZ21haWwuY29tIiwiaWF0IjoxNjgyNjYwMTIyLCJleHAiOjE2ODI4MzI5MjJ9.EKWj1B4PhtQEa0D2e1Kw7K5PET0r30kFDLyJXPsC5So', 'BEARER', 0, 0, 403),
(1702, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjcwNDYzNiwiZXhwIjoxNjgyODc3NDM2fQ.6jo3l6b-xK4NcAwMFRMiD9ToZmSUN_3dGmq-Id-GPho', 'BEARER', 1, 1, 303),
(1752, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc0OTMwOSwiZXhwIjoxNjgyOTIyMTA5fQ.oylIAa_OUrShEyJ3UUlz4mkwdJxo3TUNNOYRBY2PqaA', 'BEARER', 1, 1, 303),
(1802, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc2MjI5NiwiZXhwIjoxNjgyOTM1MDk2fQ.TIDN1AuefKo77O5zYCBNPqAPVhMzVbuw4Cwfcc7_i4w', 'BEARER', 1, 1, 303),
(1852, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc3Mzg0NywiZXhwIjoxNjgyOTQ2NjQ3fQ.jKsRKe9fHQJLLfdsm8S863Bk-eOhgvUuJFAbojgZsuY', 'BEARER', 1, 1, 303),
(1902, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc3NTU1OCwiZXhwIjoxNjgyOTQ4MzU4fQ.Jta_RERegqcbPP6hWGHrPK_7DiDYIksAh6NVD-zxwR8', 'BEARER', 1, 1, 303),
(1952, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc3NjI3NywiZXhwIjoxNjgyOTQ5MDc3fQ.xQS_wqJp9kqM0j1uwaz0GxcOTBQR8JHQLTzp4LzSn9k', 'BEARER', 1, 1, 303),
(1953, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc3NjI4OSwiZXhwIjoxNjgyOTQ5MDg5fQ.GzXH217zoiCaVdsT_bEFA50XZDYYBvBfYWmYkyL4VOI', 'BEARER', 1, 1, 303),
(2002, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc3NjM4NSwiZXhwIjoxNjgyOTQ5MTg1fQ.X9QC-k0fgpFXmtyUo5c4U4CKrzFYhGv4B8EeLQNNIHM', 'BEARER', 1, 1, 303),
(2052, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc3NjQ1NywiZXhwIjoxNjgyOTQ5MjU3fQ.H6hsMf9hQepX2itf7SZj9g0VkE0UP2aj8RRFubT36RI', 'BEARER', 1, 1, 303),
(2102, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjc4NTcwOCwiZXhwIjoxNjgyOTU4NTA4fQ.kQucl7HxeyUaXZTutfqkBcTVscmjv2wzEr0T9oZElzo', 'BEARER', 1, 1, 303),
(2152, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4MjgzOTI5MiwiZXhwIjoxNjgzMDEyMDkyfQ.-3WEzX7Rds_ykltNMZ1u8MC4j84WKMuA4vDKHo81Mms', 'BEARER', 1, 1, 303),
(2202, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg0NzAxNiwiZXhwIjoxNjgzMDE5ODE2fQ.gBJPYrSbhdBoqqxobtLHEkg-yl2pU-erZMdNAvVms4Y', 'BEARER', 1, 1, 303),
(2252, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg0Nzc4MSwiZXhwIjoxNjgzMDIwNTgxfQ.Q8lVRPEtcDgZNxsk7Zxnw06gLmfc_nnz-TbI88ARJgc', 'BEARER', 1, 1, 303),
(2302, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg0ODU1MiwiZXhwIjoxNjgzMDIxMzUyfQ.58l-URZXAECTbxLHdBYh7HQO2GZWvDaLJ-m2eNBD5Ls', 'BEARER', 1, 1, 303),
(2352, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg0ODkwMSwiZXhwIjoxNjgzMDIxNzAxfQ.a-3940nln4Wx7xvnog0MKUd_nzoph7EOpO0XJLM393U', 'BEARER', 1, 1, 303),
(2402, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg0OTMzMCwiZXhwIjoxNjgzMDIyMTMwfQ.iHjCxpFYMzxzyZKM6l-D3STKdDEhBhNYFiy08IiJRbk', 'BEARER', 1, 1, 303),
(2452, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg2MTEzMSwiZXhwIjoxNjgzMDMzOTMxfQ.-DhPSyJhWC2VMOGzEgmeGBkbJdLMJQ6d9GLru57xOo0', 'BEARER', 1, 1, 303),
(2502, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXVtbEBoYXVtbC5jb20iLCJpYXQiOjE2ODI4NjI0NzksImV4cCI6MTY4MzAzNTI3OX0.sXzRvH2jwuXstrLi6Vt44i7e3_VHMpXUWa1ltVyi2wg', 'BEARER', 1, 1, 452),
(2503, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg2MjUyNCwiZXhwIjoxNjgzMDM1MzI0fQ.BP_I-FZ98HbhzyeAilLTZgRN3Fhl02vrjaYBaJDlRuM', 'BEARER', 1, 1, 303),
(2552, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg2MzYyOCwiZXhwIjoxNjgzMDM2NDI4fQ.h-k0kVUeMcTvZAinBUF7QfVjAF8l9OLxE72pNffIa8g', 'BEARER', 1, 1, 303),
(2602, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg2NDk2OSwiZXhwIjoxNjgzMDM3NzY5fQ.v4e4qnb81G18co95eo_CpNNige-M1xqHIIOczaZrYGc', 'BEARER', 1, 1, 303),
(2652, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg2NzQ4MSwiZXhwIjoxNjgzMDQwMjgxfQ.AWIIsbYTgpyE2fFn_j729uTpPqRtM84pZpk7IL_IeHI', 'BEARER', 1, 1, 303),
(2702, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg2Nzc4NCwiZXhwIjoxNjgzMDQwNTg0fQ.QTjVLrjWrK_x3lwIdQnX7VLnud4wjr46ktQj8_qr09g', 'BEARER', 1, 1, 303),
(2752, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg2ODE3NSwiZXhwIjoxNjgzMDQwOTc1fQ._sRYKE-UX1aSBu-G26a73R1TSFBI3qr6n_4_MgjtLC0', 'BEARER', 1, 1, 303),
(2802, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg3MDkxNywiZXhwIjoxNjgzMDQzNzE3fQ.no4YTI8LlQwwhIRUY3N8mY_I5kSIXdovvKLrNfDAMJs', 'BEARER', 1, 1, 303),
(2852, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg3MTQzMCwiZXhwIjoxNjgzMDQ0MjMwfQ.rrAFd9g_uAGb5GpSOd4vWvbjjCMFhKz0lEc_KCD3Quw', 'BEARER', 1, 1, 303),
(2902, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg3MTYwOSwiZXhwIjoxNjgzMDQ0NDA5fQ.PT57cQoGZivKAWOKEheeucfXNryQV4QRXOasAdK_nHQ', 'BEARER', 1, 1, 303),
(2952, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg3MTk4MSwiZXhwIjoxNjgzMDQ0NzgxfQ.4oGY8n5HBowbeBGMtbedPvTwN2L2we_o9DtTuTfUdEs', 'BEARER', 1, 1, 303),
(2953, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg3MjE1OCwiZXhwIjoxNjgzMDQ0OTU4fQ.ZKJG5yPW5Hk05NjePBiDwV8J0kmOGsKmxvaAaC6ncuA', 'BEARER', 1, 1, 303),
(3002, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2dWx1YW4xMjMzQGdtYWlsLmNvbSIsImlhdCI6MTY4Mjg3MjU0NSwiZXhwIjoxNjgzMDQ1MzQ1fQ.gCE7REFWk3x9OzN2mG8BRp5JKscOrQP9pLuUKy5TmnY', 'BEARER', 1, 1, 303);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `token_seq`
--

CREATE TABLE `token_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `token_seq`
--

INSERT INTO `token_seq` (`next_val`) VALUES
(3101);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `phone`, `name`, `address`, `password`, `status`, `role`) VALUES
(252, 'vuluan123@gmail.com', '0123456789', 'Vu Luan', '123 đường 123', '$2a$10$JnFcbSkEjtF37ePvAOdFP.Pfjs63CrZvyDtAEVeF3KLeghT0XVtiS', 1, 'USER'),
(303, 'vuluan1233@gmail.com', '0123456789', 'Vu Luan', '123 đường 123', '$2a$10$rsL14a5ViCKI/zsQlrGFEO.IsepE/OfR/ooib8A7Lp0zee3JtjWVy', 1, 'ADMIN'),
(352, 'tss@gmaiol', '1231', 'test', '123', '$2a$10$L.6i9aweEFX.9LAdLMOKc.rWUt6zCR.QQbw4wkLRGM.3WIXSt0GgG', 1, 'USER'),
(353, 'tss@gmaiol1', '1231', 'test1', '123', '$2a$10$VNiQFUjVshGYxubBDw9zJur0on6XlqrkbvzmEHJxdFzK3ITH5sQZ6', 1, 'USER'),
(402, 'tss@gmaiol12', '1231', 'test1', '123', '$2a$10$mtiMpdaDmNgwPlSTikmwROl5B9LfM9uApRoCiQUquKz0eVmdLbyze', 1, 'USER'),
(403, 'teser1@gmail.com', '0123456789', 'tester1', '123 avb', '$2a$10$/xFOc7pHxTKFd9TD503CPujphzCHFi4tBOvvkXzH3VlDK/cUoc5NO', 1, 'USER'),
(452, 'hauml@hauml.com', '1234567890', 'trunghau', 'hauml', '$2a$10$0Lth78SlDhWdQy.axEtJ2OWuYBH38dgf.TR4GOqFiC0O5V.522uze', 1, 'USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(551);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `about`
--
ALTER TABLE `about`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foodId` (`foodId`),
  ADD KEY `userId` (`userId`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`),
  ADD KEY `food_ibfk_1` (`categoryId`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orderfood`
--
ALTER TABLE `orderfood`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKky025lm1011kw4wu8wpwnrpx0` (`user`);

--
-- Chỉ mục cho bảng `orderunit`
--
ALTER TABLE `orderunit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foodId` (`foodId`),
  ADD KEY `orderId` (`orderId`);

--
-- Chỉ mục cho bảng `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`),
  ADD KEY `orderId` (`orderId`);

--
-- Chỉ mục cho bảng `tag`
--
ALTER TABLE `tag`
  ADD KEY `newId` (`newId`),
  ADD KEY `categoryId` (`categoryId`);

--
-- Chỉ mục cho bảng `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `token` (`token`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `about`
--
ALTER TABLE `about`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `banner`
--
ALTER TABLE `banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT cho bảng `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT cho bảng `orderfood`
--
ALTER TABLE `orderfood`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT cho bảng `orderunit`
--
ALTER TABLE `orderunit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `token`
--
ALTER TABLE `token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3003;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=453;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`foodId`) REFERENCES `food` (`id`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `food_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE SET NULL;

--
-- Các ràng buộc cho bảng `orderfood`
--
ALTER TABLE `orderfood`
  ADD CONSTRAINT `FKky025lm1011kw4wu8wpwnrpx0` FOREIGN KEY (`user`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `orderunit`
--
ALTER TABLE `orderunit`
  ADD CONSTRAINT `orderunit_ibfk_1` FOREIGN KEY (`foodId`) REFERENCES `food` (`id`),
  ADD CONSTRAINT `orderunit_ibfk_2` FOREIGN KEY (`orderId`) REFERENCES `orderfood` (`id`);

--
-- Các ràng buộc cho bảng `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`orderId`) REFERENCES `orderfood` (`id`);

--
-- Các ràng buộc cho bảng `tag`
--
ALTER TABLE `tag`
  ADD CONSTRAINT `tag_ibfk_1` FOREIGN KEY (`newId`) REFERENCES `news` (`id`),
  ADD CONSTRAINT `tag_ibfk_2` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
