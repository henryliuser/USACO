import java.util.*;
import java.io.*;
public class evolutionWrong {

    static class SubPop implements Comparable{
        Integer numTraits;
        HashSet<String> traits;
        SubPop(int n, HashSet s) {
            numTraits = n;
            traits = s;
        }
        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.numTraits,((SubPop) o).numTraits);
        }

    }

    static class Branch {
        HashSet<Branch> children = new HashSet();
        String trait;
        boolean isLeaf;
        public Branch(String s) {
            trait = s;
        }
    }

    //global variables
    static ArrayList<SubPop> all = new ArrayList<>();

    static boolean debug = true;
    public static void main(String[] args) throws IOException {

        //read input and initialize data
        String inpath = "evolution.in";
        if (debug) inpath = "";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        for (int z = 0; z < N; z++) {
            int a = in.nextInt();
            HashSet<String> te = new HashSet();
            for (int b = 0; b < a; b++) {
                te.add(in.next());
            }
            in.nextLine();
            all.add(new SubPop(a,te));
        }
        Collections.sort(all);
    }
}
