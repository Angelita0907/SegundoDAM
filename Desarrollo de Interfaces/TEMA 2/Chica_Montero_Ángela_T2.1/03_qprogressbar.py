# Ángela Chica Montero

# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QProgressBar
from PySide6.QtCore import QTimer

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        # Primero ponemos sobre que progreso se encuentra al inicio del programa
        self.progreso_actual = 0

        # lueog creamos la barra de progreso y le indicamos el progreso inicial que pusimos antes
        self.barra = QProgressBar()
        self.barra.setRange(0, 100)
        self.barra.setValue(self.progreso_actual)
        self.setCentralWidget(self.barra)

        # Título ventana
        self.setWindowTitle("Progreso: 0%")

        # ponemos el temporizador para que despues de eso muestre el menu de opciones
        self.timer = QTimer(self)
        self.timer.timeout.connect(self.menu)
        self.timer.start(2000)  # cada 2 segundos

    # esto se ejecuta luego del timer indicado (2 segundos)
    def menu(self):
        print("\n=== Control de progreso ===")
        print("1. Aumentar progreso")
        print("2. Disminuir progreso")
        print("0. Salir")

        opcion = input("Selecciona una opción: ")

        if opcion == "1":
            self.cambiar_progreso("aumentar")
        elif opcion == "2":
            self.cambiar_progreso("disminuir")
        elif opcion == "0":
            print("Fin del programa!!")
            self.timer.stop()
            self.close()
        else:
            print("Opción no válida, Intentalo de nuevo :(")

    # menu de opcines para cambiar el progreso de la brra
    def cambiar_progreso(self, modo):
        if modo == "aumentar":
            # irá aumentando o disminuyendo de 20 en 20 sin psar de 100
            self.progreso_actual = min(self.progreso_actual + 20, 100)
        elif modo == "disminuir":
            self.progreso_actual = max(self.progreso_actual - 20, 0)

        # Actualizar la barra
        self.barra.setValue(self.progreso_actual)

        # Actualizar título de la ventana
        if self.progreso_actual == 100:
            self.setWindowTitle("¡Tarea completada!")
        else:
            self.setWindowTitle("Progreso: " + str(self.progreso_actual) + "%")

        # para que enseñe el progreso que lleva
        print("Progreso actual:", str(self.progreso_actual) + "%")


app = QApplication()
ventana = VentanaPrincipal()
ventana.show()
app.exec()
