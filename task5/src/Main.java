import java.io.*;
import java.util.*;

public class Main {

    public static void transporateMatrix(double[] inMatrix, int N){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < i; j++){
                double temp = inMatrix[i * N + j];
                inMatrix[i * N + j] = inMatrix[j * N + i];
                inMatrix[j * N + i] = temp;
            }
        }
    }

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
                resultMatrix[i * N + j] = 0;
                for (int k = 0; k < N; ++k){
                    resultMatrix[i * N + j] += firstMatrix[i * N + k] * secondMatrix[k * N + j];
                }
            }
        }
    }

    public static void multTranspMatrix(double[] firstMatrix, double[] secondMatrix, double[] resultMatrix, int N){
        for (int i = 0; i < N; ++i){
            for (int j = 0; j < N; ++j){
                resultMatrix[i * N + j] = 0;
                for (int k = 0; k < N; ++k){
                    resultMatrix[i * N + j] += firstMatrix[i * N + k] * secondMatrix[j * N + k];
                }
            }
        }
    }

	public static void generateTest(int n, File inFile) throws IOException{
		PrintWriter myTestPW = new PrintWriter(inFile);
		Random testRandom = new Random();

		myTestPW.println(n);

		for (int i = 0; i < n * n; i++){
			myTestPW.print(testRandom.nextInt(10000) + "," + testRandom.nextInt(10000) + " ");
		}
		myTestPW.println();

		for (int i = 0; i < n * n; i++){
			myTestPW.print(testRandom.nextInt(10000) + "," + testRandom.nextInt(10000) + " ");
		}
		myTestPW.println();

		myTestPW.close();
	}

    public static void main(String[] args) throws IOException{

	    for (int j = 1; j <= 10; j++){
		    int N = 1 << (0 + j);

		    double[] firstMatrix = new double[N * N];
		    double[] secondMatrix = new double[N * N];
		    double[] resultMatrix = new double[N * N];


		    long startTime1 = System.nanoTime();
		    multMatrix(firstMatrix, secondMatrix, resultMatrix, N);
		    long time1 = System.nanoTime() - startTime1;

		    transporateMatrix(secondMatrix, N);
		    long startTime2 = System.nanoTime();
		    multTranspMatrix(firstMatrix, secondMatrix, resultMatrix, N);
		    long time2 = System.nanoTime() - startTime2;

		    //writeMatrix(resultMatrix, N, myPrintWriter);
		    //myPrintWriter.println(time1/Math.pow(10, 9) + " " + time2/Math.pow(10, 9));
		    System.out.print("N == " + N + ":\n" +
				    "без транспонирования: " + time1/(Math.pow(N, 3)) + "\n" +
				    "с транспонированием: " + time2/(Math.pow(N, 3)) + "\n" +
				    "ассимптотическая разница: " +  ((double)time1/time2) + "\n\n");

	    }

    }
}
