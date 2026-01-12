# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QDateTimeEdit
from PySide6.QtCore import QDateTime

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.selector_fecha_hora = QDateTimeEdit()
        self.setCentralWidget(self.selector_fecha_hora)

        # con esto muestra el día y hora de hoy
        self.selector_fecha_hora.setDateTime(QDateTime.currentDateTime())

        # lo ponemos en formato español porque por defecto sería en inglés con el año por delante
        self.selector_fecha_hora.setDisplayFormat("dddd, d 'de' MMMM 'de' yyyy hh:mm")

        # para cambiar el titulo según la fecha que escogamos
        self.selector_fecha_hora.dateTimeChanged.connect(self.actualizar_titulo)

        # igual que el anterior pero el titulo será primero la fecha iniciañ
        self.actualizar_titulo(self.selector_fecha_hora.dateTime())

    # cambia el titulo al cambiar la hora y mostramos cual es por consola
    # lo he puesto  en formato español con el día por delante
    def actualizar_titulo(self, fecha_hora):

        print("Fecha elegida:", fecha_hora.toString("dddd, d 'de' MMMM 'de' yyyy hh:mm"))
 
        self.setWindowTitle(fecha_hora.toString("dddd, d 'de' MMMM 'de' yyyy hh:mm"))


app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
