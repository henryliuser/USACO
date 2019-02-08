import java.util.*;
import java.io.*;
public class guess {
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
        ArrayList<Trait> traits = new ArrayList<>();
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
                String y= in.next();
                x.traits.add(new Trait(y,0));
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
            for (Trait n: e.traits) {
                String trait = n.name;
                if (seen.get(n) == 1) {
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
//
//            for (Cow x: feasible) {
//                boolean cowHas = false;
//                for (Trait temp1: x.traits) {
//                    String temp = temp1.name;
//                    if (temp.equals(trait.name)) {
//                        cowHas = true;
//                        break;
//                    }
//                }
//                if(!cowHas) {
//                    trait.feasYes -= 1;
//                }
//                else {
//                    if (unique) {
//                        trait.feasYes = 1;
//                        break;
//                    }
//                }
//
//            }

        }
        Cow p = null;

        for (Cow e: animals) {
            int z = 0;
            if (e.isUnique) {
                z = e.nonuniques.size() + 1;
            }
            else {
                z = e.nonuniques.size();
            }
            if (z > max) {
                max = z;
                p = e;
            }
        }

        order.addAll(p.traits);

        Collections.sort(order,new SortByFeas());

        HashMap<Cow,Integer> asfhfejh = new HashMap<>();


        for (Trait x: order) {
            String tee = x.name;
            max++;
            for (int c = 0; c < feasible.size(); c++) {  //check if the cow has the trait
                Cow z = feasible.get(c);                    //IF yes then remove others
                boolean cowHas = false;
                for (Trait temp1: z.traits) {
                    String temp = temp1.name;
                    if (temp.equals(tee)){
                        cowHas = true;
                        if (asfhfejh.containsKey(z)) {
                            asfhfejh.put(z,asfhfejh.get(tee)+1);
                        }
                        break;
                    }
                }
//                if (!cowHas) asdasd;


            }

            if (feasible.size() == 1) {
                break;
            }
        }



        System.out.println(max);

        BufferedWriter out = new BufferedWriter(new FileWriter("guess.out"));

        out.write((max ) + "");
        out.close();








    }
}
