package E2.uso;

import E2.implementacion.ConjuntoMamushka;

public class Main {
	public static void main(String[] args) {
		ConjuntoMamushka c = new ConjuntoMamushka();
		c.inicializar();
		c.guardar(1);
		c.guardar(2);
		c.guardar(4);
		c.guardar(1);
		c.guardar(4);
		c.guardar(5);
		c.sacar(1);
		c.p();
		System.out.println("El numero 4 se encuentra " + c.perteneceCant(4) + " veces en el conjunto.");
	}
}
