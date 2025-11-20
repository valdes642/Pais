/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  
 * Created:
 */
 
DROP DATABASE IF EXISTS `mundo`;

CREATE DATABASE IF NOT EXISTS mundo;
USE mundo;


CREATE TABLE IF NOT EXISTS `mundo`.`Pais` (
  `codigoPais` CHAR(3) NOT NULL,
  `nombrePais` VARCHAR(50) NOT NULL,
  `continentePais` VARCHAR(50) NOT NULL,
  `poblacionPais` INT NOT NULL,
  `tipoGobierno` BIT(1) NOT NULL,
  PRIMARY KEY (`codigoPais`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mundo`.`Ciudad` (
  `idCiudad` INT NOT NULL AUTO_INCREMENT,
  `nombreCiudad` VARCHAR(50) NOT NULL,
  `poblacionCiudad` INT NOT NULL,
  `codigoPais` CHAR(3) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  CONSTRAINT `ciudadfk`
    FOREIGN KEY (`codigoPais`)
    REFERENCES `mundo`.`Pais` (`codigoPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mundo`.`Idioma` (
  `idIdioma` INT NOT NULL AUTO_INCREMENT,
  `nombreIdioma` VARCHAR(50) NOT NULL,
  `oficial` BIT(1) NOT NULL,
  `codigoPais` CHAR(3) NOT NULL,
  PRIMARY KEY (`idIdioma`),
  CONSTRAINT `idiomafk`
    FOREIGN KEY (`codigoPais`)
    REFERENCES `mundo`.`Pais` (`codigoPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mundo`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `codigoPais` CHAR(3) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  CONSTRAINT `codUsuariofk`
    FOREIGN KEY (`codigoPais`)
    REFERENCES `mundo`.`Pais` (`codigoPais`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;

INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('AND', 'Andorra', 'Europa', '78000', 1);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('ARG', 'Argentina', 'America', '37032000', 1);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('AUT', 'Austria', 'Europa', '8091800', 1);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('BEL', 'Bélgica', 'Europa', '10239000', 0);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('BHS', 'Bahamas', 'America', '307000', 0);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('BLZ', 'Belize', 'America', '241000', 0);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('BRA', 'Brasil', 'America', '170115000', 0);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('CHL', 'Chile', 'America', '15211000', 1);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('CHN', 'China', 'Asia', '1277558000', 0);
INSERT INTO `mundo`.`pais` (`codigoPais`, `nombrePais`, `continentePais`, `poblacionPais`, `tipoGobierno`) VALUES ('MNG','Mongolia', 'Asia', '2662000', 0);

INSERT INTO mundo.Pais (codigoPais, nombrePais, continentePais, poblacionPais, tipoGobierno) VALUES
('PER', 'Perú', 'America', 33000000, 1),
('MEX', 'México', 'America', 126000000, 1),
('COL', 'Colombia', 'America', 51500000, 1);



INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Andorra la Vella', '21189', 'AND');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Buenos Aires', '2982146', 'ARG');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Córdoba', '1157507', 'ARG');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Bahía Blanca', '239810', 'ARG');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Wien', '240967', 'AUT');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Salzburg', '144247', 'AUT');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Antwerpen', '446525', 'BEL');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Gent', '224180', 'BEL');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Nassau', '172000', 'BHS');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Belize City', '55810', 'BLZ');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Rio de Janeiro', '5598953', 'BRA');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('São Paulo', '78978955', 'BRA');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Santiago de Chile', '4703954', 'CHL');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Viña del Mar', '312493', 'CHL');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Concepción', '217664', 'CHL');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Shanghai', '9696300', 'CHN');
INSERT INTO `mundo`.`ciudad` (`nombreCiudad`, `poblacionCiudad`, `codigoPais`) VALUES ('Ulan Bator', '773700', 'MNG');

INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Catalan', 1, 'AND');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Español', 0, 'AND');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Español', 1,  'ARG');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Italiano', 0, 'ARG');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('German', 1, 'AUT');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Serbo-Croatian', 0, 'AUT');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Dutch', 1, 'BEL');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Arabic', 0, 'BEL');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Creole', 0, 'BHS');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Inglés', 1, 'BLZ');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Espalol', 0, 'BLZ');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Portuges', 1, 'BRA');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Alemán', 0, 'BRA');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Español', 1, 'CHL');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('mapudungun', 0, 'CHL');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Chino', 1, 'CHN');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Zhuang', 0, 'CHN');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Mongolian', 1, 'MNG');
INSERT INTO `mundo`.`idioma` (`nombreIdioma`, `oficial`, `codigoPais`) VALUES ('Kazakh', 0, 'MNG');


INSERT INTO mundo.Usuario (nombre, username, password, codigoPais) VALUES
('Juan Pérez', 'jperez', '123456', 'CHL'),
('María López', 'mlopez', '123456', 'PER'),
('Carlos Ruiz', 'cruiz', '123456', 'ARG'),
('Ana Torres', 'atorres', '123456', 'MEX'),
('Pedro Gómez', 'pgomez', '123456', 'COL'),
('Lucía Fernández', 'lfernandez', '123456', 'CHL'),
('Ricardo Díaz', 'rdiaz', '123456', 'PER'),
('Sofía Morales', 'smorales', '123456', 'ARG'),
('Diego Herrera', 'dherrera', '123456', 'MEX'),
('Camila Soto', 'csoto', '123456', 'COL'),
('Gabriel Rivas', 'grivas', '123456', 'CHL'),
('Valentina Torres', 'vtorres', '123456', 'PER'),
('Tomás Aguilar', 'taguilar', '123456', 'ARG'),
('Daniela Bravo', 'dbravo', '123456', 'MEX'),
('Ignacio Silva', 'isilva', '123456', 'COL'),
('Fernanda Castro', 'fcastro', '123456', 'CHL'),
('Héctor Medina', 'hmedina', '123456', 'PER'),
('Nicole Pozo', 'npozo', '123456', 'ARG'),
('Esteban Fuentes', 'efuentes', '123456', 'MEX'),
('Francisca Araya', 'faraya', '123456', 'COL'),
('Pablo Cortés', 'pcortes', '123456', 'CHL'),
('Carolina Vega', 'cvega', '123456', 'PER'),
('Matías López', 'mlopez2', '123456', 'ARG'),
('Isidora Peña', 'ipena', '123456', 'MEX'),
('Sebastián Reyes', 'sreyes', '123456', 'COL'),
('Beatriz Soto', 'bsoto', '123456', 'CHL'),
('Mauricio Campos', 'mcampos', '123456', 'PER'),
('Paula Rojas', 'projas', '123456', 'ARG'),
('Felipe Navarro', 'fnavarro', '123456', 'MEX'),
('Daniela Mena', 'dmena', '123456', 'COL'),
('Vicente Figueroa', 'vfigueroa', '123456', 'CHL'),
('Antonia Díaz', 'adiaz', '123456', 'PER'),
('Cristóbal Ramos', 'cramos', '123456', 'ARG'),
('Josefa Valdés', 'jvaldes', '123456', 'MEX'),
('Rodrigo Cáceres', 'rcaceres', '123456', 'COL'),
('Martina Salinas', 'msalinas', '123456', 'CHL'),
('Álvaro Pizarro', 'apizarro', '123456', 'PER'),
('Trinidad Molina', 'tmolina', '123456', 'ARG'),
('Javier Carrillo', 'jcarrillo', '123456', 'MEX'),
('Camilo Guzmán', 'cguzman', '123456', 'COL');
