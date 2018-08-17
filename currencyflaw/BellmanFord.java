package currencyflaw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord {

	private double[] distTo;               
	private Edge[] edgeTo;         
    private boolean[] onQueue;             
    private Queue<Integer> queue;          
    private int cost;                      
    private Iterable<Edge> cycle;
	
	public BellmanFord(Graph g,int s) {
    
    distTo = new double[g.V()];
    edgeTo = new Edge[g.V()];
    onQueue = new boolean[g.V()];
    
    for(int i=0;i<g.V();i++)
    	distTo[i] = Double.MAX_VALUE;
    distTo[s]=0.0;
    
    queue = new LinkedList<Integer>();
    queue.add(s);
    onQueue[s] = true;
    
    while(!queue.isEmpty() && !hasNegativeCycle()) {
    	int v = queue.poll();
    	onQueue[v]=false;
    	relax(g,v);
    	
    }
    
	}

	
	private void relax(Graph g, int v) {
		for(Edge e: g.adj(v)) {
			
			int w = e.dest();
			if(distTo[w]>distTo[v]+e.weight()) {
				
				distTo[w] = distTo[v]+e.weight();
				edgeTo[w]=e;
				
				if(!onQueue[w]) {
					queue.add(w);
					onQueue[w]=true;
				}
			}
			
			if(cost++ % g.V() == 0) {
				findNegativeCycle();
			if(hasNegativeCycle()) return;
			}
			
		}

		
	}

	

	private void findNegativeCycle() {
		int v = edgeTo.length;
		Graph  sp = new Graph(v);
		
		for(int i=0;i<v;i++)
			if(edgeTo[i] !=null)
				sp.addEdge(edgeTo[i]);
		
		DirectedCycle find = new DirectedCycle(sp);
		cycle = find.cycle();
	}

	public boolean hasNegativeCycle() {
        return cycle != null;
    }
	
	public Iterable<Edge> negativeCycle() {
        return cycle;
    }
    
    
	
}
