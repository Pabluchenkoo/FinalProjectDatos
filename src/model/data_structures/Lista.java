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

