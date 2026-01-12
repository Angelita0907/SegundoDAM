<<<<<<< HEAD
CREATE DATABASE AngelaJdbc;

CREATE TABLE AngelaJdbc.jugadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100)  NOT NULL,
    puntosTotales INT DEFAULT 0
);

CREATE TABLE AngelaJdbc.partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    torneo_id INT,
    narrador_id INT,
    fecha DATE NOT NULL,
    resultado ENUM('TODOS', 'NADIE', 'ALGUNOS') NOT NULL,
    FOREIGN KEY (narrador_id) REFERENCES jugadores(id)
);
=======
CREATE DATABASE AngelaJdbc;

CREATE TABLE AngelaJdbc.jugadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100)  NOT NULL,
    puntosTotales INT DEFAULT 0
);

CREATE TABLE AngelaJdbc.partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    torneo_id INT,
    narrador_id INT,
    fecha DATE NOT NULL,
    resultado ENUM('TODOS', 'NADIE', 'ALGUNOS') NOT NULL,
    FOREIGN KEY (narrador_id) REFERENCES jugadores(id)
);
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
