import java.util.*;
import java.io.*;
public class guess3 {
    static boolean debug = false;

    public static class Trait {
        String name = "";
        int feasYes = 0;
        public Trait(String n, int f) {
            name = n;
            feasYes = f;
        }
    }

    public static class Cow {
        String name = "";
        int numTraits;
        boolean isUnique = true;
        ArrayList<String> traits = new ArrayList<>();
        ArrayList<String> uniques = new ArrayList<>();
        ArrayList<String> nonuniques = new ArrayList<>();
        public Cow(String s, int n) {
            numTraits = n;
            name = s;
        }
    }

    static class SortByFeas implements Comparator<Trait> {
        public int compare(Trait a, Trait b) {
            return b.feasYes-a.feasYes;
        }
    }

    public static void main(String[] args) throws IOException {
        String inpath = "Text Files/guess.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/Bronze/guess.in";
        Scanner in = new Scanner(new File(inpath));
        ArrayList<Cow> animals = new ArrayList<>();
        HashMap<String,Integer> seen = new HashMap<>();

        int N = in.nextInt();
        for (int z = 0; z < N; z++) {
            String name = in.next();
            int K = in.nextInt();
            Cow x = new Cow(name, K);
            for (int z1 = 0; z1 < K; z1++) {
                String y = in.next();
                x.traits.add(y);
                if (seen.containsKey(y)) {
                    seen.put(y,seen.get(y)+1);
                }
                else seen.put(y,1);

            }
            animals.add(x);
        }
        in.close();

        for (int z = 0; z < N; z++) {           //i think this appends all unique traits to each cows list
            Cow e = animals.get(z);
            for (String trait: e.traits) {
                if (seen.get(trait) == 1) {
                    e.uniques.add(trait);
                }
                else e.nonuniques.add(trait);
//
//                boolean unique = true;
//                for (int z1 = 0; z1 < N; z1++) {
//                    if (z1 == z) continue;
//                    Cow p = animals.get(z1);
//                    for (String s: p.traits) {
//                        if (s.equals(trait)) {
//                            unique = false;
//                            break;
//                        }
//                    }
//                    if (!unique) break;
//
//                }
//                if (unique) e.uniques.add(trait);
//                else e.nonuniques.add(trait);

            }
            if (e.uniques.size() == 0) {
                e.isUnique = false;
            }
        }

        ArrayList<Cow> feasible = (ArrayList)animals.clone();

        int max = 0;
        ArrayList<Trait> order = new ArrayList<>();

        for (String trait: seen.keySet()) {
            int feasYes = feasible.size();
            boolean unique = false;
            if (seen.get(trait) == 1) {
                unique = true;
            }

            for (Cow x: feasible) {
                boolean cowHas = false;
                for (String temp: x.traits) {
                    if (temp.equals(trait)) {
                        cowHas = true;
                        break;
                    }
                }
                if(!cowHas) {
                    feasYes -= 1;
                }
                else {
                    if (unique) {
                        feasYes = 1;
                        break;
                    }
                }

            }
            order.add(new Trait(trait,feasYes));

        }
        Collections.sort(order,new SortByFeas());
        for (Trait x: order) {
            max++;
            String tee = x.name;
            for (int c = 0; c < feasible.size(); c++) {  //check if the cow has the trait
                Cow z = feasible.get(c);                    //IF yes then remove others
                boolean cowHas = false;
                for (String temp: z.traits) {
                    if (temp.equals(tee)){
                        cowHas = true;
                        break;
                    }
                }
                if (!cowHas)
                    feasible.remove(z);

            }

            if (feasible.size() == 1) {
                break;
            }
        }

//        for (Cow e: animals) {
//            int z = 0;
//            if (e.isUnique) {
//                z = e.nonuniques.size() + 1;
//            }
//            else {
//                z = e.nonuniques.size();
//            }
//            if (z > max) max = z;
//        }

        System.out.println(max);

        BufferedWriter out = new BufferedWriter(new FileWriter("guess.out"));

        out.write((max ) + "");
        out.close();








    }
}
