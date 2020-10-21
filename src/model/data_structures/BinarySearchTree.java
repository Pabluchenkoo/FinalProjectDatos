package model.data_structures;

import java.util.ArrayList;

public class   BinarySearchTree <K extends Comparable<K>, V> implements TablaSimbolosOrdenada<K, V>{

	private NodoBST raiz;             

	private class NodoBST 
	{
		private K llave;  
		
		private ArrayList<V> valores;
		
		private NodoBST izquierda;
		
		private NodoBST derecha;   
		
		private int size;          

		public NodoBST(K pLlave, ArrayList<V> pValor, int size) 
		
		{
			
			this.llave = pLlave;
			
			this.valores = pValor;
			
			this.size = size;
		}
	}

	
	public BinarySearchTree() 
	{
		raiz = new NodoBST(null, null, 0);
	}

	@Override
	public int size() 
	{
		return darTamanioNodo(raiz);
	}
	
	
	


	@Override
	public boolean isEmpty() 
	{
		return size() == 0;
	}

	@Override
	public ArrayList<V> get(K llave) 
	{
		ArrayList<V> respuesta = null;
		try 
		{
			respuesta = get(raiz, llave);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
		
	}

	

	@Override
	public int getHeight(K key) 
	{
		int respuesta = 0;
		try {
			respuesta = height(raiz) - height(darNodo(raiz, key));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public boolean contains(K key) 
	{
		if (key == null)
			{
			throw new IllegalArgumentException("no hay llaves ");
			}
		return get(key) != null;
	}

	@Override
	public void put(K llave, V valor) throws Exception
	{
		if (llave  == null) 
		{
		
			throw new Exception("no existe la llave");
		}
		
		if (valor == null) 
		{
			return;
		}
		
		raiz = putt(raiz, llave, valor);
	}

	

	@Override
	public int height() {
		return height(raiz);
	}

	@Override
	public K min() {
		if (isEmpty()) System.out.println("calls min() with empty symbol table");
		return min(raiz).llave;
	}

	


	@Override
	public K max() {
		if (isEmpty()) System.out.println("tabla de simbolos vacia");
		return max(raiz).llave;
	}

	

	@Override
	public Iterable<K> keySet() {
		if (isEmpty())
			{
			return new Lista<K>();
			}
		return keysInRange(min(), max());
	}

	@Override
	public Iterable<K> keysInRange(K init, K end) {
		if (init == null) throw new IllegalArgumentException("first argument to keys() is null");
		if (end == null) throw new IllegalArgumentException("second argument to keys() is null");

		Lista<K> queue = new Lista<K>();
		llaves(raiz, queue, init, end);
		return queue;
	}

	 

	@Override
	public Iterable<V> valuesInRange(K init, K end) throws Exception
	{
		if (init == null)
		{
			throw new Exception("el inicial es vacio");
		}
		if (end == null) 
		{
			throw new Exception("el end es vacio");
		}

		ArrayList<V> lista = new ArrayList<V>(); 
		values(raiz, lista, init, end);
		return lista;
	}

	
	
	public Iterable<V> valueSet() throws Exception{
		if (isEmpty())
		{
			return new ArrayList<V>();
		}
			
		return valuesInRange(min(), max());
	}

	private NodoBST darNodo(NodoBST pNodo, K key) throws  Exception 
	{
		if (key == null) 
		{
			throw new Exception("no existe esa llave");
		}
		if (pNodo == null) 
		{
			return null;
		}
		
		int comparacion = key.compareTo(pNodo.llave);
		
		if      (comparacion < 0) 
		{
			return darNodo(pNodo.izquierda, key);
		}
			
		else if (comparacion > 0) 
		{
			return darNodo(pNodo.derecha, key);
		}
		else      
		{
			return pNodo;
		}
	}
	
	private int darTamanioNodo(NodoBST pNodo) 
	{
		if (pNodo == null) 
		{
			return 0;
		}
		else
		{	
			return pNodo.size;
		}
	}
	private ArrayList<V> get(NodoBST pNodo, K llave) throws Exception
	{
		if (llave == null) 
		{
			throw new Exception("la llave no ha sido encontrada");
		}
		if (pNodo == null) 
		{
			return null;
		}
		
		int comparacion = llave.compareTo(pNodo.llave);
		
		if(comparacion < 0) 
		{
			return get(pNodo.izquierda, llave);
		}
		else if (comparacion > 0) 
		{
			return get(pNodo.derecha, llave);
		}
		else     
		{
			return pNodo.valores;
		}
	}
	private NodoBST putt(NodoBST x, K key, V val) {
		if (x == null)
		{
			ArrayList<V> lista = new ArrayList<>();
			lista.add(val);
			return new NodoBST(key, lista, 1);
		}
		
		int comparacion = key.compareTo(x.llave);
		
		if      (comparacion < 0) 
			{
			x.izquierda  = putt(x.izquierda,  key, val);
			}
		else if (comparacion  > 0) 
			{
			x.derecha = putt(x.derecha, key, val);
			}
		else              
			{
			x.valores.add(val);
			}
		
		return x;
	}

	private int height(NodoBST x) 
	{
		if (x == null)
		{
			return -1;
		}
		
		return 1 + Math.max(height(x.izquierda), height(x.derecha));
	}
	private NodoBST min(NodoBST pNodo) { 
		if (pNodo.izquierda == null)
			{
			return pNodo; 
			}
		else              
			{
			return min(pNodo.izquierda); 
			}
	} 
	private NodoBST max(NodoBST pNodo) {
		if (pNodo.derecha == null)
			{
			return pNodo; 
			}
		else   
			{
			return max(pNodo.derecha); 
			}
	} 
	private void llaves (NodoBST pNodo, Lista<K> lista, K lo, K hi) { 
		if (pNodo == null)
			{
			return; 
			}
		int comparalo = lo.compareTo(pNodo.llave); 
		int comparahi = hi.compareTo(pNodo.llave);
		
		if (comparalo < 0) 
			{
			llaves(pNodo.izquierda, lista, lo, hi); 
			}
		if (comparalo <= 0 && comparahi >= 0)
			{
			lista.enlistar(pNodo.llave); 
			}
		if (comparahi > 0)
			{
			llaves(pNodo.derecha, lista, lo, hi); 
			}
	}
	private void values(NodoBST x, ArrayList<V> queue, K lo, K hi) {
		if (x == null)
		{
			return;
		}
			 
		int comparalo = lo.compareTo(x.llave); 
		int comparahi = hi.compareTo(x.llave); 
		
		
		if (comparalo < 0)
		{
			values(x.izquierda, queue, lo, hi);
		}
			 
		if (comparalo <= 0 && comparahi >= 0) 
		{
			ArrayList<V> w = x.valores;
			for (int i = 0; i < w.size(); i++) 
				queue.add(w.get(i)); 
		}
		if (comparahi > 0) 
		{
			values(x.derecha, queue, lo, hi); 
		}
			
	}
}
