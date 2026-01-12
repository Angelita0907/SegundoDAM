<<<<<<< HEAD
const express = require('express') //Requerimos Express
const router = express.Router();

// Ahora, CORTAMOS del fichero principal 01-express.js
// las dos rutas que tenemos: la principal ( / ) y la 
// de contactos ( /contaco )
// Importante que ya no usaremos el app.get(...), ahora
//vamos a utilizar las rutas, por lo que deberemos poner:
router.get('/', (req, res) => {
    res.render("index", { titulo: "mi titulo dinámico" })
})

router.get('/contacto', (req, res) => {
    res.render("contacto", { tituloContacto: "Estamos en contacto de manera dinámica!!" })
})
// Por último, vamos a exportarlo:
module.exports = router;
=======
const express = require('express') //Requerimos Express
const router = express.Router();

// Ahora, CORTAMOS del fichero principal 01-express.js
// las dos rutas que tenemos: la principal ( / ) y la 
// de contactos ( /contaco )
// Importante que ya no usaremos el app.get(...), ahora
//vamos a utilizar las rutas, por lo que deberemos poner:
router.get('/', (req, res) => {
    res.render("index", { titulo: "mi titulo dinámico" })
})

router.get('/contacto', (req, res) => {
    res.render("contacto", { tituloContacto: "Estamos en contacto de manera dinámica!!" })
})
// Por último, vamos a exportarlo:
module.exports = router;
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
