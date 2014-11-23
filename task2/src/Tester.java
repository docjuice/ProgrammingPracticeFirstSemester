import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
        int wordsCount = testRandom.nextInt(100) + 1;

        for (int j = 0; j < wordsCount; j++){
            int stringLength = testRandom.nextInt(20) + 1;

            for (int i = 0; i < stringLength; i++){
                char randomChar = (char)(testRandom.nextInt(26) + (int)('a'));
                testPrintWriter.print(randomChar);
            }
            testPrintWriter.print(" ");
        }

        testPrintWriter.close();
    }

    private static boolean check(Vector<Object> s1, Vector<Object> s2){
        for (int i = 0; i < s1.size(); i++){
            if (!s1.get(i).equals(s2.get(i))){
                return false;
            }
        }
        return true;
    }

    public void checkAnswer(){
        Vector<Object> s1 = new Vector<Object>();
        Vector<Object> s2 = new Vector<Object>();

        while (inTestScanner.hasNext()){
            s1.add(inTestScanner.next());
        }
        inTestScanner.close();

        while (outTestScanner.hasNext()){
            s2.add(outTestScanner.next());
        }
        outTestScanner.close();

        if (check(s1, s2)) {
            answersPrintWriter.print("OK\n");
            } else{
            answersPrintWriter.print("Oops FAIL\n");
            }
    }
}
