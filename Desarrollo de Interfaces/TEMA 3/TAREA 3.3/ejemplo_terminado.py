import sys
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton
)
from PySide6.QtGui import QPainter, QColor, QPen, QBrush
from PySide6.QtCore import QRect, Qt


class PanelSemaforo(QWidget):
    """
    Componente gráfico que simula un semáforo con tres luces:
    roja, amarilla y verde.
    """
    
    def __init__(self, parent=None):
        super().__init__(parent)
        self.__estado_actual = "rojo"
        self._inicializar_ui()
    
    def _inicializar_ui(self):
        """Configura la interfaz del componente"""
        # Configurar tamaño mínimo del widget
        self.setMinimumSize(150, 350)
        
        # Crear el botón
        self.boton_cambiar = QPushButton("Cambiar", self)
        self.boton_cambiar.clicked.connect(self._cambiar_estado)
        
        # Crear layout
        layout = QVBoxLayout()
        layout.addStretch()  # Espacio arriba para el dibujo
        layout.addWidget(self.boton_cambiar)
        
        self.setLayout(layout)
    
    def _cambiar_estado(self):
        """Cambia el estado del semáforo al siguiente color"""
        if self.__estado_actual == "rojo":
            self.__estado_actual = "amarillo"
        elif self.__estado_actual == "amarillo":
            self.__estado_actual = "verde"
        else:  # verde
            self.__estado_actual = "rojo"
        
        # Forzar repintado
        self.update()
    
    def estado(self):
        """Devuelve el color actual del semáforo"""
        return self.__estado_actual
    
    def reiniciar(self):
        """Reinicia el semáforo al estado rojo"""
        self.__estado_actual = "rojo"
        self.update()
    
    def paintEvent(self, event):
        """Dibuja el semáforo con sus tres luces"""
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)
        
        # Dimensiones y posiciones
        ancho = self.width()
        alto_disponible = self.height() - self.boton_cambiar.height() - 20
        
        # Tamaño del semáforo
        ancho_semaforo = 100
        alto_semaforo = 260
        x_semaforo = (ancho - ancho_semaforo) // 2
        y_semaforo = 20
        
        # Dibujar rectángulo del semáforo (fondo)
        painter.setPen(QPen(QColor(50, 50, 50), 3))
        painter.setBrush(QBrush(QColor(80, 80, 80)))
        painter.drawRect(x_semaforo, y_semaforo, ancho_semaforo, alto_semaforo)
        
        # Parámetros de las luces
        radio_luz = 35
        x_centro = x_semaforo + ancho_semaforo // 2
        espaciado = 80
        y_primera_luz = y_semaforo + 50
        
        # Dibujar luz roja
        if self.__estado_actual == "rojo":
            color_rojo = QColor(255, 0, 0)
        else:
            color_rojo = QColor(100, 100, 100)
        
        painter.setPen(QPen(Qt.black, 2))
        painter.setBrush(QBrush(color_rojo))
        painter.drawEllipse(x_centro - radio_luz, y_primera_luz - radio_luz, 
                          radio_luz * 2, radio_luz * 2)
        
        # Dibujar luz amarilla
        if self.__estado_actual == "amarillo":
            color_amarillo = QColor(255, 255, 0)
        else:
            color_amarillo = QColor(100, 100, 100)
        
        painter.setBrush(QBrush(color_amarillo))
        painter.drawEllipse(x_centro - radio_luz, y_primera_luz + espaciado - radio_luz,
                          radio_luz * 2, radio_luz * 2)
        
        # Dibujar luz verde
        if self.__estado_actual == "verde":
            color_verde = QColor(0, 255, 0)
        else:
            color_verde = QColor(100, 100, 100)
        
        painter.setBrush(QBrush(color_verde))
        painter.drawEllipse(x_centro - radio_luz, y_primera_luz + espaciado * 2 - radio_luz,
                          radio_luz * 2, radio_luz * 2)


 
if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = PanelSemaforo()
    ventana.show()
    app.exec()