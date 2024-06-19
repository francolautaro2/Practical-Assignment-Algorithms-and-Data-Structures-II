package E3.uso;

import tda.PilaTDA;
import imple.Pila;
import E3.interfaces.MultiPilaTDA;
import E3.implementacion.MultiPila;

public class Main {
	public static void main(String[] args) {
		PilaTDA pilaNormal = new Pila();
		pilaNormal.inicializarPila();
		pilaNormal.apilar(3);
		pilaNormal.apilar(4);
		
		PilaTDA valores = new Pila();
		valores.inicializarPila();
		valores.apilar(34);
		valores.apilar(344);
		valores.apilar(89);
		
		
		MultiPilaTDA multiPila = new MultiPila();
		multiPila.inicializarMultiPila();
		multiPila.apilar(pilaNormal);
		multiPila.apilar(valores);
		
		PilaTDA pilaTope = multiPila.tope(4);
		while(!pilaTope.pilaVacia()) {
			System.out.println(pilaTope.tope());
			pilaTope.desapilar();
		}
		
	}
}
