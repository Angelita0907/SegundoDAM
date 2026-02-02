-- crear base de datos
create database LitMind;
-- Crear el usuario (si ya existe, esto dará error, puedes usar IF NOT EXISTS)
CREATE USER IF NOT EXISTS 'angela'@'%' IDENTIFIED BY 'angela';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `LitMind`.* TO 'angela'@'%';
--  Refrescar
FLUSH PRIVILEGES;
