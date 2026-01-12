from PySide6.QtWidgets import QApplication, QMainWindow, QLabel
from PySide6.QtGui import QPixmap

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación con QLabelImg")

        etiqueta = QLabel("Holii!")
        etiqueta.setPixmap(QPixmap("gatito2.jpg"))
        etiqueta.setScaledContents(True)

        self.setCentralWidget(etiqueta)

app = QApplication([])
window = ventanaPrincipal()
window.show()
app.exec()