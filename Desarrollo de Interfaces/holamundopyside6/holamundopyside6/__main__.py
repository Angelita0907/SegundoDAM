from datetime import datetime

def main():
    hora_actual = datetime.now().strftime("%H:%M:%S")
    print("=" * 50)
    print("🎉 ¡HOLA MUNDO DESDE PyPI! 🎉")
    print("=" * 50)
    print("Hora de ejecución: " + hora_actual)
    print("Paquete creado por: Ángela")
    print("=" * 50)

if __name__ == "__main__":
    main()