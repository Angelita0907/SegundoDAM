# Ángela Chica Montero

from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication, QCheckBox, QMainWindow

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejercicio Checked")
        etiqueta = QCheckBox("Casillas")
        # así se queda la casilla marcada por defecto
        # con setChecked pondremos como queremos que salga la casilla
        etiqueta.setCheckState(Qt.Checked)

        etiqueta.setTristate(True)
        etiqueta.setCheckState(Qt.PartiallyChecked)
        etiqueta.stateChanged.connect(self.mostrar_estado)

        self.setCentralWidget(etiqueta)

    # asi mostraremos el estado de la casilla
    def mostrar_estado(self, estado):
        if estado == 2:
            print("Marcado completamente")
        elif estado == 0:
            print("Desmarcado")
        else:
            print("Marcado parcialmente")

app = QApplication([])
window = ventanaPrincipal()
window.show()
app.exec()