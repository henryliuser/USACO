import java.util.*;
import java.io.*;

public class cowjogBad {
    static boolean debug = false;

    static boolean done(int[][] c) {
        for (int z = 0; z < c.length; z++) {
            int[] current = c[z];
            for (int a = z+1; a < c.length; a++) {
                if (c[a][1] < current[1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String inpath = "cowjog.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/cowjog.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        int[][] cows = new int[N][2]; //[x] = cow at x | [x][0] = position | [x][1] = speed
        for (int z = 0; z < N; z++) {
            cows[z][0] = in.nextInt();
            cows[z][1] = in.nextInt();
        }
        in.close();
//        Arrays.sort(cows, Comparator.comparing((int[] z) -> z[0]));

        int numGroups = 0;
        while (!done(cows)) {
            for (int z = N-1; z >=0; z--) {

                int[] current = cows[z];
                current[0] += current[1];
                if (z == N-1) continue;
                int[] next = cows[z+1];
                if (current[0] >= next[0]) {
                    current[0] = next[0]-1;
                    current[1] = next[1];
                }

            }
        }

        for (int z = N-1; z >0; z--) {
            int[] current = cows[z];
            int currPos = current[0];
            int currSpd = current[1];

            for (int a = z-1; a >= 0; a--) {
                int[] consec = cows[a];
                if (currPos == consec[0] + 1 && currSpd == consec[1]) {
                    if (a == 0) numGroups++;
                    currPos--;
                }
                else if (a == 0) {
                    numGroups += 2;
                    z = a;
                }
                else {
                    numGroups++;
                    z = a;
                    break;
                }
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("cowjog.out"));
        out.write(numGroups + "");
        System.out.println(numGroups);
        out.close();


    }
}
