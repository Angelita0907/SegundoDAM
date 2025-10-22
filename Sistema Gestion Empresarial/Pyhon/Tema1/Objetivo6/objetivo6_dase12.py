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
        self.autor = Autor
    
    def aniadirAutor(self):
        self.autor = Autor

    def mostrarLibro(self):
        print("Título: ", self.titulo)
        print("ISBN: ", self.isbn)
        print("Autor: ", Autor.mostrarAutor) 
    
    def obtenerTitulo(self):
        return self.titulo
    
class Biblioteca:
    def __init__(self, listaLibros):
        self.listaLibros = listaLibros[Libro]

    def numeroLibros(self):
        return len(self.listaLibros)
    
    def aniadirLibros(self, libro):
        return self.listaLibros.append(libro)