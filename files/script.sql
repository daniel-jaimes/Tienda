CREATE DATABASE dam2tm03uf6p2;
use dam2tm03uf6p2;
#DROP table dam2tm03uf6p2.componente;
#DROP table dam2tm03uf6p2.juego;
CREATE TABLE dam2tm03uf6p2.componente
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    nombre      VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);
CREATE TABLE dam2tm03uf6p2.juego
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    nombre     VARCHAR(255) NOT NULL,
    componente INT          NOT NULL,
    FOREIGN KEY (componente)
        REFERENCES dam2tm03uf6p2.componente (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
select * from juego;

INSERT INTO dam2tm03uf6p2.componente (nombre, descripcion) VALUES ('DWAD', 'ADWDAW');