# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QComboBox

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("ComboBox")
        
        lista = QComboBox()
        lista.addItems(["Python", "Java", "C++", "Kotlin"])
        
        # el usuario escribe su propia opcion
        lista.setEditable(True)

        # maximo de elementos
        lista.setMaxCount(10)

        # para que ordene alfabeticamente
        lista.setInsertPolicy(QComboBox.InsertAlphabetically)

        # añadir elementos despues del elemento seleccionado
        lista.setInsertPolicy(QComboBox.InsertAfterCurrent)

        lista.itemText(self.cambio_texto)

        self.setCentralWidget(lista)

    def cambio_texto(self, t):
        print("Texto seleccionado: ", t)


app = QApplication([])
window = VentanaPrincipal()
window.show()
app.exec()