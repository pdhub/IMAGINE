CREATE TABLE `user` (
  `USERNAME` VARCHAR(32) DEFAULT NULL,
  `PASSWORD` VARCHAR(32) DEFAULT NULL,
  `USERID` INT(32) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

INSERT  INTO `user`(`USERNAME`,`PASSWORD`,`USERID`) VALUES ('pritom','pritom',1);

CREATE TABLE `questions` (
  `QuestionId` INT(32) NOT NULL,
  `Question` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`QuestionId`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
SELECT SYSDATE- SYSDATE  FROM DUAL;
/*Data for the table `questions` */

INSERT  INTO `questions`(`QuestionId`,`Question`) VALUES (1,'What is the color of a Peacock?'),(2,'How does a Dog sound?');

DROP TABLE IF EXISTS `answers`;

CREATE TABLE `answers` (
  `AnsId` INT(11) NOT NULL,
  `Ans` VARCHAR(100) DEFAULT NULL,
  `QuestionId` INT(11) DEFAULT NULL,
  `Is_Correct_Ans` VARCHAR(1) DEFAULT NULL,
  PRIMARY KEY (`AnsId`),
  KEY `fk_QuestionId` (`QuestionId`),
  CONSTRAINT `fk_QuestionId` FOREIGN KEY (`QuestionId`) REFERENCES `questions` (`QuestionId`) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `answers` */

INSERT  INTO `answers`(`AnsId`,`Ans`,`QuestionId`,`Is_Correct_Ans`) VALUES (11,'Green',1,'Y'),(12,'Blue',1,'N'),(13,'Black',1,'N'),(21,'Woof!!',2,'Y'),(22,'Meoow..',2,'N'),(23,'Quack',2,'N');

CREATE TABLE `user_ans` (
  `USER_ID` VARCHAR(32) DEFAULT NULL,
  `QUES_ID` INT(10) DEFAULT NULL,
  `ANS_ID` INT(10) DEFAULT NULL,
  `USER_ANS_ID` INT(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`USER_ANS_ID`)
) ENGINE=INNODB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

CREATE TABLE user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(32) NOT NULL,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES USER (USERNAME));
  
INSERT INTO USER(username,PASSWORD,userid,enabled)
VALUES ('mkyong','123456','123', TRUE);
INSERT INTO USER(username,PASSWORD,userid,enabled)
VALUES ('alex','123456','456', TRUE);

SELECT * FROM USER;
SELECT * FROM USER_ROLEs;


INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('alex', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('pritom', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('pritom', 'ROLE_USER');