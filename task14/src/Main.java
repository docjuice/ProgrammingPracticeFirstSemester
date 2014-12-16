import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
	// n - vertex count, m - edges count
	static int n, counter;
	static int[] seen = new int[100];
	static int[] low = new int[100];
	static Vector<Integer> stack = new Vector<Integer>();
  	static LinkedList<Vector<Integer>> adj = new LinkedList<Vector<Integer>>();

	public static void dfs(int x, int parent){
		int kids = 0, art = 0;
		low[x] = seen[x] = ++counter;
		stack.add(x);

		if (x > adj.size()) return;

		for (Integer y : adj.get(x)){

			if (y == parent){
				continue;
			}

			if (seen[y] == 0){
				dfs(y, x);

				low[x] = Math.min(low[x], low[y]);
				boolean k = low[y] >= seen[x];
				art = art | (k ? 1 : 0);
				kids++;

				if (low[y] == seen[y]){
					System.out.println("Edge (" + x + ", " + y + ") - bridge");
				}
			} else{
				low[x] = Math.min(low[x], seen[y]);
			}
		}

		if (parent == -1){
			art = (kids >= 2) ? 1 : 0;
		}
		if (art == 1){
			System.out.println("Vertex " + x + " - articulation point");
		}

		if (low[x] == seen[x]){
			System.out.println("Biconnected component:");
			while(true){
				int y = stack.lastElement();
				stack.remove(stack.size() - 1);
				System.out.print(y + " ");
				if (y == x){
					break;
				}
			}
			System.out.println();
		}
	}

    public static void main(String[] args) throws IOException{
	    Scanner sc = new Scanner(new File("input.txt"));
	    n = sc.nextInt();
	    sc.nextLine();

	    adj.add(new Vector<Integer>());

	    for (int i = 1; i <= n; i++){
		    Vector<Integer> a = new Vector<Integer>();
		    String[] s = sc.nextLine().split(" ");
		    for (String k : s){
			    a.add(Integer.parseInt(k));
		    }
		    adj.add(a);
	    }

	    for (int i = 1; i <= n; i++){
		    if (seen[i] == 0){
			    dfs(i, -1);
		    }
	    }
    }
}
