package lemonade.open2018;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class lemonade1 {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("lemonade.in"));
        BufferedWriter out;

        int min = 0; //answer

        int N = in.nextInt();
        int[] ws = new int[N];
        for (int c = 0; c < N; c++) {
            int temp = in.nextInt();
            ws[c] = temp;
            if (temp >= N) {
                min++;
            }
        }
        in.close();
        Arrays.sort(ws);
        for (int c = N-1; c>= 0; c--) {
            int t = ws[c];
            if (t < N && t >= min) {
                min++;
            }
        }
        out = new BufferedWriter(new FileWriter("lemonade.out"));
        out.write("" +min);
        out.close();



    }
}
