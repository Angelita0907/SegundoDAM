# Ángela Chica Montero 2ºDAM

#creamos las listas
ordenadores = ['Tablet', 'Portátil','Sobremesa']
perifericos = ['Ratón', 'Teclado', 'Monitor']
accesorios = ['Micrófono','Altavoz', 'Alfombrilla']

#creamos la tupla de precios
precios = (350,500,730)

#creamos el diccionario
catalogo = {
    "Ordenadores: ": ordenadores,
    "Periféricos: ": perifericos,
    "Accesorios:" : accesorios,
}

#mostramos las listas y la tupla
print(ordenadores,"\n", perifericos, "\n", accesorios,"\n", precios)

#mostramos el diccionario
print(catalogo)

#accedemos una una posicion concreta
print("Segundo periférico: ", perifericos[1])