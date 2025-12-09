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
        # el estado principal es en rojo que es donde inicia 
        # y si se reinicia tambien
        self.__estado_actual = "rojo"

    def cambiarEstado(self, estado):
        # Guardamos el nuevo texto.
        self.estado = estado

        # para cambiar los colores del semáforo
        if self.__estado_actual == "rojo":
            self.__estado_actual = "amarillo"
            
        elif self.__estado_actual == "amarillo":
            self.__estado_actual = "verde"

        # update() avisa a Qt de que debe volver a dibujar el widget.
        self.update()

    def paintEvent(self, event):
        # QPainter es el objeto que permite dibujar dentro del widget.
        painter = QPainter(self)

        # Activamos el suavizado de bordes para evitar formas “dentadas”.
        painter.setRenderHint(QPainter.Antialiasing)

        # Configuramos el color de relleno del círculo (verde).
        painter.setBrush(QColor("#4CAF50"))

        # Borde del círculo en color negro.
        painter.setPen(QPen(Qt.white))

        # Calculamos el tamaño máximo posible de un cuadrado dentro del widget.
        # Esto asegura que el círculo no se deforme aunque el widget no sea cuadrado.
        lado = min(self.width(), self.height())

        # Creamos un rectángulo cuadrado, centrado en el widget.
        recto = QRect(
            (self.width() - lado) // 2,   # posición X centrada
            (self.height() - lado) // 2,  # posición Y centrada
            lado,                         # ancho del cuadrado
            lado                          # alto del cuadrado
        )

        # Dibujamos el círculo dentro del rectángulo calculado.
        painter.drawEllipse(recto)

        # Cambiamos el lápiz para dibujar texto en blanco.
        painter.setPen(QPen(Qt.white))

        # Dibujamos el texto centrado dentro del círculo mediante AlignCenter.
        painter.drawText(recto, Qt.AlignCenter, self._texto)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = Semaforo()
    ventana.show()
    app.exec()