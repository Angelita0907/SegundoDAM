# Ángela Chica Montero

import os
from PySide6.QtWidgets import QApplication, QMainWindow, QLabel
from PySide6.QtGui import QPixmap

# para que cargue desde el mismo directorio del script
directorioBase = os.path.dirname(__file__)
# vamos a poner un print para ver nuestro directorio de trabajo y otro de la ruta
print("Directorio de trabajo: ", os.getcwd())  
print("Ruta del archivo actual: ", directorioBase)  

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación con QLabelImg")

        etiqueta = QLabel("Holii!")
        # ahora aquí ponemos la ruta para que desde ka ruta principal
        # se vaya a donde se ejecuta el script
        etiqueta.setPixmap(QPixmap(os.path.join(directorioBase, "gatito2.jpg")))

        etiqueta.setScaledContents(True)

        self.setCentralWidget(etiqueta)

app = QApplication([])
window = ventanaPrincipal()
window.show()
app.exec()