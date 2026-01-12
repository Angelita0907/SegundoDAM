# Ángela Chica Montero

#Primero están las funciones, a continuacion de ellas está la muestra

salir = False

# menu

def menu():
        print("=========================\nCALCULADORA AVANZADA\n=========================")
        print("1) Sumar")
        print("2) Restar")
        print("3) Multiplicar")
        print("4) Dividir")
        print("5) Operaciones avanzadas")
        print("6) Salir")

def menuAvanzado():
    print("Operaciones avanzadas:")
    print("a) Potencia")
    print("b) Raíz cuadrada")
    print("c) Módulo")
    print("d) volver")


# Funciones para la calculadora
    #suma
def suma():
    return num1 + num2

    #resta
def resta():
    return num1-num2

    #multiplicacion
def multiplicacion():
    return num1*num2

    #division
def division():
    return round(num1/num2, 3)

    #operaciones avanzadas
        #potencia
def potencia():
    return base**exponente

        #raiz cuadrada
def raiz():
    return base**(numRaiz)

        #modulo (%)
def modulo():
    return base%numModulo

  
# Ahora se muestra la funcionalidad

while not salir:
    menu()

    opcion = int(input("Elige que operacion deseas realizar: "))

    if opcion == 1:
        num1 = int(input("Introduce el primer número: "))
        num2 = int(input("Introduce el segundo número: "))
        print("Resultado de la suma: ", suma())
    
    elif opcion == 2:
        num1 = int(input("Introduce el primer número: "))
        num2 = int(input("Introduce el segundo número: "))
        print("Resultado de la resta: ", resta())

    elif opcion == 3:
        num1 = int(input("Introduce el primer número: "))
        num2 = int(input("Introduce el segundo número: "))
        print("Resultado de la multiplicación: ", multiplicacion())

    elif opcion == 4:
        num1 = int(input("Introduce el primer número: "))
        num2 = int(input("Introduce el segundo número: "))
        if num1 != 0 and num2 != 0: 
            print("Resultado de la división: ", division())
        else:
            print("No se puede dividir entre 0")
            num1 = int(input("Introduce el primer número: "))
            num2 = int(input("Introduce el segundo número: "))
            print("Resultado de la división: ", division())

    elif opcion == 5:
        menu_avanzado = True
        while menu_avanzado:
            menuAvanzado()
            avanzado = input("Selecciona una opcion: ")
            if avanzado == "a":
                base = int(input("Base: "))
                exponente = int(input("Exponente: "))
                print("Resultado: ", potencia())
            elif avanzado == "b":
                base = int(input("Base: "))
                numRaiz = int(input("Exponente: "))
                print("Resultado: ", raiz())
            elif avanzado == "c":
                base = int(input("Base: "))
                numModulo = int(input("Exponente: "))
                print("Resultado: ", modulo())
            elif avanzado == "d":
                menu_avanzado = False
    
    elif opcion == 6:
        salir = True
        print("Programa finalizado ;)")
