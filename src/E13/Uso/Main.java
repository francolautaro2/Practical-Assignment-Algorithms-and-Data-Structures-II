package E13.Uso;

import tda.ABBTDA;
import imple.ABB;

public class Main {
		
	public static void main(String[] args) {
		ABB arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregarElem(10);
		arbol.agregarElem(5);
		arbol.agregarElem(15);
		arbol.agregarElem(2);
		arbol.agregarElem(800);
		
		
		System.out.println(cantidadHojasPares(arbol));
	}
	
	public static int cantidadHojasPares(ABBTDA arbol) {
		if (arbol.arbolVacio()) {
			return 0;
		}
		
<<<<<<< HEAD
		if (arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio()) { // si es hoja
	        if (arbol.raiz() % 2 == 0) {
	            return 1;
	        } else {
	            return 0;
	        }
	    }
=======
		if (arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio()) {
			if (arbol.raiz() % 2 == 0) {
		    		return 1;
			} else {
		   		return 0;
			}
	    	}
>>>>>>> dc4236b53164728f1aba31d51872f6aebb1d3b1a
		
		int cantidadHojasParesDer = cantidadHojasPares(arbol.hijoDer());
		int cantidadHojasParesIzq = cantidadHojasPares(arbol.hijoIzq());
		
		return cantidadHojasParesDer + cantidadHojasParesIzq;
		
	}

	
}
