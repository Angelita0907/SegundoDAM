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
    
    def mirar_video(self):
        print("¡Iniciando video!")
        print("El video se llama: ", self.GetTitulo_V(), " con duracion de ", self.GetDuracion(), " y su categoria es ", self.GetCategoria())

    def detener_video(self):
        print("Deteniendo el video")

class Audio:
    def __init__(self, titulo_A = "", nombre = ""):
        self.__titulo_A = titulo_A
        self.__nombre = nombre

    def SetTitulo_A(self, titulo_A):
        self.__titulo_A = titulo_A
    
    def GetTitulo_A(self):
        return self.__titulo_A
    
    def SetNombre(self, nombre):
        self.__nombre = nombre
    
    def GetNombre(self):
        return self.__nombre
    
    def escuchar_audio(self):
        print("Escuchando audioo!")
        print("El audio se titula ",self.GetTitulo_A(), " producido por el artista ", self.GetNombre())
    
    def detener_audio(self):
        print("Finalizando reproduccion de audio")

# clase hija que hereda de las dos anteriores y llama a las funciones
class Media(Video, Audio):
    def __init__(self, titulo_V, categoria, duracion, nombre):
        # debemos iniciar los constructores de los padre para que pueda coger los valores
        Video.__init__(self, titulo_V, duracion, categoria)
        Audio.__init__(self, titulo_V, nombre)

    def mostrar_media(self):
        print("--- REPRODUCCIÓN DE MEDIA ---")
        self.mirar_video()
        self.detener_video()
        self.escuchar_audio()
        self.detener_audio()

# ahora mostraremos las funciones de la clase media que hereda de los anteriores
medio1 = Media("Titulo 1", "infantil", 180, "Artista 1")
medio1.escuchar_audio()
medio1.mirar_video()
medio1.detener_audio()
medio1.detener_video()