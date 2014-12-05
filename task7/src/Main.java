import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

	public static void reverseList(LinkedNode inList){
		inList.top = inList.reverse(inList.top);
	}

	public static void unload(LinkedNode list, int n, File inFile) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(inFile, "rw");

		for (int i = 0; i < n; i++){
			raf.seek(raf.length());
			raf.writeBytes(list.pop() + " ");
		}

		raf.seek(raf.length());
		raf.writeBytes("\n");
		raf.close();
	}

    public static void main(String[] args) throws IOException {
        File readFile = new File("input.txt");
	    File writeFile = new File("output.txt");

	    Scanner myScanner = new Scanner(readFile);

        int n = myScanner.nextInt();

	    LinkedNode list = new LinkedNode();

	    while (myScanner.hasNextByte()){
		    while (myScanner.hasNextByte() && list.size != 2 * n){
			    list.add(myScanner.nextByte());
		    }
		    reverseList(list);
		    if (list.size != 2 * n){
			    break;
		    }
		    unload(list, n, writeFile);
		    reverseList(list);
	    }

	    if (list.size == n){
		    reverseList(list);
	    }
	    unload(list, list.size, writeFile);

        myScanner.close();
    }
}
