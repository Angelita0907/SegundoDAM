const express = require('express') //Requerimos Express
const router = express.Router();

// aquí es donde van a ir ahora nuestras rutas para simplificar código

// ejemplo luego borrar
router.get('/', (req, res) => {
    res.render("inicio", { titulo: "Esperamos su visita" })
})

router.get('/About_us', (req, res) => {
    res.render("About_us", { titulo: "Sobre Nosotros" })
})



router.get('/Contacto', (req, res) => {
    res.render("Contacto", { titulo: "Contáctenos" })
})


// Por último, vamos a exportarlo:
module.exports = router;
