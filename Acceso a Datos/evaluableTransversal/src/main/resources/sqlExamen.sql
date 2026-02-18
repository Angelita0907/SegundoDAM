CREATE DATABASE salud;
CREATE TABLE salud.paciente (
    id_paciente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dni VARCHAR(10) UNIQUE NOT NULL
);
INSERT INTO salud.paciente (nombre, dni) VALUES 
('Juan Pérez', '12345678A'),
('María López', '23456789B'),
('Carlos Sánchez', '34567890C'),
('Ana González', '45678901D'),
('Pedro Martínez', '56789012E');

-- Crear el usuario (si ya existe, esto dará error, puedes usar IF NOT EXISTS)
CREATE USER IF NOT EXISTS 'aSpring'@'%' IDENTIFIED BY 'aSpring1234';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `salud`.* TO 'aSpring'@'%';
--  Refrescar
FLUSH PRIVILEGES;
