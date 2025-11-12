# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QSlider
from PySide6.QtCore import Qt

class Ventana(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Control de Brillo")

        # creamos la barra y la posicionamos para que se vea en 
        # el centro de la ventana
        self.barra = QSlider(Qt.Horizontal)
        self.setCentralWidget(self.barra)

        # ponemos el rango según el ejercicio
        self.barra.setMinimum(0)
        self.barra.setMaximum(100)

        # ponemos que primero comience en 50
        self.barra.setValue(50)

        # luego de crear la funcion de mostrar cambio brillo para 
        # que al hacer ambios llame a la funcion
        self.barra.valueChanged.connect(self.cambiar_brillo)

        # pata enseñar el valor por consola
        print("Nivel de brillo:", self.barra.value(), "%")

    def cambiar_brillo(self, valor):
        print("Nivel de brillo:", valor, "%")

app = QApplication([])
ventana = Ventana()
ventana.show()
app.exec()