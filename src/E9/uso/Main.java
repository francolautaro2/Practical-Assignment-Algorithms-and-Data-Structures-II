package E9.uso;

import imple.*;
import tda.*;

public class Main {

    public static ConjuntoTDA elementosComunes(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conj = new Conjunto();
        conj.inicializarConjunto();
        ConjuntoTDA conjComun = new Conjunto();
        conjComun.inicializarConjunto();
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        
        while (!pila.pilaVacia()) {
            conj.agregar(pila.tope());
            pilaAux.apilar(pila.tope());
            pila.desapilar();
        }
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        while (!cola.colaVacia()) {
            if (conj.pertenece(cola.primero())) {
                conjComun.agregar(cola.primero());
            }
            colaAux.acolar(cola.primero());
            cola.desacolar();
        }
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        return conjComun;
    }

    public static void main(String[] args) {

        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(5);
        pila.apilar(3);
        pila.apilar(20);

        ColaTDA cola = new Cola();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(5);
        cola.acolar(10);
        cola.acolar(25);

        ConjuntoTDA conjuntoElementosComunes = elementosComunes(pila, cola);

        while (!conjuntoElementosComunes.conjuntoVacio()) {
            int elemento = conjuntoElementosComunes.elegir();
            System.out.println(elemento);
            conjuntoElementosComunes.sacar(elemento);
        }
    }

}
