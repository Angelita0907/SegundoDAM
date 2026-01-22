import matplotlib.pyplot as plt
import pandas as pd
import datapane as dp

# Ejercicio 4

# leemos el fichero csv
df = pd.read_csv("uso_servicios_municipales.csv")

# Datos ejercicio 1
titulito = dp.HTML("<h1>Análisis de Datos</h1>")
table = dp.Table(df)
data_table = dp.DataTable(df)

# Datos ejercicio 2
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

# Datos Ejercicio 3
# grafico sectores(tarta)
titulo1 = dp.HTML("<h1>Gráfico por sectores según Servicio</h1>")
usos_servicio = df.groupby('servicio')["numero_usos"].sum()
sectores = usos_servicio.plot.pie(y="Sectores", legend= False, ylabel="")
grafico_sectores = dp.Plot(sectores)
plt.close()

# grafico lineas
titulo2 = dp.HTML("<h1>Gráfico de líneas según Año</h1>")
uso_anios = df.groupby('anio')["numero_usos"].sum()
lineas = uso_anios.plot(y="evolución por año")
grafico_lineas = dp.Plot(lineas)
plt.close()

# grafico barras
titulo3 = dp.HTML("<h1>Gráfico de barras según Distrito</h1>")
uso_distritos = df.groupby('distrito')["numero_usos"].sum()
barras = uso_distritos.plot.bar(y="usos por distrito")
grafico_barras = dp.Plot(barras)
plt.close()


report = dp.Report(
    dp.Page(
        title="Resumen", blocks=[titulo,texto,usos_acumulados, comparacion]),
    dp.Page(title="Análisis", blocks=[titulito,table, data_table]),
    dp.Page(
        title="Gráficos", blocks=[dp.Group(titulo1,grafico_sectores, titulo2,grafico_lineas, titulo3,grafico_barras, columns=2)]
    ),
    dp.Page(title="Selectores", blocks=[
        dp.Select(
            blocks=[data_table, grafico_sectores]
        )
        ])

)
report.save(path="Chica_Angela_E4_informe_organizado.html", open=True)