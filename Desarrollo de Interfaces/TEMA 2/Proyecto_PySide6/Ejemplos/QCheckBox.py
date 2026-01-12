from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication, QCheckBox, QMainWindow

class ventanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("App con QCheckBox")

        etiqueta = QCheckBox("Casillas")
        # así se queda la casilla marcada por defecto
        # con setChecked pondremos como queremos que salga la casilla
        etiqueta.setCheckState(Qt.Checked)

        etiqueta.stateChanged.connect(self.show_state)

        self.setCentralWidget(etiqueta)

    # asi mostraremos el estado de la casilla
    def show_state(self, s):
        state = Qt.CheckState(s)
        print(state == Qt.CheckState.Checked)
        #imprime el estado que hemos cambiado de string a entero
        print(s)

app = QApplication([])
window = ventanaPrincipal()
window.show()
app.exec()