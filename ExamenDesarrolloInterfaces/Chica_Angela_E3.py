import matplotlib.pyplot as plt
import pandas as pd
import datapane as dp

# Ejercicio 3

# leemos el fichero csv
df = pd.read_csv("uso_servicios_municipales.csv")

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

report = dp.Report(titulo1,grafico_sectores, titulo2,grafico_lineas, titulo3,grafico_barras)
report.save(path="Chica_Angela_E3_graficos.html", open=True)