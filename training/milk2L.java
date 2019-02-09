/*
 ID: henryli3
 LANG: JAVA
 TASK: milk2
 */
//package train;

import java.util.*;
import java.io.*;

public class milk2L {

    static String inPath = "milk2.in"; //   /Users/henry/Desktop/intelliJ/USACO/src/train/milk2.in
    static String outPath = "milk2.out"; // /Users/henry/Desktop/intelliJ/USACO/src/train/milk2.out

    static List<farmerPair> roster = new ArrayList<farmerPair>();

    static class farmerPair {

        private int start;
        private int end;
        private int duration;

        int getStart() {
            return this.start;
        }

        int getEnd() {
            return this.end;
        }

        int getDuration() {
            return this.duration;
        }

        farmerPair(String Start, String End) {
            this.start = Integer.parseInt(Start);
            this.end = Integer.parseInt(End);
            this.duration = this.end - this.start;
        }
    }

    static String getInfo(List<farmerPair> roster) {

        int leadingDuration = roster.get(0).getDuration();
        int currentDuration = roster.get(0).getDuration();
        int currentEnd = roster.get(0).getEnd();

        int leadingGap = 0;
        int currentGap;

        for (int c = 1; c < roster.size(); c++) {
             farmerPair z = roster.get(c);
             if (currentEnd >= z.getStart()) {
                 currentDuration += z.getDuration() - (currentEnd-z.getStart());
                 currentEnd = z.getEnd();
                 if (z == roster.get(roster.size()-1)) {
                     leadingDuration = currentDuration;
                 }
             }
             else {
                 if (currentDuration > leadingDuration) {
                     leadingDuration = currentDuration;
                 }
                 currentDuration = z.getDuration();
                 currentGap = z.getStart() - currentEnd;
                 if (currentGap > leadingGap) {
                     leadingGap = currentGap;
                 }
                 currentEnd = z.getEnd();
             }

        }
        return String.valueOf(leadingDuration) + " " + String.valueOf(leadingGap);
    }

    static List<farmerPair> sort1(List<farmerPair> roster) {

        List<farmerPair> roster1 = roster;

        Collections.sort(roster1, new Comparator<farmerPair>() {
            @Override
            public int compare(farmerPair x, farmerPair y) {
                return x.getStart() - y.getStart();
            }
        });

        return roster1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new FileReader(inPath));

        int total = Integer.parseInt(r.readLine());
        for (int z = 0; z < total; z++) {
            String[] times = r.readLine().split(" ");
            roster.add(new farmerPair(times[0],times[1]));
        }
        r.close();

        //calculate stuff
        roster = sort1(roster);
        String[] info = getInfo(roster).split(" ");
        String longest = info[0];
        String shortest = info[1];

        BufferedWriter f = new BufferedWriter(new FileWriter(outPath));
        f.write(longest + " " + shortest + "\n");
        f.close();
//        System.out.println(longest + " " + shortest);

    }

}
