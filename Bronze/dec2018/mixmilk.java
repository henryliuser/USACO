package dec2018;

import java.io.*;
import java.util.Scanner;
public class mixmilk {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("dec2018/mixmilk.in"));
        BufferedWriter out;


        //Store initial bucket data
        int[] caps = new int[3];
        int[] inits = new int[3];
        caps[0] = in.nextInt();
        inits[0] = in.nextInt();
        caps[1] = in.nextInt();
        inits[1] = in.nextInt();
        caps[2] = in.nextInt();
        inits[2] = in.nextInt();
        in.close();
        int curr = 0;
        for (int z = 0; z < 100; z++) {
            int d = curr + 1;
            if (curr == 2) {
                d = 0;
            }

            int val = inits[curr];
            int capD = caps[d];
            int valD = inits[d];

            if (val <= capD-valD) {// if current value is less than remaining in next
                inits[curr] = 0;
                inits[d] += val;
            }

            else {
                inits[curr] -= capD - valD;
                inits[d] += capD - valD;
            }
            curr++;
            if (curr == 3) {
                curr = 0;
            }
        }


        out = new BufferedWriter(new FileWriter("mixmilk.out"));
        for (int z = 0; z < 3; z++) {
            out.write(inits[z]+"\n");
        }
        out.close();
    }

}
