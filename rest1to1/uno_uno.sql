-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`alumnos` (
  `idalumno` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`idalumno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`infocontacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`infocontacto` (
  `idinfocontacto` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `alumnos_idalumno` INT NOT NULL,
  PRIMARY KEY (`idinfocontacto`, `alumnos_idalumno`),
  INDEX `fk_infocontacto_alumnos_idx` (`alumnos_idalumno` ASC) VISIBLE,
  CONSTRAINT `fk_infocontacto_alumnos`
    FOREIGN KEY (`alumnos_idalumno`)
    REFERENCES `mydb`.`alumnos` (`idalumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
