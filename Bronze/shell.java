import java.util.Scanner;
import java.io.*;
public class shell {

    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        String inpath = "Text Files/shell.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/Bronze/shell.in";
        Scanner in = new Scanner(new File(inpath));

        int N = in.nextInt();
        int[][] swaps = new int[N][3];

        for (int z = 0; z < N; z++) {
            swaps[z][0] = in.nextInt();
            swaps[z][1] = in.nextInt();
            swaps[z][2] = in.nextInt();
        }

        in.close();

        int max = 0;


        for (int z = 0; z < 3; z++) {
            int[] grid = new int[3];
            grid[z] = 1;
            int counter = 0;
//            int[][] copy = swaps.clone();
            for (int z1 = 0; z1 < N; z1++) {
                int a = swaps[z1][0]-1;
                int b = swaps[z1][1]-1;
                int g = swaps[z1][2]-1;
                int temp = grid[a];
                grid[a] = grid[b];
                grid[b] = temp;
                if (grid[g] == 1) {
                    counter++;
                }
            }
            if (counter > max) {
                max = counter;
            }

        }

        System.out.println(max);
        BufferedWriter out = new BufferedWriter(new FileWriter("shell.out"));
        out.write(max + "");
        out.close();

    }

}
