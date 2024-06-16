package E4.uso;

import E4.implementacion.*;
import E4.interfaces.*;

public class Main {
    public static void main(String[] args) {
        DiccionarioSimpleModTDA d = new DiccionarioSimpleMod();
        d.inicializarDiccionario();

        d.agregar(3, 39);
        d.agregar(3, 34);
        d.agregar(4, 890);
        d.agregar(1, 89);
        d.agregar(3, 90);

        System.out.println(d.recuperarMod(3));
        System.out.println(d.recuperarMod(1));
        System.out.println(d.recuperarMod(4));
    }
}
