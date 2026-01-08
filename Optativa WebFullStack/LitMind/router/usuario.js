const express = require('express');
const router = express.Router();
const Usuario = require('../models/usuarios'); // Cambiado a modelo Usuario

// Vista para crear un nuevo usuario
router.get('/crearUsuario', (req, res) => {
    res.render('crearUsuario') 
})

// Listado de usuarios
router.get('/', async (req, res) => {
    try {
        // Cambiado arrayPokemonDB por arrayUsuariosDB
        const arrayUsuariosDB = await Usuario.find();
        console.log(arrayUsuariosDB);
        res.render("usuarios", { 
            arrayUsuarios: arrayUsuariosDB
        })
    } catch (error) {
        console.error(error)
    }
})

// Detalle de un usuario único
router.get('/:id', async(req, res) => { 
    const id = req.params.id 
    try {
        const usuarioDB = await Usuario.findOne({ _id: id }) 
        console.log(usuarioDB) 
        res.render('detalle', { 
            usuario: usuarioDB,
            error: false
        })
    } catch (error) { 
        console.log('Se ha producido un error', error)
        res.render('detalle', { 
            error: true,
            mensaje: '¡Usuario no encontrado!'
        })
    }
})

// Crear usuario (POST)
router.post('/', async (req, res) => {
    const body = req.body 
    console.log(body) 

    // asi mongo entiende el check box del formulario como un booleano que si no me daba error
    body.esDocente = body.esDocente === 'on' ? true : false;

    try {
        const usuarioDB = new Usuario(body) 
        await usuarioDB.save() 
        res.redirect('/usuario') // Redirige a la lista de usuarios
    } catch (error) {
        console.log('error', error)
    }
})

// Eliminar usuario
router.delete('/:id', async (req, res) => {
    const id = req.params.id;
    console.log('id desde backend', id)
    try {
        const usuarioDB = await Usuario.findByIdAndDelete({ _id: id });
        
        if (!usuarioDB) {
            res.json({ 
                estado: false,
                mensaje: 'No se puede eliminar el usuario.'
            })
        } else {
            res.json({
                estado: true,
                mensaje: 'Usuario eliminado.'
            })
        } 
    } catch (error) {
        console.log(error)
    }
})

// Modificar usuario (PUT)
router.put('/:id', async (req, res) => {
    const id = req.params.id;
    const body = req.body;
    console.log(id)
    console.log('body', body)

    try {
        const usuarioDB = await Usuario.findByIdAndUpdate(
            id, body, { useFindAndModify: false }
        )
        console.log(usuarioDB)
        res.json({
            estado: true,
            mensaje: 'Usuario editado'
        })
    } catch (error) {
        console.log(error)
        res.json({
            estado: false,
            mensaje: 'Problema al editar el usuario'
        })
    }
})

module.exports = router;