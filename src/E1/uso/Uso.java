package E1.uso;
import E1.interfaces.ConjuntoEspecialTDA;
import E1.implementacion.*;
public class Uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConjuntoEspecialTDA c=new ConjuntoEspecial();
		c.inicializarConjunto();
		c.agregar(2);
		c.agregar(3);
		c.agregar(4);
		
		System.out.println(c.elegir().error);
		System.out.println(c.sacar(1).error);//True porque no puede sacar algo que no pertenece
		System.out.println(c.sacar(2).error);//False porque logra sacarlo
		System.out.println(c.agregar(3).error);//True porque ya esta agregado
		System.out.println(c.elegir().rta);//Devuelve el entero elegido
	}

}
