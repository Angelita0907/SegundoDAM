# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación con Slot")

        self.boton = QPushButton("Pulsar")
        self.setCentralWidget(self.boton)

        # ahora ponemos el boton en un interruptor
        self.boton.setCheckable(True)


        # para que el botón al presionarlo diga algo por consola
        self.boton.pressed.connect(self.botonPresionado)

        self.boton.released.connect(self.botonSoltar)
    

    def botonPresionado(self):
        self.boton.setText("Soltar")
        print("Botón presionado")
    
    def botonSoltar(self):
        self.boton.setText("Pulsar")
        print("Botón liberado")

app = QApplication()
window = ventanaPrincipal()
window.show()
app.exec()