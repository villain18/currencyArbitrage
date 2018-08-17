package currencyflaw;

import java.util.Stack;

public class DirectedCycle {
	
	
	private boolean[] marked;             
	private Edge[] edgeTo;        
    private boolean[] onStack;            
    private Stack<Edge> cycle;

	public Iterable<Edge> cycle() {
        return cycle;
    }
	
	public DirectedCycle(Graph g) {
		marked = new boolean[g.V()];
		onStack = new boolean[g.V()];
		edgeTo = new Edge[g.V()];
	for(int i=0;i<g.V();i++)
		if(!marked[i])
			dfs(g,i);
	
	}

	private void dfs(Graph g, int v) {
		onStack[v] =true;
		marked[v] = true;
		
		for(Edge e:g.adj(v)) {
			
			int w = e.dest();
			
			if(cycle !=null) return;
			
			else if(!marked[w]) {
				edgeTo[w] =e;
				dfs(g,w);
				
			}
			else if(onStack[w]) {
				cycle = new Stack<Edge>();
				Edge k =e;
				while(k.src() !=w) {
					cycle.push(k);
					k = edgeTo[k.src()];
					
					
				}
				cycle.push(k);
				return;
			}
			
			
		}
		
		
		onStack[v] = false;
	}
	
	
	
	

}
