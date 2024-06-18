package E8.uso;

import imple.Cola;
import imple.Conjunto;
import tda.ColaTDA;
import tda.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        ColaTDA c = new Cola();
        c.inicializarCola();
        c.acolar(1);
        c.acolar(2);
        c.acolar(3);
        c.acolar(4);
        c.acolar(2);
        c.acolar(2);
        c.acolar(2);
        c.acolar(8);
        c.acolar(9);
        c.acolar(10);
        c.acolar(10);
        c.acolar(10);
        c.acolar(10);
        c.acolar(14);
        c.acolar(15);

        ColaTDA sinRepetidos = sinRepetidos(c);
        while (!sinRepetidos.colaVacia()) {
            System.out.println(sinRepetidos.primero());
            sinRepetidos.desacolar();
        }
    }

    public static ColaTDA sinRepetidos(ColaTDA c) { // Complejidad Exponencial
        ConjuntoTDA temp = new Conjunto();
        temp.inicializarConjunto();
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();
        while (!c.colaVacia()) {
            int dato = c.primero();
            c.desacolar();
            if (!temp.pertenece(dato)) {
                temp.agregar(dato);
                resultado.acolar(dato);
            }
        }
        return resultado;
    }
}
