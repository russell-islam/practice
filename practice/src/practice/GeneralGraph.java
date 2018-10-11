package practice;


import java.util.Iterator;
import java.util.LinkedList;


public class GeneralGraph {
	public GeneralGraph()
	{}
	
	class Graph
	{
		Node nodes[];
		int V;
		public Graph(int v)
		{
			nodes = new Node[v];
			this.V =v;
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
		
		// A function used by DFS 
	    private void DFSVisit(int v, boolean visited[]) 
	    { 
	        // Mark the current node as visited and print it 
	        visited[v] = true; 
	        System.out.print(v+" "); 
	  
	        // Recur for all the vertices adjacent to this vertex 
	        Iterator<Edge> i = nodes[v].adj.listIterator(); 
	        while (i.hasNext()) 
	        { 
	        	Edge e = i.next();
                int n = e.getOtherNode(v);
	            if (!visited[n]) 
	            	DFSVisit(n, visited); 
	        } 
	    } 
	  
	    // The function to do DFS traversal. It uses recursive DFSUtil() 
	    public void DFS(int v) 
	    { 
	        // Mark all the vertices as not visited(set as 
	        // false by default in java) 
	        boolean visited[] = new boolean[this.V]; 
	  
	        // Call the recursive helper function to print DFS traversal 
	        DFSVisit(v, visited); 
	    } 
		public void BFS(int s)
		{
			// Mark all the vertices as not visited(By default 
	        // set as false) 
	        boolean visited[] = new boolean[this.V]; 
	  
	        // Create a queue for BFS 
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	  
	        // Mark the current node as visited and enqueue it 
	        visited[s]=true; 
	        queue.add(s); 
	  
	        while (queue.size() != 0) 
	        { 
	            // Dequeue a vertex from queue and print it 
	            s = queue.poll(); 
	            System.out.print(s+" "); 
	  
	            // Get all adjacent vertices of the dequeued vertex s 
	            // If a adjacent has not been visited, then mark it 
	            // visited and enqueue it 
	            Iterator<Edge> i = nodes[s].adj.listIterator(); 
	            while (i.hasNext()) 
	            { 
	                Edge e = i.next();
	                int n = e.getOtherNode(s);
	                if (!visited[n]) 
	                { 
	                    visited[n] = true; 
	                    queue.add(n); 
	                } 
	            } 
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
		public int getOtherNode(int src)
		{
			if (this.src == src)
				return dst;
			return src;
		}
	}
	class Node
	{
		int key;
		int color;
		int value;
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
