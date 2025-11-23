
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
//db.estudiantes.find({"_id":"17"});

// devuelve sólo el nombre y la dirección del estudiante con id igual 22
//db.estudiantes.find({"_id":"17"},{"name":1, "address":1, "_id":0});

//estudiantes que son de  BROOKLYN
//db.estudiantes.find({"address.city":"BROOKLYN"});


//un estudiante de BROOKLYN
//db.estudiantes.findOne({"address.city":"BROOKLYN"});

//estudiantes que son de BROOKLYN o MANHTTAN
//db.estudiantes.find({$or:[{"address.city":"BROOKLYN"},{"address.city":"MANHTTAN"}]});

//estudiantes cuya nota media es mayor o igual que 4
//db.estudiantes.find({"notaMedia":{$gt:4}});

//estudiantes cuya nota media es mayor o igual que 4 y menor que 6
//db.estudiantes.find({"notaMedia":{$gte:4, $lt:6}});

//estudiantes tienen de nota media 9 o más.
db.estudiantes.find({"notaMedia":{$gte:9}});