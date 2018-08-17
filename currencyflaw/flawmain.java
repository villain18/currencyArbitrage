package currencyflaw;

import java.util.Scanner;

public class flawmain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		String[] name = new String[v];
		
		Graph g = new Graph(v);
		
		for(int i=0;i<v;i++) {
			
			name[i] = sc.next();
			for(int j=0;j<v;j++) {
				
				double price = sc.nextDouble();
				Edge e= new Edge(i,j,-Math.log(price));
				g.addEdge(e);
			}
			
		}
		
		BellmanFord b = new BellmanFord(g,0);
		
		if(b.hasNegativeCycle()) {
			
			double invest = 1000.0;
		
			for(Edge e : b.negativeCycle()) {
				System.out.println(e.src()+" "+e.dest());
		
				System.out.printf("%10.6f %s",invest,name[e.src()]);
				invest*=Math.exp(-e.weight());
				System.out.printf("= %10.5f %s\n",invest,name[e.dest()]);
		
		
			}
		
		
		
		}		
		
		else System.out.println("Not possible");
		
		

	}

}
