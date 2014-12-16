import java.io.IOException;

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
        int max = 0;

        for (int i = 1; i <= 140; i++){
            int doGame = game(i, 0, 141);
            if (doGame > max) max = doGame;

            System.out.println(i + " - " + doGame);
        }

        System.out.println("\nmax - " + max);
    }
}
