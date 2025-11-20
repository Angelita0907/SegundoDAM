# Ángela Chica Montero

import os
import platform
import getpass
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar, QLabel
from PySide6.QtCore import QTimer

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana con menú y barra de estado")

        # mensaje que aparece al inicio
        self.statusBar().showMessage("Aplicación iniciada correctamente", 2000)


        # --- MENÚ ---
        barra_menus = self.menuBar()
        menu = barra_menus.addMenu("&Archivo")

        # Ruta del icono
        ruta_icono = os.path.join(os.path.dirname(__file__), "impresora.png")
        ruta_borrar = os.path.join(os.path.dirname(__file__), "borrar.png")
        ruta_info = os.path.join(os.path.dirname(__file__), "info.png")

        # Acción con icono, texto y descripción
        accion = QAction(QIcon(ruta_icono), "Mostrar mensaje temporal", self)
        accion.setWhatsThis("Muestra un mensahe temporal de 3 segundos") 
        accion.setShortcut(QKeySequence("Ctrl+T"))
        accion.triggered.connect(self.mostrar_mensaje)
        menu.addAction(accion)

        accion2 = QAction(QIcon(ruta_borrar), "Limpiar mensaje", self)
        accion2.setWhatsThis("Limpiar mensaje por consola")
        accion2.setShortcut(QKeySequence("Ctrl+L"))
        accion2.triggered.connect(self.statusBar().clearMessage)
        menu.addAction(accion2)

        accion3 = QAction(QIcon(ruta_info), "Informacion sistema", self)
        accion3.setWhatsThis("Muestra información del sistema")
        accion3.setShortcut(QKeySequence("Ctrl+I"))
        # guardamos quien es el usuario
        accion3.triggered.connect(self.mostrar_sistema)
        menu.addAction(accion3)


        # --- BARRA DE HERRAMIENTAS ---
        barra_herramientas = QToolBar("Barra principal")
        barra_herramientas.addAction(accion) 
        barra_herramientas.addAction(accion2)
        barra_herramientas.addAction(accion3)
        self.addToolBar(barra_herramientas)

        # --- BARRA DE ESTADO ---
        barra_estado = self.statusBar()
        barra_estado.addPermanentWidget(QLabel(getpass.getuser()))


    def mostrar_mensaje(self):
        self.statusBar().showMessage("Listo, esperando acción...", 3000)
        
    def mostrar_sistema(self):
        sistema = platform.system()
        self.statusBar().addWidget(QLabel("Sistema:"+ sistema))
    
if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()