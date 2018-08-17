package currencyflaw;

import java.util.ArrayList;
import java.util.Queue;

public class Graph {

	private final int V;                
    private int E;                      
    private ArrayList<Edge>[] adj;    
    private int[] indegree; 
	
	public Graph(int v) {
		
		this.V=v;
		this.E=0;
		this.indegree = new int[v];
		adj = new ArrayList[v];
		for(int i=0;i<v;i++)
			adj[i] = new ArrayList<Edge>();
	}
	public int V() {
		return V;
	}
	
	public int E() {
		
		return E;
	}
	public void addEdge(Edge e) {
		
		int v = e.src();
		int w = e.dest();
		adj[v].add(e);
		indegree[w]++;
		E++;
	}
	public Iterable<Edge> adj(int v){
		
		return adj[v];
		
	}
	
	public int outdegree(int v) {
        return adj[v].size();
    }
	
	public int indegree(int v) {
        return indegree[v];
    }
	public Iterable<Edge> edges() {
        ArrayList<Edge> list = new ArrayList<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }
	
	
	

}
