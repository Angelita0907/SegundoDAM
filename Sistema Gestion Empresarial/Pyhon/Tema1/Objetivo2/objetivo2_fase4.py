#Ángela Chica Montero 2ºDAM

#pedimos los 3 números
num1 = int(input("Introduce el primer número: "))
num2 = int(input("Introduce el segundo número: "))
num3 = int(input("Introduce el tercer número: "))

#hacemos la comparación y lo mostramos por pantalla
print("(a < b) and (b < c): ", (num1 < num2) and (num2 < num3))
print("(a == b) or (b == c): ", (num1 == num2) or (num2 == num3))
print("not (a > c): ", not (num1 > num3))

