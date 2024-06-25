package E5.implementacion;

import tda.ConjuntoTDA;
import E5.interfaces.DiccionarioSimpleTDA;
import tda.ColaPrioridadTDA;
import imple.ColaPrioridad;
import imple.Conjunto;


public class DiccionarioSimple implements DiccionarioSimpleTDA {
   
    private ColaPrioridad elementos;

    public void inicializarDiccionario() {
        elementos = new ColaPrioridad();
        elementos.inicializarCola();
    }
    public void agregar(int clave, int valor) { // Complejidad lineal
        // clave = prioridad
        // valor = info de la cola
        
        elementos.acolarPrioridad(valor, clave);

    }
    public void eliminar(int clave) { // Complejidad exponencial
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        while(!elementos.colaVacia()) {
            int prioridad = elementos.prioridad();
            if (prioridad != clave) {
                colaAux.acolarPrioridad(elementos.primero(), prioridad);
            }
            elementos.desacolar();
        }
        while(!colaAux.colaVacia()) {
            elementos.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
    }

    public int recuperar(int clave) { // Complejidad exponencial
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        int elemento = 0;
        while(!elementos.colaVacia()) {
            int valor = elementos.primero();
            if (clave == elementos.prioridad()) {
               elemento = valor;
            }
            colaAux.acolarPrioridad(elementos.primero(), elementos.prioridad());
            elementos.desacolar();
        }
        
        while(!colaAux.colaVacia()) {
            elementos.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
        return elemento;
    }
    public ConjuntoTDA claves() { // Complejidad exponencial
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        ConjuntoTDA conj = new Conjunto();
        conj.inicializarConjunto();
        
        while(!elementos.colaVacia()) {
            conj.agregar(elementos.prioridad());
            elementos.desacolar();
        }
        
        while(!colaAux.colaVacia()) {
            elementos.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
        return conj;
    }
    
}
