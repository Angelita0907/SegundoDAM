# Ángela Chica Montero

# primero creamos las clases necesarias con sus funciones correspondientes
class Autor:
    def __init__(self, nombre, apellidos):
        self.nombre = nombre
        self.apellidos = apellidos

    def mostrarAutor(self):
        print("Autor: ", self.nombre, self.apellidos)

class Libro:
    def __init__(self, titulo, isbn):
        self.titulo = titulo
        self.isbn = isbn
        self.autor = None
    
    def aniadirAutor(self, autor):
        self.autor = autor

    def mostrarLibro(self):
        print("------ Libro ------")
        print("Título: ", self.titulo)
        print("ISBN: ", self.isbn)
        autor.mostrarAutor()
    
    def obtenerTitulo(self):
        return self.titulo
    
class Biblioteca:
    def __init__(self):
        # creamos primero la lsita vacía para luego ir añadiendo los libros
        self.listaLibros = []

    def numeroLibros(self):
        return len(self.listaLibros)
    
    def aniadirLibro(self, libro):
        return self.listaLibros.append(libro)
    
    def delLibro(self, titulo):
        for libro in self.listaLibros:
            if libro.titulo == titulo:
                self.listaLibros.remove(libro)
    
    def mostrarBiblioteca(self):
        print("########################################")
        for libro in self.listaLibros:
            print(libro.mostrarLibro())
        print("########################################")


# creadas las clases ahora iremos con las funciones del menu:

def menu():
    print("Menu")
    print("1) Añadir libro a la biblioteca")
    print("2) Mostrar biblioteca")
    print("3) Borrar libro")
    print("4) ¿Número de libros?")
    print("5) Salir")

# para el menú crearemos la siguiente variable para luego poder salir
# tambien creamos la clase de biblioteca para usar los metodos
biblioteca = Biblioteca()
salir = False

while not salir:
    menu()

    opcion = int(input("Elige que operacion deseas realizar: "))

    if opcion == 1:
        titulo = input("Introduzca el título del libro: ")
        isbn = input("Introduzca el ISBN del libro: ")
        nombre = input("Introduzca el nombre del autor: ")
        apellido = input("Introduzca el apellido del autor: ")

    # ahora llamamos a la clase y le asignamos los varoles
        autor = Autor(nombre, apellido)
        libro = Libro(titulo, isbn)
        libro.aniadirAutor(autor)

    #añadimos el libro a la biblioteca
        biblioteca.aniadirLibro(libro)
    
    elif opcion == 2:
        biblioteca.mostrarBiblioteca()
        

    elif opcion == 3:
        borrar = input("Introduzca el título del libro a borrar: ")
        print("¡Libro borrado correctamente!", biblioteca.delLibro(borrar))

    elif opcion == 4:
        print("El número de libros en la biblioteca es: ", biblioteca.numeroLibros())
    
    elif opcion == 5:
        salir = True
        print("Programa finalizado ;)")