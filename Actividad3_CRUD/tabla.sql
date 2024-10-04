CREATE TABLE `portfolio_projects`.`alumnos` (
  `idAlumnos` INT NOT NULL AUTO_INCREMENT,
  `nombreAlumnos` VARCHAR(45) NOT NULL,
  `edad` INT NULL,
  PRIMARY KEY (`idAlumnos`));
  
INSERT INTO `portfolio_projects`.`alumnos` (nombreAlumnos, edad) VALUES ("Diana Pascual García", 40);
