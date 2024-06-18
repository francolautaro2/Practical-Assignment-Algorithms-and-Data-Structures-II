package E12.uso;
import tda.*;
import imple.*;


public class Main {
		

		public static int devolverElementosSubarbol(ABBTDA arbol){
				int elemento = arbol.raiz();
				return elemento;
		}
		
		public static int calcularSumaElementosImparesArbol(ABBTDA arbolOriginal){
			ABBTDA arbolAuxDer = new ABB();
			arbolAuxDer.inicializarArbol();
			arbolAuxDer = arbolOriginal.hijoDer();
			
			ABBTDA arbolAuxIzq = new ABB();
			arbolAuxIzq.inicializarArbol();
			arbolAuxIzq = arbolOriginal.hijoIzq();
			
			int suma = 0;
			
			int primeraRaiz = arbolOriginal.raiz();
			
			if (primeraRaiz % 2 != 0){
				suma += primeraRaiz;
			}
			
			while (arbolAuxDer.arbolVacio() == false){
				int elemento = devolverElementosSubarbol(arbolAuxDer);
				if (elemento % 2 != 0) {
					suma += elemento;
				}
				arbolAuxDer = arbolAuxDer.hijoDer();
			}
			
			while (arbolAuxIzq.arbolVacio() == false){
				int elemento = devolverElementosSubarbol(arbolAuxIzq);
				if (elemento % 2 != 0) {
					suma += elemento;
				}
				arbolAuxIzq = arbolAuxIzq.hijoIzq();				
			}
			
			return suma;
			
		}
	
	
	public static void main(String[] args) {
		ABBTDA arbol = new ABB();
		int acumuladoImpar = 0;
		
		arbol.inicializarArbol();
		
		arbol.agregarElem(0);
		arbol.agregarElem(1);
		arbol.agregarElem(2);
		arbol.agregarElem(3);
		arbol.agregarElem(4);
		arbol.agregarElem(5);
		arbol.agregarElem(6);
		arbol.agregarElem(7);
		arbol.agregarElem(8);
		arbol.agregarElem(9);
		arbol.agregarElem(10);	
		
		if (arbol.arbolVacio() == false) {
			acumuladoImpar = calcularSumaElementosImparesArbol(arbol);
		}
		
		System.out.println(String.format("El total de la suma de los impares es: %d", acumuladoImpar));

	}

}
