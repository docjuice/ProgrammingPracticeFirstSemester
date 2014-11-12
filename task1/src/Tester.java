import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Tester{

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

            int stringLength = testRandom.nextInt(1000) + 255;

            for (int i = 0; i < stringLength; i++){
                char randomChar = (char)(testRandom.nextInt(26) + (int)('A'));
                testPrintWriter.print(randomChar);
            }
            testPrintWriter.print("  ");
            testPrintWriter.close();
    }

    private static boolean check(String s1, String s2){
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(s2.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public void checkAnswer(){
        String strings1;
        String strings2;

        strings1 = inTestScanner.nextLine();
        inTestScanner.close();

        strings2 = outTestScanner.nextLine();
        outTestScanner.close();

        if (check(strings1, strings2)) {
            answersPrintWriter.print("OK\n");
            } else{
            answersPrintWriter.print("Oops FAIL\n");
            }
    }
}
