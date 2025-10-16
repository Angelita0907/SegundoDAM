# Ángela Chica Montero

# Ejercicio 1
print("-1-")
#Pedimos los numeros
num1 = int(input("Introduce el primer numero: "))
num2 = int(input("Introduce el segundo numero: "))

#Realizamos las operaciones
print("Suma: ",num1+num2)
print("Resta: ", num2-num1)
print("Multiplicación: ",num1*num2)
print("División: ",num2/num1)

#Ejercicio 2
print("-2-")
#pedimos numeros reales
real1 = float(input("Introduce el primer número: "))
real2 = float(input("Introduce el segundo número: "))
real3 = float(input("Introduce el tercero número: "))

resultado = round( real1+real2+real3/ 3, 2)
print("El promedio es: ", resultado)

#Ejercicio 3
print("-3-")
#Pedimos los numeros
num3 = int(input("Introduce el primer numero: "))
num4 = int(input("Introduce el segundo numero: "))

#comparacion
'''he puesto la propia compracion en el print para 
    evitar repetir mucho código'''
print("¿El primero es mayor? ", num3>num4)
print("¿Son iguales? ", num3 == num4)
print("¿El segundo es distinto de cero? ", num4!=0)

#Ejercicio 4
print("-4-")
boleano1 = eval(input("Introduce el primer valor lógico (True/False): "))
boleano2 = eval(input("Introduce el segundo valor lógico (True/False): "))

#usamos operaciones  logicas
print("Resultado de and: ", boleano1 and boleano2)
print("Resultado de or: ", boleano1 or boleano2)
print("Resultado de not primer valor: ", not boleano1)
print("Resultado de not segundo valor: ", not boleano2)

#Ejercicio 5
print("-5-")
cadena1 = str(input("Edad de la primera persona: "))
cadena2 = str(input("Edad de la segunda persona: "))

#Convertimos a entero
entero1 = int(cadena1)
entero2 = int(cadena2)

#hacemos el promedio
resultado = round( entero1+entero2/2, 1)

'''Directamente realizo la suma'''
print("Suma total: ", entero1+entero2)
print("Promedio: ", resultado)

#Ejercicio 6
print("-6-")
'''lo pongo en float porsi decido poner algún real'''
numero1 = float(input("Introduce el primer número: "))
numero2 = float(input("Introduce el segundo número: "))

'''directamente indico la comparación para que de el resultado'''
print("(a > 10) and (b < 5): ",(numero1 > 10) and (numero2 < 5))
print("(a == b) or (b > 0): ",(numero1 == numero2) or (numero1 > 0))

#Ejercicio 7
print("-7-")
dividendo = float(input("Introduce el dividendo: "))
divisor = float(input("Introduce el divisor: "))

#hacemos la division y redondeamos
resultado = round(dividendo / divisor, 1)
print("Resultado redondeado: ", resultado)
