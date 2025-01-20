DROP DATABASE IF EXISTS `media-mongers`;

CREATE DATABASE `media-mongers`;
USE `media-mongers`;

DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
	`movie_id` BIGINT NOT NULL AUTO_INCREMENT,
    `adult` TINYINT(1) DEFAULT 1,
    `backdrop_path` VARCHAR(255),
    `overview` VARCHAR(255),
    `poster_path` VARCHAR(255),
    `release_date` VARCHAR(16), 
    `runtime` INT,
    `status` VARCHAR(16),
    `title` VARCHAR(255),
    `uri` VARCHAR(255),
    `watched` TINYINT(0),
    `watchlist` TINYINT(0),
	`liked` TINYINT(0),
    `rating` DECIMAL,
    PRIMARY KEY (`movie_id`)
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
  
      DROP TABLE IF EXISTS `watched`;

CREATE TABLE `watched` (
	`watched_id` BIGINT NOT NULL AUTO_INCREMENT,
	`date` DATE DEFAULT NULL,
	`uri` VARCHAR( 255 ) DEFAULT NULL,
	`movie_id` BIGINT,
	PRIMARY KEY ( `watched_id` ),
	FOREIGN KEY ( `movie_id` ) REFERENCES `movies` ( `movie_id` )
  );
  
CREATE USER IF NOT EXISTS 'mongersapp'@'localhost' IDENTIFIED BY 'mongersapp';
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE on `media-mongers`.* TO 'mongersapp'@'localhost';