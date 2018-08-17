package currencyflaw;

public class Edge {

		
		private final int src;
		private  final int dest;
		private  final double weight;
		
		public Edge(int src,int dest,double weight) {
			this.src=src;
			this.dest=dest;
			this.weight = weight;
		}
		
		public int src() {
			return src;
		}
		public int dest() {
		
			return dest;
		}
		
		public double weight() {
			
			return weight;
		}
		
		
	}


