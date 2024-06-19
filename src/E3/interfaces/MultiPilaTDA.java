package E3.interfaces;

import tda.PilaTDA;

public interface MultiPilaTDA {
	public void apilar(PilaTDA valores);
	public void desapilar(PilaTDA valores);
	public PilaTDA tope(int cantidad);
	public void inicializarMultiPila();
	public boolean pilaVacia();
}
