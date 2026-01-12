# Ángela Chica Montero 

import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QDialog, QWidget,QComboBox, QRadioButton, QFormLayout, QToolBar, QStatusBar, QMessageBox, QLineEdit, QTextEdit, QVBoxLayout, QHBoxLayout, QCheckBox, QDockWidget,QLabel
from PySide6.QtGui import QAction, QKeySequence
from PySide6.QtCore import Qt, QSize
# Importar lo necesario


# ===================================================================
#                            LOGIN
# ===================================================================
class DialogoLogin(QDialog):
    def __init__(self, parent=None):
        super().__init__(parent)

        self.setWindowTitle("Iniciar sesión")

        # TODO: Crear el diseño y los widgets del diálogo de login



# ===================================================================
#                        VENTANA PRINCIPAL
# ===================================================================
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Encuesta de satisfacción")
        self.setMinimumSize(800, 600)

        # TODO: declarar variables necesarias

        # esto es para el panel de notas
        self.dock = None

        # variables pestaña persona
        self.nombre = None
        self.telefono = None
        self.compania = None
        self.satisfaccion_global = None

        # variables pestaña opinion
        self.calidad = None
        self.velocidad = None
        self.atencion_cliente = None
        self.calidad_precio = None
        self.recomendacion = None
        self.recomendacionSi= None
        self.recomendacionNo = None

        # casillas de verificacion
        #self.titulo = None
        self.check1 = None
        self.check2 = None
        self.check3 = None
        self.check4 = None

        self.crear_central()
        self.crear_acciones()
        self.crear_menus()
        self.crear_toolbar()
        self.crear_statusbar()
        self.crear_dock_notas()
        self.conectar_senales()

    # ---------------------------------------------------------------
    def crear_central(self):
        # TODO: Crear las pestañas, formularios y widgets

        widget_central = QWidget()

       # para hacer las otras dos ventanas e con stacked laypit pero no me ha dado tiempo de hacerlo :(

        self.nombre = QLineEdit()
        self.nombre.setPlaceholderText("Inicia sesión para rellenar el nombre")
        self.telefono = QLineEdit()
        self.telefono.setPlaceholderText("Número de teléfono")

        self.compania = QComboBox()
        # añadimos lo que contiene
        self.compania.addItems(["MovisTar","Orange", "O2", "Avantel"])
        
        self.satisfaccion_global = QComboBox()
        # añadimos lo que contiene
        self.satisfaccion_global.addItems(["Muy baja", "Baja", "Media","Buena", "Muy Buena", "Exelente"])

        # panel de notas
        self.dock = QDockWidget("Notas Internas", self)
        #self.notas = QTextEdit()
        self.dock.setWidget(QTextEdit(""))
        self.addDockWidget(Qt.BottomDockWidgetArea, self.dock)
        # para que sea flontante
        self.dock.setFeatures(QDockWidget.DockWidgetClosable | QDockWidget.DockWidgetFloatable)

        # ahora para la otra pestaña
        self.calidad = QComboBox()
        self.calidad.addItems(["Muy baja", "Baja", "Media","Buena", "Muy Buena", "Exelente"])

        self.velocidad = QComboBox()
        self.velocidad.addItems(["Muy lenta", "Lenta", "Normal","Rápida", "Muy Rápida", "Más rápida que la luz"])

        self.atencion_cliente = QComboBox()
        self.atencion_cliente.addItems(["Muy baja", "Baja", "Media","Buena", "Muy Buena", "Exelente"])

        self.calidad_precio = QComboBox()
        self.calidad_precio.addItems(["Muy caro", "caro", "Precio Medio","Barato", "Muy Barato"])

        self.titulo = QLabel()
        # poner los checkbox de cada opcion self.preferencias
        self.check1 = QCheckBox("Valoro más la cobertura que el precio")
        self.check2 = QCheckBox("Valoro más el precio que la velocidad")
        self.check3 = QCheckBox("Me interesan las ofertas y promociones")
        self.check4 = QCheckBox("Estoy pensando en cambiar de compañía")

        # ahora los dos botones
        self.recomendacion = QLabel()
        self.recomendacionSi = QRadioButton("Sí")
        self.recomendacionNo = QRadioButton("No")

        # creamos los layaout para meter cada cosa en su sitio
        
        layout_formulario1 = QFormLayout()
        layout_formulario1.addRow("Nombre: ", self.nombre)
        layout_formulario1.addRow("Teléfono: ", self.telefono)
        layout_formulario1.addRow("Compañía: ", self.compania)
        layout_formulario1.addRow("Satisfacción global: ", self.satisfaccion_global)

        # aquí ponemos otro formulario con las otras widgets de las otra ventana
        layout_formulario2 = QFormLayout()
        # hacemos el layout de preferencias
        preferencias = QVBoxLayout()
        #preferencias.addWidget(self.titulo)
        preferencias.addWidget(self.check1)
        preferencias.addWidget(self.check2)
        preferencias.addWidget(self.check3)
        preferencias.addWidget(self.check4)

         # layoout para los botones de la segunda pestaña
        layout_botones = QHBoxLayout()
        layout_botones.addWidget(self.recomendacionSi)
        layout_botones.addWidget(self.recomendacionNo)

        layout_formulario2.addRow("Calidad de la cobertura: ", self.calidad)
        layout_formulario2.addRow("Velocidad de datos: ", self.velocidad)
        layout_formulario2.addRow("Atención al cliente: ", self.atencion_cliente)
        layout_formulario2.addRow("Relación calidad-precio: ", self.calidad_precio)
        layout_formulario2.addRow("Prefencias del servicio: ", self.titulo)
        layout_formulario2.addRow("¿Recomendarías esta compañía a otra persona?",layout_botones)

        layout_principal = QVBoxLayout()
        layout_principal.addLayout(layout_formulario1)
        layout_principal.addLayout(layout_formulario2)
        layout_principal.addLayout(preferencias)

        widget_central.setLayout(layout_principal)

        self.setCentralWidget(widget_central)


    # ---------------------------------------------------------------
    def crear_dock_notas(self):
        # TODO: Crear el dock inferior con un área de texto

        # he realizado el dock desde fuera sin utilizar esta función, arriba esta declarado

        pass

    # ---------------------------------------------------------------
    def crear_acciones(self):
        # TODO: Crear las acciones del menú y la toolbar

        # creamos las acciones del menú
        self.iniciar_sesion = QAction("Iniciar Sesión", self)
        self.iniciar_sesion.triggered.connect(self.slot_login)

        self.nueva_encuesta = QAction("Nueva encuesta", self)
        self.nueva_encuesta.triggered.connect(self.slot_nueva_encuesta)

        self.resumen = QAction("Ver Resumen", self)
        self.resumen.setShortcut(QKeySequence("Ctrl+R"))
        self.resumen.triggered.connect(self.slot_ver_resumen)
        # separador
        # poner
        self.salir = QAction("Salir")
        self.salir.setShortcut(QKeySequence("Ctrl+Q"))
        self.salir.triggered.connect(self.slot_salir)

        # accion menú de ayuda
        self.acerca_de = QAction("Acerca de", self)
        self.acerca_de.triggered.connect(self.slot_acerca_de)

        pass

    # ---------------------------------------------------------------
    def crear_menus(self):
        # TODO: Crear los menús y añadir las acciones

        # menu principal
        barra_menus = self.menuBar()
        menu_prinicipal = barra_menus.addMenu("Encuesta")
        menu_ayuda = barra_menus.addMenu("Ayuda")
        
        # añadimos las acciones a los menus
        menu_prinicipal.addAction(self.iniciar_sesion)
        menu_prinicipal.addAction(self.nueva_encuesta)
        menu_prinicipal.addAction(self.resumen)
        menu_prinicipal.addAction(self.salir)

        menu_ayuda.addAction(self.acerca_de)

        pass

    # ---------------------------------------------------------------
    def crear_toolbar(self):
        # TODO: Crear la toolbar y añadir las acciones

        barra_herramientas = QToolBar()
        barra_herramientas.addAction(self.nueva_encuesta)
        barra_herramientas.addAction(self.resumen)
        self.addToolBar(barra_herramientas)


    # ---------------------------------------------------------------
    def crear_statusbar(self):
        # TODO: Crear la barra de estado

        self.barra_estado = QStatusBar()
        self.setStatusBar(self.barra_estado)
        #self.barra_estado.showMessage()

        pass

    def obtener_prioridad_actual(self):
        # TODO devolver prioridad actual
        recomendacion = ""

        if self.recomendacionSi.isChecked():
            recomendacion = "La persona recomienda la compañía"

        else:
            recomendacion = "La persona no recomienda la compañía"

        return recomendacion   

    # ---------------------------------------------------------------
    def conectar_senales(self):
        # TODO: Conectar señales a los distintos slots

        self.compania.currentTextChanged.connect(self.slot_compania_cambiada)
        self.satisfaccion_global.currentTextChanged.connect(self.slot_satisfaccion_cambiada)
        self.recomendacionSi.clicked.connect(self.slot_recomienda_cambiado)
        self.recomendacionNo.clicked.connect(self.slot_recomienda_cambiado)
        self.nombre.textChanged.connect(self.slot_nombre_cambiado)

        pass

    # ---------------------------------------------------------------
    def slot_login(self):
        # TODO: Implementar el proceso de login
        pass

    # ---------------------------------------------------------------
    def slot_nueva_encuesta(self):
        # TODO: Limpiar los datos tras confirmación

        boton = QMessageBox.question(self, "¿Desea limpiar el contenido?","Elija una opción",
                buttons = QMessageBox.Yes | QMessageBox.No)
        
        if boton == QMessageBox.Yes:
            # poner las varibles a limpiar y quitar lo otro
            self.nombre.clear()
            self.compania.clear()
            self.telefono.clear()
            self.satisfaccion_global.clear()
            self.recomendacion.clear()
        else:
            print("No se borra")

        pass

    # ---------------------------------------------------------------
    def slot_ver_resumen(self):
        # TODO: Mostrar un resumen de la encuesta

        resumen = "Nombre", self.nombre.text(), "\n", "Compañía: ", self.compania.itemText(self.compania.currentIndex()), "\n","Satisfacción Global: ", self.satisfaccion_global.itemText(self.satisfaccion_global.currentIndex()),"\n",self.slot_recomienda_cambiado

        QMessageBox().information(self, "Resumen de la encuesta", resumen)


        pass

    # ---------------------------------------------------------------
    def slot_salir(self):
        # TODO: Confirmar y cerrar la aplicación

        boton = QMessageBox.question(self, "Cerrar la encuesta?","Elija una opción",
                buttons = QMessageBox.Yes | QMessageBox.No)
        
        if boton == QMessageBox.Yes:
            # cerramos todas las ventanas
            self.close()
        else:
            print("No cerramos la app, aún")


    # ---------------------------------------------------------------
    def slot_acerca_de(self):
        # TODO: Mostrar información sobre la aplicación

        QMessageBox.information(self, "Mensaje de ayuda", "Aplicación de Encuestas\nExamen tema 2\n Desarrollo de Interfaces")


    # ---------------------------------------------------------------
    def slot_compania_cambiada(self, nueva):
        # TODO: Mensaje en la barra de estado
        if nueva:

            eleccion = self.compania.itemText(self.compania.setCurrentIndex())

            self.barra_estado.showMessage("Compañía: "+ eleccion)
        pass

    # ---------------------------------------------------------------
    def slot_satisfaccion_cambiada(self, nueva):
        # TODO: Mensaje en la barra de estado
        if nueva:

            eleccion = self.satisfaccion_global.itemText(self.satisfaccion_global.setCurrentIndex())

            self.barra_estado.showMessage("Satisfacción: "+ eleccion)
        pass

    # ---------------------------------------------------------------
    def slot_recomienda_cambiado(self, checked):
        # TODO: Mensaje en la barra de estado

        

        pass

    # ---------------------------------------------------------------
    def slot_nombre_cambiado(self, nuevo_nombre):
        # TODO: Actualizar el título de la ventana
        pass


# ===================================================================
#                       EJECUCIÓN DE LA APP
# ===================================================================
if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()

