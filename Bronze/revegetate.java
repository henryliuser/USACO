import java.util.*;
import java.io.*;
public class revegetate {
    static boolean debug = false;

    static class Pasture {
        Cow[] favorites = new Cow[3];
        int grass;
        Pasture(int a){
            grass = a;
        }
    }

    static class Cow {

        Pasture[] favorites = new Pasture[2];
        public Cow(Pasture a, Pasture b) {
            favorites[0] = a;
            favorites[1] = b;
        }
    }
    static boolean done = false;

    static void oni(int i, int[] x) throws IOException {

        for (int a = 0; a < 4; a++) {
            if (done) return;
            if (x[1] == 1) {
                System.out.print("");
            }
            x[i] = a;
            if (i+1 != x.length) oni(i+1, x);
            else {
                if (done) return;
                if (check(x)) {
                    for(int z = 0; z < N; z++) {
                        out.write(x[z]+1 + "");
                        System.out.print(x[z]+1);
                    }
                    done = true;
                    return;
                }
            }
        }

    }

    static boolean check(int[] x) {
        for (int z = 0; z < M; z++) {
            int a = illegalPairs[z][0]-1;
            int b = illegalPairs[z][1]-1;
            if (x[a] == x[b]) return false;
        }
        return true;
    }

//    static boolean isValid(int[] x) {
//        for (int z = 0; z < x.length; z++) {
//            pastures[z].grass=x[z]+1;
//        }
//        for (Cow e: cows) {
//            if (e.favorites[0].grass == e.favorites[1].grass) return false;
//        }
//        return true;
//    }


    static Pasture[] pastures;
    static Cow[] cows;
    static BufferedWriter out;
    static int N, M;
    static int[][] illegalPairs;

    public static void main(String[] args ) throws IOException {
        String inpath = "revegetate.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/revegetate.in";
        Scanner in = new Scanner(new File(inpath));
        N = in.nextInt();
        M = in.nextInt();
        pastures = new Pasture[N];
        cows = new Cow[M];
        illegalPairs = new int[M][2];

        for (int z = 0; z < N; z++) {
            pastures[z] = new Pasture(5);
        }
        for (int z = 0; z < M; z++) {
            int a = in.nextInt();
            int b = in.nextInt();
            illegalPairs[z][0] = a;
            illegalPairs[z][1] = b;
            cows[z] = new Cow(pastures[a-1],pastures[b-1]);
        }
        int[] ans = new int[N];
        out = new BufferedWriter(new FileWriter("revegetate.out"));
        oni(0,ans);
        out.write("\n");
        out.close();

    }
}
