import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        File readFile = new File("input.txt");
        File writeFile = new File("output.txt");

        LinkedNode list = new LinkedNode();

        Scanner myScanner = new Scanner(readFile);
        PrintWriter myPrintWriter = new PrintWriter(writeFile);

        int N = myScanner.nextInt();

        while (myScanner.hasNextByte()){
            if (list.size == N){
                while (!list.isEmpty()){
                    myPrintWriter.print(list.pop() + " ");
                }
            } else{
                list.add(myScanner.nextByte());
            }
        }

        while (list.top != null){
            myPrintWriter.print(list.pop() + " ");
        }

        myScanner.close();
        myPrintWriter.close();
    }
}
