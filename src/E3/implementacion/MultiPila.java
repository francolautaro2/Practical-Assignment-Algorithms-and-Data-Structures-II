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
	/** Inserta la pila recibida en el tope de la multipila.
	* Si la multipila actualmente es: (tope) 3 - 5 - 7
	* Y la pila que se recibe es: (tope) 1 - 9
	* La multipila debe quedar: (tope) 1 - 9 - 3 - 5 - 7
	*/
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
	/** Desapila la pila recibida por parámetro de la multipila,
	* solo si el tope de la multipila coincide con la pila recibida.
	* Si la multipila actualmente es: (tope) 7 - 2 - 8 - 9
	* Y la pila que se recibe es: (tope) 7 - 2
	* La multipila debe quedar: (tope) 8 - 9
	* Si en cambio la pila que se recibe es: (tope) 7 - 2 - 3
	* No deben realizarse cambios en la multipila,
	* dado que no coincide con la pila recibida.
	*/
	public void desapilar(PilaTDA valores) { // Complejidad: Lineal
		if (valores.pilaVacia() || this.pilaVacia()) {
            return;
        }
		
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
	/** Devuelve una pila con los valores que estén en el tope de la multipila.
	* La cantidad de valores a devolver se define por parámetro y debe
	* preservarse el orden.
	* Si la cantidad es mayor al tamaño actual de la multipila,
	* se devuelven todos los valores de la multipila.
	* Si la multipila actualmente es: (tope) 4 - 2 - 9 - 7
	* Y se recibe por parámetro un 2, debe devolverse la pila: (tope) 4 - 2
	* Si se recibe por parámetro un 5, debe devolverse la pila: (tope) 4 - 2 - 9 - 7
	*/
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
	/** Inicializa la pila */
	public void inicializarMultiPila() { //Complejidad: Constante
		tamanio = 0;
		primero = null;
	}
	/** Devuelve un booleano que indica si la pila está vacía */
	public boolean pilaVacia() { // Complejidad: Constante
		return (primero == null);
	}
}
