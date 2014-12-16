import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

	static Stack<Integer> numbersStack(int N){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = N; i > 0; i--){
			stack.push(i);
		}
		return stack;
	}

	static Stack<Integer> recursive(int N){
		Stack<Integer> A = numbersStack(N);
		Stack<Integer> B = new Stack<Integer>();
		Stack<Integer> C = new Stack<Integer>();

		if (N != 0){
			transposition(N, A, B, C);
		}
		return C;
	}

	static void transposition(int N, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C){
		if(N == 1){
			C.push(A.pop());
		}
		else{
			transposition(N - 1, A, C, B);
			C.push(A.pop());
			transposition(N - 1, B, A, C);
		}
	}

	static Stack<Integer> nonRecursive(int n){
		int[] positions = new int[n + 1];

		Stack<Integer> A = numbersStack(n);
		Stack<Integer> B = new Stack<Integer>();
		Stack<Integer> C = new Stack<Integer>();

		List<Stack> list = new LinkedList<Stack>();
		list.add(A);
		list.add(B);
		list.add(C);

		for(int i = 1; i <= n; i++){
			positions[i] = 0;
		}

		int a = (n + 1) % 2;

		for(int i = 1; i < (int)Math.pow(2 , n); i++) {
			int ring = ringCount(i);
			int nextPosition = (positions[ring] + 3 + (int)Math.pow(-1, ring + a)) % 3;

			list.get(nextPosition).push(list.get(positions[ring]).pop());
			positions[ring] = nextPosition;

			System.out.println("ring № " + ring + " -> " + (positions[ring] + 1));
		}

		return C;
	}

	static int ringCount(int x){
		int ans = 1;
		while(x % 2 != 1){
			ans++;
			x /= 2;
		}
		return ans;
	}

	public static void main(String[] args) {
		int N = 10;
		Stack st1 = nonRecursive(N);
		Stack st2 = recursive(N);
		System.out.println((st1.equals(st2) ? "OK" : "FAIL") + " - " + N);
	}
}
