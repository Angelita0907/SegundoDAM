// Creamos la base de datos
// La seleccionamos para usarla
use('LitMindDB');

// --- 1. Definición de Índices (Clave 'id') ---

// Índice Único para la colección 'usuarios'
db.usuarios.createIndex({ id: 1 }, { unique: true });

// Índice Único para la colección 'lecturas'
db.lecturas.createIndex({ id: 1 }, { unique: true });

// Índice Único para la colección 'asignaciones'
db.asignaciones.createIndex({ id: 1 }, { unique: true });

// --- 2. Insertamos Lecturas Base (Necesarias para la incrustación) ---

// LECTURA 1 (LEC-89021A)
db.lecturas.insertOne(
  {
    "id": "LEC-89021A",
    "titulo": "Cien Años de Soledad (Fragmento)",
    "autor": "Gabriel García Márquez",
    "numPalabras": 3450, // int
    "puntuacionMedia": 4.75, // float
    "disponible": true, // boolean
    "tipoContenido": "Ficción",
    
    // Campos aplanados: Administración
    "fechaPublicacion": "2025-09-01",
    "costePorLicencia": 0.05, // float

    // Lista aplanada: Actividades
    "tiposPrueba": ["Opción Múltiple", "Tiempo Máximo"],
    "nivelesRecomendadosPrueba": [5, 4], // List<Integer>

    // Campo auxiliar: pesoEnCalificacion (0.0 por defecto en el catálogo)
    "pesoEnCalificacion": 0.0 
  }
);

// LECTURA 2 (LEC-45B09W)
db.lecturas.insertOne(
  {
    "id": "LEC-45B09W",
    "titulo": "Ensayo sobre la Memoria", 
    "autor": "Autor Anónimo",
    "numPalabras": 1800,
    "puntuacionMedia": 4.20,
    "disponible": true,
    "tipoContenido": "NoFicción",
    "fechaPublicacion": "2025-10-20",
    "costePorLicencia": 1.25,
    "tiposPrueba": ["Resumen"],
    "nivelesRecomendadosPrueba": [6],
    "pesoEnCalificacion": 0.0
  }
);


// --- 3. Insertamos Usuario (Estudiante) ---

// USUARIO (Estudiante)
db.usuarios.insertOne(
  {
    "id": "USR-001234",
    "nombreCompleto": "Diego García",
    "edad": 14, // int
    "esDocente": false, // boolean
    "metaDiaria": 30.5, // float
    "rolPrincipal": "Estudiante",
    
    // Campos eliminados/reemplazados del diseño original para coincidir con la clase Java:
    // "nivelLector" (removido, sus campos se usan en las clases), metaDiaria ahora es float.
    
    // Lista aplanada: Logros
    "codigosLogrosObtenidos": ["VEL-SUPERSONICA", "NO-FICTION-MASTER"],
    "puntosPorLogro": [500, 350] // List<Integer>
  }
);

// --- 4. Insertamos Asignación (Con incrustación de Lecturas) ---

// ASIGNACION
db.asignaciones.insertOne(
  {
    "id": "ASN-000456",
    "tituloAsignacion": "Proyecto: Inferencia y Resumen",
    "idDocente": "USR-000005",
    // fechaLimite (se puede dejar como String si el driver lo maneja)
    "fechaLimite": "2026-03-15", 
    "esObligatoria": true, // boolean
    
    // Campos aplanados: Clase Asignada
    "codigoClase": "3ESOA-2025",
    "totalAlumnos": 28, // int
    
    // LISTA INCORPORADA: List<Lectura>
    "referenciasLectura": [
      {
        "id": "LEC-89021A",
        "titulo": "Cien Años de Soledad (Fragmento)",
        "autor": "Gabriel García Márquez",
        "numPalabras": 3450,
        "puntuacionMedia": 4.75,
        "disponible": true,
        "tipoContenido": "Ficción",
        "fechaPublicacion": "2025-09-01",
        "costePorLicencia": 0.05,
        "tiposPrueba": ["Opción Múltiple", "Tiempo Máximo"],
        "nivelesRecomendadosPrueba": [5, 4],
        "pesoEnCalificacion": 0.40 // ¡Metadato de la tarea!
      },
      {
        "id": "LEC-45B09W",
        "titulo": "Ensayo sobre la Memoria", 
        "autor": "Autor Anónimo",
        "numPalabras": 1800,
        "puntuacionMedia": 4.20,
        "disponible": true,
        "tipoContenido": "NoFicción",
        "fechaPublicacion": "2025-10-20",
        "costePorLicencia": 1.25,
        "tiposPrueba": ["Resumen"],
        "nivelesRecomendadosPrueba": [6],
        "pesoEnCalificacion": 0.60 // ¡Metadato de la tarea!
      }
    ]
  }
);