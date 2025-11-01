# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación con Slot")

        boton = QPushButton("Encender")
        self.setCentralWidget(boton)

        # ahora ponemos el boton en un interruptor
        boton.setCheckable(True)

        #ponemos un metodo para saber si esta encendido
        boton.clicked.connect(self.elBoton_esta_encendido)

        # para que el botón al pulsarlo diga algo por consola
        boton.clicked.connect(self.elBoton_fue_Pulsado)

        # cambia titulo segun estado

        boton.clicked.connect(self.cambiaTitulo)
    
    # el metodo fuera del constructor
    def elBoton_fue_Pulsado(self):
        print("Botón Pulsado")

    def elBoton_esta_encendido(self, checked):
        print("Está encendido?", checked)
    
    def cambiaTitulo(self,cheked):
        if(cheked):
            self.setWindowTitle("Ventan encendida")
        else:
            self.setWindowTitle("Ventana apagada")


app = QApplication()
window = ventanaPrincipal()
window.show()
app.exec()