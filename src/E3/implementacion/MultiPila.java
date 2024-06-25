package E3.implementacion;

import tda.PilaTDA;
import imple.Pila;
import E3.interfaces.MultiPilaTDA;

public class MultiPila implements MultiPilaTDA {
    private class Nodo {
	int info;
	Nodo sig;
    }
    private Nodo primero;
    private int tamanio;
	
    public void apilar(PilaTDA valores) {
	if (valores.pilaVacia()) {
            return;
        }
        
        int x = valores.tope();
        valores.desapilar();
        
        apilar(valores); // recursividad para apilar los valores dados
        
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = primero;
        primero = nuevo;
        tamanio++;
        
        valores.apilar(x);
    }

    public void desapilar(PilaTDA valores) { // Complejidad: Lineal
		
	Nodo actual = primero;
        PilaTDA temp = new Pila();
        temp.inicializarPila();
        
        while (actual != null && !valores.pilaVacia() && actual.info == valores.tope()) {
            temp.apilar(actual.info);
            valores.desapilar();
            actual = actual.sig;
        }
        
        if (valores.pilaVacia()) {
            // Saca los elementos de la pila multiple
            while (!temp.pilaVacia()) {
                primero = primero.sig;
                tamanio--;
                temp.desapilar();
            }
        }
		// Vuelve a construir la pila original
        while (!temp.pilaVacia()) {
            valores.apilar(temp.tope());
            temp.desapilar();
        }
    }

    public PilaTDA tope(int cantidad) { // Complejidad: Lineal
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        PilaTDA temp = new Pila();
        temp.inicializarPila();
        
        Nodo actual = primero;
        int elementosAIncluir = Math.min(cantidad, this.tamanio); // Cuantos elementos se van a incluir en la nueva pila
        
        for (int j = 0; j < elementosAIncluir; j++) {
            if (actual != null) {
                temp.apilar(actual.info);
                actual = actual.sig;
            }
        }
        
        // se mantiene el orden original
        while (!temp.pilaVacia()) {
            pilaAux.apilar(temp.tope());
            temp.desapilar();
        }
        
        return pilaAux;
    }

	
    public void inicializarMultiPila() { //Complejidad: Constante
	tamanio = 0;
	primero = null;
    }

	
    public boolean pilaVacia() { // Complejidad: Constante
	return (primero == null);
    }
}
