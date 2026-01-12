# Ángela Chica Montero

from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget,
    QHBoxLayout, QVBoxLayout, QPushButton
)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Layouts anidados")

        # creamos el layaout principal que contiene los otros dos
        layout_principal = QHBoxLayout()

        # Luego creamos los verticales
        layout_vertical = QVBoxLayout()
        layout_vertical.addWidget(QPushButton("V1"))
        layout_vertical.addWidget(QPushButton("V2"))
        layout_vertical.addWidget(QPushButton("V3"))
        layout_vertical.addWidget(QPushButton("V4"))

        # Ahora los orizontales
        layout_horizontal = QHBoxLayout()
        layout_horizontal.addWidget(QPushButton("H1"))
        layout_horizontal.addWidget(QPushButton("H2"))
        layout_horizontal.addWidget(QPushButton("H3"))
        layout_horizontal.addWidget(QPushButton("H4"))

        # Y los añadimos al principal en el orden del ejercicio
        layout_principal.addLayout(layout_vertical)
        layout_principal.addLayout(layout_horizontal)

        # Con los layout pequeños dentro del grande creamos el principal
        componente_principal = QWidget()
        componente_principal.setLayout(layout_principal)
        self.setCentralWidget(componente_principal)


app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
