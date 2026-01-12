# Ángela Chica Montero

import os
import platform
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QToolBar, QLabel, QDockWidget, QTextEdit
)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejercicio - Componentes flotantes")

        # --- COMPONENTE FLOTANTE (DOCK) ---
        dock1 = QDockWidget("Panel de notas", self)
        dock1.setWidget(QTextEdit(""))
        dock1.setMinimumWidth(50)
        self.addDockWidget(Qt.LeftDockWidgetArea, dock1)

        dock1.setFeatures(QDockWidget.NoDockWidgetFeatures)

        dock2 = QDockWidget("Panel de estado", self)
        dock2.setWidget(QLabel())
        dock2.setMinimumWidth(50)
        self.addDockWidget(Qt.RightDockWidgetArea, dock2)

        dock2.setFeatures(QDockWidget.DockWidgetFloatable)

        dock3 = QDockWidget("Panel de ayuda", self)
        dock3.setWidget(QLabel())
        dock3.setMinimumWidth(50)
        self.addDockWidget(Qt.BottomDockWidgetArea, dock3)

        dock3.setFeatures(QDockWidget.DockWidgetClosable | QDockWidget.DockWidgetFloatable)

        # --- COMPONENTE CENTRAL ---
        self.setCentralWidget(QLabel("Área principal de la aplicación"))

     # --- MENÚ Y ACCIÓN ---
        barra_menus = self.menuBar()
        menu = barra_menus.addMenu("&Menú")

        ruta_icono = os.path.join(os.path.dirname(__file__), "impresora.png")
        accion = QAction(QIcon(ruta_icono), "Imprimir por consola", self)
        accion.setStatusTip("Imprimir por consola")
        accion.setShortcut(QKeySequence("Ctrl+P"))
        accion.triggered.connect(self.imprimir_por_consola)
        menu.addAction(accion)

        # --- BARRA DE HERRAMIENTAS ---
        barra_herramientas = QToolBar("Barra principal")
        barra_herramientas.addAction(accion)
        self.addToolBar(barra_herramientas)

        # --- BARRA DE ESTADO ---
        barra_estado = self.statusBar()
        barra_estado.showMessage("Listo, Panales creados correctamente")

    def imprimir_por_consola(self):
        print("Acción lanzada desde el menú, el atajo o la barra de herramientas.")

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
