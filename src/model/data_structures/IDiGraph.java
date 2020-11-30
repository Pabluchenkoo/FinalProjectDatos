package model.data_structures;

import java.util.List;

public interface IDiGraph<K extends Comparable <K>,V extends Comparable <V>>{

    
    public boolean containsVertex(K id);

    
    public int numVertices();

    
    public int numEdges();

    
    public void insertVertex(K id, V value);

    
    public void addEdge(K source, K dest, double weight);

    
    public Vertex <K,V> getVertex(K id);

    
    public Edge<K,V> getEdge(K idS, K idD) ;

    
    public Lista<Edge<K,V>> adjacentEdges(K id);

    
    public List < Vertex<K,V> > adjacentVertex(K id);

    
    public int indegree(K vertex);

    
    public int outdegree(K vertex);

    
    public List <Edge<K,V>> edges();

    public List <Vertex<K,V>> vertices();


}

