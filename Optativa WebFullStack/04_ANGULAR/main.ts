// main.tsc
let saludos = (persona: string) => {
return "Hola, " + persona;
}
let usuario: string = "Marcos";
let sentencia = `Hola nu nombre es ${usuario}`;
console.log(sentencia);
document.body.innerHTML = saludos(usuario);
export{};