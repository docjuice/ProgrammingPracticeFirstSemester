import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    File rf = new File("input.txt");
	    myStack stack;

	    for (int n = 1; n <= 50; n++){
		    stack = new myStack(n);
		    stack.workWithData(rf);
		    stack.checkUpDataFile(rf);

	    }
	}
}
