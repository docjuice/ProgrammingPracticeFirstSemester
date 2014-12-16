import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class myStack {
	private     byte[] bytes;
	private int n, allSize, pointer;
	public int size;

	public myStack(int n){
		bytes = new byte[2 * n];
		this.n = n;
		allSize = 0;
		size = 0;
		pointer = 0;
	}

	public void workWithData(File inFile) throws IOException{
		Scanner sc = new Scanner(inFile);

		while (sc.hasNextByte()){
			if (size == 2 * n){
				popHalfOfBytes();
			}
			pushByte(sc.nextByte());
		}

		if (size > 0){
			popAllBytes();
		}
	}

	public void pushByte(byte b) throws IndexOutOfBoundsException{
		bytes[pointer] = b;
		pointer = (pointer + 1) % (2 * n);
		size++;
		allSize++;
	}

	public byte popByte() throws IndexOutOfBoundsException{
		byte ans = bytes[pointer];
		pointer = (pointer == 0) ? (n - 1) : (pointer - 1);
		return ans;
	}


	private void popHalfOfBytes() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("output.txt"), "rw");
		raf.seek(raf.length());

		try {
			raf.write(bytes, pointer, n);
			size -= n;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Pointer is out of bounds");
		}

		raf.close();
	}

	private void popAllBytes() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("output.txt"), "rw");
		raf.seek(raf.length());

		pointer -= size;
		if (pointer < 0) pointer += 2 * n;

		try {
			if (size <= n){
				raf.write(bytes, pointer, size);
			} else {
				if (pointer == 0){
					raf.write(bytes, pointer, size);
				} else {
					raf.write(bytes, pointer, n);
					raf.write(bytes, 0, size - n);
				}
			}
			size = 0;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Pointer is out of bounds");
		}

		raf.close();
	}

	public void checkUpDataFile(File inFile) throws IOException{
		byte[] arr1 = new byte[allSize];
		Scanner sc = new Scanner(inFile);
		for (int i = 0; i < allSize; i++){
			arr1[i] = sc.nextByte();
		}
		/*
		for (int i = 0; i < allSize; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
        */
		RandomAccessFile raf2 = new RandomAccessFile(new File("output.txt"), "r");
		byte[] arr2 = new byte[allSize];
		raf2.seek(0);
		raf2.read(arr2);
		raf2.close();
		/*
		for (int i = 0; i < allSize; i++){
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
        */
		System.out.println(Arrays.equals(arr1, arr2) ? "OK" : "FAIL");
	}
}
