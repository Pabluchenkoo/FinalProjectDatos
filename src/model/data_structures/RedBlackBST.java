package model.data_structures;

import java.util.ArrayList;



public class RedBlackBST <K extends Comparable<K>, V> implements TablaSimbolosOrdenada<K, V>{

	private static final boolean ROJO = true;
	
	private static final boolean NEGRO = false;
	
	private NodoBST raiz;   
	
	private class NodoBST 
	{
		private K llave;  
		
		private ArrayList<V> valores;
		
		private NodoBST izquierda;
		
		private NodoBST derecha;  
		
		private boolean color;
		
		private int size;          

		public NodoBST(K pLlave, ArrayList<V> pValor, boolean color , int size) 
		
		{
			
			this.llave = pLlave;
			
			this.valores = pValor;
			
			this.color = color;
			
			this.size = size;
			
		}
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size(raiz);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public ArrayList<V> get(K pLlave) {
		// TODO Auto-generated method stub
		ArrayList<V> respuesta = null;
		try 
		{
			respuesta = get(raiz, pLlave);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public int getHeight(K key) {
		// TODO Auto-generated method stub
		int respuesta = 0;
		try 
		{
			respuesta = height(raiz) - height(darNodo(raiz, key));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public boolean contains(K pLlave) 
	{
		{
			if (pLlave == null)
				{
				throw new IllegalArgumentException("no hay llaves ");
				}
			return get(pLlave) != null;
		}
	}

	@Override
	public void put(K pLlave, V pValor) throws Exception {
		// TODO Auto-generated method stub
		if (pLlave  == null) 
		{
		
			throw new Exception("no existe la llave");
		}
		
		if (pValor == null) 
		{
			//CarlosDios Si el valor no existe tocaria eliminar la llave?
			return;
		}
		
		raiz = putt(raiz, pLlave, pValor);
		raiz.color = NEGRO;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return height(raiz);
	}

	@Override
	public K min() {
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			System.out.println("calls min() with empty symbol table");
		}
		return min(raiz).llave;
	}

	@Override
	public K max() {
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			System.out.println("calls min() with empty symbol table");
		}
		return max(raiz).llave;
	}

	@Override
	public Iterable<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<K> keysInRange(K init, K end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<V> valuesInRange(K init, K end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean esRojo(NodoBST pNodo)
	{
		boolean respuesta;
		if (pNodo ==null)
		{
			respuesta=false;
		}
		else
		{
			respuesta = (pNodo.color == ROJO);
		}
		return respuesta;
	}
	
	private int size(NodoBST pNodo)
	{
		if(pNodo == null)
		{
			return 0;
		}
		else
		{
			return pNodo.size;
		}
	}
	
	private ArrayList<V> get(NodoBST pNodo, K pLlave) throws Exception
	{
		{
			if (pLlave == null) 
			{
				throw new Exception("la llave no ha sido encontrada");
			}
			if (pNodo == null) 
			{
				return null;
			}
			
			int comparacion = pLlave.compareTo(pNodo.llave);
			
			if(comparacion < 0) 
			{
				return get(pNodo.izquierda, pLlave);
			}
			else if (comparacion > 0) 
			{
				return get(pNodo.derecha, pLlave);
			}
			else     
			{
				return pNodo.valores;
			}
		}
	}
	
	public NodoBST putt (NodoBST pNodo, K pLlave, V pValor)
	{
		if (pNodo == null)
		{
			ArrayList<V> lista = new ArrayList<>();
			lista.add(pValor);
			return new NodoBST(pLlave, lista, ROJO , 1);
		}
		
		int comparacion = pLlave.compareTo(pNodo.llave);
		
		if      (comparacion < 0) 
			{
			pNodo.izquierda  = putt(pNodo.izquierda,  pLlave, pValor);
			}
		else if (comparacion  > 0) 
			{
			pNodo.derecha = putt(pNodo.derecha, pLlave, pValor);
			}
		else              
			{
			pNodo.valores.add(pValor);
			}
		if (esRojo(pNodo.derecha) && !esRojo(pNodo.izquierda))
		{
			pNodo = nodoRotarIzquierda(pNodo);
		}
		if (esRojo(pNodo.izquierda) && !esRojo(pNodo.izquierda.izquierda))
		{
			pNodo = nodoRotarDerecha(pNodo);
		}
		if (esRojo(pNodo.izquierda) && !esRojo(pNodo.derecha))
		{
			nodoCambiarColores(pNodo);
		}
		
		pNodo.size = size(pNodo.izquierda) + size (pNodo.derecha) +1;
	
		return pNodo;
	}
	
	private NodoBST nodoRotarIzquierda(NodoBST pNodo)
	{
		NodoBST temporal = pNodo.derecha;
		pNodo.derecha = temporal.izquierda;
		temporal.izquierda = pNodo;
		temporal.color = temporal.izquierda.color;
		temporal.izquierda.color = ROJO;
		temporal.size = pNodo.size;
		pNodo.size = size(pNodo.izquierda) + size(pNodo.derecha) + 1;
		return temporal;
	}
	
	private NodoBST nodoRotarDerecha(NodoBST pNodo)
	{
		NodoBST temporal = pNodo.izquierda;
		pNodo.izquierda = temporal.derecha;
		temporal.derecha = pNodo;
		temporal.color = temporal.derecha.color;
		temporal.derecha.color = ROJO;
		temporal.size = pNodo.size;
		pNodo.size = size(pNodo.izquierda) + size(pNodo.derecha) + 1;
		return temporal;
	}
	
	private void nodoCambiarColores (NodoBST pNodo)
	{
		pNodo.color = !pNodo.color;
		pNodo.derecha.color = !pNodo.derecha.color;
		pNodo.izquierda.color = !pNodo.izquierda.color;
	}
	
	private int height(NodoBST pNodo)
	{
		if (pNodo == null)
		{
			return -1;
		}
		else
		{
			return 1 + Math.max(height(pNodo.izquierda), height(pNodo.derecha));
		}
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
	
	private NodoBST min(NodoBST pNodo)
	{
		if(pNodo.izquierda == null)
		{
			return pNodo;
		}
		else
		{
			return min(pNodo.izquierda);
		}
	}
	
	private NodoBST max(NodoBST pNodo)
	{
		if ( pNodo.derecha == null )
		{
			return pNodo;
		}
		else
		{
			return max(pNodo.derecha);
		}
	}
}
