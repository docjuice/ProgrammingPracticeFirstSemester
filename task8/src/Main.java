import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void swap(Vector<Integer> a, int i, int j){
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public static void qsort(Vector<Integer> a, int l, int r){
        do {
            int i = l, j = r, med = a.get((i + j) / 2);

            do {
                while (a.get(i) < med) i++;
                while (a.get(j) > med) j--;
                if (i <= j){
                    if (i < j) swap(a, i, j);
                    i++;
                    j--;
                }
            } while (i <= j);

            if (j - l < r - i){
                if (l < j) qsort(a, l, j);
                l = i;
            } else{
                if (i < r) qsort(a, i, r);
                r = j;
            }
        } while (l != r);
    }

    public static void main(String[] args) throws IOException {
        File readFile = new File("input.txt");
        File writeFile = new File("output.txt");

        int testsCount = 100;
        Tester myTester = new Tester();

        for (int j = 0; j < testsCount; j++){
            myTester.setTestPrintWriterFile(writeFile);
            myTester.generateTest();

            Scanner myScanner = new Scanner(readFile);
            PrintWriter myPrintWriter = new PrintWriter(writeFile);

            Vector<Integer> a = new Vector<Integer>();

            while (myScanner.hasNextInt()){
                a.add(myScanner.nextInt());
            }

            qsort(a, 0, a.size() - 1);

            for (int i: a){
                myPrintWriter.print(a.get(i) + " ");
            }

            myScanner.close();
            myPrintWriter.close();

            myTester.setInOutCheckFiles(readFile, writeFile);
            myTester.checkAnswer();
        }

        myTester.closeAnswerPrintWriter();
    }
}
