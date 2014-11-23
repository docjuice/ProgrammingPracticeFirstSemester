import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void reverseList(LinkedNode inList){
		inList.top = inList.reverse(inList.top);
	}

    public static void main(String[] args) throws IOException {
        File readFile = new File("input.txt");
        File writeFile = new File("output.txt");

        Scanner myScanner = new Scanner(readFile);
        PrintWriter myPrintWriter = new PrintWriter(writeFile);

        int n = myScanner.nextInt();

	    LinkedNode list = new LinkedNode();
	    int sizeList = 0;

	    while (myScanner.hasNextByte()){
		    while (myScanner.hasNextByte() && sizeList != 2 * n){
			    list.add(myScanner.nextByte());
			    sizeList++;
		    }

		    reverseList(list);

		    if (sizeList != 2 * n) break;

		    for (int i = 0; i < n; i++){
			    myPrintWriter.print(list.pop() + " ");
			    sizeList--;
		    }

		    reverseList(list);

		    myPrintWriter.println();
	    }

	    while (!list.isEmpty()){
		    myPrintWriter.print(list.pop() + " ");
		    sizeList--;
	    }

        myScanner.close();
        myPrintWriter.close();
    }
}
