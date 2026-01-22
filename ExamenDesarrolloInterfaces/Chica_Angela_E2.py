import matplotlib.pyplot as plt
import pandas as pd
import datapane as dp

# Ejercicio 2

# leemos el fichero csv
df = pd.read_csv("uso_servicios_municipales.csv")

titulo = dp.HTML("<h1>Resumen Ejecutivo - Uso de servicios municipales</h1>")

texto = dp.Text("Esta comparativa es necesaria para el ayuntamiento ya que con ello pueden saber la satisfacción de los ciudadanos, como poder mejorar o incluso si hay quejas y poder solucionarlo antes de tiempo o simplemente si es necesario mantenimiento")

usos_totales = df["numero_usos"].sum()

usos_acumulados = dp.BigNumber(
    heading="Total de usos acumulados",
    value=usos_totales
)

# he usado 2022 y 2023 ya que son los dos ultimos que tenemos
anio_2022 = df[df['anio'] == 2022]
anio_2023 = df[df['anio'] == 2023]

usos_2023 = anio_2023['numero_usos'].sum()
usos_2022 = anio_2022['numero_usos'].sum()

comparacion = dp.BigNumber(
    heading="Diferencia de usos en los 2 últimos años (2023 - 2022)",
    value=usos_2023,
    change= usos_2023 - usos_2022,
    is_upward_change= usos_2023 < usos_2022
)

report = dp.Report(titulo, texto, usos_acumulados, comparacion)
report.save(path="Chica_Angela_E2_resumen.html", open=True)