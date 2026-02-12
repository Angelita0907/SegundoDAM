# Ángela Chica Montero
import pytest
from cartera import Cartera

    
    # Tests del Constructor
'''
def test_saldo_inicial_defecto():
        """Comprueba que si creas una cartera sin indicar saldo, el saldo inicial es 0"""
        cartera = Cartera()
        assert cartera.saldo == 0
    
def test_tipo_incorrecto():
        """Comprueba que si pasas un tipo incorrecto (texto), el saldo se queda en 0"""
        cartera = Cartera("texto")
        assert cartera.saldo == 0
    
def test_saldo_negativo():
        """Comprueba que si pasas un saldo negativo, el saldo se pone en 0"""
        cartera = Cartera(-100)
        assert cartera.saldo == 0
    
def test_saldo_inicial():
        """Comprueba que si pasas un entero positivo, el saldo inicial se asigna correctamente"""
        cartera = Cartera(500)
        assert cartera.saldo == 500
    

    # Tests del método ingresar(cantidad)
    
def test_ingresar_dinero_suma():
        """Comprueba que al ingresar dinero, el método devuelve el nuevo saldo y actualiza el saldo interno"""
        cartera = Cartera(100)
        nuevo_saldo = cartera.ingresar(50)
        
        # mira si devuelve bien el dinero
        assert nuevo_saldo == 150
        # luego comprueba si se actualiza
        assert cartera.saldo == 150

'''   
    # Tests del método gastar()
    
def test_gastar_dinero_resta():
        """Comprueba que al gastar dinero, el método devuelve el nuevo saldo y actualiza el saldo interno"""
        cartera = Cartera(200)
        nuevo_saldo = cartera.gastar(75)
        
        # lo mismo que el otro pero si lo resta bien
        assert nuevo_saldo == 125
        assert cartera.saldo == 125
    
def test_gastar_mas_del_saldo():
        """Comprueba que si se intenta gastar más dinero del que hay, devuelve None y el saldo no cambia"""
        cartera = Cartera(100)
        resultado = cartera.gastar(150)
        
        assert resultado
        # mira que al no estar bien no cambie el saldo
        assert cartera.saldo == 100
