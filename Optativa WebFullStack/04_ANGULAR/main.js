"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// main.tsc
var saludos = function (persona) {
    return "Hola, " + persona;
};
var usuario = "Marcos";
var sentencia = "Hola nu nombre es ".concat(usuario);
console.log(sentencia);
document.body.innerHTML = saludos(usuario);
