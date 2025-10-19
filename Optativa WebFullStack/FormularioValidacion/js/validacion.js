// Ángela Chica Montero

// ocultar y mostrar elementos despues de validar lo anterior

function ocultarTodos() {
  var ocultar = document.getElementsByClassName("oculto");
  // con este for decimos que por cada clase grupo este oculto 
  for (let i = 0; i < ocultar.length; i++) {
    ocultar[i].style.display = "none";
  }
}

// con esta usaremos el oculto anterior para mostrarlo
// más adelante pondremos cuando se va mostrando
function mostrarOcultos(id) {
  var elemento = document.getElementById(id);
    if (elemento) { 
        elemento.style.display = "block";
  }
}

/*En todas las funciones para validar se llama luego al id del div para que oculte todo*/

// validarción nombre
function validarNombre() {
  var nombre = document.getElementById("nombre");

  if (nombre.value.length > 2) {
    // puse de mínimo 2, ya que normalmente nadie tiene un nombre de dos letras  
    mostrarOcultos("gApellidos"); 
  }
  else {
    alert("El nombre debe tener al menos 2 caracteres");    
  }
}

// validarción apellidos
// lo mismo que el anterior pero con los apellidos
function validarApellidos() {
  var apellidos = document.getElementById("apellido");  
    if (apellidos.value.length > 2) {
        mostrarOcultos("gCorreo");
    }
    else {
        alert("Los apellidos deben tener al menos 2 caracteres");
    }
}

// validación email
function validarEmail() {
  var correo = document.getElementById("correo");
  if (correo.value.includes("@"))
  {
    mostrarOcultos("gDireccion");
  } 
  else{
    alert("Correo no válido (Debe incluir @)")
  }
}

// validación dirección
/* para direccion minimo dos palabras con un espacio
    asi debe de indicar el tipo de vía y su el nombre, claro */

function validarDireccion() {
    var dir= document.getElementById("direccion");
    //esto es para coger el valor introducido, sin ello no sabemos que ha puesto :)
    var direccion = dir.value;
    var espacio = direccion.includes(" ");
    
    //puse 4 ya que con dos me parecía muy poco y no contaria bien el espacio
    if (espacio && direccion.length >= 4) { 
        mostrarOcultos("gDni");
    } else {
        alert("Su dirección debe de ser mínimo 2 palabras con un espacio (NombreVía 'nombre')");
    }
}

// validación dni
/* es parecido a la expresion regular para una contraseña pero seria
  9 digitos y el ultimo es una letra(mayúscula)
   */

  function validarDni() {
    var dni = document.getElementById("dni");
    var recogerDni = dni.value;
    var comprobarDNI = /^[0-9]{8}[A-Z]$/;
    
    /* para comprobar el dni si o si tengo que usar test, busque otra forma
    pero usar la expresion regular tenia que ponerlo así (devuelve True o False si coincide)*/
    if (comprobarDNI.test(recogerDni)) {
        mostrarOcultos("gFecha");
    } else {
        alert("Su DNI debe tener 8 números y el último una letra mayúscula.");
    }
}

// validación edad-fecha
/* voy a poner que mínimo mayor de 18 años (cogiendo el año)*/
function validarFecha() {
    var fecha = document.getElementById("fecha_nacimiento");
    var fecha_nacimiento = new Date(fecha.value);
    // ahora creo la fecha de hoy para coger el año y así comparar más fácil
    var fechaHoy = new Date();
    var mayor18 = new Date(fechaHoy.getFullYear() - 18,fechaHoy.getMonth(),fechaHoy.getDate());

    // si nacio antes o igual hace 18 años puede seguir (usando el año principalmente)
    if (fecha_nacimiento <= mayor18) {
        mostrarOcultos("gContrasena");
    } else {
        alert("Debes ser mayor de 18 años.");
    }   
}


// validación contraseña
/* para validar la contraseña he usado expresiones regulares de numeros y letras
que minimo 8 caracteres con letras(1) y números(1) y asi no tener que poner uno por uno */
function validarContrasena() {
    var pass = document.getElementById("contrasena"); 
    var contrasena = pass.value;

    var regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/;

    if (regex.test(contrasena)) {
        mostrarOcultos("gConfirmar"); 
    } else {
        alert("Su contraseña debe ser mínimo 8 caracteres con un número y una letra.");
    }
}

// confirmar contraseña
/* para confirmar la contraseña solo tengo que ver si es igual a la anterior */
function confirmarContrasena() {
    var pass = document.getElementById("contrasena"); 
    var confirmarPass = document.getElementById("confirmar_contrasena");
    if (pass.value == confirmarPass.value) {
        mostrarOcultos("gGenero");
    } else {
        alert("Las contraseñas no coinciden.");
    } 
}

// validación género
function validarGenero() {
  // para los botones radio se debe coger el id del boton y que esté seleccionado
    var genero = document.querySelector('input[name="genero"]:checked');
    if (genero) {
        mostrarOcultos("gPais");
    } else {
        alert("Debe seleccionar un género.");
    } 
}

// validación país
/*esta es más sencilla, puse que mientras que no se deje 
el valor por defecto luego muestra el siguiente campo*/
 function validarPais() {
    var pais = document.getElementById("pais"); 
    // para que luego el boton funcione, ya que la funcion no devolvía nada
    let validado = false;
    if (pais.value !== "") {
        mostrarOcultos("registro");
        validado = true;
    } else {
        alert("Debe seleccionar un país.");
        validado = false;
    }   
    return validado;
}

// enviar formulario

/* Como los campos no se muestran si no se cumple lo anterior, pues el botón solo
  funciona cuando hemos selecionado un pais (ultimo elemento) */
function enviarFormulario() {
    if (validarPais()){
      alert("Formulario enviado, Felicidades!! ;)");
    }
}

/* aquí es donde inicio que el DOM carge los eventos que más arriba he creado
  y así que el dom entienda lo que quiero elegir y que quiero que haga con él*/
document.addEventListener("DOMContentLoaded", () => {
  ocultarTodos();
  /* accedemos al elemento del html y cuando selecionemos fuera de donde estamos
  escribiendo pues nos mostrara el siguiente elemento
  blur es lo que lo oculta hasta que hacemos clic fuera*/
  document.getElementById('nombre').addEventListener('blur', validarNombre);
  document.getElementById('apellido').addEventListener('blur', validarApellidos);
  document.getElementById('correo').addEventListener('blur', validarEmail);
  document.getElementById('direccion').addEventListener('blur', validarDireccion);
  document.getElementById('dni').addEventListener('blur', validarDni);
  document.getElementById('fecha_nacimiento').addEventListener('blur', validarFecha);
  document.getElementById('contrasena').addEventListener('blur', validarContrasena);
  document.getElementById('confirmar_contrasena').addEventListener('blur', confirmarContrasena);
  // como es un boton se debe usar change, cuando se cambie el valor enseña el siguiente
  document.getElementById('gGenero').addEventListener('change', validarGenero);
  document.getElementById('pais').addEventListener('blur', validarPais);
  document.getElementById('registro').addEventListener('click', enviarFormulario);
});

// cuando todo lo anterior sea validado, enviar formulario

/* se que algunos comentarios son algo largos, pero así me ayuda a mi para entender mejor
  ya que hasta ahora no había usado el dom para cargar funciones*/
 