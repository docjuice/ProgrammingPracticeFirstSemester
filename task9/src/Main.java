import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static boolean makeRing(LinkedNode inList){
		Random myRandom = new Random();
		boolean make = myRandom.nextBoolean();

		if (make) inList.first.next = inList.top;

		return make;
	}

    public static void main(String[] args) throws IOException{
        File readFile = new File("input.txt");
	    PrintWriter myPrintWriter = new PrintWriter(System.out);

	    int testCount = 20;

	    for (int i = 0; i < testCount; i++){
		    Scanner myScanner = new Scanner(readFile);

		    LinkedNode list = new LinkedNode();
		    while (myScanner.hasNextInt()){
			    list.add(myScanner.nextInt());
		    }

		    boolean isHaveCycle = makeRing(list);

		    if (isHaveCycle == list.isHaveCycle()){
			    myPrintWriter.println("OK");
		    } else{
			    myPrintWriter.println("FAIL");
		    }

		    myScanner.close();
	    }

        myPrintWriter.close();
    }
}
