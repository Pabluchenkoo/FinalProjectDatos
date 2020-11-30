package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Lista <T extends Comparable<T>> implements Iterable<T> 
{
    private Nodo<T> primero;   
    
    private Nodo<T> ultimo;     
    
    private int N;               

    private static class NodoLista<Item> 
    {
        private Item item;
        private NodoLista<Item> next;
    }

    public Lista() 
    {
        primero = null;
        ultimo = null;
        N = 0;
    }

   

    

    public void enlistar(T element) {
    	Nodo<T> ultimoAnterior = ultimo;

        if (isEmpty())
        	{
        	primero = ultimo;
        	}
        else 
        	{
        		ultimoAnterior.darSiguiente();
        	}
        N++;
    }

    
    public T eliminar() throws Exception
    {
        if (isEmpty())
        	{
        	throw new Exception("Lista Vacia");
        	}
        T element = primero.darInfo();
        primero = primero.darSiguiente();
        N--;
        return element;
    }

    public String toString() {
    	
        StringBuilder temp = new StringBuilder();
        for (T element : this) 
        {
            temp.append(element);
            temp.append(' ');
        }
        return temp.toString();
    } 

    public Iterator<T> iterator()  
    {
    	return null;
//        return new relacionarIterator(primero);  
    }
    
    public int size() 
    {
		// TODO Auto-generated method stub
		return N;
	}

	
	public void agregarPrimero(T elemento) {
		// TODO Auto-generated method stub
		Nodo<T> nuevoNodo = new Nodo<T>(elemento);
		nuevoNodo.cambiarSiguiene(primero);
		primero = nuevoNodo;
		N++;
	}

	
	public void agregarUltimo(T elemento) {
		// TODO Auto-generated method stub
		Nodo<T> nuevo = new Nodo<T>(elemento);

		if(primero == null)
			primero = nuevo;

		else 
			ultimo.cambiarSiguiene(nuevo);

		ultimo = nuevo;
		N++;
	}

	
	public void insertarElemento(T element, int pos) {
		// TODO Auto-generated method stub
		if(pos == 0)
			agregarPrimero(element);
		else if(primero != null)
		{
			Nodo<T> nuevo = new Nodo<T>(element);
			primero.insertarElemento(nuevo, pos);
		}
		N++;
	}

	
	public T removerPrimero() {
		// TODO Auto-generated method stub
		T temp = primero.darInfo();
		primero = primero.darSiguiente();
		N--;
		return temp;
	}

	
	public T removerUltimo() {
		// TODO Auto-generated method stub
		Nodo actual = primero;
		T temp = null;
		if(actual!= null && actual.darSiguiente() != null)
		{
			while(actual.darSiguiente().darSiguiente() != null)
				actual = actual.darSiguiente();

			temp = (T) actual.darSiguiente().darInfo();
			actual.cambiarSiguiene(null);;
			ultimo = actual;
			N--;
		}
		else if(actual != null)
		{
			temp = primero.darInfo();
			primero = null;
		}

		return temp;
	}

	
	public T eliminarElemento(int pos) {
		// TODO Auto-generated method stub
		T retorno = null;
		N--;
		if(pos == 0)
			retorno = removerPrimero();

		else 
			retorno = primero.eliminarElemento(pos);

		return retorno;
	}

	
	public T primerElemento() {
		// TODO Auto-generated method stub
		return primero == null? null:primero.darInfo( );
	}

	
	public T ultimoElemento() {
		// TODO Auto-generated method stub
		return ultimo == null? null: ultimo.darInfo( );
	}

	
	public int estaPresente(T element) {
		// TODO Auto-generated method stub
		return primero == null? -1:primero.existe(element, 0);
	}

	
	public void intercambiarElemento(int pos1, int pos2) {
		// TODO Auto-generated method stub
		if(pos1 <= N && pos2 <= N)
		{
		Nodo<T> nodo1 = darNodo(pos1);
		Nodo<T> nodo2 = darNodo(pos2); 
		T temp = nodo1.darInfo();
		nodo1.cambiarInformacion(nodo2.darInfo());;
		nodo2.cambiarInformacion(temp);
		}
	}

	
	public void cambiarInformacion(int pos, T element) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public T obtenerElemento(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Nodo<T> darNodo( int posicion )
	{
		return primero.darNodo(posicion);
	}

//    private class relacionarIterator implements Iterator<T> {
//        private NodoLista<T> current;
//
//        public relacionarIterator(NodoLista<T> primero) 
//        {
//            current = primero;
//        }
//
//        public boolean hasNext()  
//        { 
//        	return current != null;                    
//        }
//        public void remove()      
//        { 
//        	throw new UnsupportedOperationException(); 
//        }
//
//        public T next() {
//            if (!hasNext())
//            {   	
//            	throw new NoSuchElementException();
//            }
//            T item = current.item;
//            current = current.next; 
//            return item;
//        }
//    } 
}

