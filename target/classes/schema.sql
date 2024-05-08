# employee part

drop table if exists employee;
CREATE TABLE `employee` (
  `id` int NOT NULL primary key AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `position` varchar(30) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL
);

INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (1, '홍길동', '부장', '인사부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (2, '이순신', '과장', '마케팅부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (3, '김유신', '대리', '영업부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (4, '신사임당', '사원', '기획부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (5, '세종대왕', '부장', '재무부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (6, '윤봉길', '과장', '인사부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (7, '한석봉', '대리', '마케팅부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (8, '대조영', '사원', '영업부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (9, '장보고', '부장', '기획부');
INSERT INTO `employee` (`id`, `name`, `position`, `department`) VALUES (10, '강감찬', '과장', '재무부');


# user part

use ssafydb;
drop table if exists user;

CREATE TABLE `user` (
    userId BIGINT AUTO_INCREMENT,
    loginId VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(30),
    createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    age Int,
    gender ENUM('male', 'female') NOT NULL,
    nickName VARCHAR(20),
    PRIMARY KEY (userId)
);

INSERT INTO `user` (loginId, password, name, phone, email, age, gender, nickName) VALUES
('john1234', 'password1', 'John Doe', '123-456-7890', 'john@example.com', 30, 'male', 'johndoe'),
('jane99', 'password2', 'Jane Smith', '987-654-3210', 'jane@example.com', 25, 'female', 'janesmith'),
('mj1234', 'password3', 'Michael Johnson', '555-555-5555', 'michael@example.com', 35, 'male', 'michaelj');

SELECT * FROM ssafydb.user;