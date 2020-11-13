package model.data_structures;

public class Nodo <T extends Comparable<T>> 
{
	private Nodo siguiente;
	
	private T info;
	
	public Nodo (T pInfo)
	{
		siguiente = null;
		info = pInfo;
	}
	
	public void cambiarSiguiene(Nodo next)
	{
		siguiente=next;
	}
	
	public Nodo darsiguiente ()
	{
		return siguiente;
	}
	
	public T darInfo()
	{
		return info;
	}
	
	public int existe( T informacion , int actual )
	{
		return informacion.equals(info) ? actual : siguiente == null? -1: siguiente.existe(info, (actual+1));
	}
	public void cambiarInformacion (T informacion)
	{
		info=informacion;
	}
	public T obtenerElemento ( int posicion)
	{
		return posicion == 0? info: (siguiente == null? null : (T) siguiente.obtenerElemento(posicion-1));
	}
	
	public Nodo<T> obtenerNodo (int posicion)
	{
		return posicion == 0? this: (siguiente == null? null :(Nodo<T>) siguiente.obtenerNodo(posicion-1));
	}
	
	public T eliminarElemento (int posicion)
	{
		T retorno = null;
		if(posicion > 1)
			retorno = (T) siguiente.eliminarElemento(posicion-1);
		
		else if(posicion == 1)
		{
			retorno = (T) siguiente.darInfo();
			siguiente = siguiente != null? siguiente.darsiguiente():null;
		}
		return retorno;
	}
	public void insertarElemento ( Nodo<T> nuevoNodo, int posicion)
	{
		if(posicion > 1)
			 siguiente.insertarElemento(nuevoNodo,(posicion-1));
		
		else if(posicion == 1)
		{
			nuevoNodo.cambiarSiguiene(siguiente);
			siguiente = nuevoNodo;
		}
	}
	public Nodo<T> darNodo (int posicion)
	{
		return posicion == 0? this: (siguiente == null? null :(Nodo<T>) siguiente.darNodo(posicion-1));
	}
	
	public void cambiarInfo(T element, int posicion) 
	{
		if(posicion == 0)
			info = element;
		else if(siguiente != null)
			siguiente.cambiarInfo(element, (posicion-1));
	}
}
