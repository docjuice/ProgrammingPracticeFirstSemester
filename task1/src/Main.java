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

        FileInputStream fis = new FileInputStream(readFile);
        PrintWriter myPrintWriter = new PrintWriter(writeFile);

        int testsCount = 100;

        Tester myTester = new Tester();
        myTester.setTestPrintWriterFile(readFile);
        myTester.setTestsCount(testsCount);
        myTester.generateTest();

        for (int i = 0; i < testsCount; i++){
            inOutChar(fis, myPrintWriter, '0');
            myPrintWriter.print('\n');
            fis.read();            // ignore endLine symbol
        }
        fis.close();
        myPrintWriter.close();

        myTester.setInOutCheckFiles(readFile, writeFile, checkFile);
        myTester.checkAnswers();
    }
}