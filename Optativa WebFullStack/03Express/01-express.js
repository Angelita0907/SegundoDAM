const express = require('express')
const app = express()
const port = 3000

// para poder usar la carpeta donde tengamos ficheros
app.use(express.static(__dirname + '/public'))

app.get('/', (req, res) => {
    //console.log(__dirname + '/public') // pinta la ruta de donde estamos
  res.send('Ya somos unos cracks en node+express')
})

app.get('/contacto', (req, res) => {
  res.send('Estás en contacto')
})

app.get('/about_us', (req, res) => {
  res.send('Estás en about us')
})

app.get('/productos', (req, res) => {
  res.send('Estás en productos')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
