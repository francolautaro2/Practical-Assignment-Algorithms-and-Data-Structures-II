package E7.uso;

import imple.*;
import tda.*;


public class Main {

	public static void main(String[] args) {
		PilaTDA pila = new Pila();
		pila.inicializarPila();
		pila.apilar(1);
		pila.apilar(3);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(2);
		pila.apilar(4);
		pila.apilar(2);
		System.out.println("Elementos repetidos:");
		
		ConjuntoTDA conjunto = pilaRepetidos(pila);
		while (!conjunto.conjuntoVacio()) {
			int valor = conjunto.elegir();
			System.out.println(valor);
			conjunto.sacar(valor);
		}
	}
	
	public static ConjuntoTDA pilaRepetidos(PilaTDA pila) {
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		PilaTDA aux2 = new Pila();
		aux2.inicializarPila();
		PilaTDA pila2 = new Pila();
		pila2.inicializarPila();
		ConjuntoTDA conj = new Conjunto();
		conj.inicializarConjunto();
		int valor=0;
		while (!pila.pilaVacia()) {
			valor=pila.tope();
			aux.apilar(valor);
			aux2.apilar(valor);
			pila.desapilar();
		}
		
		while (!aux.pilaVacia()) {
			valor = aux.tope();
			aux2.desapilar();
			while (!aux2.pilaVacia()) {
				pila2.apilar(aux2.tope());
				aux2.desapilar();
				if (valor==pila2.tope()) {
					conj.agregar(valor);
				}
			}
			while (!pila2.pilaVacia()) {
				aux2.apilar(pila2.tope());
				pila2.desapilar();
			}
			pila.apilar(valor);
			aux.desapilar();
		}
		return conj;
	}
	
	public static void imprimirPila(PilaTDA pila) {
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		int valor=0;
		while (!pila.pilaVacia()) {
			valor=pila.tope();
			aux.apilar(valor);
			pila.desapilar();
		}
		while (!aux.pilaVacia()) {
			valor = aux.tope();
			pila.apilar(valor);
			System.out.println(valor +" ");
			aux.desapilar();
		}
	}

}
