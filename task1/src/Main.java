import java.io.*;

public class Main {

    static public void inOutChar(BufferedReader fis, FileOutputStream fos, char previousSymbol)
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

        BufferedReader fis = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fos = new FileOutputStream(new File("output.txt"));

        inOutChar(fis, fos, '0');

    }

}