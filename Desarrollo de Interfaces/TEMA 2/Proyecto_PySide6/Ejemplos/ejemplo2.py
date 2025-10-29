# -- Apuntes --
# Crear QMainWindow
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton
from PySide6.QtCore  import QSize

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi primera ventanita")
        boton = QPushButton("¡PULSA AQUÍ!")
        self.setCentralWidget(boton)
        #self.setFixedSize(QSize(400, 300))
        self.setMinimumSize(QSize(300,200))
        self.setMaximumSize(QSize(600,400))

app = QApplication([])
window = ventanaPrincipal()
# esto es para crear la aplicacion
window.show()
app.exec()