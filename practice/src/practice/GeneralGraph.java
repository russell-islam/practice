package practice;


import java.util.LinkedList;


public class GeneralGraph {
	public GeneralGraph(){};
	class Graph
	{
		Node nodes[];
		public Graph(int v)
		{
			nodes = new Node[v];
			for (int i = 0; i < v; i++)
			{
				nodes[i] = new Node(i);
			}
		}
		public void addEdge(int src, int dst)
		{
			this.nodes[src].adj.addFirst(new Edge(src, dst));
		}
		public void removeEdge(int src, int dst)
		{
			this.nodes[src].adj.remove(new Edge(src, dst));
		}
		public void printGraph()
		{
			for (int i = 0; i < this.nodes.length; i++)
			{
				System.out.println(this.nodes[i].toString());
			}
		}
	}
	class Edge
	{
		public int src;
		public int dst;
		public int weight;
		public Edge(int s, int d)
		{
			this.src = s;
			this.dst =d;
			this.weight = 0;
		}
		public Edge(int s, int d, int w)
		{
			this.src = s;
			this.dst =d;
			this.weight = w;
		}
		@Override
	    public boolean equals(Object obj) {
	        if (obj != null && obj.getClass() == getClass()) {
	            return this.src == ((Edge) obj).src && this.dst == ((Edge) obj).dst;
	        }
	        return false;
	    }
		public String toString()
		{
			return this.src + " --> " + this.dst;
		}
	}
	class Node
	{
		int key;
		int color;
		LinkedList<Edge> adj;
		public Node(int v)
		{
			this.key = v;
			this.color = 0;
			adj = new LinkedList<Edge>();
		}
		public String toString()
		{
			String out = "";
			out = "Node: " + key + " Edges:";
			if (this.adj.isEmpty())
				return out;
			out = out + " (";
			for (Edge edge : adj) {
				out = out + edge.toString() + ",";
			}
			out = out.substring(0, out.length() - 1) + ")";
			return out;
		}
		@Override
	    public boolean equals(Object obj) {
	        if (obj != null && obj.getClass() == getClass()) {
	            return this.key == ((Node) obj).key;
	        }
	        return false;
	    }
	}

	public void test()
	{
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(2, 4);
		graph.addEdge(3, 1);
		graph.printGraph();
		graph.removeEdge(0, 4);
		System.out.println("After removing 0--4 edge");
		graph.printGraph();
	}
	public static void main()
	{
		GeneralGraph gg = new GeneralGraph();
		gg.test();
	}
}
