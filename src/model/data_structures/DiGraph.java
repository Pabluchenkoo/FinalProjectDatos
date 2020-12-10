package model.data_structures;

import java.util.ArrayList;
import java.util.List;

public class DiGraph < K extends Comparable<K>, V extends Comparable<V>> 
{


	int max = 1000;

	int numVertices;

	int numEdges;

	private ArregloDinamico<Vertex<K,V>> arco;


	public DiGraph() 
	{
		this.numVertices = 0;
		this.numEdges = 0;
		arco = new ArregloDinamico<Vertex<K,V>>(max);

	}

	/**
	 * Retorna true si el vÃ©rtice con id
	suministrado estÃ¡ en el grafo
	 * @param id
	 * @return
	 */
	public boolean  containsVertex(K pId) 
	{
		boolean contains = false;
		for(int i=1; i<=arco.size() && !contains; i++) 
		{
			contains = contains ||arco.darElemento(i).getId().equals(pId);
		}
		return contains;
	}


	/**
	 * Devuelve el nÃºmero de vÃ©rtices en el grafo
	 * @return
	 */
	public int numVertices() 
	{
		return numVertices;
	}

	/**
	 * Devuelve el nÃºmero de arcos en el grafo
	 * @return
	 */
	public int numEdges() 
	{
		return numEdges;
	}

	/**
	 * AÃ±ade un vÃ©rtice al grafo con su
identificador y valor
	 * @param id
	 * @param value
	 */
	public void insertVertex(K pId, V pValue) throws Exception 
	{
		Vertex<K,V> nuevo = new Vertex<K, V>(pId, pValue);
		if(!containsVertex(pId)) {
			arco.agregarAlFinal(nuevo);
			numVertices ++;
		}else {
			throw new Exception(pId.toString());
		}
	}

	/**
	 * AÃ±ade un arco dirigido pesado entre el
vÃ©rtice source y dest, con peso weight. Si el
arco YA existe se modifica su peso.
	 * @param source
	 * @param dest
	 * @param weight
	 */
	public void addEdge(K source, K dest, double weight) throws Exception {

		// Encuentra los vÃ©rtices de acuerdo a su ID
		Vertex<K,V> fuente = getVertex(source);
		Vertex<K,V> destino = getVertex(dest);

		if(fuente==null|| destino == null) {
			throw new Exception("Los vÃ©rtices no existen");
		}

		// Crea el arco entre los vertices fuente y destino
		Edge<K,V> arcoNuevo = new Edge<K, V>(fuente, destino, weight, max);

		// Revisa si ya hay un arco que vaya entre fuente y destino, en cuyo caso cambia su peso
		// De lo contrario, agrega el arco nuevo.

		if(fuente.getEdge(dest)!=null) {
			fuente.getEdge(dest).setWeight(weight);
		}else {
			fuente.addEdge(arcoNuevo);	
			numEdges++;
		}
		
		destino.indegree();



	}

	/**
	 * Retorna el vÃ©rtice a partir de su
identificador Ãºnico
	 * @param id
	 * @return
	 */
	public Vertex<K,V> getVertex(K id) {
		Vertex<K,V> buscado = null;
		for(int i=1; i<=arco.size() && buscado == null; i++) {
			if(arco.darElemento(i).getId().equals(id)) {
				buscado = arco.darElemento(i);
			}
		}
		return buscado;
	}

	/**
	 * Retorna el arco entre los vÃ©rtices idS y idD
(si existe). Retorna null si no existe.
	 * @param idS
	 * @param idD
	 * @return
	 */
	public Edge<K,V> getEdge(K idS, K idD){
		Vertex<K,V> vertice = getVertex(idS);
		if(vertice==null) {
			return null;
		}
		return vertice.getEdge(idD);
	}

	/**
	 * Devuelve una lista de arcos adyacentes
(salientes) al vÃ©rtice con id
	 * @param id
	 * @return
	 */
	public ArregloDinamico<Edge<K,V>> adjacentEdges(K id) {
		Vertex<K,V> vertice = getVertex(id);
		return (ArregloDinamico<Edge<K, V>>) vertice.edges();
	}

	/**
	 * Devuelve una lista de vÃ©rtices adyacentes
(salientes) al vÃ©rtice con id
	 * @param id
	 * @return
	 */
	public ArregloDinamico<Vertex<K,V>> adjacentVertex(K id){
		Vertex<K,V> vertice = getVertex(id);
		return vertice.vertices();
	}

	/**
	 * Devuelve el grado de entrada del vÃ©rtice
vertex (nÃºmero de arcos entrantes)
	 * @param vertex
	 * @return
	 */
	public int indegree(K vertex) {
		Vertex<K,V> vertice = getVertex(vertex);
		return vertice.indegree();
	}

	/**
	 * Devuelve el grado de salida del vÃ©rtice
vertex (nÃºmero de arcos salientes)
	 * @param vertex
	 * @return
	 */
	public int outdegree(K vertex) {
		Vertex<K,V> vertice = getVertex(vertex);
		return vertice.outdegree();
	}

	/**
	 * Devuelve una lista con todos los arcos del
grafo
	 * @return
	 */
	public ArregloDinamico<Edge<K,V>> edges(){
		ArregloDinamico<Edge<K,V>> edges = null;
		try {
			edges = new ArregloDinamico<Edge<K,V>>(numEdges);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=1; i<=arco.size(); i++) {
			ArregloDinamico<Edge<K,V>> edgesi = (ArregloDinamico<Edge<K, V>>) arco.darElemento(i).edges();
			for(int j=1; j<=edgesi.size();j++) {
				edges.agregarAlFinal(edgesi.darElemento(j));
			}
		}
		return edges;
	}

	/**
	 * Devuelve una lista con los vÃ©rtices del grafo
	 * @return
	 */
	public ArregloDinamico<Vertex<K,V>> vertices()
	{
		return arco;
	}



}