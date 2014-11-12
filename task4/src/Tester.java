import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tester {

    private Scanner inTestScanner;
    private Scanner outTestScanner;
    private PrintWriter testPrintWriter;
    private PrintWriter answersPrintWriter;

    public Tester(){
        this.answersPrintWriter = new PrintWriter(System.out);
    }

    public void setTestPrintWriterFile(File inFile) throws IOException{
        this.testPrintWriter = new PrintWriter(inFile);
    }

    public void setInOutCheckFiles(File inFile, File outFile) throws IOException{
        this.inTestScanner = new Scanner(inFile);
        this.outTestScanner = new Scanner(outFile);
    }

    public void setAnswersPrintWriterFile(File checkAnsFile) throws IOException{
        this.answersPrintWriter = new PrintWriter(checkAnsFile);
    }

    public void closeAnswerPrintWriter(){
        answersPrintWriter.close();
    }

    public void generateTest(){
        Random testRandom = new Random();
        int k = testRandom.nextInt(10) + 1;
        int length = (int)Math.pow(2, k);

        testPrintWriter.println(k);

        for (int i = 0; i < length; i++){
            testPrintWriter.print(testRandom.nextInt(1000) + " ");
        }
        testPrintWriter.close();
    }

    private static boolean check(int[] a, int[] b){
        return Arrays.equals(a, b);
    }

    public static int bitReverse(int x, int k){
        String s = "";

        while (x > 0){
            int mod = x % 2;
            s = (char)(mod + '0') + s;
            x /= 2;
        }

        while (s.length() < k){
            s = '0' + s;
        }

        int answer = 0;
        for (int i = 0; i < s.length(); i++){
            answer += (s.charAt(i) - '0') * (int)Math.pow(2, i);
        }

        return answer;
    }

    public static void ArrayBitReverse(int[] inArray, int lenArray, int k){
        for (int i = 0; i < lenArray; ++i){
            int j = bitReverse(i ,k);
            if (j >= i){
                int temp = inArray[i];
                inArray[i] = inArray[j];
                inArray[j] = temp;
            }
        }
    }

    public void checkAnswer(){

        int k = inTestScanner.nextInt();
        int length = (int)Math.pow(2, k);
        int[] a = new int[length];
        for (int i = 0; i < length; i++){
            a[i] = inTestScanner.nextInt();
        }
        inTestScanner.close();
        ArrayBitReverse(a, length, k);

        int[] b = new int[length];
        for (int i = 0; i < length; i++){
            b[i] = outTestScanner.nextInt();
        }
        outTestScanner.close();

        if (check(a, b)) {
            answersPrintWriter.print("OK\n");
            } else{
            answersPrintWriter.print("Oops FAIL\n");
            }
    }
}
