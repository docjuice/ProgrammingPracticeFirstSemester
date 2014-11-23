import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		File readFile = new File("input.txt");
		Scanner myScanner = new Scanner(readFile);
		PrintWriter myPrintWriter = new PrintWriter(System.out);

		String s = myScanner.nextLine();

		BinTree myTree = new BinTree();
		for (int i = 0; i < s.length(); i++){
			myTree.add(s.charAt(i));
		}

		myTree.recPreOrder(myTree.root);
		myPrintWriter.println(myTree.root.string);

		myScanner.close();
		myPrintWriter.close();

	}
}
