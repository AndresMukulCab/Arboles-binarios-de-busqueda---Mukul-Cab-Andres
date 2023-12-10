
package arbo_binario.abb;

public class UsaABB {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        // Insercion de los valores en el árbol
        arbol.insertarValor(25);
        arbol.insertarValor(8);
        arbol.insertarValor(29);
        arbol.insertarValor(38);
        arbol.insertarValor(27);
        System.out.print("\n"); 
        
        // Imprime el árbol de forma horizontal
        System.out.println("Árbol horizontal:");
        arbol.imprimirArbolHorizontal();
        System.out.print("\n"); 
        
        // se busca un nodo, en este caso el nodo 8
        int valorBuscado = 8;
        Nodo nodoBuscado = arbol.buscarNodo(valorBuscado);
        if (nodoBuscado != null) {
            System.out.println("Nodo buscado, valor: " + valorBuscado);
        } else {
            System.out.println("Nodo no buscado con el valor: " + valorBuscado);
        }

        //preorden
        System.out.println("Recorrido en preorden:");
        arbol.recorrerPreorden();
        System.out.println();

        //inorden
        System.out.println("Recorrido en inorden:");
        arbol.recorrerInorden();
        System.out.println();

        //postorden
        System.out.println("Recorrido en postorden:");
        arbol.recorrerPostorden();
        System.out.println();
        System.out.print("\n"); 
        
        //eliminacion del nodo por medio de "valorEliminar"
        int valorEliminar = 38;
        arbol.eliminarNodo(valorEliminar);
        System.out.println("Árbol después de eliminar el nodo " + valorEliminar + ":");
        arbol.imprimirArbolHorizontal();
    }
}
