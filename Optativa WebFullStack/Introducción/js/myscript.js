//alert("Hello World!");

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
var third_array = new Array(3,5);
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