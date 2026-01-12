import sys, os
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton, QLabel
)
from PySide6.QtGui import QPainter, QColor, QPen, QPalette
from PySide6.QtCore import QRect, Qt,Signal

class CirculoIndicador(QWidget):
    def __init__(self):
        super().__init__()

        # Cargamos y aplicamos el fichero de estilos.
        ruta_estilo = os.path.join(os.path.dirname(__file__), "Chica_Montero_Angela_estilos.qss")
        with open(ruta_estilo, "r") as f:
            app.setStyleSheet(f.read())

        # Texto que se mostrará dentro del círculo.
        # Se puede cambiar desde fuera con setTexto().
        paleta = self.palette()
        self._texto = "OK"
        paleta.setColor(QPalette.WindowText, QColor("black"))

        self.fondo_actual = "blanco"

        # creo una varible que tenga el minimo con el que salta el cambio de aviso
        self.peligro = 8

    def setTexto(self, texto):
        # Guardamos el nuevo texto.
        self._texto = texto
        # update() avisa a Qt de que debe volver a dibujar el widget.
        self.update()

    def paintEvent(self, event):
        # QPainter es el objeto que permite dibujar dentro del widget.
        painter = QPainter(self)

        painter.setRenderHint(QPainter.Antialiasing)

        # primero ponemos el color de inicio a blanco
        painter.setBrush(QColor("white"))

        # Borde del círculo en color negro.
        painter.setPen(QColor("B3B2AE"))

        # según el enunciado creamos el diametro del circulo
        diametro = 120

        # Creamos un rectángulo cuadrado, centrado en el widget.
        recto = QRect(
            (self.width() - diametro) // 2,   
            (self.height() - diametro) // 2,  
            120,                         
            120                          
        )

        # Dibujamos el círculo dentro del rectángulo calculado.
        painter.drawEllipse(recto)

        # Cambiamos el lápiz para dibujar texto en blanco.
        painter.setPen(QPen(Qt.white))

        # Dibujamos el texto centrado dentro del círculo mediante AlignCenter.
        painter.drawText(recto, Qt.AlignCenter, self._texto)
    
    # funcion cambiar el color del ciruclo según contador (modificar)
    def cambia_color(self):

        if self.fondo_actual == "blanco":
            self.amarillo = QColor("#fbcf4f")
            self.rojo = QColor("gray")

            self.fondo_actual = "amarillo"

        elif self.fondo_actual == "amarillo":
            self.verde = QColor("#00a27d")
            self.amarillo = QColor("gray")

            self.fondo_actual = "verde"
        
        else:
            self.fondo_actual = "rojo"
            self.rojo = QColor("#9b111e")
            self.verde = QColor("gray")

        self.update()

# boton propio para añadir incidencias
class aniadirIncidencia(QPushButton):
    # creamos señal propio para el contador
    aviso_incidencias = Signal(int)

    def __init__(self,parent=None):
        super().__init__()

        # le damos nombre al botón
        self.setText("Añadir incidencia")
        self.__contador = 0
        self.clicked.connect(self.incrementar)

    # funcion para incrementar el contador
    def incrementar(self):
        self.__contador = self.__contador + 1

        self.aviso_incidencias.emit(self.__contador)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Panel de Indicencias")
        self.resize(500, 400)

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        # Añadimos nuestro widget personalizado
        self.avisos = CirculoIndicador()
        
        self.boton = aniadirIncidencia()
        #self.boton.clicked.connect(self.cambiar_texto)

        self.label_aviso = QLabel("Incidencias abiertas: ")


        # añadimos botón para reiniciar el panel de avisos
        self.boton_reiniciar = QPushButton("Reset")
        #self.boton_reiniciar.clicked.connect(self.reboot)

        layout.addWidget(self.avisos)
        layout.addWidget(self.label_aviso)
        layout.addWidget(self.boton)
        layout.addWidget(self.boton_reiniciar)

        # conectar con boton al label
        # self.label_aviso.aviso_incidencias.connect(self.boton.incrementar)

        self.setCentralWidget(contenedor)

    def cambiar_contador(self):
        avisos = (self.boton)
        self.label_aviso.label_incidencias(avisos)
        self.label_aviso.setText("Incidencias abiertas: " + str(avisos))

    def label_incidencias(self, aviso):
        
        # Iniciamos el contador
        self.aviso_rojo = 8
        self.incidencia_amarillaMax = 7

        self.contador = 0

        # indicamos las incidencias
        incidencias = "Incidencias abiertas: " + str(self.contador)
        self.setText(incidencias)
        
        paleta = self.palette()

        paleta.setColor(QPalette.WindowText, QColor("black"))

        # para que cambie el fondo según las incidencias
        if aviso >= 3:
            paleta.setColor(QPalette.Window, QColor("white"))
            self.label_incidencias.setAutoFillBackground(True)

        elif 3 < aviso >= self.incidencia_amarillaMax:
            paleta.setColor(QPalette.Window, QColor("yellow")) 
            self.label_incidencias.setAutoFillBackground(True)

        elif aviso >= self.aviso_rojo:
            paleta.setColor(QPalette.Window, QColor("red"))
            self.label_incidencias.setAutoFillBackground(True)

        self.setPalette(paleta)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()