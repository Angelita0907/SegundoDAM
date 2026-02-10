-- crear base de datos
create database AngelaChicaHQL;
-- Crear el usuario (si ya existe, esto dará error, puedes usar IF NOT EXISTS)
CREATE USER IF NOT EXISTS 'usuario3'@'%' IDENTIFIED BY 'usuario3';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `AngelaChicaHQL`.* TO 'usuario3'@'%';
--  Refrescar
FLUSH PRIVILEGES;
