import java.io.*;
import java.util.*;

public class Main {

    public static void readMatrix(double[] inMatrix, int N, Scanner inScanner) throws IOException{
        for (int i = 0; i < N * N; ++i){
            inMatrix[i] = inScanner.nextDouble();
        }
    }

    public static void writeMatrix(double[] inMatrix, int N, PrintWriter inPrintWriter) throws IOException{
        for (int i = 0; i < N; ++i, inPrintWriter.println()){
            for (int j = 0; j < N; ++j){
                inPrintWriter.print(inMatrix[i * N  + j] + " ");
            }
        }

        inPrintWriter.println();
    }

    public static void multMatrix(double[] firstMatrix, double[] secondMatrix, double[] resultMatrix, int N){
        for (int i = 0; i < N; ++i){
            for (int j = 0; j < N; ++j){
                int ind = i * N + j;

                resultMatrix[ind] = 0;

                for (int k = 0; k < N; ++k){
                    resultMatrix[ind] += firstMatrix[i * N + k] * secondMatrix[k * N + j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner myScanner = new Scanner(new File("input.txt"));
        PrintWriter myPrintWriter = new PrintWriter(new File("output.txt"));

        int N = myScanner.nextInt();

        double[] firstMatrix = new double[N * N];
        double[] secondMatrix = new double[N * N];
        double[] resultMatrix = new double[N * N];

        readMatrix(firstMatrix, N, myScanner);
        readMatrix(secondMatrix, N, myScanner);
        /*
        writeMatrix(firstMatrix, N, myPrintWriter);
        writeMatrix(secondMatrix, N, myPrintWriter);
        */
        multMatrix(firstMatrix, secondMatrix, resultMatrix, N);

        writeMatrix(resultMatrix, N, myPrintWriter);

        myPrintWriter.close();
    }
}
