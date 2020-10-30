package model.data_structures;

import java.util.Arrays;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.

 *
 */

public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico<T> , Comparable < ArregloDinamico<T>>
{
	/**
	 * Capacidad maxima del arreglo
	 */
    private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
    private int tamanoAct;
    /**
     * Arreglo de elementos de tamaNo maximo
     */
    private T elementos[ ];

    /**
     * Construir un arreglo con la capacidad maxima inicial.
     * @param max Capacidad maxima inicial
     */
	public ArregloDinamico( int max )
    {
           elementos = (T[]) new Comparable[max];
           tamanoMax = max;
           tamanoAct = 0;
    }
    
	public void agregar( T dato )
    {
           if ( tamanoAct == tamanoMax )
           {  // caso de arreglo lleno (aumentar tamaNo)
                tamanoMax = 2 * tamanoMax;
                T [ ] copia = elementos;
                elementos = (T[]) new Comparable[tamanoMax];
                for ( int i = 0; i < tamanoAct; i++)
                {
                 	 elementos[i] = copia[i];
                } 
        	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
           }	
           elementos[tamanoAct] = dato;
           tamanoAct++;
   }

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {
		// TODO implementar
		return elementos[i];
		
	}

	public T buscar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		
		int i =0;
		T elem =elementos[0];
		while(i<elementos.length && elem !=null)
		{
			if(elem.compareTo(dato)==0)
			{
				return (T) elem;
			}
			i++;
			elem=elementos[i];
		}
		
		return elem;
	}

	public T eliminar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		  int i = 0;
	        T resp = null;
	        while(i < elementos.length && resp == null)
	        {
	            T act = elementos[i];
	            if(dato.compareTo(act) == 0)
	            {
	                resp = act;
	                elementos[i] = null;
	                i--;
	            }
	            i++;
	        }
	        if(resp != null)
	        {
	            while(i+1< elementos.length)
	            {
	                elementos[i] = elementos[i+1];
	                i++;
	            }
	        }
	        return (T) resp;
	    }

	
	public void agregarPrimero(T element){
		T[ ] temp = elementos;
		if(tamanoAct == tamanoMax)
		{
			tamanoMax *= 2;
		}
	        elementos =(T[]) new Comparable[tamanoMax];
	        elementos[0] = element;

	        for(int i = 0; i < tamanoAct;i++)
	            elementos[i+1] = temp[i];

	        tamanoAct++;


	    }

	@Override
	public void agregarAlFinal(T element) {
		
		tamanoAct++;
		
		T [] copia;
		
		copia =(T []) new  Comparable[tamanoAct];
		
		
		
		for(int i=0; i<tamanoAct-1;i++){
			copia[i]=elementos[i];
		}
		
		copia[tamanoAct-1] = element;
		
		elementos = copia;
		
	}

	@Override
	public void insertarElemento(T element, int pos) {
		
		tamanoAct++;
		T[ ] temporal = elementos;
		
		if(tamanoAct == tamanoMax)
		{
			tamanoMax *= 2;
		}
		elementos =(T[]) new Comparable[tamanoMax];
		elementos[pos] = element;

		for(int i = pos; i < tamanoAct;i++)
		{
			elementos[i+1] = temporal[i];
		}
	}

	@Override
	public T removerPrimero() {
		
		if(elementos.length == 0){
			
			return null;
		
		}
		T temporal = elementos[0];
		elementos[0] = null;

		for(int i = 0; i+1 < tamanoAct && elementos[i+1] != null;i++)
		{
			elementos[i] = elementos[i+1];
		}
		tamanoAct--;
		return temporal;
	}


	@Override
	public T RemoverUltimo() {
		
		if(elementos.length == 0){
			
			return null;
		
		}
		else{
			
			T temporal = elementos[tamanoAct-1];
			elementos[tamanoAct-1] = null;
			tamanoAct--;
			return temporal;
		}
	}

	@Override
	public T borrarElemento(int pos) {
		
		if(elementos.length == 0 || elementos.length < pos){
			
			return null;
		
		}
		else{
			
			tamanoAct--;
			
			T temp = elementos[pos];
			elementos[pos] = null;

			for(int i = pos; i+1 < tamanoAct;i++)
			{
				elementos[i] = elementos[i+1];
			}
			return temp;
		}
	}

	@Override
	public T PrimerElemento() {
		
		if(elementos.length == 0){
			return null;
		}
		else{
			return elementos[0];
		}
	}

	@Override
	public T ultimoElemento() {
		
		if(elementos.length == 0){
			return null;
		}
		else{
			return elementos[tamanoAct-1];
		}
	}
	@Override
	public T obtenerElementoPos(int pos) {
		
		if(elementos.length == 0){
			return null;
		}
		else{
			return elementos[pos];
		}
	}

	@Override
	public int tamanio() {
		
		return tamanoAct;
	}

	@Override
	public boolean esVacio() {
		
		if(tamanoAct > 0){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public int estaPresente(T elemento) {
		int i = 0;
		int respuesta = -1;
		while(i < tamanoAct && respuesta == -1)
		{
			if(elementos[i].equals(elemento))
				respuesta = i;
			i++;
		}

		return respuesta;
	}

	@Override
	public void intercambiar(int pos1, int pos2) {
		
		T copia;
		
		copia = elementos[pos1];
		
		elementos[pos1] = elementos[pos2];
		
		elementos[pos2] = copia;
		
	}

	@Override
	public void cambiarInformacion(int pos, T elem) {
		
		elementos[pos] = elem;
		
	}
	public int size(){
		return tamanoAct;
	}
	
	public T[] darElementos ()
	{
		return elementos;
	}
	
	@Override
	public T obtenerElementoElem(T elem) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tamanoAct-1; i++) {
			if(elementos[i]==elem){
				return elementos[i];
			}
		}
		return null;
	}

	@Override

	public int compareTo(ArregloDinamico o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
//	public int BinarioPresente ( T elemento )
//	{
//		return Arrays.binarySearch(elementos, elemento);
//	}
//	
//	public int compareTo(ArregloDinamico o) 
//	{
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
}
