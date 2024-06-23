package E5.uso;

import tda.ConjuntoTDA;
import tda.ColaPrioridadTDA;
import imple.Conjunto;
import E5.interfaces.DiccionarioSimpleTDA;
import E5.implementacion.DiccionarioSimple;

public class Main {
    public static void main(String[] args) {
        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.inicializarDiccionario();
        dic.agregar(3, 40);
        dic.agregar(5, 90);
        System.out.println(dic.recuperar(3));
        System.out.println(dic.recuperar(5));

        dic.eliminar(5);
        System.out.println(dic.recuperar(5));

    }
}
