# función para calcular el factorial

def factorial(n):

    # para ver si es entero
    if not isinstance(n, int):
        raise TypeError("no es entero")
    
    # y para ver si es positivo o negativo
    if n < 0:
        raise ValueError("Es negativo")

    if n == 0:
        return 1
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result