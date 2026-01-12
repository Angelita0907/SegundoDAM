# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QTextEdit

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejercicio QTextEDit")

        texto = QTextEdit()

        inicio = "Bienvenido/a al editor de texto."
        texto.setPlainText(inicio)

        texto.setPlaceholderText("Escribe aquí tu mensaje...")

        # Conectamos señales
        texto.textChanged.connect(self.texto_modificado)

        self.setCentralWidget(texto)
        self.texto = texto

    def texto_modificado(self):
        print("Texto modificado: ")
        # usamos toPlainText para leer el contenido escrito
        print(self.texto.toPlainText())


app = QApplication([])
window = VentanaPrincipal()
window.show()
app.exec()
