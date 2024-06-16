package E4.implementacion;

import E4.interfaces.DiccionarioSimpleModTDA;
import imple.Conjunto;
import tda.ConjuntoTDA;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    private class Elemento {
        int clave;
        int factorMod;
        int valor;
    }
    private Elemento[] elementos;
    private int cant;
    
    public void inicializarDiccionario() {
        cant = 0;
        elementos = new Elemento[10];
    }

    public void agregar(int clave, int valor) {
        int pos = this.clave2Indice(clave);
        if (pos == -1) {
            elementos[cant] = new Elemento();
            elementos[cant].clave = clave;
            elementos[cant].factorMod = 0;
            elementos[cant].valor = valor;
            cant++;
        } else {
            elementos[pos].valor = valor;
            elementos[pos].factorMod += 1;
        }
    }

    public void eliminar(int clave) {
        int pos = clave2Indice(clave);
        if(pos != 1) {
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    private int clave2Indice(int clave) {
        int i = cant - 1;
        while(i >=0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }

    public int recuperar(int clave) {
        int pos = clave2Indice(clave);
        return elementos[pos].valor;
    }

    public int recuperarMod(int clave){
        int pos = clave2Indice(clave);
        return elementos[pos].factorMod;
    }

    public ConjuntoTDA claves() {
        int i = cant-1;
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        while (i >= 0) {
            claves.agregar(elementos[i].clave);
            i--;
        }
        return claves;
    }

}