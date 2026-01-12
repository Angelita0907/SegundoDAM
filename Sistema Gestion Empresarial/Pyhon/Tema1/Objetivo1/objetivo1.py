# sep → define el separador entre los elementos (por defecto es un espacio).
# end → define lo que aparece al final del mensaje (por defecto es un salto de línea).

print("1", "2", "3", sep="-", end=" FIN\n")

# El comando input sirve para leer información que escribe el usuario en el teclado
'''nombre = input("¿Cómo te llamas?: ")
print("Encantado de conocerte,", nombre)'''

# Si necesitas otro tipo de dato (por ejemplo, un número), tendrás que convertirlo.
'''edad = int(input("¿Cuántos años tienes?: "))
print("Tienes", edad, "años.")'''

# Ejercicio 2, separa por comas
print(1, 2, 3, 4, 5)
print(1, 2, 3, 4, 5, sep=",")

# Ejercicio 3, acaba con lo que indiques
print(1, 2, 3, 4, 5, sep=",", end="-")

# Leer información por teclado
print("¡Hola! Somos Time of Software, ¿Cómo te llamas?")
nombre = input()
print("Nos alegramos mucho de que nos hayas elegido para aprender Python,", nombre)

# lo mismo pero ahora pide la edad
edad = input("¿Cuántos años tienes?: ")
print("Tienes", edad, "años.")

