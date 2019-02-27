import java.util.*;
import java.io.*;
public class traffic {
    static boolean debug = true;

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
        int before[] = new int[2], after[] = new int[2];

        for (int z = 0; z < road.size(); z++) {
            Section s = road.get(z);
            if (z == 0) {if (!s.type.equals("none")) {
                if (s.type.equals("on")) {
                    before[0] -= s.lower;
                    before[1] -= s.higher;
                }
                else {
                    before[0] += s.higher;
                    before[1] += s.lower;
                }
            }
            else if (z== road.size()-1) if(!s.type.equals("none")) {
                if (s.type.equals("on")) {
                    after[0] += s.higher;
                    after[1] += s.lower;
                }
                else {
                    after[0] -= s.higher;
                    after[1] -= s.lower;
                }
            }

            else if (s.type.equals("on")) {
                highestMin += s.higher;
                lowestMax += s.lower;
            }

            if (s.type.equals("none")) {
                if (s.lower > highestMin) highestMin = s.lower;
                if (s.higher < lowestMax) lowestMax = s.higher;
            }

            else {
                highestMin -= s.higher;
                lowestMax -= s.lower;
            }
        }


        BufferedWriter out = new BufferedWriter(new FileWriter("traffic.out"));
        out.write("" + (before[0] + highestMin) + " " + (before[1] + lowestMax) + "\n");
        out.write("" + (after[0] + highestMin) + " " + (after[1] + lowestMax) + "\n");
//        if (A1.type.equals("on")) {
//            out.write( "" + (A2.lower - A1.lower) + " " + (A2.higher-A1.higher) + "\n");
//        }
//        else {
//            out.write( "" + (A2.lower + A1.higher) + " " + (A2.higher+A1.lower) + "\n");
//        }
//        if (A4.type.equals("on")) {
//            out.write( "" + (A3.lower + A4.higher) + " " + (A3.higher+A4.lower) + "\n");
//        }
//        else {
//            out.write( "" + (A3.lower - A4.higher) + " " + (A3.higher-A4.lower) + "\n");
//        }
        out.close();
    }
}}
