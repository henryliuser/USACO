import java.io.*;
import java.util.*;
public class cowjogSilver {
    static boolean debug = true;
    public static void main(String[] ars) throws IOException {
        String inpath = "cowjog.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/cowjog2.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        int T = in.nextInt();
        int[][] cows = new int[N][2];
        for (int z = 0; z < N; z++) {
            cows[z][0] = in.nextInt();
            cows[z][1] = in.nextInt();
        }
        in.close();
        int numGroups = 0;

        int speed = cows[N-1][1];
        int pos = cows[N-1][0];
        for (int z = N-2; z >= 0; z--) {
            if (cows[z][1] > speed) {
                cows[z][0] = --pos;
                cows[z][1] = speed;
            }
            else {
                speed = cows[z][1];
                pos = cows[z][0];
            }
        }
        for (int b = 0; b < T; b++) {
            for (int z = N-1; z >0;) {
                int[] current = cows[z];
                int currPos = current[0];
                int currSpd = current[1];

                for (int a = z-1; a >= 0; a--) {
                    int[] consec = cows[a];
                    if (currPos == consec[0] + 1 && currSpd == consec[1]) {
                        if (a == 0) {
                            numGroups++;
                            z = a;
                        }
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
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("cowjog.out"));
        out.write(numGroups + "");
        System.out.println(numGroups);
        out.close();
    }
}
