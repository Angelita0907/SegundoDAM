//alert("Hello World!");
/*
console.log("Hola k ase")

var table = "Normal Table";
let chair = "One chair";

console.log(table);
console.log(chair);

//crearcion de variables
let testBoolean = true;
console.log(testBoolean);

let testNumber = 10;
console.log(testNumber);

let testString = 'text';
console.log(testString);

//creacion variables de objeto
let testBooleanObject =  new Boolean(true);
console.log(testBooleanObject);

let testNumberObject = new Number(10);
console.log(testNumberObject);

let testStringObject = new String('text');
console.log(testStringObject);
console.log(testStringObject.toLocaleUpperCase());

//concatenar variables
console.log(table+', '+chair);
//concatenar con acentos --> permite texto y variables juntas
console.log(`${table}, ${chair}`);
//concatenar con metodos
console.log("hola ".concat(table));

//operaciones aritmeticas
let a = 3;
let b = 3;

let inc = ++a;
let dec = --a;
let expo = a ** b;
console.log(expo);
console.log(inc);
console.log(dec);

//typeof, null y undefined
console.log(typeof(testString));

let testNull = null;
console.log(typeof(testNull));

let testUndefined;
console.log(testUndefined);

//Array
var first_array = [];
var second_array = new Array(3);
var third_array = new Array(3,5, 6,7);
var fourth_array = new Array(3,5,"Seville", true, third_array);
console.log(first_array);
console.log(second_array);
console.log(third_array);
console.log(fourth_array);

//acceder Array
console.log(third_array[1]);
console.log(fourth_array[4][0]);

console.log(fourth_array.push("Spain"));
console.log(fourth_array[5]);

//añadir elemento en posicion concreta
third_array[2] = 9;
console.log(third_array);

var third_array2 = new Array(3,5,6,7);
var arrayFinal = new Array(third_array, third_array2);
console.log(arrayFinal);

//primero final luego columna
arrayFinal[1][2] = 8;
console.log(arrayFinal);
*/

var third_array = new Array(1,2,3,5,4,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

//recorrer un array
/*
for(var i=0; third_array.length > i; i++){
    console.log(third_array[i]);
}
*/
//recorrido a la inversa
/*
for(var i = third_array.length-1; i >=0; i--){
    console.log("Entramos en la iteracion de  "+third_array[i])
}
*/
//declarando la variable fuera
/*
var i = third_array.length-1;
for(;i>=0;i--){
    console.log("Entramos en la iteracion de  "+third_array[i])
}
*/

//for each
/*
third_array.forEach(function myFunction(item) {
    console.log(item)
});
*/

//if comprobar dni
/*
var DNI_REGEX = /^(\d{8})([A-Z])$/;
let dni = '12345678K';
if(dni.match(DNI_REGEX)){
    console.log("Dni correcto")
}
else{
    console.log("Dni incorrecto")
}
*/

//objeto fecha
/*
let today = new Date();
let first_september = new Date(2025,9,1);
console.log(today);
console.log(first_september);
console.log(today.getDay());

if(today>first_september){
    console.log("Today is after to first octuber");
}
else{
    console.log("Today is before to first octuber");
}
*/

//eventos
function myFirstFunction(){
    console.log("Thank you for your click");
}

function mySecondFunction(){
    console.log("Hola");
}

function myThirdFunction(variable){
    console.log("Pesao");
    console.log(variable);
}

// seleccionar y añadir al dom
var div = document.getElementById("my_div");
div.classList.add("my_class");
console.log(div);

var div2 = document.getElementsByTagName("div");
console.log(div2);

var div3 = document.querySelector(".my_class");
console.log(div3);

//buscamos por nombre para encontrarlo por selector o por la clase
//JQuery
function $(selector){
    return document.querySelectorAll(selector);
}
console.log($("#my_third_div"));
console.log($(".my_class"));