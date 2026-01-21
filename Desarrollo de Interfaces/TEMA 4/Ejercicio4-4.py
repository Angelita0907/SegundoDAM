import matplotlib.pyplot as plt
import pandas as pd
import datapane as dp

df = pd.read_csv("TEMA 4/DI_U05_A02_PP_E_01.csv")

# Gráfico de sectores
ventas_totales = df.groupby("Tipo de producto")["Ventas"].sum()

ventas_totales.plot.pie(
    y="Ventas Totales",
    legend=False,
    ylabel=""
)

grafico_sectores = dp.Plot(plt.gcf())  # Obtener la figura actual
plt.close()  # Cerrar la figura

# Gráfico Líneas - Últimos 2 años (2020 y 2021)
anio_20 = df[df['Año'] == 2020]
ventas_20 = anio_20['Ventas'].sum()

anio_21 = df[df['Año'] == 2021]
ventas_21 = anio_21['Ventas'].sum()

# resultados
ventas_anio = pd.DataFrame({
    'Año': [2020, 2021],
    'Ventas': [ventas_20, ventas_21]
})

# Establecer el índice para el gráfico
ventas_anio.plot(y="Ventas", marker='o')

grafico_lineas = dp.Plot(plt.gcf())  # Obtener la figura actual
plt.close()  # Cerrar la figura

# Gráfico barras
ventas_pais = df.groupby("Región")["Ventas"].sum()

ventas_pais.plot.bar(y="Importe (€)")

grafico_barras = dp.Plot(plt.gcf())  # Obtener la figura actual
plt.close()  # Cerrar la figura

# creamos la tabla dinámica
table = dp.Table(df)
data_table = dp.DataTable(df)

# Creamos el informe con los gráficos
'''
Informe organizado por grupos
reporte = dp.Report(
    dp.Text("# Informe de Ventas con Gráficos"),
    dp.Group(
        grafico_sectores,grafico_lineas,grafico_barras, data_table,
        columns=2)
        )
'''
'''
informe organizado por Páginas
reporte = dp.Report(
    dp.Page(
        title="Página 1",
        blocks= [grafico_sectores]
        ),
    dp.Page(
        title="Página 2",
        blocks= [grafico_barras]
        ),
    dp.Page(
        title="Página 3",
        blocks= [grafico_lineas]
        ),
    dp.Page(
        title="Página 4",
        blocks= [data_table]
        )
)
'''
reporte = dp.Report(
    dp.Text("# Informe de Ventas con Gráficos"),
    dp.Select(
        blocks=[grafico_sectores,grafico_barras, data_table]
    )
)

# Lo guardamos y abrimos
reporte.save("informePorSectores.html", open=True)