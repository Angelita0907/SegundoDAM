# Ángela Chica Montero

from PySide6.QtWidgets import (
    QApplication, QMessageBox, QMainWindow, QPushButton
)
from PySide6.QtCore import QLibraryInfo, QTranslator

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Aplicación elegir tareas")
        boton = QPushButton("Gestionar tarea")
        boton.clicked.connect(self.mostrar_dialogo)
        self.setCentralWidget(boton)

    def mostrar_dialogo(self):
        # Cuadro de mensaje crítico
        boton_pulsado = QMessageBox.question(
            self,
            "Acción sobre la tarea",
            "¿Qué quieres hacer con la tarea seleccionada?",
            buttons = QMessageBox.Yes | QMessageBox.No | QMessageBox.Ignore,

        )

        # Comprobamos qué botón ha seleccionado el usuario
        if boton_pulsado == QMessageBox.Yes:
            # para crear una ventana pero sin hacer qmainwindow
            QMessageBox.information(
                self, "Mensaje de información","La tarea se ha marcado como completada")
        elif boton_pulsado == QMessageBox.No:
            QMessageBox.information(self, "Mensaje de información","La tarea se ha pospuesto para más tarde")
        else:
            QMessageBox.information(self, "Mensaje de información","La tarea se mantiene sin cambios")
    
def cargar_traductor(app):
    traductor = QTranslator(app)
    ruta = QLibraryInfo.location(QLibraryInfo.TranslationsPath)
    traductor.load("qt_es", ruta)
    app.installTranslator(traductor)


app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
