# Ángela Chica Montero
# Crear QMainWindow
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton
from PySide6.QtCore  import QSize

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventanita1")
        boton = QPushButton("Botoncito")
        self.setCentralWidget(boton)
        #self.setFixedSize(QSize(400,300))
        self.setMinimumSize(QSize(300,200))
        self.setMaximumSize(QSize(600,400))

class ventana2(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventanita2")

app = QApplication([])
window1 = ventanaPrincipal()
window2 = ventana2()
# esto es para crear la aplicacion
window1.show()
window2.show()
app.exec()