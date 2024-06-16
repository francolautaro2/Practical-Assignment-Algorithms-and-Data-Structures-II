package E4.uso;

import E4.implementacion.*;
import E4.interfaces.*;
import tda.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        DiccionarioSimpleModTDA d = new DiccionarioSimpleMod();
        d.inicializarDiccionario();

        d.agregar(3, 39);
        d.agregar(3, 34);
        d.agregar(4, 890);
        d.agregar(1, 89);

        ConjuntoTDA conjuntoClaves = d.claves();
        while(!conjuntoClaves.conjuntoVacio()){
            int v = conjuntoClaves.elegir();
            System.out.println(v);
            conjuntoClaves.sacar(v);
        }

    }
}
