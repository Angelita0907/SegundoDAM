const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const usuarioSchema = new Schema({
    nombreCompleto: String,
    edad: Number,
    esDocente: Boolean,
    rolPrincipal: String,
    puntosPorLogro: Number,
    tipoUsuario: String
})

//Creamos el modelo
const Usuarios = mongoose.model('usuarios', usuarioSchema, "usuarios");

module.exports = Usuarios;
