-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mybriefcasedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mybriefcasedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mybriefcasedb` DEFAULT CHARACTER SET utf8 ;
USE `mybriefcasedb` ;

-- -----------------------------------------------------
-- Table `mybriefcasedb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mybriefcasedb`.`user` (
  `user_id` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mybriefcasedb`.`dvd_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mybriefcasedb`.`dvd_profile` (
  `id` CHAR(36) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `serial` VARCHAR(45) NOT NULL,
  `profile_user` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_userid_dvd_idx` (`profile_user` ASC),
  CONSTRAINT `fk_user_userid_dvd`
    FOREIGN KEY (`profile_user`)
    REFERENCES `mybriefcasedb`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mybriefcasedb`.`gigahertz_ct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mybriefcasedb`.`gigahertz_ct` (
  `id` INT(10) UNSIGNED NOT NULL,
  `description` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mybriefcasedb`.`website_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mybriefcasedb`.`website_profile` (
  `id` CHAR(36) NOT NULL,
  `name` CHAR(25) NOT NULL,
  `url` VARCHAR(100) NOT NULL,
  `userid` CHAR(20) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `profile_user` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_userid_website_idx` (`profile_user` ASC),
  CONSTRAINT `fk_user_userid_website`
    FOREIGN KEY (`profile_user`)
    REFERENCES `mybriefcasedb`.`user` (`user_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mybriefcasedb`.`wireless_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mybriefcasedb`.`wireless_profile` (
  `id` CHAR(36) NOT NULL,
  `ipaddress` CHAR(17) NOT NULL,
  `device_name` CHAR(25) NOT NULL,
  `gigahertz_id` INT(10) UNSIGNED NOT NULL,
  `active` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0',
  `profile_user` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gigahertz_ct_gigahertz_id_idx` (`gigahertz_id` ASC),
  INDEX `fk_user_userid_wireless_idx` (`profile_user` ASC),
  CONSTRAINT `fk_user_userid_wireless`
    FOREIGN KEY (`profile_user`)
    REFERENCES `mybriefcasedb`.`user` (`user_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_gigahertz_ct_gigahertz_id`
    FOREIGN KEY (`gigahertz_id`)
    REFERENCES `mybriefcasedb`.`gigahertz_ct` (`id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
