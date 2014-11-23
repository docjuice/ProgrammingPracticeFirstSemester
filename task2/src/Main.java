import java.util.*;
import java.io.*;

public class Main {

    public static void reverseList(LinkedNode inList, Scanner inScanner, PrintWriter inPrintWriter){
        while (inScanner.hasNext()){
            inList.add(inScanner.next());
        }

	    inList.top = inList.reverse(inList.top);

        while (!inList.isEmpty()){
            inPrintWriter.print(inList.pop() + " ");
        }
    }

    public static void main(String[] args) throws IOException {

        File readFile = new File("input.txt");
        File writeFile = new File("output.txt");

        int testsCount = 100;
        LinkedNode list = new LinkedNode();

        Tester myTester = new Tester();

        for (int i = 0; i < testsCount; i++){
            myTester.setTestPrintWriterFile(readFile);
            myTester.generateTest();

            Scanner myScanner = new Scanner(readFile);
            PrintWriter myPrintWriter = new PrintWriter(writeFile);
            reverseList(list, myScanner, myPrintWriter);

            myScanner.close();
            myPrintWriter.close();

            myTester.setInOutCheckFiles(readFile, writeFile);
            myTester.checkAnswer();
        }

        myTester.closeAnswerPrintWriter();
    }
}
