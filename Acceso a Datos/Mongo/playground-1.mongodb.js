
// Select the database to use.
use('peliculas');

//db.createCollection("estudiantes");

//db.estudiantes.insertMany();

// Devolver todos los estudiantes
// db.estudiantes.find();

// devolver estudiantes orden ascendente nombre
// db.estudiantes.find().sort({"name":1});

// ordenador por notaMedia y name descendente
//db.estudiantes.find().sort({"notaMedia":-1, "name":-1});

//devolver _id = 22
db.estudiantes.find({_id:"17"});