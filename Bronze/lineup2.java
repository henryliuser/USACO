import java.util.*;
import java.io.*;
public class lineup2 {

    static class Cow implements Comparable {
        int alpha;
        String name = "";
        ArrayList<Cow> linked = new ArrayList();

        Cow(int a, String s) {
            alpha = a;
            name = s;
            linked.add(this);
        }

        @Override
        public int compareTo(Object o) {
            Cow x = (Cow) o;
            return this.alpha - x.alpha;
        }
    }

    static class Chunk implements Comparable {
        ArrayList<Cow> cows= new ArrayList();
        @Override
        public int compareTo(Object o) {
            Chunk c = (Chunk)o;
            return this.cows.get(0).alpha-c.cows.get(0).alpha;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("lineup.in"));
        int N = in.nextInt();
        HashMap<String, Cow> key = new HashMap();
        key.put("Beatrice", new Cow(0, "Beatrice"));
        key.put("Belinda", new Cow(1, "Belinda"));
        key.put("Bella", new Cow(2, "Bella"));
        key.put("Bessie", new Cow(3, "Bessie"));
        key.put("Betsy", new Cow(4, "Betsy"));
        key.put("Blue", new Cow(5, "Blue"));
        key.put("Buttercup", new Cow(6, "Buttercup"));
        key.put("Sue", new Cow(7, "Sue"));
        HashMap<Integer, Cow> reverseKey = new HashMap();
        reverseKey.put(0, key.get("Beatrice"));
        reverseKey.put(1, key.get("Belinda"));
        reverseKey.put(2, key.get("Bella"));
        reverseKey.put(3, key.get("Bessie"));
        reverseKey.put(4, key.get("Betsy"));
        reverseKey.put(5, key.get("Blue"));
        reverseKey.put(6, key.get("Buttercup"));
        reverseKey.put(7, key.get("Sue"));


        for (int z = 0; z < N; z++) {
            Cow temp1 = key.get(in.next());
            in.next();
            in.next();
            in.next();
            in.next();
            Cow temp2 = key.get(in.next());
            temp1.linked.add(temp2);
            temp2.linked.add(temp1);
        }

        ArrayList<Chunk> fin = new ArrayList();
        HashSet<Integer> crossedOff = new HashSet();

        for (int z = 0; z < 8; z++) {
            if (crossedOff.contains(z)) continue;
            Chunk a = new Chunk();
            Cow x = reverseKey.get(z);
            if (x.linked.size() == 3) {
                x.linked.remove(x);
                Collections.sort(x.linked);
                a.cows.add(x.linked.get(0));
                x.linked.add(1,x);
            }
            fin.add(makeChunk(x,a));
            for (int b = 0; b < x.linked.size(); b++) crossedOff.add(a.cows.get(b).alpha);

        }
        Collections.sort(fin);
        BufferedWriter out = new BufferedWriter(new FileWriter("lineup.out"));
        for (Chunk b: fin) {
            for (Cow a:b.cows) {
                out.write(a.name + "\n");
                System.out.println(a.name);
            }
        }
        out.close();
    }


    static Chunk makeChunk(Cow a, Chunk b) {
        b.cows.add(a);
        ArrayList<Cow> lin = a.linked;
        Collections.sort(lin);
        Cow temp = lin.get(lin.size()-1);
        if (a != temp) return makeChunk(temp,b);
        else return b;
    }
}