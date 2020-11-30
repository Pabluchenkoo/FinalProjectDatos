package model.data_structures;


import java.util.ArrayList;
import java.util.List;

public class Vertex<K extends Comparable<K>,V > 
{
	
	private boolean marked;
	
	private List<Vertex<K,V>> vertices;
	
	private V valor;
	
	private K id;
	
	private int gradoIn;
	
	private int gradoOut;
	
	private int viajesIn;
	
	private int viajesOut;
	
	private ArrayList<Edge<K, V>> arcos;
	
	
	public Vertex(K id, V pValor){
		
		this.id = id;
		
		valor = pValor;
		
		marked = false;
		
		arcos = new ArrayList<Edge<K,V>>();
		
		vertices = new ArrayList<Vertex<K,V>>();
		
		gradoIn = 0;
		
		gradoOut = 0;
		
		viajesIn = 0;
		
		viajesOut = 0;
	}
	
	/**
	 * Devuelve el identificador del vertice
	 * @return identificador del vertice
	 */
	public  K getId() {
		return id;
	}
	
	/**
	 * Devuelve el valor asociado al vertice
	 * @return valor asociado al vertice
	 */
	public V getInfo() {
		return valor;
	}
	
	/**
	 * Retorna si el vertice esta marcado o no
	 * @return true en el caso de marcado, false en el caso contrario
	 */
	public boolean getMark() {
		return marked;
	}
	
	/**
	 *  Agrega un arco adyacente al vertice
	 * @param edge arco adyacente que se quiere agregar al vertice
	 */
	public void addEdge( Edge<K,V> edge ) 
	{
		arcos.add(edge);
	}
	
	/**
	 * Suma 1 al gradoOut, o sea que se cuenta un arco saliente mas
	 */
	public void UnOutDegreeMas()
	{
		gradoOut++;
	}
	
	public int getViajesLlegando() {
		return viajesIn;
	}

	public void setViajesLlegando(int viajesLlegando) {
		this.viajesIn = viajesLlegando;
	}

	public int getViajesSaliendo() {
		viajesSaliendo();
		return viajesOut;
	}

	public void setViajesSaliendo(int viajesSaliendo) {
		this.viajesOut = viajesSaliendo;
	}

	public void viajesSaliendo()
	{
		for (Edge<K, V> edge : arcos) {
			viajesOut += edge.darNViajes();
		}
	}
	
	public void UnInDegreeMas()
	{
		gradoIn++;
	}
	
	public void addVertex( Vertex<K,V> vertice)
	{
		vertices.add(vertice);
	}
	
	public void mark() {
		marked = true;
	}
	
	public void unmark() {
		marked = false;
	}
	
	
	public int outdegree() {
		return gradoOut;
	}
	
	
	public int indegree() {
		return gradoIn;
	}
	
	
	
	public Edge<K,V> getEdge(Vertex<K,V> vertex){
		for(int i = 0; i<arcos.size(); i++)
		{
			if(arcos.get(i).getDest().equals(vertex))
			{
				return arcos.get(i);
			}
		}
		return null;
	}
	
	public Edge<K,V> getEdge(K id){
		for(int i = 0; i<arcos.size(); i++)
		{
			if(arcos.get(i).getDest().getId()==id)
			{
				return arcos.get(i);
			}
		}
		return null;
	}
	
	 
	public List<Vertex<K,V>> vertices(){
		return vertices;
	}
	
	 
	public List<Edge<K,V>> edges(){
		return arcos;
	}
	
	public ArrayList<K> darIdsAdyacentes() {
		ArrayList<K> rta = new ArrayList<K>();
		for (Edge<K,V> act : arcos) {
			rta.add(act.getDest().getId());
		}
		return rta;
	}
	
	
	
	
}