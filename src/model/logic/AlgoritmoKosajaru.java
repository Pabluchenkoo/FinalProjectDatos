package model.logic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import model.data_structures.ArregloDinamico;
import model.data_structures.DiGraph;
import model.data_structures.Edge;
import model.data_structures.TablaHashLinearProbing;
import model.data_structures.Vertex;



public class AlgoritmoKosajaru <K extends Comparable<K>, V> {

	private TablaHashLinearProbing <K, Vertex<K,V> > tablaHash;
	private ArregloDinamico <Vertex<K,V>> vectores;
	private TablaHashLinearProbing<Integer, Boolean> marcados;
	private TablaHashLinearProbing<Integer, Integer> clusters;
	
	private int count; 

	public AlgoritmoKosajaru(DiGraph G)
	{
		
		vectores = (ArregloDinamico<Vertex <K, V>>) tablaHash.valueSet();
		
		
		marcados = new TablaHashLinearProbing<Integer,Boolean>(vectores.size());
		
		for (int i = 0; i< vectores.darTamano();i++) //Vertex<K, V> vertex : vectores) 
		{
			Vertex<K, V> vertex = vectores.darElemento(i);
			marcados.put((Integer) vertex.getId(), false);
		}
		
		DiGraph graphoReves = G;
		
		ArrayList<Integer> order = DFOOrder(graphoReves, (int) tablaHash.darPrimerElemento().getId()); 
		
		
		Integer darPrimeroEnfalseID = darPrimeroEnFalse();
		
		while(darPrimeroEnfalseID!=null) 
		{
			order.addAll(DFOOrder(graphoReves, darPrimeroEnfalseID));
		
			darPrimeroEnfalseID = darPrimeroEnFalse();
		}
		
		Collections.reverse(order);

		clusters = new TablaHashLinearProbing<Integer, Integer>(vectores.size());
		
		for (int s : order)
			if (marcados.get(s))
			{
				dfs(G, s); 
				count++;
			}
	}
	
	private ArrayList<Integer> rtaDFO;

	private ArrayList<Integer> DFOOrder(DiGraph G, int idVerticeFuente) {
		rtaDFO = new ArrayList<Integer>();
		DFOORderRecursivo(G, idVerticeFuente);
		rtaDFO.add(idVerticeFuente);
		return rtaDFO;
	}

	private void DFOORderRecursivo(DiGraph G, int idVerticeAct) {
		marcados.remove(idVerticeAct);
		marcados.put(idVerticeAct, true);
		
		ArregloDinamico<Integer> ordenDeVisita = G.getVertex(idVerticeAct).darIdsAdyacentes();

		
		for (int i = 0; i < ordenDeVisita.darTamano(); i++) //Integer w : ordenDeVisita) 
		{
			Integer w = ordenDeVisita.darElemento(i);
			if (!marcados.get(w)) {
				DFOORderRecursivo(G, w);
				rtaDFO.add(w);
			}
		}
	}

	private Integer darPrimeroEnFalse() {
		ArregloDinamico<Boolean> valMarcados = (ArregloDinamico<Boolean>) marcados.valueSet();
		int cont = 0 ;
		for (int i =0; i < valMarcados.darTamano(); i++)//Boolean boolean1 : valMarcados) 
			{
			Boolean boolean1 = false;
			if(boolean1==false) return marcados.keySet().get(cont);
			cont++;
		
			}
		return null;
	}


	private void dfs(DiGraph G, int idVerticeAct) {
		marcados.remove(idVerticeAct);
		marcados.put(idVerticeAct, false);
		clusters.put(idVerticeAct, count);
		
		ArregloDinamico<Integer> ordenDeVisita = G.getVertex(idVerticeAct).darIdsAdyacentes();
		Comparator<Integer> cmp = Collections.reverseOrder();
		
		for (int i = 0; i < ordenDeVisita.darTamano(); i++)
		{
			Integer w = ordenDeVisita.darElemento(i);
			if (marcados.get(w))
				dfs(G, w);
		}
	}
	
	
	public boolean fuertementeConectados(int v, int w) 
	{ 
		return clusters.get(v) == clusters.get(w); 
		}

	
	public int darClusterDe(int k)
	{ 
		return clusters.get(k); 
		}

	
	public int cantidadDeClusters()
	{ 
		return count;
		
	}
	
	
	
	
	
	public ArregloDinamico<K> darIDsEnCluster(K cluster){
		ArregloDinamico<K> rta = new ArregloDinamico<K>(10000);
		ArregloDinamico<K> llaves =  (ArregloDinamico<K>) clusters.keySet();
		ArregloDinamico<K> valores = (ArregloDinamico<K>)clusters.valueSet();

		for (int i =0; i < valores.darTamano();i++) //K k : valores) 
			{
			K k = valores.darElemento(i);
			if(cluster.equals(k))
			{
				K aAgregar = llaves.darElemento(i);
				rta.agregar(aAgregar);
			}
				

		
			}
		return rta;
	}
	
	public DiGraph<K,V> formarGrafoParaCluster(K cluster) {
		
		DiGraph<K,V> rta = new DiGraph<K, V>();
		
		ArregloDinamico<K> idsVertices = darIDsEnCluster(cluster);
		for (int i = 0; i < idsVertices.darTamano();i++)//K id : idsVertices) 
		{
			K iD = idsVertices.darElemento(i);
			rta.insertVertex(iD, tablaHash.get(iD).getInfo());
		}
		
		for ( int i =0; i < idsVertices.darTamano();i++)//K id : idsVertices ) 
		{
			K id = idsVertices.darElemento(i);
			Vertex<K, V> act = tablaHash.get(id);
			ArregloDinamico<Edge<K,V>> edgesAct =  (ArregloDinamico<Edge<K, V>>) act.edges();
			for (int j = 0 ; j < edgesAct.darTamano(); j++)		//Edge<K,V> edgeAct : edgesAct) 
			{
				Edge<K,V> edgeAct = edgesAct.darElemento(j);
				K idDestino = (K)edgeAct.getDest().getId();
				if(idsVertices.estaPresente(idDestino) == 1)
					{
					rta.addEdge(id, idDestino, edgeAct.weight());
					}
			}
		}
		
		return rta;
	}

}
