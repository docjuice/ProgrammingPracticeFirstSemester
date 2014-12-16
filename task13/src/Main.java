import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static boolean testGraph(Graph inGraph){
		inGraph.addEdge(1, 2);
		inGraph.addEdge(9, 17);
		inGraph.addEdge(6, 9);
		inGraph.addEdge(1, 11);
		//inGraph.removeEdge(3, 6);
		inGraph.removeEdge(9, 17);
		if (inGraph.contain(1, 12)) return false;
		if (inGraph.contain(9, 17)) return false;
		if (!inGraph.contain(3, 6)) return false;
		if (inGraph.contain(2, 10)) return false;
		return true;
	}

	public static void fillGraph(Graph inGraph, Scanner sc){
		String[] s;
		int v1, v2;
		while (sc.hasNextLine()){
			s = sc.nextLine().split(" ");
			v1 = Integer.parseInt(s[0]);
			v2 = Integer.parseInt(s[1]);
			inGraph.addEdge(v1, v2);
		}
	}

	public static void writeGraph(Graph inGraph){
		StringBuilder sb = new StringBuilder();
		for (Edge e : inGraph.edges){
			sb.append("(" + e.v1 + ", " + e.v2 + ")\n");
		}
		System.out.print(sb.toString());
	}

    public static void main(String[] args) throws IOException{
	    File readFile = new File("input.txt");
	    Scanner myScanner = new Scanner(readFile);

	    Graph myGraph = new Graph();
	    fillGraph(myGraph, myScanner);
	    System.out.print(testGraph(myGraph) ? "OK" : "FAIL");

	    myScanner.close();
    }
}