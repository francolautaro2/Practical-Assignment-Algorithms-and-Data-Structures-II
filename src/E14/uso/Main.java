package E14.uso;

import imple.Conjunto;
import imple.Grafo;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class Main {
    public static void main(String[] args) {
        GrafoTDA g = new Grafo();
        g.inicializarGrafo();
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarArista(1, 2, 1);
        g.agregarArista(1, 3, 1);
        g.agregarArista(1, 4, 1);
        g.agregarArista(2, 5, 1);
        g.agregarArista(3, 5, 1);
        g.agregarArista(4, 5, 1);
        ConjuntoTDA puente = puente(g, 1, 5);
        while (!puente.conjuntoVacio()) {
            int p = puente.elegir();
            System.out.println(p);
            puente.sacar(p);
        }
    }

    // Se define un método que reciba un GrafoTDA y dos enteros que representen vértices, y devuelva un ConjuntoTDA con
    // todos los vértices puente entre los vértices recibidos por parámetro.
    // Se define que un vértice p es puente entre dos vértices o y d, si hay una arista que comienza en o y termina en p
    // y otra que comienza en p y termina en d.
    public static ConjuntoTDA puente(GrafoTDA g, int o, int d) { // Complejidad Exponencial
        ConjuntoTDA puente = new Conjunto();
        puente.inicializarConjunto();
        ConjuntoTDA vertices = g.vertices();

        // Verificar todos los posibles vértices p en el grafo
        while (!vertices.conjuntoVacio()) {
            int p = vertices.elegir();
            vertices.sacar(p);

            // Si p no es o ni d, verificar si p es puente entre o y d
            if (p != o && p != d && g.existeArista(o, p) && g.existeArista(p, d)) {
                puente.agregar(p);
            }
        }
        return puente;
    }
}
