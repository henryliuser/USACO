import java.io.*;
import java.util.*;

public class blist2 {
    public static Comparator<Cow> comp = new Comparator<Cow>() {
        @Override
        public int compare(Cow o1, Cow o2) {
            return o1.compareTo(o2);
        }
    };
    static class Cow implements Comparable<Cow>{
        int si, ti, buckets;
        public Cow(int a, int b, int c){
            si = a;
            ti = b;
            buckets = c;
        }

        @Override
        public int compareTo(Cow o) {
            return this.si - o.si;
        }

        public String toString() {
            return si + " " + ti + " " + buckets;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Text Files/blist.in"));
        BufferedWriter out;



        //take input
        int startMin = 56789, endMin = 0;

        int N = in.nextInt();
        Cow[] cows = new Cow[N];
        for (int z = 0; z< N; z++ ) {

                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                if (a < startMin) startMin = a;
                if (b > endMin) endMin = b;
                cows[z] = new Cow(a,b,c);
                System.out.println(cows[z]);

        }

        Arrays.sort(cows,comp);
        int[][] times = new int[endMin][2];
        int counterS = 0, counterT = 0;
        int bucketsInUse = 0;
        int bucketsOutUse = 0;
//        Arrays.fill(times, 0);
        for(int z = 0; z < N; z++) {
            int a = cows[z].si-1;
            int b = cows[z].ti-1;
            int c = cows[z].buckets;
            times[a][0] = 1;
            times[a][1] = c;
            times[b][0] = 2;
            times[b][1] = c;
            counterS++;
            counterT++;
        }
        counterS = 0;
        counterT = 0;
        for (int[] t : times) {
            if (t[0] == 1){
                int b = t[1];

                if (b <= bucketsOutUse) {bucketsOutUse -= b;bucketsInUse +=b;}
                else {
                    bucketsInUse += b;
                    bucketsOutUse = 0;
                }
                counterS++;
            }
            if (t[0] == 2) {
                int b = t[1];
                bucketsInUse -= b;
                bucketsOutUse += b;
                counterT++;
            }
        }

        out = new BufferedWriter(new FileWriter("Text Files/blist.out"));
        out.write(bucketsInUse+bucketsOutUse + "");
        out.close();

    }
}
