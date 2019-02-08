import java.util.Scanner;
import java.io.*;
public class lifeguard {

    static boolean debug = false;

    public static void main(String[] args) throws IOException {
        String inpath = "Text Files/lifeguards.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/Bronze/lifeguards.in";
        Scanner in = new Scanner(new File(inpath));

        int N = in.nextInt();
        int total = 0;
        int[] grid = new int[1001];
        int[][] cows = new int[N][2];
        for (int z = 0; z < N; z++) {
            int a = in.nextInt();
            int b = in.nextInt();
            cows[z][0] = a;
            cows[z][1] = b;
            for (int z1 = a; z1 < b; z1++) {
                grid[z1] += 1;
                if (grid[z1] == 1) {
                    total++;
                }
            }
        }
        in.close();
        int max = 0;

        for (int[] z : cows) {
            int temp = total;
            for (int x = z[0]; x < z[1]; x++) {
                if (grid[x] == 1) {
                    temp--;
                }
            }
            if (temp > max) {
                max = temp;
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("lifeguards.out"));
        System.out.println(max);
        out.write((max) + "");
        out.close();

    }
}
