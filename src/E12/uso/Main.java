package E12.uso;
import tda.*;
import imple.*;


public class Main {
		private static int suma = 0;
		
		public static int calcularSumaElementosImparesArbol(ABBTDA arbol){ //No se mide la complejidad por ser recursivo
			
			if (arbol.arbolVacio() == false) {
				int raiz = arbol.raiz();
				
				if (raiz % 2 != 0) {
					suma += raiz;
				}
				
				if (arbol.hijoDer() != null) {
					calcularSumaElementosImparesArbol(arbol.hijoDer());
				}
				
				if (arbol.hijoIzq() != null) {
					calcularSumaElementosImparesArbol(arbol.hijoIzq());
				}
									
			}
			
			return suma;			
		}
	
	
	public static void main(String[] args) {
		ABBTDA arbol = new ABB();
		int acumuladoImpar = 0;
		
		arbol.inicializarArbol();
		
		arbol.agregarElem(3);
		arbol.agregarElem(9);
		arbol.agregarElem(6);
		arbol.agregarElem(0);
		arbol.agregarElem(4);
		arbol.agregarElem(5);
		arbol.agregarElem(2);
		arbol.agregarElem(7);
		arbol.agregarElem(8);
		arbol.agregarElem(1);
		arbol.agregarElem(10);	
		
		if (arbol.arbolVacio() == false) {
			acumuladoImpar = calcularSumaElementosImparesArbol(arbol);
		}
		
		System.out.println(String.format("El total de la suma de los impares es: %d", acumuladoImpar));

	}

}
