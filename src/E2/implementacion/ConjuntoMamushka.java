package E2.implementacion;

import E2.interfaces.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
	private int[] elementos;
	private int indice;
	@Override
	public void inicializar() { // Complejidad Constante
		elementos = new int[10];
		indice = 0;
	}

	@Override
	public void guardar(int dato) { // Complejidad Constante
		elementos[indice] = dato;
		indice++;
	}

	@Override
	public void sacar(int dato) { // Complejidad Lineal
		for (int i = indice - 1; i >= 0; i--) {
			if (elementos[i] == dato) {
				elementos[i] = elementos[indice - 1];
				indice--;
				return;
			}
		}
	}

	@Override
	public int elegir() {
		return elementos[(int) (Math.random() * indice)];
	}

	@Override
	public int perteneceCant(int dato) { // Complejidad Lineal
		int cant = 0;
		for (int i = 0; i < indice; i++) {
			if (elementos[i] == dato)
				cant++;
		}
		return cant;
	}

	@Override
	public boolean estaVacio() { // Complejidad Constante
		return indice == 0;
	}

	public void p() {// Complejidad Lineal
		for (int i = 0; i < indice; i++) {
			System.out.println(elementos[i]);
		}
	}
}
