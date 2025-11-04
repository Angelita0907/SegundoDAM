from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication, QCheckBox, QMainWindow

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Casilla con estado inicial")

        widget = QCheckBox("Modo oscuro activado por defecto")
        widget.setChecked(True)
        widget.stateChanged.connect(self.mostrar_estado)

        self.setCentralWidget(widget)

    def mostrar_estado(self, s):
        print("Estado:", s == Qt.Checked)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()