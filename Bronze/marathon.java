import java.util.Scanner;
import java.io.*;
public class marathon {
    static boolean debug = false;

    static int distance(int[] x, int[] y) {
        return Math.abs(x[0]-y[0]) + Math.abs(x[1]-y[1]);
    }

    public static void main(String[] args) throws IOException {
        String inpath = "marathon.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/marathon.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        int[][] checkpoints = new int[N][2];
        int totalDistance = 0;
        int[] currentPos = {0,0};
        for (int z = 0; z < N; z++) {
            checkpoints[z][0] = in.nextInt();
            checkpoints[z][1] = in.nextInt();
            if (z == 0) currentPos = checkpoints[z].clone();
            totalDistance += distance(currentPos, checkpoints[z]);
            currentPos = checkpoints[z].clone();
        }
        in.close();

        int max = 0;
        for (int z = 1; z < N-1; z++) {
            int[] C = checkpoints[z];
            int[] pos = checkpoints[z-1];
            int[] next = checkpoints[z+1];
            int temp = Math.abs(distance(pos,next) - (distance(pos, C) + distance(C, next)) );
            if (temp > max) max = temp;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("marathon.out"));
        int ans = totalDistance-max;
        System.out.println(ans);
        out.write(ans + "\n");
        out.close();


    }
}
