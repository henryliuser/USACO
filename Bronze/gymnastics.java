import java.util.*;
import java.io.*;
public class gymnastics {

    static class Gymnast implements Comparable{
        int num = 0;
        ArrayList<Gymnast> below = new ArrayList();
        Gymnast(int a) {num = a;}
        @Override
        public int compareTo(Object a) {
            Gymnast b = (Gymnast)a;
            return this.num-b.num;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("gymnastics.in"));
        int K = in.nextInt();
        int N = in.nextInt();
        int consistent = N;
        Gymnast[] standard = new Gymnast[N];
        HashMap<Integer,Gymnast> g = new HashMap();
        for (int z = 0; z < N; z++) { //populate the standard array
            Gymnast temp = new Gymnast(in.nextInt());
            standard[z] = temp;
            g.put(z,temp);
        }
        for (int z = 0; z< N; z++) {
            for (int a = z+1; a < N; a++){ //establishes which cows are below it
                standard[z].below.add(standard[a]);
            }
        }
        for (Gymnast a: standard) {
            Collections.sort(a.below);
        }

        for (int z = 1; z < K; z++) {
            Gymnast[] current = new Gymnast[N];
            for (int a = 0; a < N; a++) {
                current[a] = new Gymnast(in.nextInt());
            }
            for (int a = 0; a < N; a++) {
                for (int b = a; b < N; b++) {
                    current[a].below.add(current[b]);
                }
            }
            for (Gymnast a: current) {
                Collections.sort(a.below);

            }
        }
    }

}
