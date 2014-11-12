import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

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
        int length = testRandom.nextInt(100) + 1;
        int k = testRandom.nextInt(length) + 1;
        testPrintWriter.println(k);

        for (int i = 0; i < length; i++){
            testPrintWriter.print(testRandom.nextInt(1000) + " ");
        }
        testPrintWriter.close();
    }

    private static boolean check(int k, Integer[] s, int answer){
        Arrays.sort(s);
        return (s[k] == answer);
    }

    public void checkAnswer(){
        Vector<Integer> a = new Vector<Integer>();
        int k = inTestScanner.nextInt() - 1;
        while (inTestScanner.hasNext()){
            a.add(inTestScanner.nextInt());
        }
        inTestScanner.close();

        Integer[] s = new Integer[a.size()];
        a.toArray(s);

        int answer = outTestScanner.nextInt();

        if (check(k, s, answer)) {
            answersPrintWriter.print("OK\n");
            } else{
            answersPrintWriter.print("Oops FAIL\n");
            }
    }
}
