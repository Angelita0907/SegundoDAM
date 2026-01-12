from PySide6.QtWidgets import QApplication, QMainWindow, QComboBox

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Casilla con estado inicial")

        combo = QComboBox()
        combo.addItems(["Manzana", "Mandarina", "Naranja"])

        combo.currentIndexChanged.connect(self.cambio_indice)
        combo.currentTextChanged.connect(self.cambio_texto)

        # el usuario escribe su propia opcion
        combo.setEditable(True)

        self.setCentralWidget(combo)

    # muestra posicion de lo que seleccionamos por consola
    def cambio_indice(self,i):
        print("Índice seleccionado: ",i)
    
    # muestra el texto que escogimos por consola
    def cambio_texto(self, t):
        print("Texto seleccionado: ", t)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()