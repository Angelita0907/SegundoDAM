from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication, QCheckBox, QMainWindow

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Casilla tri-state")

        widget = QCheckBox("Seleccionar todo")
        widget.setTristate(True)
        widget.setCheckState(Qt.PartiallyChecked)
        widget.stateChanged.connect(self.mostrar_estado)

        self.setCentralWidget(widget)

    def mostrar_estado(self, s):
        if s == Qt.Checked:
            print("Marcado completamente")
        elif s == Qt.Unchecked:
            print("Desmarcado")
        else:
            print("Marcado parcialmente")

app = QApplication([])
window = MainWindow()
window.show()
app.exec()