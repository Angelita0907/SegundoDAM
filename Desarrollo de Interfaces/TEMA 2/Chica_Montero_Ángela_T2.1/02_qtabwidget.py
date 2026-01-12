# Ángela Chica Montero

from PySide6.QtWidgets import QApplication, QMainWindow, QTabWidget, QLabel, QWidget

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Pestaña 1")  # título inicial

       
        self.pestanas = QTabWidget()
        self.setCentralWidget(self.pestanas)
        
        self.crear_pestanas()
        
        self.pestanas.currentChanged.connect(self.cambiar_pestana)

    def crear_pestanas(self):
        # asi se verían la pestaña 1
        ventana1 = QWidget()
        layout1 = QLabel("Bienvenido", ventana1)

        # Pestaña 2
        ventana2 = QWidget()
        layout2 = QLabel("Segunda pestaña", ventana2)

        # Pestaña 3
        ventana3 = QWidget()
        layout3 = QLabel("Tercera pestaña", ventana3)

        # añadimos pestañas al QTabWidget
        self.pestanas.addTab(ventana1, "Pestaña 1")
        self.pestanas.addTab(ventana2, "Pestaña 2")
        self.pestanas.addTab(ventana3, "Pestaña 3")

    def cambiar_pestana(self, indice):
        print("Estamos en la pestaña: " ,indice)
        self.setWindowTitle("Pestaña: "+ str(indice + 1))


app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()
