# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QDial

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        # creamos el dial en el centro de la ventana
        self.barra_volumen = QDial()
        self.setCentralWidget(self.barra_volumen)

        # ponemos el minimo y maximo dentro del rango elegido 
        self.barra_volumen.setRange(0, 10)
        self.barra_volumen.setNotchesVisible(True)

        # que comience en 0
        self.barra_volumen.setValue(0)
        self.setWindowTitle("Volumen: 0 / 10")

        # cuando cambie el valor se inprime por pantalla
        self.barra_volumen.valueChanged.connect(self.cambiar_volumen)

    def cambiar_volumen(self, valor):
        self.setWindowTitle("Volumen: " + str(valor) + " / 10")

        # si ponemos el maximo muestra:
        if valor == 10:
            print("¡Volumen máximo alcanzado!")

app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()