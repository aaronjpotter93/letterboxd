DROP DATABASE IF EXISTS `media-mongers`;

CREATE DATABASE `media-mongers`;
USE `media-mongers`;

DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
	`movie_id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) DEFAULT NULL,
    `year` YEAR DEFAULT NULL, 
    `uri` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`movie_id`)
);
  
  DROP TABLE IF EXISTS `ratings`;

CREATE TABLE `ratings` (
	`rating_id` BIGINT NOT NULL AUTO_INCREMENT,
	`date` DATE DEFAULT NULL,
	`rating` DECIMAL DEFAULT NULL,
	`movie_id` BIGINT,
	PRIMARY KEY ( `rating_id` ),
	FOREIGN KEY ( `movie_id` ) REFERENCES `movies` ( `movie_id` )
  );
  
    DROP TABLE IF EXISTS `watchlist`;

CREATE TABLE `watchlist` (
	`watchlist_id` BIGINT NOT NULL AUTO_INCREMENT,
	`date` DATE DEFAULT NULL,
	`uri` VARCHAR( 255 ) DEFAULT NULL,
	`movie_id` BIGINT,
	PRIMARY KEY ( `watchlist_id` ),
	FOREIGN KEY ( `movie_id` ) REFERENCES `movies` ( `movie_id` )
  );
  
CREATE USER IF NOT EXISTS 'mongersapp'@'localhost' IDENTIFIED BY 'mongersapp';
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE on `media-mongers`.* TO 'mongersapp'@'localhost';