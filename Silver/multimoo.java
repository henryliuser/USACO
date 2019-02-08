import java.util.Scanner;
import java.io.*;
public class multimoo {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("multimoo.in"));
        BufferedWriter out;
        int N = in.nextInt();
        int[][] grid = new int[N][N];
        for (int z = 0; z < N; z++) {
            for (int c = 0; c < N; c++) {
                grid[z][c] = in.nextInt();
            }
        }
        in.close();


    }
}
