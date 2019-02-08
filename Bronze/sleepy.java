import java.util.Scanner;
import java.io.*;
public class sleepy {
    public static void main(String[] args) throws IOException {
        boolean debug = true;
        String inpath = "sleepy.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/sleepy.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        int[] grid = new int[N];
        for (int z = 0; z < N; z++) {
            grid[z] = in.nextInt();
        }
        in.close();
        int temp = grid[N-1];
        int x = 0;
        for (int z = 1; z <= N; z++) {
            int a = grid[N-z];
            if (a > temp) {
                x = z;
                break;
            }
            else temp = a;
        }
        x +=1;
        BufferedWriter out = new BufferedWriter(new FileWriter("sleepy.out"));
        System.out.println(x);
        out.write((x) + "");
        out.close();
    }
}


