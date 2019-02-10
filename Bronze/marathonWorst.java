import java.util.*;
import java.io.*;

public class marathonWorst {
    static boolean debug = false;

    static int distance(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }

    public static void main(String[] ars) throws IOException {
        String inpath = "marathon.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/marathon.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        int[][] checks = new int[N][2];
        int totalDistance = 0;
        int[] currentPositio = {0,0};
        for (int z = 0; z < N; z++) {
            checks[z][0] = in.nextInt();
            checks[z][1] = in.nextInt();
//            totalDistance += distance(currentPosition, checks[z]);
//            currentPosition = checks[z].clone();
        }
        int min = Integer.MAX_VALUE;
        currentPositio[0] = checks[0][0];
        currentPositio[1] = checks[0][1];
        for (int a = 1; a < N-1; a++) {
            int[] z = checks[a];
            int[] currentPosition = currentPositio.clone();
            totalDistance = 0;
            for (int[] x: checks) {
                if (x == z) continue;
                totalDistance += distance(currentPosition, x);
                currentPosition[0] = x[0];
                currentPosition[1] = x[1];
            }
            if (totalDistance < min) min = totalDistance;
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("marathon.out"));
        out.write(min + "\n");
        out.close();
        System.out.println(min);

    }
}
