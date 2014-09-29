import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    static public void inOutChar(FileInputStream fis, FileOutputStream fos, char previousSymbol)
    {
        try {
            char currentSymbol = (char)(fis.read());

            if ((currentSymbol != ' ') || (previousSymbol != ' ')){
                inOutChar(fis, fos, currentSymbol);
            }

            fos.write(currentSymbol);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) throws IOException {

        FileInputStream fis = new FileInputStream(new File("input.txt"));
        FileOutputStream fos = new FileOutputStream(new File("output.txt"));

        inOutChar(fis, fos, '0');

    }

}