

// ocultar y mostrar elementos despues de validar lo anterior

function ocultarTodos() {
  var ocultar = document.getElementsByClassName("oculto");
  // con este for decimos que por cada clase grupo este oculto 
  for (let i = 0; i < ocultar.length; i++) {
    ocultar[i].style.display = "none";
  }
}

// con esta usaremos el oculto anterior para mostrarlo
// más adelante podremos cuando se va mostrando
function mostrarOcultos(id) {
  var elemento = document.getElementById(id);
    if (elemento) { 
        elemento.style.display = "block";
  }
}

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
  var emailInput = document.getElementById("correo");
  if (emailInput.value.includes("@"))
  {
    mostrarOcultos("gFecha");
  } 
  else{
    alert("Correo no válido (Debe incluir @)")
  }

  // con false ponemos que reenvíe el formulario
  return  true;
}

// validación contraseña

// validación edad

// validación país

// validación términos y condiciones    

document.addEventListener("DOMContentLoaded", () => {
  ocultarTodos();
  /* accedemos al elemento del html y cuando selecionemos fuera de donde estamos
  escribiendo pues nos mostrara el siguiente elemento
  blur es lo que lo oculta hasta que hacemos clic fuera*/
  document.getElementById('nombre').addEventListener('blur', validarNombre);
  document.getElementById('apellido').addEventListener('blur', validarApellidos);
  document.getElementById('correo').addEventListener('blur', validarEmail);
});

// cuando todo lo anterior sea validado, enviar formulario
 