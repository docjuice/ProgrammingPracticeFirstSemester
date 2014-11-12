import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        int numCount = testRandom.nextInt(1000) + 1;

        for (int i = 0; i < numCount; i++){
            testPrintWriter.print(testRandom.nextInt(1000000) + " ");
        }

        testPrintWriter.close();
    }

    private static boolean check(Integer[] a, ArrayList b){
        Arrays.sort(a);

        for (int i = 0; i < b.size(); i++){
            if (a[i] != b.get(i)) return false;
        }

        return true;
    }

    public void checkAnswer(){
        ArrayList<Integer> b = new ArrayList<Integer>();
        while (outTestScanner.hasNextInt()){
            b.add(outTestScanner.nextInt());
        }
        outTestScanner.close();

        Integer[] a = new Integer[b.size()];
        for (int i = 0; i < b.size(); i++){
            a[i] = inTestScanner.nextInt();
        }
        inTestScanner.close();

        if (check(a, b)) {
            answersPrintWriter.print("OK\n");
            } else{
            answersPrintWriter.print("Oops FAIL\n");
            }
    }
}
