from PySide6.QtWidgets import (QApplication,QMainWindow,QWidget,QVBoxLayout,QLabel,QLineEdit,QPushButton, QCheckBox, QRadioButton, QComboBox)

import os

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        # Cargamos y aplicamos el fichero de estilos.
        ruta_estilo = os.path.join(os.path.dirname(__file__), "estilos.qss")
        with open(ruta_estilo, "r") as f:
            app.setStyleSheet(f.read())

        self.setWindowTitle("Personalización visual de componentes con QSS")

        # --- Widgets ---
        self.label = QLabel("Introduce tu nombre:")
        self.input_nombre = QLineEdit()

        # CheckBox
        self.chequeo = QCheckBox("Casilla Personalizada")

        # QPushBotton
        self.boton_aceptar = QPushButton("Aceptar")
        self.boton_cancelar = QPushButton("Cancelar")

        # --- Layout ---

        # he añadido espacios entre los widgets para que se diferencen mejor
        # busqué el atributo  ya que no se me ocurría otra forma

        layout = QVBoxLayout()
        layout.setContentsMargins(30, 30, 30, 30)  # Márgenes

        layout.addWidget(self.chequeo)
        layout.addSpacing(25)

        layout.addWidget(self.label)
        layout.addWidget(self.input_nombre)
        layout.addWidget(self.boton_aceptar)
        layout.addWidget(self.boton_cancelar)

        contenedor = QWidget()
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)


app = QApplication([])
app.setStyle("Fusion")

ventana = MainWindow()
ventana.show()
app.exec()