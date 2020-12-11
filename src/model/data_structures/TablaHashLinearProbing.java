package model.data_structures;


public class TablaHashLinearProbing < K extends Comparable<K>, V extends Comparable<V>> implements TablaSimbolos<K, V> {

	private double loadFactor;
	
	private static final double MAXIMUM_LOAD_FACTOR = 0.75;
	
	private int N = 1; // number of key-value pairs in the table
	
	private int M=1; // size of linear-probing table  
	
	private ArregloDinamico<NodoTablas <K,V>> array;
	
	private int numeroRehashes;
	
	public TablaHashLinearProbing (int size)
	{
		array = new ArregloDinamico<NodoTablas<K,V>>(M);
	}

	@Override
	public void put(K pLlave, V pValor) {
		// TODO Auto-generated method stu
	    
		if((darFactorDeCarga() + (1/M)) >= MAXIMUM_LOAD_FACTOR)
		{
			rehash();
		}
		
		int posicion = hash(pLlave);
		NodoTablas<K,V> actual = array.darElemento( posicion );
		
		if (actual == null || actual.getKey().equals("EMPTY"))
		{
			NodoTablas<K,V> nuevoElemento = new NodoTablas<K,V>(pLlave , pValor);
			array.cambiarInformacion(posicion , nuevoElemento );
			N++;
		}
		
		else if ( actual.getKey().equals(pLlave) )
		{
			actual.cambiarValor(pValor);
	
		}
//		else
//		{
//			 putRecursiveVersion(posicion + 1, pLlave, pValor);
//		}
           
	}
	public int darN()
	{
		return N;
	}
	public double darFactorDeCarga()
	{
		return N/M;
	}
	
	@Override
	public V get(K pLlave) 
	{
		// TODO Auto-generated method stub
		int posicion = hash(pLlave);
		NodoTablas<K,V> actual = array.obtenerElementoPos(posicion);
		for (posicion=posicion; actual != null && pLlave.equals(actual.getKey()) ; posicion++)
		{
			return actual.getValue();
		}
		return null;
	}

	@Override
	public V remove(K pLlave) {
		// TODO Auto-generated method stub
		int posicion = hash (pLlave);
		V respuesta;
		NodoTablas<K,V> actual = array.obtenerElementoPos(posicion);
		for (posicion = posicion ; actual != null && pLlave.equals(actual.getKey()); posicion++)
		{
			respuesta = actual.getValue();
			actual.cambiarValor(null);
			N--;
			return respuesta;
		}
		return null;
	}

	@Override
	public boolean contains(K pLlave) {
		// TODO Auto-generated method stub
		return get(pLlave) != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}

	@Override
	public ArregloDinamico<K> keySet() {
		// TODO Auto-generated method stub
		ArregloDinamico<K> respuesta = new ArregloDinamico<>(N);
		for ( int i = 0 ; i < M ; i++)
		{
			NodoTablas<K,V> temporal = array.borrarElemento(i);
			if (temporal != null && temporal.getKey() != null)
			{
				respuesta.agregarAlFinal(temporal.getKey());
			}
		}
		return respuesta;
	}

	@Override
	public ArregloDinamico<V> valueSet() {
		// TODO Auto-generated method stub
		ArregloDinamico<V> respuesta = new ArregloDinamico<>(N);
		for ( int i = 0; i < M ; i++ )
		{
			NodoTablas<K,V> temporal = array.obtenerElementoPos(i);
			if (temporal != null && temporal.getValue() != null  )
			{
				respuesta.agregarAlFinal(temporal.getValue());
			}
		}
		return respuesta;
	}
	
	public int hash( K key )
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}
		
	public void rehash()
	{
		ArregloDinamico<NodoTablas<K,V>> todosLosElementos = obtenerTodos();
		array = new ArregloDinamico<NodoTablas<K,V>>(M);
		for ( int i = 0 ; i < todosLosElementos.size() ; i++ )
		{
			NodoTablas<K,V> actual = todosLosElementos.obtenerElementoPos(i);
			put(actual.getKey() , actual.getValue());
		}
		numeroRehashes++;
	}
	
	public ArregloDinamico<NodoTablas<K,V>> obtenerTodos()
	{
		ArregloDinamico<NodoTablas<K,V>> respuesta = new ArregloDinamico<NodoTablas<K,V>>(N);
		for( int i = 0; i < M ; i++ )
		{
			NodoTablas<K,V> temporal = array.obtenerElementoPos(i);
			if (temporal != null)
			{
				respuesta.agregarAlFinal(temporal);
			}
		}
		return respuesta;
	}
	public int numeroRehashes()
	{
		return numeroRehashes;
	}
	private void putRecursiveVersion(int pos, K key, V value)
    {
        if(pos > M)
            pos = 1;
        NodoTablas<K,V> act = array.obtenerElementoPos(pos);
        if(act == null || act.getKey().equals("EMPTY"))
        {
        	NodoTablas<K,V> nuevo = new NodoTablas<K,V>(key, value);
            array.cambiarInformacion(pos, nuevo);
            N++;
        }

        else if(act.getKey().equals(key))
            act.cambiarValor(value);

        else
            putRecursiveVersion(pos + 1, key, value);
    }
	
}