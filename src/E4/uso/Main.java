package E4.uso;

import imple.Conjunto;
import tda.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ConjuntoTDA test = new Conjunto();
        test.inicializarConjunto();
        test.agregar(30);
        test.agregar(23);
        while(!test.conjuntoVacio()){
            int c = test.elegir();
            System.out.println(c); // esto es un print. --Jordi
            test.sacar(c);
        }
    }
}
