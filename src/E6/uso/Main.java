package E6.uso;
import tda.*;
import imple.*;

public class Main {
	
	public static float porcentajeElementosParesPila(PilaTDA pilaOriginal) { //Lineal
		PilaTDA pilaAuxiliar = new Pila();
		
		int cantidadElementos = 0;
		int cantidadElementosPares = 0;
		float porcentaje = 0;
		
		pilaAuxiliar.inicializarPila();
		
		while(pilaOriginal.pilaVacia() == false) {
			
			int elemento = pilaOriginal.tope();
			cantidadElementos ++;
			
			if (elemento % 2 == 0) {
				cantidadElementosPares ++;
			}
			
			pilaAuxiliar.apilar(elemento);
			pilaOriginal.desapilar();
		}
		
		while(pilaAuxiliar.pilaVacia() == false) {
			int elemento = pilaAuxiliar.tope();
			
			pilaOriginal.apilar(elemento);
			pilaAuxiliar.desapilar();		
			
		}
		
		if (pilaOriginal.pilaVacia() == false) {
			porcentaje = ((cantidadElementosPares * 100) / cantidadElementos);
		}
		
		return porcentaje;	
		
	}
	
	

	public static void main(String[] args) {
		PilaTDA pila = new Pila();
		
		pila.inicializarPila();
		
		pila.apilar(0);
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(5);
		pila.apilar(6);

		
		float porcentaje = porcentajeElementosParesPila(pila);
		
		System.out.println(String.format("El porcentaje de pares de la pila es: %f", porcentaje));
		
	}

}
