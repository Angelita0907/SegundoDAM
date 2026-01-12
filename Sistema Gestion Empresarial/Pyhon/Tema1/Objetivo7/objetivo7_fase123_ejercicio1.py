#Ángela Chica Montero

# primero creamos la clase padre
class Vehiculo:
    def __init__(self, marca = "", velocidad_inicial = 0):
        self.__marca = marca
        self.__velocidad_inicial = velocidad_inicial
    def SetMarca(self, marca):
        self.__marca = marca
    
    def GetMarca(self):
        return self.__marca
    
    def SetVelocidad_Inicial(self, velocidad_inicial):
        self.__velocidad_inicial = velocidad_inicial

    def GetVelocidad_Inicial(self):
        return self.__velocidad_inicial
    
    #ahora creamos las funciones 
    def acelerar(self, v):
        mas_velocidad = self.GetVelocidad_Inicial()+v
        #indicamos para guardar ese valor que hemos añadido nuevo
        self.SetVelocidad_Inicial(mas_velocidad)
        return mas_velocidad
    
    def desacelerar(self, v):
        menos_velocidad = self.GetVelocidad_Inicial()-v
        self.SetVelocidad_Inicial(menos_velocidad)
        return menos_velocidad
    
    def mostrarVelocidad(self):
        return self.GetVelocidad_Inicial()


# ahora creamos la clase hijo
class Coche(Vehiculo):
    def __init__(self, marca, velocidad_inicial):
        super().__init__(marca, velocidad_inicial)
        self.bocina = "¡tuuut!"
    
    def tocar_claxon(self):
        return self.bocina

# ya creadas las clases y sus métodos, crearemos la instancia de las clases

vehiculo = Vehiculo()
coche1 = Coche("Peugeot 208", 10.5)
print("Marca: ", coche1.GetMarca())
print("La velocidad inicial de tu cohe es: ", coche1.mostrarVelocidad())
coche1.acelerar(50)
print("Tu velocidad actual es: ",coche1.mostrarVelocidad(),"km/h")
coche1.desacelerar(15)
print("Tu velocidad actual es: ",coche1.mostrarVelocidad(),"km/h")