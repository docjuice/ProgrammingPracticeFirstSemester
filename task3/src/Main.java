import java.util.*;
import java.io.*;

public class Main {

    public static void readVector(ArrayList<Integer> inNumbers, Scanner inScanner){
        while (inScanner.hasNextInt()){
            inNumbers.add(inScanner.nextInt());
        }
    }

    public static int findMaxNumber(ArrayList<Integer> inNumbers, int leftBorder, int rightBorder, int k){
        int x = inNumbers.get(k);
        int i = leftBorder, j = rightBorder;

        while (i <= j){
            while (inNumbers.get(i) > x) i++;
            while (inNumbers.get(j) < x) j--;

            if (i <= j){
                //swap
                int temp = inNumbers.get(i);
                inNumbers.set(i, inNumbers.get(j));
                inNumbers.set(j, temp);
                //
                i++;
                j--;
            }
        }

        if ((leftBorder <= k) && (k <= j)){
            return findMaxNumber(inNumbers, leftBorder, j, k);
        }

        if ((i <= k) && (k <= rightBorder)){
            return findMaxNumber(inNumbers, i, rightBorder, k);
        }

        return inNumbers.get(k);
    }

    public static void main(String[] args) throws IOException{
        Scanner myScanner = new Scanner(new File("input.txt"));
        PrintWriter myPrintWriter = new PrintWriter(new File("output.txt"));

        int k = myScanner.nextInt() - 1;

        ArrayList<Integer> inNumbers = new ArrayList<Integer>();

        readVector(inNumbers, myScanner);

        int kMax = findMaxNumber(inNumbers, 0, inNumbers.size() - 1, k);

        myPrintWriter.print(kMax);

        myPrintWriter.close();
    }
}
