-- =====================
-- LOGROS
-- =====================
INSERT INTO logro (nombre_logro, descripcion, icono, puntos_requeridos, lecturas_requeridas, categoria) VALUES
('Primer Paso', 'Completa tu primera lectura', '📖', 0, 1, 'Inicio'),
('Lector Ávido', 'Completa 5 lecturas', '🔥', 100, 5, 'Lectura'),
('Explorador', 'Lee un libro de cada género', '🗺️', 200, 10, 'Diversidad'),
('Centurión', 'Acumula 500 puntos XP', '⚔️', 500, 0, 'Puntos'),
('Maestro Lector', 'Completa 20 lecturas', '🏆', 1000, 20, 'Lectura');

-- =====================
-- ESTUDIANTES
-- =====================
INSERT INTO estudiante (nombre_completo, email, edad, puntosxp, nivel_actual, rol) VALUES
('Ana García López', 'ana.garcia@litmail.com', 14, 350, 3, 0),
('Carlos Martínez Ruiz', 'carlos.martinez@litmail.com', 15, 120, 1, 0),
('Sofía Hernández Pérez', 'sofia.hernandez@litmail.com', 13, 780, 7, 0),
('David Torres Sánchez', 'david.torres@litmail.com', 16, 50, 1, 0),
('Laura Jiménez Gómez', 'laura.jimenez@litmail.com', 14, 520, 5, 0),
('Marta Fernández Díaz', 'marta.fernandez@litmail.com', 35, 0, 0, 1),
('Roberto Navarro Gil', 'roberto.navarro@litmail.com', 42, 0, 0, 2);

-- =====================
-- LECTURAS
-- =====================
INSERT INTO lectura (titulo, autor, genero, numero_paginas, puntos_otorgados, descripcion, nombre_docente, fecha_asignacion, fecha_limite, progreso, calificacion, es_obligatoria, estudiante_id) VALUES
('El Hobbit', 'J.R.R. Tolkien', 'FANTASIA', 310, 80, 'La aventura de Bilbo Bolsón', 'Marta Fernández', '2026-01-10', '2026-02-10', 100, 9.0, true, 1),
('1984', 'George Orwell', 'CIENCIA_FICCION', 328, 90, 'Distopía en el año 1984', 'Marta Fernández', '2026-01-10', '2026-02-15', 60, null, true, 1),
('El Principito', 'Antoine de Saint-Exupéry', 'INFANTIL', 96, 40, 'Un príncipe de otro planeta', 'Marta Fernández', '2026-01-15', '2026-02-01', 100, 10.0, false, 2),
('Harry Potter y la Piedra Filosofal', 'J.K. Rowling', 'FANTASIA', 309, 80, 'El inicio de la saga de Harry Potter', 'Marta Fernández', '2026-01-15', '2026-02-20', 100, 8.5, true, 3),
('Cien Años de Soledad', 'Gabriel García Márquez', 'FICCION', 471, 120, 'La saga de los Buendía', 'Marta Fernández', '2026-01-20', '2026-03-01', 45, null, true, 3),
('Frankenstein', 'Mary Shelley', 'TERROR', 280, 70, 'La criatura del Dr. Frankenstein', 'Marta Fernández', '2026-02-01', '2026-03-01', 0, null, false, 4),
('Orgullo y Prejuicio', 'Jane Austen', 'ROMANCE', 432, 100, 'La historia de Elizabeth Bennet', 'Marta Fernández', '2026-01-05', '2026-02-05', 100, 9.5, true, 5),
('El Alquimista', 'Paulo Coelho', 'AVENTURA', 208, 60, 'La leyenda personal de Santiago', 'Marta Fernández', '2026-01-20', '2026-02-28', 80, null, false, 5);

-- =====================
-- RELACIÓN ESTUDIANTE - LOGROS (tabla intermedia)
-- =====================
INSERT INTO estudiante_logros (estudiantes_estudiante_id, logros_id_logro) VALUES
(1, 1), -- Ana tiene "Primer Paso"
(1, 2), -- Ana tiene "Lector Ávido"
(3, 1), -- Sofía tiene "Primer Paso"
(3, 2), -- Sofía tiene "Lector Ávido"
(3, 4), -- Sofía tiene "Centurión"
(5, 1), -- Laura tiene "Primer Paso"
(5, 3), -- Laura tiene "Explorador"
(2, 1); -- Carlos tiene "Primer Paso"