from PySide6.QtWidgets import (
    QMainWindow, QApplication, QDialog, QDialogButtonBox, QVBoxLayout,
    QLabel, QPushButton, QMessageBox
)
from PySide6.QtCore import QLibraryInfo, QTranslator
class DialogoPersonalizado(QDialog):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setWindowTitle("Diálogo personalizado")

        botones = QDialogButtonBox.Ok | QDialogButtonBox.Cancel
        caja = QDialogButtonBox(botones)

        caja.accepted.connect(self.accept)
        caja.rejected.connect(self.reject)

        layout = QVBoxLayout()
        layout.addWidget(QLabel("¿Quieres realizar esta acción?"))
        layout.addWidget(caja)

        self.setLayout(layout)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Aplicación con diálogo personalizado")

        boton = QPushButton("Mostrar diálogo personalizado")
        boton.clicked.connect(self.mostrar_dialogo)
        self.setCentralWidget(boton)

    def mostrar_dialogo(self):
        boton_pulsado = QMessageBox.critical(
            self, 
            "Ejemplo de cuadro de mensaje critico", 
            "Ha ocurrido un problema al realizar la accion",
            buttons=QMessageBox.Discard | QMessageBox.NoToAll | QMessageBox.Ignore,
            defaultButton=QMessageBox.Discard
        )


        if boton_pulsado == QMessageBox.Discard:
            print("Descartado")

        elif boton_pulsado == QMessageBox.NoToAll:
            print("No a todo")
        else:
            print("Ignorado")

def cargar_traductor(app):
    traductor = QTranslator(app)
    ruta = QLibraryInfo.location(QLibraryInfo.TranslationsPath)
    traductor.load("qt_es", ruta)
    app.installTranslator(traductor)



app = QApplication([])
ventana = VentanaPrincipal()
cargar_traductor(app)
ventana.show()
app.exec()