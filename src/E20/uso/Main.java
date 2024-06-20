package E20.uso;

import imple.ABB;
import tda.ABBTDA;

public class Main {
    /*
    * Partiendo de un Árbol B vacío de orden 5, se solicita realizar las siguientesoperaciones:
    *   a. Agregar el 53
    *   b. Agregar el 62
    *   c. Agregar el 31
    *   d. Agregar el 105
    *   e. Agregar el 85
    *   f. Agregar el 55
    *   g. Eliminar el 105
    *   h. Eliminar el 62
    * */
    public static void main(String[] args) {
        ABBTDA a = new ABB();

        // Se inicializa el nodo principal y se le asigna un info = 53.
        // Tambien se inicializan los ABBTDA hijos (izquierda y derecha)
        a.agregarElem(53);

        // Como 62 > 53, se ejecuta agregarElem en el hijo derecho.
        // Este, al ser null, inicializa el nodo y le asigna un info = 62.
        // Se inicializan los ABBTDA hijos.
        a.agregarElem(62);

        // Como 31 < 53, se ejecuta agregarElem en el hijo izquierdo.
        // Este, al ser null, inicializa el nodo y le asigna un info = 31.
        // Se inicializan los ABBTDA hijos.
        a.agregarElem(31);

        // Como 105 > 53, se ejecuta agregarElem en el hijo derecho.
        // Como 105 > 62, se ejecuta agregarElem en el hijo derecho.
        // Este, al ser null, inicializa el nodo y le asigna un info = 105.
        // Se inicializan los ABBTDA hijos.
        a.agregarElem(105);

        // Como 85 > 53, se ejecuta agregarElem en el hijo derecho.
        // Como 85 > 62, se ejecuta agregarElem en el hijo derecho.
        // Como 85 < 105, se ejecuta agregarElem en el hijo izquierdo.
        // Este, al ser null, inicializa el nodo y le asigna un info = 85.
        // Se inicializan los ABBTDA hijos.
        a.agregarElem(85);

        // Como 55 > 53, se ejecuta agregarElem en el hijo derecho.
        // Como 55 < 62, se ejecuta agregarElem en el hijo izquierdo.
        // Este, al ser null, inicializa el nodo y le asigna un info = 55.
        // Se inicializan los ABBTDA hijos.
        a.agregarElem(55);

        // Como 105 > 53, se ejecuta eliminarElem en el arbol derecho
        // Como 105 > 62, se ejecuta eliminarElem en el arbol derecho
        // El nodo posee el elemento buscado, se busca el elemento mayor por el lado izquierdo
        // y se reemplaza el actual con el mayor. Este ultimo se elimina.
        a.eliminarElem(105);

        // 62 > 53, se ejecuta eliminarElem por el lado derecho.
        // Como info == 62 y el arbol izquierdo no esta vacio, se obtiene el mayor por el lado izquierdo
        // y se lo reemplaza por el actual. Este ultimo se elimina
        a.eliminarElem(62);
    }
}
