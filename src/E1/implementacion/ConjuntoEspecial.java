package E1.implementacion;

import E1.interfaces.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {
	private int[] conj;
	private int cant;
	private Respuesta resp;
	
	@Override
	public void inicializarConjunto() {

		conj = new int[100];
		cant = 0;
		resp=new Respuesta();
	}

	@Override
	public Respuesta agregar(int valor) {
		if (!pertenece(valor)) {
			resp.error = false;
			conj[cant]=valor;
			cant++;
		}
		else {
			resp.error = true;
		}
		return resp;
	}

	@Override
	public Respuesta sacar(int valor) {
		int i=0;
		while (i < cant && conj[i] != valor) {
			i++;
		}
		if (i<cant) {
			resp.error=false;
			conj[i]=conj[cant-1];
			cant--;
		}
		else {
			resp.error=true;
		}
		return resp;
	}

	@Override
	public Respuesta elegir() {
		if (!conjuntoVacio()) {
			resp.error=false;
			int max = cant-1;
	        int min = 0;
	        int pos = (int)(Math.random() * (max-min+1) + min);
	        resp.rta=conj[pos];
		}
		else {
			resp.error=true;
		}
		return resp;
	}

	@Override
	public boolean pertenece(int valor) {
		int i=0;
		while (i < cant && conj[i] != valor) {
			i++;
		}
		return i<cant;
	}

	@Override
	public boolean conjuntoVacio() {

		return cant==0;
	}

}
