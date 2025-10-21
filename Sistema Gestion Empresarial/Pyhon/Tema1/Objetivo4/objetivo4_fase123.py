# Ángela Chica Montero

alumnos = int(input("Introduce el número de alumnos: "))
aprobado = 0
mejorar = 0
suspenso = 0
total_media = 0
#primero comprobamos que el numero de alumnos no es 0 para continuar
while alumnos != 0: 
    #creamos esta variable para luego almacenar el total de notas

    '''con el for recorremos las asignaturas para saber la noa de cada una 
    y luego sumarlas para mas tarde calcular la media'''
    for i in range(alumnos):
        nombre = input("Nombre: ")
        asignaturas = int(input("¿Cuántas notas tiene ? "+nombre))
        print("Alumno ", (i+1))
        total = 0
        if (asignaturas != 0): 
            for j in range(asignaturas):
                notas = int(input("Introduce la nota: ")) 
                total += notas    
    # aqui tenemos la media
    media = total /asignaturas
    total_media += media
    if media >= 5:
        print("Media de ", nombre, ":", media," está aprobado")
        aprobado = aprobado+1
    elif 4 <= media >= 5:
        print("Media de ", nombre, ":", media," debe mejorar")
        mejorar = mejorar+1
    elif media < 4:
        print("Media de ", nombre, ":", media," está suspenso")
        suspenso = suspenso+1


print("--- RESUMEN FINAL ---")
media_grupo = (total_media)/alumnos
print("Media del grupo: "+ media_grupo)
print("Aprobados: "+aprobado)
print("Deben mejorar: "+ mejorar)
print("Suspensos: "+ suspenso)
