# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QLabel
from PySide6.QtCore import Qt

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación con QLabel")

        etiqueta = QLabel("Sistema en espera")
        fuente = etiqueta.font()
        fuente.setPointSize(24)

        etiqueta.setFont(fuente)

        etiqueta.setAlignment(Qt.AlignHCenter | Qt.AlignBottom)

        self.setCentralWidget(etiqueta)

        # cambiamos el texto una vez inicie
        etiqueta.setText("Sistema operativo iniciado")

        
    

app = QApplication()
window = ventanaPrincipal()
window.show()
app.exec()
