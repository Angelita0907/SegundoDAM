# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QRadioButton

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Función DESACTIVADA")

        # Creamos el botón redondito
        radio = QRadioButton("Activar función")
        self.setCentralWidget(radio)

        # Conectamos la señal al método
        radio.toggled.connect(self.cambiaTitulo)

    def cambiaTitulo(self, checked):
        if checked:
            self.setWindowTitle("Función ACTIVADA")
        else:
            self.setWindowTitle("Función DESACTIVADA")

app = QApplication()
window = ventanaPrincipal()
window.show()
app.exec()