import sys
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLabel,
    QLineEdit
)
from PySide6.QtGui import QPalette, QColor


class LineEditAvisoColores(QLineEdit):
    """
    QLineEdit que cambia de color según la longitud del texto:

        - Vacío             -> blanco
        - OK                -> verde suave
        - Aviso             -> amarillo suave
        - Error (muy largo) -> rojo suave
    """

    def __init__(self, parent=None):
        super().__init__(parent)

        # Valores usados internamente
        self.__longitud_aviso = 10
        self.__longitud_error = 20

        # Conectamos la señal
        self.textChanged.connect(self.__comprobar_longitud)

        # Primera comprobación
        self.__comprobar_longitud("")

    def __comprobar_longitud(self, texto):
        paleta = self.palette()
        longitud = len(texto)

        if longitud == 0:
            paleta.setColor(QPalette.Base, QColor("white"))
        elif longitud <= self.__longitud_aviso:
            paleta.setColor(QPalette.Base, QColor("#CCFFCC"))
        elif longitud <= self.__longitud_error:
            paleta.setColor(QPalette.Base, QColor("#FFF2CC"))
        else:
            paleta.setColor(QPalette.Base, QColor("#FFCCCC"))

        self.setPalette(paleta)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ejemplo LineEditAvisoColores")

        contenedor = QWidget()
        layout = QVBoxLayout()

        etiqueta = QLabel(
            "Escribe texto en el campo de abajo.\n"
            "Colores:\n"
            "- Blanco: vacío\n"
            "- Verde: longitud cómoda\n"
            "- Amarillo: aviso, texto largo\n"
            "- Rojo: texto demasiado largo"
        )

        campo_texto = LineEditAvisoColores()

        layout.addWidget(etiqueta)
        layout.addWidget(campo_texto)

        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())