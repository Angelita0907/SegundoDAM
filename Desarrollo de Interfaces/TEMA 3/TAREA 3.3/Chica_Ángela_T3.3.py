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

class Semaforo(QWidget):
    def __init__(self):
        super().__init__()

        self.__estado_actual = "rojo"
    
        self.rojo = QColor("#9b111e")
        self.amarillo = QColor("gray")
        self.verde = QColor("gray")

    def paintEvent(self, event):
    
        painter = QPainter(self)

        # Activamos el suavizado de bordes para evitar formas “dentadas”.
        painter.setRenderHint(QPainter.Antialiasing)

        painter.setBrush(QColor("#91918F"))
        painter.setPen(QColor("#B3B2AE"))

        # dimensiones rectangulo

        alto = (self.height() // 5) * 4

        ancho = alto // 2

        # posicion rectangulo

        x = (self.width() - ancho) // 2
        y = (self.height() - alto) // 2

        # pintamos el rectangulo
        painter.drawRect(x,y,ancho,alto)

        # circulos
        # para que quepan dentro del semaforo
        diametro = ancho * 0.6

        # parta separar cada circilo
        espacio = (alto - (diametro*3)) // 4

        # posiciones

        x_circulo = x + (ancho - diametro) // 2 
        
        y_circuloRojo = y + espacio

        y_circuloAmarillo = y + (espacio * 2) + diametro

        y_circuloVerde = y + (espacio * 3) + (diametro * 2)

        # pintar ciruclos

        painter.setBrush(self.rojo)
        painter.setPen(QColor("#ff4759"))
        circulo_rojo = painter.drawEllipse(x_circulo, y_circuloRojo, diametro, diametro)

        painter.setBrush(self.amarillo)
        painter.setPen(QColor("#ffe085"))
        circulo_amarillo = painter.drawEllipse(x_circulo, y_circuloAmarillo, diametro, diametro)

        painter.setBrush(self.verde)
        painter.setPen(QColor("#0addac"))
        circulo_verde = painter.drawEllipse(x_circulo, y_circuloVerde, diametro, diametro)


    def cambia_color(self):

        if self.__estado_actual == "rojo":
            self.amarillo = QColor("#fbcf4f")
            self.rojo = QColor("gray")

            self.__estado_actual = "amarillo"

        elif self.__estado_actual == "amarillo":
            self.verde = QColor("#00a27d")
            self.amarillo = QColor("gray")

            self.__estado_actual = "verde"
        
        else:
            self.__estado_actual = "rojo"
            self.rojo = QColor("#9b111e")
            self.verde = QColor("gray")

        self.update()
    
    def reiniciar(self):
        self.__estado_actual = "rojo"
        self.rojo = QColor("#9b111e")
        self.amarillo = QColor("gray")
        self.verde = QColor("gray")

        self.update()
    
    def estado(self):
        return self.__estado_actual


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Panel de Semáforo")
        self.resize(300, 300)

        # boton para el cambio de color

        self.boton = QPushButton("Cambiar estado")
        self.boton.clicked.connect(self.cambiar_estado)

        self.boton_reiniciar = QPushButton("Reiniciar")
        self.boton_reiniciar.clicked.connect(self.reboot)

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        # Nuestro widget personalizado
        self.semaforo = Semaforo()

        layout.addWidget(self.semaforo)
        layout.addWidget(self.boton)
        layout.addWidget(self.boton_reiniciar)
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)
    
    def cambiar_estado(self):
        self.semaforo.cambia_color()
        print("Estado actual: "+ self.semaforo.estado())
    
    def reboot(self):
        self.semaforo.reiniciar()

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()