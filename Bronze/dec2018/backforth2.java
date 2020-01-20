package dec2018;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class backforth2 {


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("dec2018/backforth.in"));
        BufferedWriter out;

        int[] buckets1 = new int[10];
        int[] buckets2 = new int[11];
        for (int z = 0; z < 10; z++) {
            buckets1[z] = in.nextInt();
        }
        for (int z = 0; z < 10; z++) {
            buckets2[z] = in.nextInt();
        }

        int[] x1 = buckets1;
        int[] x2 = buckets2;
        ArrayList<Integer> finals = new ArrayList<>();
//        for (int z: buckets1) {
            for (int p = 0; p < 10; p++) {
                buckets2[10] = buckets1[p];
                int q = buckets1[p];
                for (int a = 0; a < 11; a++) {
                    buckets1[p] = buckets2[a];
                    int q1 = buckets2[a];
                    for (int b = 0; b < 10; b++) {
                        buckets2[a] = buckets1[b];
                        int q2 = buckets2[b];
                        for (int c= 0 ; c < 11; c++) {
                            buckets1[b] = buckets2[c];
                            int q3 = buckets2[c];
                            int yyu = 1000 - q + q1 - q2 + q3;
                            if (!finals.contains(yyu)) {
                                finals.add(yyu);
                            }
                        }
                    }
                }
                buckets1 = x1;
                buckets2 = x2;
            }

//        }

        out = new BufferedWriter(new FileWriter("dec2018/backforth.out"));
        out.write(String.valueOf(finals.size()/2+1));
        out.close();

    }

}
