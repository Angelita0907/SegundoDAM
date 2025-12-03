from PySide6.QtWidgets import (QApplication,QMainWindow,QWidget,QVBoxLayout,QLabel,QLineEdit,QPushButton, QCheckBox, QRadioButton, QComboBox)
from PySide6.QtCore import Qt
import os

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        # Cargamos y aplicamos el fichero de estilos.
        ruta_estilo = os.path.join(os.path.dirname(__file__), "Chica_Angela_estilos_T3.1.qss")
        with open(ruta_estilo, "r") as f:
            app.setStyleSheet(f.read())

        self.setWindowTitle("Personalización visual de componentes con QSS")
        self.setMinimumSize(600, 400)

        # --- Widgets ---

        # CheckBox
        self.titulo_check = QLabel("QCheckBox Personalizado")
        self.titulo_check.setAlignment(Qt.AlignCenter)
        self.chequeo = QCheckBox("Casilla Personalizada")

        # QPushBotton
        self.label = QLabel("Elija una opción: ")
        self.titulo_boton = QLabel("QPushButton Personalizado")
        self.titulo_boton.setAlignment(Qt.AlignCenter)
        self.boton_aceptar = QPushButton("Aceptar")
        self.boton_cancelar = QPushButton("Cancelar")

        # QLineEdit
        self.titulo_line = QLabel("QLineEdit Personalizado")
        self.titulo_line.setAlignment(Qt.AlignCenter)
        self.lineEdit = QLineEdit()
        self.lineEdit.setPlaceholderText("Indica tu comida favorita: ")

        # QRadioButton
        self.titulo_radio = QLabel("QRadioButton Personalizado")
        self.titulo_radio.setAlignment(Qt.AlignCenter)
        self.radio1 = QRadioButton("Avatar: Fuego y Ceniza")
        self.radio2 = QRadioButton("Frankestein")
        self.radio3 = QRadioButton("Opción C")

        # QComboBox --> en qss he personalizado como se ve el desplegable de las opciones también
        self.titulo_combo = QLabel("QComboBox Personalizado")
        self.titulo_combo.setAlignment(Qt.AlignCenter)
        self.combo = QComboBox()
        self.combo.addItems(["Selecciona una fruta: ", "Mandarinas", "Naranjas", "Platanos", "Cereza"])


        # --- Layout ---
        # he añadido espacios entre los widgets para que se diferencen mejor
        # busqué el atributo  ya que no se me ocurría otra forma

        layout = QVBoxLayout()
        layout.setContentsMargins(30, 30, 30, 30)  # Márgenes

        layout.addWidget(self.titulo_check)
        layout.addWidget(self.chequeo)

        # añado espacios entre cada widget para poder diferenciarlos mejor
        layout.addSpacing(25)

        layout.addWidget(self.titulo_boton)
        layout.addWidget(self.label)
        layout.addWidget(self.boton_aceptar)
        layout.addWidget(self.boton_cancelar)
        layout.addSpacing(25)

        layout.addWidget(self.titulo_line)
        layout.addWidget(self.lineEdit)
        layout.addSpacing(25)

        layout.addWidget(self.titulo_radio)
        layout.addWidget(self.radio1)
        layout.addWidget(self.radio2)
        layout.addWidget(self.radio3)
        layout.addSpacing(25)

        layout.addWidget(self.titulo_combo)
        layout.addWidget(self.combo)

        contenedor = QWidget()
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)


app = QApplication([])
app.setStyle("Fusion")

ventana = MainWindow()
ventana.show()
app.exec()