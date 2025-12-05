const express = require('express')
const app = express()
const port = 3000

// motor de plantillas 
app.set('view engine', 'ejs');

// carpeta de las vistas
app.use('views', express.static(__dirname + '/views'));

// aqui ponemos los elementos publicos de la raiz
app.use(express.static(__dirname + '/public'))

// llamamos al fichero de las rutas
app.use('/', require('./router/rutas'));
app.use('/Nuestras_Autoescuelas', require('./router/autoescuelas'));

// para ver la imagen de public
app.get('/public/kirby.jpg', (req, res) => {
  res.send('KIRBYYY')
})

// esta es una pagína que saldrá en caso del error 404
app.use((req, res) => {
  res.status(404).sendFile(__dirname + "/public/html/404.html")
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
