
// Creamos la base de datos
// La seleccionamos para usarla
use('use LitMindDB;');

// insertamos datos para que nuestro json tenga datos

// Índice Único para la colección 'usuarios'
db.usuarios.createIndex({ id: 1 }, { unique: true });

// Índice Único para la colección 'lecturas'
db.lecturas.createIndex({ id: 1 }, { unique: true });

// Índice Único para la colección 'asignaciones'
db.asignaciones.createIndex({ id: 1 }, { unique: true });

// creamos los documentos (entidades)

// USUARIO (Estudiante)
db.usuarios.insertOne(
  {
    "id": "USR-001234",
    "nombreCompleto": "Diego García",
    "edad": 14,
    "esDocente": false,
    "metaDiaria": 30.5,
    "rolPrincipal": "Estudiante",
    "nivelLector": {
      "puntuacionComprension": 85,
      "velocidadPPM": 450,
      "adaptacionIAActiva": true
    },
    "logrosObtenidos": [
      {
        "codigoLogro": "VEL-SUPERSONICA",
        "puntosGanados": 500,
        "fechaObtencion": "2025-11-20"
      },
      {
        "codigoLogro": "NO-FICTION-MASTER",
        "puntosGanados": 350,
        "fechaObtencion": "2025-12-01"
      }
    ]
  }
);

// LECTURA 
db.lecturas.insertOne(
  {
    "id": "LEC-89021A",
    "titulo": "Cien Años de Soledad (Fragmento)",
    "autor": "Gabriel García Márquez",
    "numPalabras": 3450,
    "puntuacionMedia": 4.75,
    "disponible": true,
    "tipoContenido": "Ficción",
    "administracion": {
      "fechaPublicacion": "2025-09-01",
      "fuenteLegal": "Convenio Editorial X",
      "costePorLicencia": 0.05
    },
    "actividades": [
      {
        "idInternoActividad": "Q01-INFERENCIAL",
        "tipoPrueba": "Opción Múltiple",
        "nivelRecomendado": 5,
        "esObligatoria": true
      },
      {
        "idInternoActividad": "Q02-VELOCIDAD",
        "tipoPrueba": "Tiempo Máximo",
        "nivelRecomendado": 4,
        "esObligatoria": true
      }
    ]
  }
);

// ASIGNACION
db.asignaciones.insertOne(
  {
    "id": "ASN-000456",
    "tituloAsignacion": "Proyecto: Inferencia y Resumen",
    "idDocente": "USR-000005",
    "fechaLimite": "2026-03-15",
    "esObligatoria": true,
    "claseAsignada": {
      "nombreClase": "3º ESO - Grupo A",
      "codigoClase": "3ESOA-2025",
      "totalAlumnos": 28
    },
    "lecturasRequeridas": [
      {
        "idLectura": "LEC-89021A",
        "tituloLectura": "Cien Años de Soledad (Fragmento)",
        "pesoEnCalificacion": 0.40
      },
      {
        "idLectura": "LEC-45B09W", // Se requiere una segunda lectura de ejemplo
        "tituloLectura": "Ensayo sobre la Memoria", 
        "pesoEnCalificacion": 0.60
      }
    ]
  }
);
