import pandas as pd
import datapane as dp

fichero_csv = "TEMA 4/DI_U05_A02_PP_E_01.csv"
df = pd.read_csv(fichero_csv)

imagen = dp.Media(file='TEMA 4/DI_U05_A02_PP_E_02.jpg')

titulo = dp.HTML(
    '<p style="font-size:30px; text-align:center; color:#ffffff; background-color:#4d4d4d;">Informe de ventas</p>'
)


# aqui ponemos las operaciones para hacer el resumen ejecutivo 

ventas_totales = df['Ventas'].sum()
ventas_por_anio = df.groupby('Año')['Ventas'].sum()
mejor_anio = ventas_por_anio.idxmax()
valor_mejor_anio = ventas_por_anio.max()


unidades = dp.BigNumber(
    heading='Ventas totales y año con mayor ventas',
    value=ventas_totales,
)

unidades2 = dp.BigNumber(
    heading='Año con mayores ventas',
    value=mejor_anio
)

resumen_ejecutivo = dp.Text("**La dirección necesita un balance sobre las ventas durante varios años"
"para poder entender la situación en la que se encuentran en ese momento y poder saber si deben realizar cambios "
"en la empresa o su forma de actuar**")

anio_21 = df[df['Año'] == 2021]
ventas_21 = anio_21['Ventas'].sum()

anio_20 = df[df['Año'] == 2020]
ventas_20 = anio_20['Ventas'].sum()


comparacion_ventas = dp.BigNumber(
    heading='Comparación ventas 2021-2020',
    value=ventas_21,
    change=ventas_21 - ventas_20,
    is_upward_change=ventas_21 > ventas_20
)

table = dp.Table(df)
data_table = dp.DataTable(df)

report = dp.Report(table, data_table)
report.save(path="DI_U05_A02_PP_E_01_tabla.html", open=True)

texto = dp.Text("**Aquí puedes descargar el fichero con todos los datos del informe**")

descarga = dp.Attachment(file='TEMA 4/DI_U05_A02_02.csv')

report = dp.Report(
    imagen,
    titulo,
    unidades,
    unidades2,
    resumen_ejecutivo,
    comparacion_ventas,
    texto,
    descarga
)

report.save(path='DI_U05_A02_PP_E_01.html', open=True)