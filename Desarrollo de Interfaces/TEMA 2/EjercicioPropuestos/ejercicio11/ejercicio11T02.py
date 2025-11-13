import os
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar
from PySide6.QtCore import Qt

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana principal")

        # --- MENÚ PRINCIPAL ---
        barra_menus = self.menuBar()
        menu_archivo = barra_menus.addMenu("&Archivo")

        # indicamos la ruta para cada accion con su icono
        mensaje = os.path.join(os.path.dirname(__file__), "mensaje.png")
        titulo = os.path.join(os.path.dirname(__file__), "titulo.png")
        desactivar = os.path.join(os.path.dirname(__file__), "bloquear.png")
        activar = os.path.join(os.path.dirname(__file__), "activar.png")

        # Creamos las acciones y lo que hacen
        self.accion_mensaje = QAction(QIcon(mensaje), "Mostrar mensaje", self)
        self.accion_mensaje.setShortcut(QKeySequence("Ctrl+M"))
        self.accion_mensaje.setWhatsThis("Muestra el texto 'Hola' en la consola.")
        self.accion_mensaje.triggered.connect(self.mostrar_mensaje)

      
        self.accion_titulo = QAction(QIcon(titulo), "Cambiar título", self)
        self.accion_titulo.setShortcut(QKeySequence("Ctrl+T"))
        self.accion_titulo.setWhatsThis("Cambia el título de la ventana a 'Título cambiado'.")
        self.accion_titulo.triggered.connect(self.cambiar_titulo)

        
        self.accion_desactivar = QAction(QIcon(desactivar), "Desactivar acciones", self)
        self.accion_desactivar.setShortcut(QKeySequence("Ctrl+D"))
        self.accion_desactivar.setWhatsThis("Desactiva las acciones 'Mostrar mensaje' y 'Cambiar título'.")
        self.accion_desactivar.triggered.connect(self.desactivar_acciones)

        # Ahora las añadimos al menú
        menu_archivo.addAction(self.accion_mensaje)
        menu_archivo.addAction(self.accion_titulo)
        menu_archivo.addSeparator()
        menu_archivo.addAction(self.accion_desactivar)

        # Primero creamos la barra de herramientas
        barra_principal = QToolBar("Barra principal")
        barra_principal.addAction(self.accion_mensaje)
        barra_principal.addAction(self.accion_titulo)
        barra_principal.addAction(self.accion_desactivar)

        # Mostrar texto debajo de los iconos
        barra_principal.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        self.addToolBar(barra_principal)

        # Creamos otra barra de herramientas
        self.accion_activar = QAction(QIcon(activar), "Activar acciones", self)
        self.accion_activar.setWhatsThis("Vuelve a activar las acciones desactivadas.")
        self.accion_activar.triggered.connect(self.activar_acciones)

        barra_secundaria = QToolBar("Barra secundaria")
        barra_secundaria.addAction(self.accion_activar)
        barra_secundaria.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        self.addToolBar(barra_secundaria)


    def mostrar_mensaje(self):
        print("Hola")

    def cambiar_titulo(self):
        self.setWindowTitle("Título cambiado")

    def desactivar_acciones(self):
        self.accion_mensaje.setEnabled(False)
        self.accion_titulo.setEnabled(False)

    def activar_acciones(self):
        self.accion_mensaje.setEnabled(True)
        self.accion_titulo.setEnabled(True)


if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()