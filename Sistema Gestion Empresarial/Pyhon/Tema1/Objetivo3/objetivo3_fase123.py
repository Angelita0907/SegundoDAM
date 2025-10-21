#Ángela Chica Montero 2ºDAM

print("--- 1. Evaluar un número ---")

num = int(input("Introduce un número: "))
#para validar si es negativo o positivo
if num > 0: (
    print("El número es positivo")
    )
elif num < 0: (
    print("El número es negativo")
    )
else:
    print("El número es 0")

print("--- 2. Comparar dos números ---")
num1 = int(input("Introduce el primer número: "))
num2 = int(input("Introduce el segundo número: "))

#asi vemos si uno es mayor o menos que el otro
if num1 > num2:(
    print("El primero es mayor que el segundo")
)
elif num1 < num2:(
    print("El segundo es mayor que el primero")
)
else:
    print("Ambos son iguales")

print("--- 3.Comprobar texto dentro de una frase ---")
frase = input("Escribe una frase: ")
palabra = input("Escribe una palabra: ")

#asi se puede buscar una palabra en una frase o texto
if palabra in frase:(
    print("La palabra está en la frase")
)
else:
    print("La palabra no se encuentra")

print("--- 4. Verificar el formato de una cadena ---")
texto = input("Escribe un texto: ")

#para verificar como empieza o acaba
if texto and texto[0].isupper():(
    print("Empieza por mayúscula")
)
elif texto.endswith("."):(
    print("Termina en punto")
)
else:
    print("El texto no cumple las condiciones")

print("--- 5. Clasificar una nota ---")
# con lo siguiente veremos para clasificar la nota
nota = int(input("Intriduce una nota (0-10): "))

if 0 <= nota <= 4:(
    print("Insuficiente")
)
elif nota == 5:(
    print("Suficiente")
)
elif nota == 6:(
    print("Bien")
)
elif 7 <= nota <= 8: (
    print("Notable")
)
elif 9 <= nota <= 10: (
    print("Sobresaliente")
)
else:
    print("Nota no válida")
