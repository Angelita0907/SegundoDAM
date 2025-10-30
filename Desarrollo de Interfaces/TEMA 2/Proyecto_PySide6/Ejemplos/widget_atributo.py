from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit
from PySide6.QtCore import QSize

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación con Widget")
        self.setMinimumSize(QSize(400,300))

        texto = QLineEdit()

        # creamos una señal que nos dice si el texto cambia
        texto.textChanged.connect(self.textModificado)

        self.setCentralWidget(texto)

        self.texto = texto

    def textModificado(self):
        self.setWindowTitle(self.texto.text())

app = QApplication()
window = ventanaPrincipal()
window.show()
app.exec()