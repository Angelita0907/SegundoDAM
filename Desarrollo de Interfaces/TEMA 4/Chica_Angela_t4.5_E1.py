"""
Ángela Chica Montero
Ejercicio 1. Apertura de informes en el navegador del sistema
"""

import sys
import os
from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QVBoxLayout, QPushButton, QLabel
from PyQt6.QtGui import QFont
from PyQt6.QtCore import QUrl
from PyQt6.QtGui import QDesktopServices


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Visualizador de Informes - Navegador del Sistema")
        self.setMinimumSize(400, 250)

        # Widget central y layout principal
        widget_central = QWidget()
        self.setCentralWidget(widget_central)
        layout = QVBoxLayout()
        layout.setSpacing(15)
        layout.setContentsMargins(30, 30, 30, 30)
        widget_central.setLayout(layout)

        # Etiqueta de título
        titulo = QLabel("Selecciona un informe para abrirlo en el navegador:")
        titulo.setFont(QFont("Arial", 11))
        layout.addWidget(titulo)

        # Botón 
        btn_informe_03 = QPushButton("Abrir Informe: DI_U05_A02_03")
        btn_informe_03.setMinimumHeight(45)
        btn_informe_03.clicked.connect(lambda: self.abrir_informe("DI_U05_A02_03.html"))
        layout.addWidget(btn_informe_03)

        # Botón 2
        btn_informe_08 = QPushButton("Abrir Informe: DI_U05_A02_08")
        btn_informe_08.setMinimumHeight(45)
        btn_informe_08.clicked.connect(lambda: self.abrir_informe("DI_U05_A02_08.html"))
        layout.addWidget(btn_informe_08)

        # Botón 3
        btn_informe_11 = QPushButton("Abrir Informe: DI_U05_A03_11")
        btn_informe_11.setMinimumHeight(45)
        btn_informe_11.clicked.connect(lambda: self.abrir_informe("DI_U05_A03_11.html"))
        layout.addWidget(btn_informe_11)

    def abrir_informe(self, nombre_fichero):

        # Ruta del fichero HTML 
        ruta = os.path.join(os.path.dirname(os.path.abspath(__file__)), nombre_fichero)

        # Convertir la ruta a una URL válida para el navegador
        url = QUrl.fromLocalFile(ruta)

        # Abrir en el navegador predeterminado del sistema operativo
        QDesktopServices.openUrl(url)
        print(f"[INFO] Abriendo en navegador: {ruta}")


def main():
    app = QApplication(sys.argv)
    ventana = MainWindow()
    ventana.show()
    sys.exit(app.exec())


if __name__ == "__main__":
    main()