import java.util.HashSet;
import java.util.Set;

public class Graph {
	HashSet<Edge> edges;

	public Graph(){
		edges = new HashSet<Edge>();
		edges.clear();
	}

	public boolean contain(int v1, int v2){
		Edge e = new Edge(v1, v2);
		return edges.contains(e);
	}

	public void addEdge(int v1, int v2){
		Edge e = new Edge(v1, v2);
		if (!edges.contains(e)){
			edges.add(e);
		}
	}

	public void removeEdge(int v1, int v2){
		Edge e = new Edge(v1, v2);
		if (edges.contains(e)){
			edges.remove(e);
		}
	}
}
