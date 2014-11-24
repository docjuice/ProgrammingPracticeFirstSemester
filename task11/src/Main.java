import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static boolean isEndScanning(TreeSet<Double> inTree, Double delta){
		Iterator<Double> i = inTree.iterator();

		Double b = 0.0;
		if (i.hasNext()) b = i.next();

		while (i.hasNext()){
			Double a = i.next();
			if (Math.abs(a - b) <= delta) return true;
			b = a;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		File readFile = new File("input.txt");
		Scanner myScanner = new Scanner(readFile);
		PrintWriter myPrintWriter = new PrintWriter(System.out);

		Double d = myScanner.nextDouble();

		TreeSet<Double> myTree = new TreeSet<Double>();

		if (myScanner.hasNextDouble()) myTree.add(myScanner.nextDouble());

		while (myScanner.hasNextDouble()){
			if (isEndScanning(myTree, d)) break;
			myTree.add(myScanner.nextDouble());
		}

		for (Double i: myTree) myPrintWriter.print(i + " ");

		myScanner.close();
		myPrintWriter.close();
	}
}