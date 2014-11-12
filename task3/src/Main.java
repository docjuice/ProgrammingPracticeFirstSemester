import java.util.*;
import java.io.*;

public class Main {

    public static void readVector(ArrayList<Integer> inNumbers, Scanner inScanner){
        while (inScanner.hasNextInt()){
            inNumbers.add(inScanner.nextInt());
        }
    }

    public static void swap(ArrayList<Integer> a, int i, int j){
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public static int findMaxNumber(ArrayList<Integer> inNumbers, int leftBorder, int rightBorder, int k){
        int x = inNumbers.get(k);
        int i = leftBorder, j = rightBorder;

        while (i <= j){
            while (inNumbers.get(i) < x) i++;
            while (inNumbers.get(j) > x) j--;

            if (i <= j){
                swap(inNumbers, i, j);
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
        File readFile = new File("input.txt");
        File writeFile = new File("output.txt");
        File checkFile = new File("checkerFile.txt");

        int testsCount = 100;
        Tester myTester = new Tester();
        //myTester.setAnswersPrintWriterFile(checkFile);

        for (int i = 0; i < testsCount; i++){
            myTester.setTestPrintWriterFile(readFile);
            myTester.generateTest();

            Scanner myScanner = new Scanner(readFile);
            PrintWriter myPrintWriter = new PrintWriter(writeFile);
            ArrayList<Integer> inNumbers = new ArrayList<Integer>();

            inNumbers.clear();
            int k = myScanner.nextInt() - 1;
            readVector(inNumbers, myScanner);

            int kMax = findMaxNumber(inNumbers, 0, inNumbers.size() - 1, k);

            myPrintWriter.print(kMax);

            myScanner.close();
            myPrintWriter.close();

            myTester.setInOutCheckFiles(readFile, writeFile);
            myTester.checkAnswer();
        }

        myTester.closeAnswerPrintWriter();
    }
}
