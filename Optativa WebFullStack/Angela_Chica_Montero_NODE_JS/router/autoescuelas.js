const express = require('express') 
const router = express.Router();

// creamos la lista con las autoescuelas que llamaremos más adelante
router.get('/', (req, res) => {
    res.render("Nuestras_Autoescuelas", { 
        arrayautoescuelas: [ 
            {id: 'ae01', nombre: 'Autoescuela SinCoques1', tipo: 'Más antigua', descripcion:'Desde 1995'},
            {id: 'ae02', nombre: 'Autoescuela SinCoques2', tipo: 'Renovada', descripcion:'Con más aprobados de toda España'},
            {id: 'ae03', nombre: 'Autoescuela SinCoques3', tipo: 'En reformas', descripcion:'Disculpe las molestias, volveremos luego de las reformas'},
            {id: 'ae04', nombre: 'Autoescuela SinCoques4', tipo: 'Nueva', descripcion:'Matrículas abiertas, precio especial'},
            {id: 'ae05', nombre: 'Autoescuela SinCoques5', tipo: 'En construcción', descripcion:'Ubicada en una zona clave'}
        ]
    })
})

module.exports = router;