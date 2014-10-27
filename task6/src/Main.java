import java.util.*;
import java.io.*;

public class Main {

    public static int game(int x){
        int answer = 0,
            leftBorder = 0,
            rightBorder = 101,
            supposX = (leftBorder + rightBorder) / 2;

        while (supposX != x){
            if (supposX < x){
                answer += 1;
                leftBorder = supposX;
            }
            if (supposX > x){
                answer += 2;
                rightBorder = supposX;
            }

            supposX = (leftBorder + rightBorder) / 2;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        Scanner myScanner = new Scanner(new File("input.txt"));
        PrintWriter myPrintWriter = new PrintWriter(new File("output.txt"));

        for (int i = 1; i <= 100; i++){
            myPrintWriter.println(i + " - " + game(i));
        }

        myPrintWriter.close();
    }
}
