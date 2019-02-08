package BovineShuffle.dec2017;

import java.io.*;
import java.util.Scanner;

public class shuffle {
    public static void main(String[] args) throws IOException {
        File inpath = new File("shuffle.in");
        File outpath = new File("shuffle.out");

        Scanner in = new Scanner(inpath);
        int N = in.nextInt();
        int[] shuffles = new int[N];
        for (int z = 0; z<N; z++) {
            shuffles[z] = in.nextInt()-1;
        }

        String[] IDs = new String[N];
        for (int z = 0; z<N; z++) {
            IDs[z] = in.next();
        }
        in.close();

        String[] answer = new String[N];
        for (int z1 = 0; z1 < 3; z1++) {
            for (int z = 0; z< N; z++) {
                answer[z] = IDs[shuffles[z]];
            }
            IDs = answer.clone();
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(outpath));
        for (int z = 0; z < N; z ++) {
            out.write(answer[z] + "\n");
        }
        out.close();
    }
}
