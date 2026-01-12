from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QLineEdit")

        texto = QLineEdit()
        texto.setMaxLength(20)
        texto.setPlaceholderText("Introduce un nombre: ")

        texto.returnPressed.connect(self.mostrar_mensaje)

        texto.textChanged.connect(self.texto_modificado)

        texto.textEdited.connect(self.texto_editado)

        self.setCentralWidget(texto)
    
        self.texto = texto

    def mostrar_mensaje(self):
        print("Se pulsó Enter")

    def texto_modificado(self,s):
        print("Escribe tu ciudad ", s)
        self.setWindowTitle(s)
    
    def texto_editado(self, e):
        print("Texto editado por el usuario: ", e)
        


app = QApplication([])
window = VentanaPrincipal()
window.show()
app.exec()