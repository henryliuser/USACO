import java.util.*;
import java.io.*;
public class lineup {

    static class Cow implements Comparable {
        int alpha;
        String name = "";
        ArrayList<Cow> linked = new ArrayList();
        Cow(int a, String s) {alpha = a; name = s; linked.add(this);}
        @Override
        public int compareTo(Object o) {
            Cow x = (Cow)o;
            return this.alpha - x.alpha;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("lineup.in"));
        int N = in.nextInt();
        HashMap<String,Cow> key = new HashMap();
        key.put("Beatrice",new Cow(0,"Beatrice"));
        key.put("Belinda",new Cow(1,"Belinda"));
        key.put("Bella",new Cow(2,"Bella"));
        key.put("Bessie",new Cow(3,"Bessie"));
        key.put("Betsy",new Cow(4,"Betsy"));
        key.put("Blue",new Cow(5,"Blue"));
        key.put("Buttercup",new Cow(6,"Buttercup"));
        key.put("Sue",new Cow(7,"Sue"));
        HashMap<Integer,Cow> reverseKey = new HashMap();
        reverseKey.put(0,key.get("Beatrice"));
        reverseKey.put(1,key.get("Belinda"));
        reverseKey.put(2,key.get("Bella"));
        reverseKey.put(3,key.get("Bessie"));
        reverseKey.put(4,key.get("Betsy"));
        reverseKey.put(5,key.get("Blue"));
        reverseKey.put(6,key.get("Buttercup"));
        reverseKey.put(7,key.get("Sue"));


        for (int z = 0; z < N; z++) {
            Cow temp1 = key.get(in.next());
            in.next(); in.next(); in.next(); in.next();
            Cow temp2 = key.get(in.next());
            temp1.linked.add(temp2);
            temp2.linked.add(temp1);
        }

        String[] finalOrder = new String[8];
        HashSet<Integer> crossedOff = new HashSet();
        int counter = 0;
        for (int z = 0; z < 8;) {
            Cow one = reverseKey.get(counter);
            Collections.sort(one.linked);
            if (one.linked.size() == 3) {

                one.linked.remove(one);
//
//                for (int a = 0; a < one.linked.size(); a++) {
//                    if (!(one.linked.get(a) == one)) {
//                        finalOrder[z++] = one.linked.get(a).name;
//                        crossedOff.add(one.linked.get(a).alpha);
//                        if (z >= 8) break;
//                    }
//                }
                if (one.linked.get(0).alpha > counter+1) {
                    counter++;
                    one.linked.add(one);
                    Collections.sort(one.linked);
                    continue;
                }
                finalOrder[z++] = one.linked.get(0).name;
                finalOrder[z++] = one.name;
                finalOrder[z++] = one.linked.get(1).name;
            }
            else {
                for (int a = 0; a < one.linked.size(); a++) {
                    finalOrder[z++] = one.linked.get(a).name;
                    crossedOff.add(one.linked.get(a).alpha);
                    if (z >= 8) break;
                }
            }
            counter++;
            while (crossedOff.contains(counter)) counter++;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("lineup.out"));
        for (int z = 0; z < 8; z++) {
            out.write(finalOrder[z] + "\n");
            System.out.println(finalOrder[z]);
        }
        out.close();





    }



}
