const express = require('express')
const bodyParser = require('body-parser')
const app = express()

require('dotenv').config()

const port = process.env.PORT || 4000

// parser la aplicacion
app.use(bodyParser.urlencoded({ extended: false}))

// parse de la app/json
app.use(bodyParser.json())

// motor de plantillas 
app.set('view engine', 'ejs');

// carpeta de las vistas
app.set('views', __dirname + '/views');

// para poder usar la carpeta donde tengamos ficheros (middleware)
app.use(express.static(__dirname + '/public'))

// llamamos al fichero de las rutas
app.use('/', require('./router/rutas'));
app.use('/usuario', require('./router/usuario'));

// Conexión a base de datos
const mongoose = require('mongoose');
const uri = `mongodb+srv://${process.env.USER}:${process.env.PASSWORD}@clase.xq89gc1.mongodb.net/${process.env.DBNAME}?retryWrites=true&w=majority`;

mongoose.connect(uri)
  .then(() => console.log('Base de datos conectada - LitMindDB'))
  .catch(e => console.log('Error de conexión:', e))

// Ruta 404
app.use((req, res) => {
  res.status(404).sendFile(__dirname + "/public/html/404.html")
})

app.listen(port, () => {
  console.log(`Servidor corriendo en puerto ${port}`)
})