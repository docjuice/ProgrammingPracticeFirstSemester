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
    private int testsCount;

    public void setTestPrintWriterFile(File inFile) throws IOException{
        this.testPrintWriter = new PrintWriter(inFile);
    }

    public void setInOutCheckFiles(File inFile, File outFile, File checkAnsFile) throws IOException{
        this.inTestScanner = new Scanner(inFile);
        this.outTestScanner = new Scanner(outFile);
        this.answersPrintWriter = new PrintWriter(checkAnsFile);
    }

    public void setTestsCount(int testsCount){
        this.testsCount = testsCount;
    }

    public void generateTest(){
        Random testRandom = new Random();

        for (int j = 0; j < testsCount; j++){
            int stringLength = testRandom.nextInt(1000) + 255;

            for (int i = 0; i < stringLength; i++){
                char randomChar = (char)(testRandom.nextInt(26) + (int)('A'));
                testPrintWriter.print(randomChar);
            }
            testPrintWriter.print("  \n");
        }
        testPrintWriter.close();
    }

    private static boolean check(String s1, String s2){
        boolean answer = true;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(s2.length() - i - 1)) answer = false;
        }
        return answer;
    }

    public void checkAnswers(){
        String[] strings1 = new String[testsCount];
        String[] strings2 = new String[testsCount];

        for (int i = 0; i < testsCount; i++){
            strings1[i] = inTestScanner.nextLine();
        }
        inTestScanner.close();

        for (int i = 0; i < testsCount; i++){
            strings2[i] = outTestScanner.nextLine();
        }
        outTestScanner.close();

        for (int i = 0; i < testsCount; i++){
            answersPrintWriter.print(i + 1 + ".)");
            if (check(strings1[i], strings2[i])){
                answersPrintWriter.print("OK\n");
            } else{
                answersPrintWriter.print("FAIL\n");
            }
        }
        answersPrintWriter.close();
    }
}
