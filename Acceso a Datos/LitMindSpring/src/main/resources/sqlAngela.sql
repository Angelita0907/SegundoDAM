-- crear base de datos
create database LitMindSpring;
-- Crear el usuario (si ya existe, esto dará error, puedes usar IF NOT EXISTS)
CREATE USER IF NOT EXISTS 'aSpring'@'%' IDENTIFIED BY 'aSpring1234';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `LitMindSpring`.* TO 'aSpring'@'%';
--  Refrescar
FLUSH PRIVILEGES;
