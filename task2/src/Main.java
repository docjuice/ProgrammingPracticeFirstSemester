import java.util.*;
import java.io.*;

public class Main {

    public static void reverseList(LinkedList<String> inList, Scanner inScanner, PrintWriter inPrintWriter){

            if (inScanner.hasNext()){
                inList.addLast(inScanner.next());
                reverseList(inList, inScanner, inPrintWriter);
            }

        if (!(inList.isEmpty())){
            inPrintWriter.println(inList.getLast());
            inList.removeLast();
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner myScanner = new Scanner(new File("input.txt"));
        PrintWriter myPrintWriter = new PrintWriter(new File("output.txt"));

        LinkedList<String> list = new LinkedList<String>();

        reverseList(list, myScanner, myPrintWriter);

        myPrintWriter.close();
    }
}
