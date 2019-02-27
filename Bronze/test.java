import java.util.*;
import java.io.*;
public class test {
    static boolean debug = false;

    static class Section {
        String type;
        int lower, higher;
        Section(String a, int b, int c) {
            type = a;
            lower = b;
            higher = c;
        }
    }

    public static void main(String[] args) throws IOException {
        String inpath = "traffic.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/traffic.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        ArrayList<Section> road = new ArrayList<>(); //create the road
        for (int z = 0; z < N; z++) {
            road.add(new Section(in.next(), in.nextInt(), in.nextInt())); //append all sections
        }
        int highestMin = 0, lowestMax=Integer.MAX_VALUE;
        int before[] = new int[2], after[] = new int[2];

        int leadingIndex = 0;
        int trailingIndex = 0;

        for (int z = road.size()-1; z >= 0; z--) {
            Section s = road.get(z);
            if (s.type.equals("none")) {
                trailingIndex = z;
                break;
            }
            else if (s.type.equals("on")) {
                after[0] += s.higher;
                after[1] += s.lower;
            }
            else {
                after[0] -= s.higher;
                after[1] -= s.lower;
            }
        }

        for (int z = 0; z <= trailingIndex; z++) {
            Section s = road.get(z);

            if (s.type.equals("on")) {
                before[0] -= s.lower;
                before[1] -= s.higher;
            }
            else if (s.type.equals("off")) {
                before[0] += s.higher;
                before[1] += s.lower;
            }
            else {
                leadingIndex = z;
                break;
            }

        }

        for (int z = leadingIndex; z <= trailingIndex; z++) {
            Section s = road.get(z);
            if (s.type.equals("none")) {
                if (s.lower > highestMin) highestMin = s.lower;
                if (s.higher < lowestMax) lowestMax = s.higher;
            }
            else if (s.type.equals("on")) {
                highestMin += s.higher;
                lowestMax += s.lower;
            }
            else {
                highestMin -= s.higher;
                lowestMax -= s.lower;
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("traffic.out"));
        out.write("" + (before[0] + highestMin) + " " + (before[1] + lowestMax) + "\n");
        out.write("" + (after[0] + highestMin) + " " + (after[1] + lowestMax) + "\n");

        out.close();
    }
}
