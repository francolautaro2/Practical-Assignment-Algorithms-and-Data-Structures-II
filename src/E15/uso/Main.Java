package E15.uso;

import imple.*;
import tda.*;

public class Main {

	public static int gradoVertice(GrafoTDA grafo, int vertice) {
	    int gradoSalida = 0;
	    int gradoEntrada = 0;
	    
	    // Cuenta la cantidad de aristas que salen del vertice
	    ConjuntoTDA vertices = grafo.vertices();
	    vertices.inicializarConjunto();
	    vertices.agregar(vertice);
	    while (!vertices.conjuntoVacio()) {
	        int v = vertices.elegir();
	        vertices.sacar(v);
	        if (grafo.existeArista(vertice, v)) {
	            gradoSalida++;
	        }
	    }
	    
	    // Cuenta las aristas que llegan al vertice 
	    vertices = grafo.vertices();
	    vertices.inicializarConjunto();
	    while (!vertices.conjuntoVacio()) {
	        int v = vertices.elegir();
	        vertices.sacar(v);
	        if (grafo.existeArista(v, vertice)) {
	            gradoEntrada++;
	        }
	    }
	    
	    return gradoSalida - gradoEntrada;
	}
	
	public static void main(String[] args) {
	    GrafoTDA grafo = new Grafo();
	    grafo.inicializarGrafo();
	    grafo.agregarVertice(1);
	    grafo.agregarVertice(2);
	    grafo.agregarVertice(3);
	    grafo.agregarArista(1, 2, 10);
	    grafo.agregarArista(2, 3, 20);
	    grafo.agregarArista(3, 1, 30);
	    grafo.agregarArista(3, 2, 40);

	    int grado = gradoVertice(grafo, 2);
	    System.out.println("Grado del vértice 2: " + grado);
	}


}
