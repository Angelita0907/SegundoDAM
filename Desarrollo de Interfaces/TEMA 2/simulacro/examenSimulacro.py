import sys

from PySide6.QtWidgets import (
    QApplication,QMainWindow,QWidget,QLineEdit,QTextEdit, QComboBox, QMessageBox,QRadioButton,QFormLayout, QVBoxLayout,
    QToolBar, QStatusBar, QLabel, QHBoxLayout
)
from PySide6.QtGui import QAction, QKeySequence
from PySide6.QtCore import Qt, QSize


class VentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        # lo primero que haremos será declarar todo lo que vamos 
        # a usar en nuestro programa para poder usarlo donde deseemos

        # TODO: ti­tulo y tamaño ma­ximo de la ventana
        self.setWindowTitle("Mini Bloc de Notas")
        self.setMinimumSize(QSize(700,400))

        # TODO: declarar atributos de widgets (title, categoria, prioridad, area de texto)
        self.line_edit_titulo = None
        self.categoria = None
        self.prioridad = None
        self.area_texto = None

        # ...

        # TODO: declarar acciones (limpiar, imprimir, salir, acerca de)
        self.accion_limpiar_nota = None
        self.accion_imprimir_nota = None
        self.salir = None
        self.acerca_de = None
        # ...

        # Construccion general
        self.crear_central()       # TODO: completar
        self.crear_acciones()      # TODO: completar
        self.crear_menus()         # TODO: completar
        self.crear_toolbar()       # TODO: completar
        self.crear_statusbar()     # TODO: completar
        self.conectar_senales()    # TODO: completar

    # =========================
    # CREACION DE LA ZONA CENTRAL
    # =========================
    def crear_central(self):
        widget_central = QWidget()

        # TODO: crear widgets del formulario
        self.line_edit_titulo = QLineEdit()
        self.line_edit_titulo.setPlaceholderText("Escribe aquí")
        self.combo_categoria = QComboBox()

        # añadimos lo que aparece como selección
        self.combo_categoria.addItems(["Trabajo","Ideas","Otros"])

        self.radio_prioridad_normal = QRadioButton("Normal")
        self.radio_prioridad_alta = QRadioButton("Alta")


        self.texto_nota = QTextEdit()

        # TODO: crear layouts (formulario + layout principal)
        layout_form = QFormLayout()
        layout_principal = QVBoxLayout()
        # layout para los botones
        layout_botones = QHBoxLayout()

        layout_botones.addWidget(self.radio_prioridad_normal)
        layout_botones.addWidget(self.radio_prioridad_alta)

        # TODO: aÃ±adir widgets al layout del formulario
        
        layout_form.addRow("Titulo: ",self.line_edit_titulo)
        layout_form.addRow("Categoría: ",self.combo_categoria)
        layout_form.addRow("Pioridad: ",layout_botones)


        # TODO: aÃ±adir layouts al layout principal
        layout_principal.addLayout(layout_form)
        layout_principal.addWidget(self.texto_nota)

        # TODO: setLayout del widget central
        widget_central.setLayout(layout_principal)

        self.setCentralWidget(widget_central)

    # =========================
    # ACCIONES, MENUS Y TOOLBAR
    # =========================
    def crear_acciones(self):
        # TODO: crear acciones (QAction) con texto y atajos
        self.accion_limpiar_nota = QAction("Limpiar nota", self)
        self.accion_limpiar_nota.setShortcut(QKeySequence("Ctrl+C"))
        self.accion_limpiar_nota.triggered.connect(self.slot_limpiar_nota)

        self.accion_imprimir_nota = QAction("Imprimir Nota", self)
        self.accion_imprimir_nota.setShortcut(QKeySequence("Ctrl+I"))
        self.accion_imprimir_nota.triggered.connect(self.imprimir_en_consola)
        
        self.salir = QAction("Salir")
        self.accion_imprimir_nota.setShortcut(QKeySequence("Ctrl+S"))
        self.salir.triggered.connect(self.slot_salir)


        # accion para imprimir ayuda
        self.acerca_de = QAction("Acerca de", self)
        self.acerca_de.triggered.connect(self.slot_acerca_de)

        pass

    def crear_menus(self):
        # TODO: crear la barra de menÃºs y aÃ±adir los menÃºs Archivo y Ayuda
        barra_menus = self.menuBar()
        menu_archivo = barra_menus.addMenu("Archivo")
        menu_archivo.addAction(self.accion_imprimir_nota)
        menu_archivo.addAction(self.accion_limpiar_nota)
        menu_archivo.addAction(self.salir)

        menu_info = barra_menus.addMenu("Ayuda")
        menu_info.addAction(self.acerca_de)

        pass

    def crear_toolbar(self):
        # TODO: crear barra de herramientas y aÃ±adir las acciones bÃ¡sicas
        toolbar = QToolBar()
        toolbar.addAction(self.accion_limpiar_nota)
        toolbar.addAction(self.accion_imprimir_nota)
        self.addToolBar(toolbar)
        pass

    def crear_statusbar(self):
        # TODO: crear barra de estado y mostrar un mensaje inicial
        self.barra_estado = QStatusBar()
        self.setStatusBar(self.barra_estado)
        self.barra_estado.showMessage("Bienvenido a tu bloc de notas!!",3000)
        pass

    # =========================
    # SEÑALES
    # =========================
    def conectar_senales(self):
        # TODO conectar seÃ±ales como textChanged, currentTextChanged, toggled...
        
        self.combo_categoria.currentTextChanged.connect(self.slot_categoria_cambiada)

        self.line_edit_titulo.textChanged.connect(self.slot_titulo_cambiado)

        self.radio_prioridad_normal.clicked.connect(self.slot_prioridad_cambiada)
        self.radio_prioridad_alta.clicked.connect(self.slot_prioridad_cambiada)

        self.accion_imprimir_nota.triggered.connect(self.slot_imprimir_nota)
        
        pass

    # =========================
    # FUNCIONES DE UTILIDAD
    # =========================
    def obtener_prioridad_actual(self):
        # TODO devolver prioridad actual
        prioridad = ""

        if self.radio_prioridad_normal.isChecked():
            prioridad = "Normal"

        else:
            prioridad = "Alta"

        return prioridad    

    def limpiar_contenido_nota(self):
        self.texto_nota.clear()
        pass

    def imprimir_en_consola(self):
        # TODO imprimir la nota completa usando print con comas

        print(' ======================================\n',
              'NOTA ACTUAL\n',
              '======================================\n',
              'Título: ',self.line_edit_titulo.text(),'\n',
              'Categoría: ',self.combo_categoria.itemText(self.combo_categoria.currentIndex()),'\n',
              'Prioridad: ',self.obtener_prioridad_actual(),'\n',
              '--------------------------------------\n',
              'Contenido: \n',self.texto_nota.toPlainText(),'\n',
              '======================================'
              )

        pass

    # =========================
    # SLOTS (LOGICA)
    # =========================
    def slot_limpiar_nota(self):
        # TODO mostrar cuadro de confirmaciÃ³n y limpiar si aceptan
        
        boton = QMessageBox.question(self, "¿Desea borrar la nota?","Elija una opción",
                buttons = QMessageBox.Yes | QMessageBox.No)
        
        if boton == QMessageBox.Yes:
            self.texto_nota.clear()
        else:
            print("No se borra")

        pass

    def slot_imprimir_nota(self):

        self.texto_nota        

        pass

    def slot_salir(self):
        self.close()
        pass

    def slot_acerca_de(self):
        QMessageBox.information(self, "Mensaje de ayuda", "Mini Bloc de Notas")
        pass

    def slot_titulo_cambiado(self, nuevo_titulo):
        # TODO actualizar tÃ­tulo de la ventana y barra de estado
        self.setWindowTitle("Mini Bloc de Notas - "+nuevo_titulo)
        self.barra_estado.showMessage("Bienvenido a tu bloc de notas!!",3000)

        pass

    def slot_categoria_cambiada(self, nueva_categoria):
        print("Categoría: ", nueva_categoria)
        pass

    def slot_prioridad_cambiada(self, checked):
        # TODO reaccionar solo si checked es True

        if checked:

            prioridad = self.obtener_prioridad_actual()

            self.barra_estado.showMessage("Prioridad: "+ prioridad)

        pass


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()