
package arbo_binario.abb;

public class ABB{   		//Java Beans
	private Nodo raiz;  //null

	ABB(){
		this.raiz = null;
	} 

	public boolean esVacio(){
		return (this.raiz == null); 
	}

	public Nodo regresaRaiz(){   //getRaiz  -- getter de atributo raiz
		return this.raiz;
	}

	public void insertarValor(int valor){
		if (this.raiz == null){
			System.out.println("Insertando raiz: " + valor);
			this.raiz = new Nodo();
			this.raiz.dato = valor;
			this.raiz.izquierdo = null;
			this.raiz.derecho = null;
		}
		else insertarNodo(valor, this.raiz);
	}

	public void insertarNodo(int valor, Nodo nodoRef){
			if (valor <= nodoRef.dato) {
				if (nodoRef.izquierdo == null){
					System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
					nodoRef.izquierdo =  new Nodo();
					nodoRef.izquierdo.dato = valor;
					nodoRef.izquierdo.izquierdo = null;
					nodoRef.izquierdo.derecho = null;
				}
				else {
					insertarNodo(valor, nodoRef.izquierdo);
				}
			}
			else {
				if (valor > nodoRef.dato) {
					if (nodoRef.derecho == null){
						System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
						nodoRef.derecho =  new Nodo();
						nodoRef.derecho.dato = valor;
						nodoRef.derecho.izquierdo = null;
						nodoRef.derecho.derecho = null;
					}
					else {
						insertarNodo(valor, nodoRef.derecho);
					}
				}
			}
	}

	public void muestraAcostado(int nivel, Nodo nodoRef){
		if (nodoRef == null){
			return;
		}
		else {
			muestraAcostado(nivel + 1, nodoRef.derecho);

			for (int i=0; i < nivel; i++){
				System.out.print("   ");
			}

			System.out.println(nodoRef.dato);
			muestraAcostado(nivel + 1, nodoRef.izquierdo);
		}
	}
        
            //Metodos para la tarea 
            //Método para imprimir el árbol de forma horizontal
            public void imprimirArbolHorizontal() {
                imprimirArbolHorizontal(raiz, 0);
            }

            private void imprimirArbolHorizontal(Nodo nodoRef, int nivel) {
                if (nodoRef != null) {
                    imprimirArbolHorizontal(nodoRef.derecho, nivel + 1);

                    for (int i = 0; i < nivel; i++) {
                        System.out.print("   ");
                    }

                    System.out.println(nodoRef.dato);
                    imprimirArbolHorizontal(nodoRef.izquierdo, nivel + 1);
                }
            }

            // Método para buscar un nodo
            public Nodo buscarNodo(int valor) {
                return buscarNodo(valor, raiz);
            }

            private Nodo buscarNodo(int valor, Nodo nodoRef) {
                //cuando el valor es nulo o tiene el nodo que se busca lo devuelve
                if (nodoRef == null || nodoRef.dato == valor) {
                    return nodoRef;
                }
                //busca en el subarbol izquierdo si el valor es menor que el nodo actual
                if (valor < nodoRef.dato) {
                    return buscarNodo(valor, nodoRef.izquierdo);
                } else {
                //busca en el subarbol derecho si el valor es mayor que el nodo actual
                    return buscarNodo(valor, nodoRef.derecho);
                }
            }

            // Métodos para recorrer el árbol en preorden, inorden y postorden
            public void recorrerPreorden() {
                recorrerPreorden(raiz);
            }

            private void recorrerPreorden(Nodo nodoRef) {
                if (nodoRef != null) {
                    //valor nodo actualk
                    System.out.print(nodoRef.dato + " ");
                    //hacer el recorrido en lado izquierdo
                    recorrerPreorden(nodoRef.izquierdo);
                    //hacer el recorrido en lado derecho
                    recorrerPreorden(nodoRef.derecho);
                }
            }

            public void recorrerInorden() {
                recorrerInorden(raiz);
            }

            private void recorrerInorden(Nodo nodoRef) {
                if (nodoRef != null) {
                    recorrerInorden(nodoRef.izquierdo);
                    System.out.print(nodoRef.dato + " ");
                    recorrerInorden(nodoRef.derecho);
                }
            }

            public void recorrerPostorden() {
                recorrerPostorden(raiz);
            }

            private void recorrerPostorden(Nodo nodoRef) {
                if (nodoRef != null) {
                    recorrerPostorden(nodoRef.izquierdo);
                    recorrerPostorden(nodoRef.derecho);
                    System.out.print(nodoRef.dato + " ");
                }
            }

            // Método para la eliminacion del nodo
            public void eliminarNodo(int valor) {
                raiz = eliminarNodo(raiz, valor);
            }
             //si el nodo es nulo no se elimina nada :)
            private Nodo eliminarNodo(Nodo nodoRef, int valor) {
                if (nodoRef == null) {
                    return nodoRef;
                }
            //hace una busqueda en subarbol izquierdo para ver si el valor es menor   
                if (valor < nodoRef.dato) {
                    nodoRef.izquierdo = eliminarNodo(nodoRef.izquierdo, valor);
                } else if (valor > nodoRef.dato) {
                    nodoRef.derecho = eliminarNodo(nodoRef.derecho, valor);
                    //si el nodo se busca, se elimina
                } else {
                    //cuando el nodo cuenta con un solo hijo o no tiene
                    if (nodoRef.izquierdo == null) {
                        return nodoRef.derecho;
                    } else if (nodoRef.derecho == null) {
                        return nodoRef.izquierdo;
                    }

                    //en caso de que el nodo tenga dos hijos
                    nodoRef.dato = encontrarMinimoValor(nodoRef.derecho);
                    nodoRef.derecho = eliminarNodo(nodoRef.derecho, nodoRef.dato);
                }

                return nodoRef;
            }

            private int encontrarMinimoValor(Nodo nodoRef) {
                int minValor = nodoRef.dato;
                while (nodoRef.izquierdo != null) {
                    minValor = nodoRef.izquierdo.dato;
                    nodoRef = nodoRef.izquierdo;
                }
                return minValor;
            }

}










