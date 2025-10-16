#Ángela Chica Montero 2ºDAM

cadena = input("Introduce una frase o palabra: ")

print("--- FORMATO DEL TEXTO ---")
#pasamos a Mayúscula la primera letra de la cadena de texto
print("Capitalizada: ", cadena.capitalize())
#ahora a mayúsculas todas y luego minúsculas
print("Mayúsculas: ", cadena.upper())
print("Minúsculas: ", cadena.lower())
#pasamos todo a mayúsculas menos la primera letra
print("invertida: ", cadena.swapcase())

#con las funciones siguientes podemos ver lo que nos pide el propio enunciado
print("\n--- ANÁLISIS DEL CONTENIDO ---")
print("¿Solo letras?: ", cadena.isalpha())
print("¿Solo números?: ", cadena.isdigit())
print("¿Letras y números?: ", cadena.isalnum())
print("¿Está en minúsculas?: ", cadena.islower())
print("¿Está en mayúsculas?: ", cadena.isupper())

#ahora comprobaremos cuanto mide la cadena
print("\n--- LONGITUD ---")
print("Número total de caracteres: ", len(cadena))
print("Caracteres reales (sin espacios): ")

#usamos comandos para dejar el código más limpio sin espacios blancos
print("\n--- LIMPIEZA ---")
print("Sin espacios al principio: ", cadena.lstrip())
print("Sin espacios al final: ", cadena.rstrip())
print("Sin espacios en ambos lados: ", cadena.strip())

#de esta forma podemos buscar o añadir palabras en la cadena
palabraBuscar = input("Palabra a buscar: ")
palabraNueva =  input("Palabra nueva: ")
print("Frase modificada: ", cadena.replace(palabraBuscar, palabraNueva))

#con lo siguiente veremos el menor y mayor caracter
print("\n--- CARACTERES ---")
print("Carácter mayor: ", max(cadena))
print("Carácter menor: ", min(cadena))

print("\n--- LISTA DE PALABRAS ---")
#guardamos la separacion en una variable para usarlo luego
separado = cadena.split()
print("Lista: ",separado)
print("Número de palabras: ", len(separado))

#ahora veremos como mostrar una frase separada por otra cosa que no son espacios
print("\n--- DIVISIÓN POR '/' ---")
print("Resultado del split('/'): ", cadena.split("/"))

print("\n--- ANÁLISIS COMPLETO FINALIZADO ---")