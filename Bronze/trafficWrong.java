import java.util.*;
import java.io.*;
public class trafficWrong {
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


        Section A1 = new Section("on",0,0);
        Section A2 = null;
        Section A3 = null;
        Section A4 = new Section("off",0,0);

        int highestMin = 0, lowestMax=Integer.MAX_VALUE;

        for (int z = 0; z < road.size(); z++) {
            Section s = road.get(z);
            if (s.type.equals("none")) {
                if (s.lower > highestMin) highestMin = s.lower;
                if (s.higher < lowestMax) lowestMax = s.higher;
            }
            else if (z == 0) {
                A1 = s;
            }
            else {
                A2 = new Section("none",highestMin,lowestMax);
                break;
            }
        }
        highestMin = 0;
        lowestMax=Integer.MAX_VALUE;
        for (int z = road.size()-1; z >= 0; z--) {
            Section s = road.get(z);
            if (s.type.equals("none")) {
                if (s.lower > highestMin) highestMin = s.lower;
                if (s.higher < lowestMax) lowestMax = s.higher;
            }
            else if (z == road.size()-1) {
                A4 = s;
            }
            else {
                A3 = new Section("none",highestMin,lowestMax);
                break;
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("traffic.out"));

        if (A1.type.equals("on")) {
            out.write( "" + (A2.lower - A1.lower) + " " + (A2.higher-A1.higher) + "\n");
        }
        else {
            out.write( "" + (A2.lower + A1.higher) + " " + (A2.higher+A1.lower) + "\n");
        }
        if (A4.type.equals("on")) {
            out.write( "" + (A3.lower + A4.higher) + " " + (A3.higher+A4.lower) + "\n");
        }
        else {
            out.write( "" + (A3.lower - A4.higher) + " " + (A3.higher-A4.lower) + "\n");
        }
        out.close();
    }
}
