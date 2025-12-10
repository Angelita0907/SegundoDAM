import sys
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton
)
from PySide6.QtGui import QPainter, QColor, QPen
from PySide6.QtCore import QRect, Qt

class PanelSemaforo(QWidget):
    def __init__(self):
        super().__init__()
        # el estado principal es en rojo que es donde inicia 
        # y si se reinicia tambien
        self.__estado_actual = "rojo"

        self.rojo = QColor("#FF0000")
        self.amarillo = QColor("#FFFB00")
        self.verde = QColor("#4CAF50")
        self.fondo = QColor("gray")

    def cambiarEstado(self, estado):
        # Guardamos el nuevo texto.
        self.estado = estado

        # para cambiar los colores del semáforo
        if self.__estado_actual == "rojo":
            self.__estado_actual = "amarillo"
            
        elif self.__estado_actual == "amarillo":
            self.__estado_actual = "verde"
        
        else:
            self.__estado_actual = "rojo"

        # update() avisa a Qt de que debe volver a dibujar el widget.
        self.update()
    
    def estado(self):
        # Devuelve el color actual del semáforo
        return self.__estado_actual
    
    def reiniciar(self):
        # Reinicia el semáforo al estado rojo
        self.__estado_actual = "rojo"
        self.update()

    def paintEvent(self, event):
        # QPainter es el objeto que permite dibujar dentro del widget.
        painter = QPainter(self)

        # Activamos el suavizado de bordes para evitar formas “dentadas”.
        painter.setRenderHint(QPainter.Antialiasing)

        # posicion rectángulo y tamaño

        alto = self.height() // 5
        ancho = alto // 2

        x = (self.width() - ancho) // 2
        y = (self.height() - alto) // 2

        # posiciónes círculos y tamaño


        # dimension de circulos
        radio = self.width() // 4
        diametro = radio*2

        alto_circulo = diametro * 4
        ancho_circulo = diametro * 2

        # posiciones circulos

        painter.setBrush(self.fondo)

        x_circulo = x + (ancho_circulo // 2)
        y_rojo = y + alto_circulo 
        y_amarillo = y + alto_circulo + (y_rojo * 2)
        y_verde = y + alto_circulo + (y_amarillo * 3)

        # Creamos un rectángulo cuadrado, centrado en el widget.
        recto = QRect(x, y, ancho, alto)
        
    

    def cambia_color(self):
        if self.__estado_actual == "rojo":
            color_rojo =self.rojo
        

        elif self.__estado_actual == "amarillo":
            color_amarillo = self.amarillo
        
        elif self.__estado_actual == "verde":
            color_verde = self.verde

        # Configuramos el color de relleno del círculo (verde).
        # painter.setBrush(QColor("#4CAF50"))

        # Borde del círculo en color negro.
        # painter.setPen(QPen(Qt.white))

        

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Panel de Semáforo")
        self.resize(300, 300)

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        # Nuestro widget personalizado
        self.semaforo = PanelSemaforo()

        layout.addWidget(self.semaforo)
        
        # Botón interno "Cambiar"
        self.boton_cambiar = QPushButton("Cambiar estado")
        self.layout().addWidget(self.boton_cambiar)
        
        # Conexión del botón al método de avance
        self.boton_cambiar.clicked.connect(self.cambiar_color)
        
        # self.boton_cambiar.clicked.connect(self.cambiarEstado)
        self.setCentralWidget(contenedor)
    
    def cambiar_color(self):
        self.semaforo.cambia_color()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()