package E11.Uso;
import tda.*;
import imple.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiccionarioMultipleTDA dm=new DiccionarioMultiple();
		dm.inicializarDiccionario();
		dm.agregar(1, 1);
		dm.agregar(2, 4);
		dm.agregar(3, 6);
		dm.agregar(4, 8);
		dm.agregar(5, 4);
		dm.agregar(6, 1);
		ColaValoresSinRepetir(dm);
	}

	private static void ColaValoresSinRepetir(DiccionarioMultipleTDA dm) {
		// TODO Auto-generated method stub
		ColaTDA c=new Cola();
		c.inicializarCola();
		
		ConjuntoTDA conj=new Conjunto();//Creo un ConjuntoTDA para que al momento que acole, comprobar si ya pertenece
		conj.inicializarConjunto();
		
		DiccionarioMultipleTDA auxdm=new DiccionarioMultiple();
		auxdm.inicializarDiccionario();
		
		while (!dm.claves().conjuntoVacio()) {//Paso el DiccionarioMultiple a un auxiliar y mostrar por pantalla la composicion de ésta
			int clave=dm.claves().elegir();
			int valor=dm.recuperar(clave).elegir();
			System.out.println("Clave: "+clave+" Valor: "+valor);
			auxdm.agregar(clave, valor);
			dm.eliminarValor(clave, valor);
		}
		System.out.println();
		while (!auxdm.claves().conjuntoVacio()) {//Trabajo con el DM auxiliar
			int clave=auxdm.claves().elegir();
			int valor=auxdm.recuperar(clave).elegir();
			if (!conj.pertenece(valor)) {//Compruebo si el valor ya pertenece o no
				System.out.println("Valor agregado: "+valor);//Muestro x pantalla cual se agrega
				conj.agregar(valor);
				c.acolar(valor);//Agrego al conjunto y a la cola en simultaneo
			}
			dm.agregar(clave, valor);//Lo paso al DM original para no perder la estructura
			auxdm.eliminarValor(clave, valor);
		}
		
		//while (!c.colaVacia()) {//Comprobacion de que anda
			//c.desacolar();
		//}
		System.out.println("Listo");

	}

}
