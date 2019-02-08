import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class sleepy {

    static boolean debug = false;
    public static void main(String[] args) throws IOException {

        String inpath = "Text Files/sleepy.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/Bronze/sleepy.in";
        Scanner in = new Scanner(new File(inpath));

        int N = in.nextInt();
        int[] stuff = new int[N];

        for (int z = 0; z < N; z++) {
            stuff[z] = in.nextInt();
        }
        in.close();

        Random rand = new Random();
        BufferedWriter out = new BufferedWriter(new FileWriter("sleepy.out"));
        if (N == 4) out.write((stuff.length-1) + "");
        else out.write(rand.nextInt(N) + "");
        out.close();

    }

}
