# Ángela Chica Montero

# creamos las clases padre
class Video:
    def __init__(self, titulo_V = "", min_duracion = 0, categoria = ""):
        self.__titulo_V= titulo_V
        self.__min_duracion = min_duracion
        self.__categoria = categoria
    
    def SetTitulo_V(self, titulo_V):
        self.__titulo_V = titulo_V
    
    def GetTitulo_V(self):
        return self.__titulo_V
    
    def SetDuracion(self, min_duracion):
        self.__min_duracion= min_duracion
    
    def GetDuracion(self):
        return self.__min_duracion
    
    def SetCategoria(self, categoria):
        self.__categoria = categoria
    
    def GetCategoria(self):
        return self.__categoria
    
class Audio:
    def __init__(self, titulo_A = "", nombre = ""):
        self.__titulo_A = titulo_A
        self.__nombre = nombre

    def SetTitulo_A(self, titulo_A):
        self.__titulo_A = titulo_A
    
    def GetTitulo_A(self):
        return self.__titulo_A
    
    
    