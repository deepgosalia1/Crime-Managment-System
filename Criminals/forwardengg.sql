-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema criminaldatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema criminaldatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `criminaldatabase` DEFAULT CHARACTER SET utf8 ;
USE `criminaldatabase` ;

-- -----------------------------------------------------
-- Table `criminaldatabase`.`Crime`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`Crime` (
  `ipc` INT NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  `bailable` ENUM("T", "F") NOT NULL,
  PRIMARY KEY (`ipc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criminaldatabase`.`Police`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`Police` (
  `police_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `police_station` VARCHAR(45) NOT NULL,
  `image` VARCHAR(150) NULL,
  `password` VARCHAR(45) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL COMMENT 'emailfield\n\n\n',
  PRIMARY KEY (`police_id`),
  UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criminaldatabase`.`CriminalRecord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`CriminalRecord` (
  `record_id` INT NOT NULL AUTO_INCREMENT,
  `police_station` VARCHAR(45) NOT NULL,
  `bust_time` TIMESTAMP NOT NULL,
  `punishment` VARCHAR(150) NOT NULL DEFAULT 'none',
  `criminal_id` INT NOT NULL,
  `ipc` INT NOT NULL,
  `investigated_by` INT NOT NULL,
  PRIMARY KEY (`record_id`),
  INDEX `criminal_id_idx` (`criminal_id` ASC) VISIBLE,
  INDEX `ipc_idx` (`ipc` ASC) VISIBLE,
  INDEX `police_idx` (`investigated_by` ASC) VISIBLE,
  CONSTRAINT `criminal_id`
    FOREIGN KEY (`criminal_id`)
    REFERENCES `criminaldatabase`.`Criminal` (`criminal_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ipc`
    FOREIGN KEY (`ipc`)
    REFERENCES `criminaldatabase`.`Crime` (`ipc`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `police`
    FOREIGN KEY (`investigated_by`)
    REFERENCES `criminaldatabase`.`Police` (`police_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criminaldatabase`.`Criminal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`Criminal` (
  `criminal_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `alias` VARCHAR(45) NULL,
  `sex` ENUM('M', "F", "U") NOT NULL DEFAULT "U",
  `judicial_status` VARCHAR(150) NULL DEFAULT 'none',
  `age` INT NULL,
  PRIMARY KEY (`criminal_id`),
  UNIQUE INDEX `criminal_id_UNIQUE` (`criminal_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criminaldatabase`.`Victim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`Victim` (
  `victim_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `sex` ENUM("M", "F", "U") NOT NULL DEFAULT "U",
  `age` INT NULL,
  `casualty` VARCHAR(150) NULL DEFAULT 'none',
  `image` VARCHAR(150) NULL,
  PRIMARY KEY (`victim_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criminaldatabase`.`Citizen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`Citizen` (
  `citizen_id` INT NOT NULL AUTO_INCREMENT,
  `contact_number` INT(10) NULL,
  `email_id` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NOT NULL DEFAULT 'Anonymous',
  `last_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`citizen_id`),
  UNIQUE INDEX `citizen_id_UNIQUE` (`citizen_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criminaldatabase`.`Leads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`Leads` (
  `lead_id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(100) NOT NULL,
  `report_time` TIMESTAMP NULL DEFAULT NULL,
  `description` VARCHAR(200) NOT NULL,
  `authority_validation` ENUM("True", "False", "U") NOT NULL DEFAULT "U",
  `reported_by` INT NULL DEFAULT '-1',
  `ipc` INT NOT NULL,
  PRIMARY KEY (`lead_id`),
  UNIQUE INDEX `id_lead_UNIQUE` (`lead_id` ASC) VISIBLE,
  INDEX `reported_by_idx` (`reported_by` ASC) VISIBLE,
  INDEX `ipc_idx` (`ipc` ASC) VISIBLE,
  CONSTRAINT `reported_by`
    FOREIGN KEY (`reported_by`)
    REFERENCES `criminaldatabase`.`Citizen` (`citizen_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ipcleads`
    FOREIGN KEY (`ipc`)
    REFERENCES `criminaldatabase`.`Crime` (`ipc`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `criminaldatabase`.`Victim_has_CriminalRecord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `criminaldatabase`.`Victim_has_CriminalRecord` (
  `Victim_victim_id` INT NOT NULL,
  `CriminalRecord_record_id` INT NOT NULL,
  PRIMARY KEY (`Victim_victim_id`, `CriminalRecord_record_id`),
  INDEX `fk_Victim_has_CriminalRecord_CriminalRecord1_idx` (`CriminalRecord_record_id` ASC) VISIBLE,
  INDEX `fk_Victim_has_CriminalRecord_Victim1_idx` (`Victim_victim_id` ASC) VISIBLE,
  CONSTRAINT `fk_Victim_has_CriminalRecord_Victim1`
    FOREIGN KEY (`Victim_victim_id`)
    REFERENCES `criminaldatabase`.`Victim` (`victim_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Victim_has_CriminalRecord_CriminalRecord1`
    FOREIGN KEY (`CriminalRecord_record_id`)
    REFERENCES `criminaldatabase`.`CriminalRecord` (`record_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
