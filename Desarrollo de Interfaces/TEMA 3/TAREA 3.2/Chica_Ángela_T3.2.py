import sys
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLabel,
    QTextEdit, 
    QPushButton
)
from PySide6.QtGui import QPalette, QColor
from PySide6.QtCore import Signal
# widget personalizado de QTextEdit
class AreaTextoLimitada(QTextEdit):

    def __init__(self, parent=None):
        super().__init__(parent)

        self.texto_senal = Signal()

        # Voy a crear una variable con el total y desde ella haremos los porcentajes
        self.limite = 200
        self.aviso = int(self.limite*0.8)

        # voy a poner el color de texto en negro 
        # porque si no al escribir no veo nada hasta que cambia el fondo
        paleta = self.palette()
        paleta.setColor(QPalette.Text, QColor("black"))
        self.setPalette(paleta)

        # Conectamos la señal
        self.textChanged.connect(self.__comprobar_longitud)

        # Primera comprobación
        self.__comprobar_longitud()

    def __comprobar_longitud(self):
        # añadimos palette para usar los colores que trae por defecto
        paleta = self.palette()
        
        # Obtenemos el texto directamente aquí
        texto = self.toPlainText()
        longitud = len(texto)

        if longitud < self.aviso:
            paleta.setColor(QPalette.Base, QColor("white"))
        elif longitud <= self.limite:
            paleta.setColor(QPalette.Base, QColor("#FFF2CC"))
        else:
            paleta.setColor(QPalette.Base, QColor("#FFCCCC"))

        self.setPalette(paleta)

    def obtener_maximo_caracteres(self):
        return self.limite


# Widget personalizado de QLabel
class EtiquetaContadorCaracteres(QLabel):
    def __init__(self, parent=None):
        super().__init__(parent)

        self.maximo_caracteres = 200
        self.aviso_caracteres = int(self.maximo_caracteres*0.8)

        # Iniciamos el contador
        self.modificar_contador(0)

    def modificar_contador(self, caracteres):

        texto_escrito = "Caracteres: " + str(caracteres) + "/" + str(self.maximo_caracteres)
        self.setText(texto_escrito)
        
        paleta = self.palette()


        if caracteres < self.aviso_caracteres:
            paleta.setColor(QPalette.WindowText, QColor("black"))
        elif caracteres <= self.maximo_caracteres:
            paleta.setColor(QPalette.WindowText, QColor("#FF8C00"))  # Naranja
        else:
            paleta.setColor(QPalette.WindowText, QColor("red"))

        self.setPalette(paleta)


class BotonLimpiarAviso(QPushButton):
    # Corregido: recibir el área de texto como parámetro
    def __init__(self, area_texto, parent=None):
        super().__init__(parent)

        # le damos nombre al botón
        self.setText("Limpiar texto")

        # guardamos referencia al área de texto
        self.texto_completo = area_texto

        # conectamos lo que hace el boton a la funcion de abajo
        self.clicked.connect(self.limpiar)


    def limpiar(self):
        self.texto_completo.clear()

        # Cambiar a verde cuando se limpia
        paleta = self.palette()
        paleta.setColor(QPalette.Button, QColor("#CCFFCC"))
        self.setPalette(paleta)

        

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Editor de notas con avisos")

        contenedor = QWidget()
        layout = QVBoxLayout()

        # definimos las variables de cada widget derivado
        self.area_texto = AreaTextoLimitada()
        self.contador_caracteres = EtiquetaContadorCaracteres()

        self.boton_limpiador = BotonLimpiarAviso(self.area_texto)

        # lo añadimos al layout
        layout.addWidget(self.contador_caracteres)
        layout.addWidget(self.area_texto)
        layout.addWidget(self.boton_limpiador)


        self.area_texto.textChanged.connect(self.actualizar_contador)

        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)

    def actualizar_contador(self):
        longitud = len(self.area_texto.toPlainText())

        self.contador_caracteres.modificar_contador(longitud)


app = QApplication(sys.argv)
ventana = VentanaPrincipal()
ventana.show()
sys.exit(app.exec())