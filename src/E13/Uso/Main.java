package E13.Uso;

import tda.ABBTDA;
import imple.ABB;

public class Main {
	
	private static int cantidad = 0;
	
	public static void main(String[] args) {
		ABB arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregarElem(10);
		arbol.agregarElem(5);
		arbol.agregarElem(15);
		arbol.agregarElem(2);
		arbol.agregarElem(7);
		arbol.agregarElem(12);
		arbol.agregarElem(20);
		
		System.out.println(cantidadHojasPares(arbol));
	}
	
	public static int cantidadHojasPares(ABBTDA arbol) {
		if (arbol.arbolVacio()) {
			return 0;
		}
		
		if (arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio()) {
			if (arbol.raiz() % 2 == 0) {
		    		return 1;
			} else {
		   		return 0;
			}
	    	}
		
		int cantidadHojasParesDer = cantidadHojasPares(arbol.hijoDer());
		int cantidadHojasParesIzq = cantidadHojasPares(arbol.hijoIzq());
		
		return cantidadHojasParesDer + cantidadHojasParesIzq;
		
	}

	
}
