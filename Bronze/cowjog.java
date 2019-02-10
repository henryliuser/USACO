import java.util.*;
import java.io.*;
public class cowjog {
    static boolean debug = true;
    public static void main(String[] args) throws IOException {
        String inpath = "cowjog.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/cowjog2.in";
        Scanner in = new Scanner( new File(inpath));
        int N = in.nextInt();
        int[] speeds = new int[N];
        for (int z = 0; z < N; z++) {
            in.nextInt();
            speeds[z] = in.nextInt();
        }

        int slowest = speeds[N-1];
        int numGroups = 1;
        for (int z = N-2; z>=0; z--) {
            if (speeds[z] > slowest);
            else numGroups++;
            slowest = Math.min(slowest,speeds[z]);
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("cowjog.out"));
        System.out.println(numGroups);
        out.write(numGroups+"");
        out.close();
    }
}
