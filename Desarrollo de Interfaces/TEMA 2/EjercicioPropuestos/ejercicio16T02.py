# Ángela Chica Montero
import os

from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout,
    QPushButton, QLabel, QFileDialog, QColorDialog, QFontDialog
)
from PySide6.QtGui import QColor, QFont
from PySide6.QtCore import Qt

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Gestión de archivo y preferencias")

        self.layout1 = QVBoxLayout()   
        # para poder mostrar los cambios usamos qlabel    
        self.label_texto = QLabel()

        contenedor_botones = QWidget()
        contenedor_botones.setLayout(self.layout1)
        self.setCentralWidget(contenedor_botones)

        # ahora crearemos los botones del layout vertical 
        # y luego lo conectaremos a las funciones

        abrirArchivo = QPushButton("Abrir archivo de texto")
        guardar = QPushButton("Guardar archivo como...")
        color = QPushButton("Elegir color de fondo")
        fuente = QPushButton("Cambiar fuente del texto")

        # añadimos al layout
        self.layout1.addWidget(abrirArchivo)
        self.layout1.addWidget(guardar)
        self.layout1.addWidget(color)
        self.layout1.addWidget(fuente)

        # conectamos con las funciones
        abrirArchivo.clicked.connect(self.abrir_archivo)
        guardar.clicked.connect(self.guardar_archivo)
        color.clicked.connect(self.cambiar_color)
        fuente.clicked.connect(self.cambiar_fuente)

        self.layout1.addWidget(self.label_texto)

    # abrir archivos
    def abrir_archivo(self):
        ventana_dialogo = QFileDialog.getOpenFileName(
        self,
        caption="Abrir archivo ...",
        dir="./",
        filter="Documentos de texto (*.txt)",
        selectedFilter="Documentos de texto (*.txt)"
    )

        archivo = ventana_dialogo[0]   # Ruta del archivo seleccionado
        self.layout1.addWidget(QLabel("Archivo: "+archivo))

        nombre = os.path.basename(archivo)

    # guardar archhivos
    def guardar_archivo(self):
        ventana_dialogo = QFileDialog.getSaveFileName(
        self,
        caption="Guardar archivo ...",
        dir="./",
        filter="Documentos de texto (*.txt);;Documentos PDF (*.pdf)",
        selectedFilter="Documentos de texto (*.txt)"
    )

        archivo = ventana_dialogo[0]
        print(archivo)

    # cambia color
    def cambiar_color(self):
        color = QColorDialog.getColor()
        if color.isValid():
            self.label_texto.setStyleSheet(f"background-color: {color.name()}")

    # cambiar fuente
    def cambiar_fuente(self):
        seleccionada, fuente = QFontDialog.getFont(self)
        if seleccionada:
            self.label_texto.setFont(fuente)

app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
