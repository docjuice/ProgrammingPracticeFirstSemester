import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

    static public void inOutChar(FileInputStream fis, PrintWriter inPrintWriter, char previousSymbol){
        try{
            char currentSymbol = (char)(fis.read());
            if ((previousSymbol != ' ') || (currentSymbol != ' ')){
                inOutChar(fis, inPrintWriter, currentSymbol);
            }
            inPrintWriter.print(currentSymbol);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) throws IOException {

        File readFile = new File("input.txt");
        File writeFile = new File("output.txt");
        File checkFile = new File("checkerAnswers.txt");

        int testsCount = 100;

        Tester myTester = new Tester();
        //myTester.setAnswersPrintWriterFile(checkFile);

        for (int i = 0; i < testsCount; i++){
            myTester.setTestPrintWriterFile(readFile);
            myTester.generateTest();

            FileInputStream fis = new FileInputStream(readFile);
            PrintWriter myPrintWriter = new PrintWriter(writeFile);
            inOutChar(fis, myPrintWriter, '0');
            fis.close();
            myPrintWriter.close();

            myTester.setInOutCheckFiles(readFile, writeFile);
            myTester.checkAnswer();
        }

        myTester.closeAnswerPrintWriter();
    }
}