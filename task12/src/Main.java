import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static boolean test(Scanner sc, String answer){
		HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
		String[] s = sc.nextLine().split(" ");
		for (int i = 0; i < s.length; i++){
			if (myHashMap.containsKey(s[i])){
				myHashMap.put(s[i], myHashMap.get(s[i]) + 1);
			} else {
				myHashMap.put(s[i], 1);
			}
		}

		String[] rightSplittedAns = answer.split(" ");
		String[] splittedAns = new String[myHashMap.size()];
		int i = 0;
		for (Map.Entry entry : myHashMap.entrySet()) {
			splittedAns[i] = entry.getKey().toString() + "-" + entry.getValue().toString();
			i++;
		}

		Arrays.sort(splittedAns);
		Arrays.sort(rightSplittedAns);

		for (int j = 0; j <  rightSplittedAns.length; j++){
			if (!splittedAns[j].equals( rightSplittedAns[j])) return false;
		}

		return true;
	}

    public static void main(String[] args) throws IOException{
	    File readFile = new File("input.txt");

	    Scanner myScanner = new Scanner(readFile);
	    PrintWriter myPrintWriter = new PrintWriter(System.out);

	    String test1 = "0-1 1-6 2-1 3-2 9-2",
			   test2 = "masdawww-1",
			   test3 = "one-5 two-2 three-1 four-2 fourfour-1 oneoneone-1 five-1 six-1 seven-1 oneone-1";

	    myPrintWriter.print(test(myScanner, test1) ? "OK" : "FAIL");
	    myPrintWriter.print("\n" + (test(myScanner, test2) ? "OK" : "FAIL"));
	    myPrintWriter.print("\n" + (test(myScanner, test3) ? "OK" : "FAIL"));

	    myScanner.close();
	    myPrintWriter.close();
    }
}
