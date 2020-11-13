package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Lista <T extends Comparable<T>> implements Iterable<T> 
{
    private NodoLista<T> primero;   
    
    private NodoLista<T> ultimo;     
    
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

    public boolean isEmpty() 
    {
        return primero == null;
    }

    public int size() {
        return N;
    }

    public T primerElemento() throws Exception
    {
    	
        if (isEmpty())
        	{
        		throw new Exception("Lista Vacia");
        	}
        
        return primero.item;
    }

    public void enlistar(T element) {
    	NodoLista<T> ultimoAnterior = ultimo;
        ultimo = new NodoLista<T>();
        ultimo.item = element;
        ultimo.next = null;
        if (isEmpty())
        	{
        	primero = ultimo;
        	}
        else 
        	{
        		ultimoAnterior.next = ultimo;
        	}
        N++;
    }

    
    public T eliminar() throws Exception
    {
        if (isEmpty())
        	{
        	throw new Exception("Lista Vacia");
        	}
        T element = primero.item;
        primero = primero.next;
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
    
    @Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}

	@Override
	public void agregarPrimero(T elemento) {
		// TODO Auto-generated method stub
		Nodo<T> nuevoNodo = new Nodo<T>(elemento);
		nuevoNodo.cambiarSiguiene(primero);
		primero = nuevoNodo;
		N++;
	}

	@Override
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

	@Override
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

	@Override
	public T removerPrimero() {
		// TODO Auto-generated method stub
		T temp = primero.darInfo();
		primero = primero.darsiguiente();
		N--;
		return temp;
	}

	@Override
	public T removerUltimo() {
		// TODO Auto-generated method stub
		Nodo actual = primero;
		T temp = null;
		if(actual!= null && actual.darsiguiente() != null)
		{
			while(actual.darsiguiente().darsiguiente() != null)
				actual = actual.darsiguiente();

			temp = (T) actual.darsiguiente().darInfo();
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

	@Override
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

	@Override
	public T primerElemento() {
		// TODO Auto-generated method stub
		return primero == null? null:primero.darInfo( );
	}

	@Override
	public T ultimoElemento() {
		// TODO Auto-generated method stub
		return ultimo == null? null: ultimo.darInfo( );
	}

	@Override
	public int estaPresente(T element) {
		// TODO Auto-generated method stub
		return primero == null? -1:primero.existe(element, 0);
	}

	@Override
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

	@Override
	public void cambiarInformacion(int pos, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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

