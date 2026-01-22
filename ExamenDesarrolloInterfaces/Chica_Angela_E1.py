# Ángela Chica Montero
import pandas as pd
import datapane as dp

# Ejercicio 1 --> Crear data table

# leemos el fichero csv
df = pd.read_csv("uso_servicios_municipales.csv")
titulito = dp.HTML("<h1>Análisis de Datos</h1>")
table = dp.Table(df)
data_table = dp.DataTable(df)

texto = dp.Text("**Uso de Servicios Municipales**")

report = dp.Report(texto, table, data_table)
report.save(path="Chica_Angela_E1_tabla.html", open=True)