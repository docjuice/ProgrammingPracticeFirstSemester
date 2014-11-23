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
        File readFile = new File("input.txt");
	    PrintWriter myPrintWriter = new PrintWriter(System.out);

	    for (int i = 1; i <= 100; i++){
		    generateTest(i, readFile);
		    Scanner myScanner = new Scanner(readFile);

		    int N = myScanner.nextInt();

		    double[] firstMatrix = new double[N * N];
		    double[] secondMatrix = new double[N * N];
		    double[] resultMatrix = new double[N * N];

		    readMatrix(firstMatrix, N, myScanner);
		    readMatrix(secondMatrix, N, myScanner);

		    long startTime1 = System.nanoTime();
		    multMatrix(firstMatrix, secondMatrix, resultMatrix, N);
		    long time1 = System.nanoTime() - startTime1;

		    long startTime2 = System.nanoTime();
		    transporateMatrix(secondMatrix, N);
		    multTranspMatrix(firstMatrix, secondMatrix, resultMatrix, N);
		    long time2 = System.nanoTime() - startTime2;

		    //writeMatrix(resultMatrix, N, myPrintWriter);
		    //myPrintWriter.println(time1/Math.pow(10, 9) + " " + time2/Math.pow(10, 9));
		    myPrintWriter.print("N == " + i + " -> " + (time2 - time1)/(Math.pow(N, 3)) + "\n");

		    myScanner.close();
	    }

	    myPrintWriter.close();
    }
}
