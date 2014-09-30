import java.util.*;
import java.io.*;
import java.io.PrintWriter;

public class Main {

    public static void swap(int[] inArray, int ind1, int ind2){
        int temp = inArray[ind1];
        inArray[ind1] = inArray[ind2];
        inArray[ind2] = temp;
    }

    public static void bitReverse(int[] inArray, int lenArray){
        for (int i = 0; i < lenArray / 2; ++i){
            int j = ~i & (lenArray - 1);
            swap(inArray, i, j);
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner myScanner = new Scanner(new File("input.txt"));
        PrintWriter myPrintWriter = new PrintWriter(new File("output.txt"));

        int lenArray = (int)(Math.pow(2, myScanner.nextInt()));

        int[] myArray = new int[lenArray];

        for (int i = 0; i < lenArray; ++i){
            myArray[i] = myScanner.nextInt();
        }

        bitReverse(myArray, lenArray);

        for (int i = 0; i < lenArray; ++i){
            myPrintWriter.print(myArray[i] + " ");
        }

        myPrintWriter.close();

    }
}
