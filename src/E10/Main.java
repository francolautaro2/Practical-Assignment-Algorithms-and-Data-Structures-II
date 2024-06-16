package E10;

import tda.*;
import imple.*;

public class Main {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(3);
        pila.apilar(4);
        pila.apilar(8);
        pila.apilar(3);
        pila.apilar(3);
        pila.apilar(3);
        pila.apilar(8);

        DiccionarioSimpleTDA d = pilaToClave(pila);
        ConjuntoTDA claves = d.claves();
        while(!claves.conjuntoVacio()) {
        	int clave = claves.elegir();
        	System.out.println(clave + " " + d.recuperar(clave));
        	claves.sacar(clave);
        }
    }

    public static DiccionarioSimpleTDA pilaToClave(PilaTDA pila) {
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        DiccionarioSimpleTDA pilaToDic = new DiccionarioSimple();
        pilaToDic.inicializarDiccionario();
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        	
        int counter = 0;
        
        while(!pila.pilaVacia()) {
        	int valor = pila.tope();
        	claves.agregar(valor);
        	pilaToDic.agregar(valor, counter);
        	pilaAux.apilar(valor);
        	pila.desapilar();
        }
        
        while(!pilaAux.pilaVacia()) {
        	int valor = pilaAux.tope();
        	if (claves.pertenece(valor)) {
        		int elemento = pilaToDic.recuperar(valor);
        		elemento += 1;
        		pilaToDic.agregar(valor, elemento);
        	}
        	pilaAux.desapilar();
        }
       

        return pilaToDic;

    }
}
