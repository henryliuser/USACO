/*
 ID: henryli3
 LANG: JAVA
 TASK: milk2
 */

//package train;

import java.util.*;
import java.io.*;

public class milk2 {

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

    static int[] getInfo(List<farmerPair> roster) {

        int min = roster.get(0).getStart();
        int max = roster.get(0).getEnd();

        //get range
        for (int counter = 1; counter < roster.size(); counter++) {
            int tempStart = roster.get(counter).getStart();
            int tempEnd = roster.get(counter).getEnd();

            if (tempStart < min) {
                min = tempStart;
            }

            if (tempEnd > max) {
                max = tempEnd;
            }
        }

        int spread = max - min;

        List<Integer> range = new ArrayList<Integer>(spread); //IMPORTANT

        for (int counter = 0; counter < spread; counter++) { //SET EVERYTHING 0
            range.add(0);
        }

        for (int counter = 0; counter < roster.size(); counter++) { //ESTABLISH RANGE
            farmerPair z = roster.get(counter);
            for (int x = z.getStart() - (max - spread); x < z.getEnd() - (max - spread); x++) {

                range.set(x, 1);

            }
        }


        int leadingX = 0;
        int trailingX = 0;
        int zStreak = 0;
        int oStreak = 0;

        for (Integer x : range) {
            if (x == 0) {
                oStreak = 0;
                zStreak += 1;
                if (zStreak == 299) {

                }
                if (zStreak > leadingX) {
                    leadingX = zStreak;
                }
            } else {
                zStreak = 0;
                oStreak += 1;
                if (oStreak > trailingX) {
                    trailingX = oStreak;
                }

            }
        }

        int[] arr = {trailingX, leadingX};

        return arr;


        //get coverage


    }


    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new FileReader(inPath));

        int total = Integer.parseInt(r.readLine());
        for (int z = 0; z < total; z++) {
            String[] times = r.readLine().split(" ");
            roster.add(new farmerPair(times[0], times[1]));
        }
        r.close();

        //calculate stuff


        String longest = String.valueOf(getInfo(roster)[0]);
        String shortest = String.valueOf(getInfo(roster)[1]);

        BufferedWriter f = new BufferedWriter(new FileWriter(outPath));
        f.write(longest + " " + shortest + "\n");
        f.close();
        System.out.println(longest + " " + shortest);

    }

}
