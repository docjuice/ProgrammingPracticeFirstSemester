import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void swap(int[] inArray, int ind1, int ind2){
        int temp = inArray[ind1];
        inArray[ind1] = inArray[ind2];
        inArray[ind2] = temp;
    }

    public static int bitReverse(int x, int k){
        int answer = 0;
        for (int i = 0; i < k; i++){
            int d = x & 1;
            answer = (answer << 1) | d;
            x >>= 1;
        }
        return answer;
    }

    public static void ArrayBitReverse(int[] inArray, int lenArray, int k){
        for (int i = 0; i < lenArray; ++i){
            int j = bitReverse(i ,k);
            if (j >= i){
                swap(inArray, i, j);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        File readFile = new File("input.txt");
        File writeFile = new File("output.txt");
        File checkFile = new File("checkerFile.txt");

        int testsCount = 100;
        Tester myTester = new Tester();
        myTester.setAnswersPrintWriterFile(checkFile);

        for (int j = 0; j < testsCount; j++){
            myTester.setTestPrintWriterFile(readFile);
            myTester.generateTest();

            Scanner myScanner = new Scanner(readFile);
            PrintWriter myPrintWriter = new PrintWriter(writeFile);

            int k = myScanner.nextInt();
            int lenArray = (int)(Math.pow(2, k));
            int[] myArray = new int[lenArray];

            for (int i = 0; i < lenArray; ++i){
                myArray[i] = myScanner.nextInt();
            }

            ArrayBitReverse(myArray, lenArray, k);

            for (int i = 0; i < lenArray; ++i){
                myPrintWriter.print(myArray[i] + " ");
            }

            myScanner.close();
            myPrintWriter.close();

            myTester.setInOutCheckFiles(readFile, writeFile);
            myTester.checkAnswer();
        }

        myTester.closeAnswerPrintWriter();
    }
}
