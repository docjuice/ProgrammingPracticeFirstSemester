import java.util.*;
import java.io.*;

public class Main {

    public static int game(int x, int min, int max){
        int median = (max - min) / 3 + 1;

        if (min + median - 1 == x){
            return 0;
        }
        if (min + median - 1 > x){
            return game(x, min, min + median - 2) + 2;
        } else{
            return game(x, min + median, max) + 1;
        }
    }

    public static void main(String[] args) throws IOException{
        File readFile = new File("input.txt");
        Scanner myScanner = new Scanner(readFile);
        PrintWriter myPrintWriter = new PrintWriter(System.out);

        int max = 0;

        for (int i = 1; i <= 100; i++){
            int doGame = game(i, 0, 101);
            if (doGame > max) max = doGame;

            myPrintWriter.println(i + " - " + doGame);
        }

        myPrintWriter.println("max - " + max);

        myScanner.close();
        myPrintWriter.close();
    }
}
