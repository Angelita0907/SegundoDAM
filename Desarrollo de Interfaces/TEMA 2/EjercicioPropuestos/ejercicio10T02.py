# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow
from PySide6.QtGui import QAction, QKeySequence


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Menú Archivo")

        # Obtenemos la referencia a la barra de menús incluida en QMainWindow
        barra_menu = self.menuBar()

        # Añadimos un menú principal
        menu = barra_menu.addMenu("&Archivo")

        # Creamos una acción
        accion = QAction("Mostrar mensaje", self)
        accion.setShortcut(QKeySequence("Ctrl+M"))  # Atajo de teclado
        accion.triggered.connect(self.Mostrar_mensaje)  # Vinculamos acción con método

        # Creamos las demás acciones y las añadimos
        accion2 = QAction("Cambiar Título", self)
        accion2.setShortcut(QKeySequence("Ctrl+L"))
        accion2.triggered.connect(self.cambiar_titulo)

        accion3 = QAction("Salir", self)
        accion3.setShortcut(QKeySequence("Ctrl+Q"))
        accion3.triggered.connect(self.cerrar_menu)

        # Añadimos la acción al menú
        menu.addAction(accion)
        menu.addAction(accion2)
        menu.addAction(accion3)

    def Mostrar_mensaje(self):
        print("Hola desde el menú")

    def cambiar_titulo(self):
        self.setWindowTitle("Título cambiado desde el menú")

    def cerrar_menu(self):
        self.close()

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()