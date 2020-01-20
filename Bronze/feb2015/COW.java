package feb2015;

import java.io.*;

public class COW {
    public static void main(String[] args) throws IOException {

        String inpath = "cow.in";
        String outpath = "cow.out";
        BufferedWriter out;
        BufferedReader in = new BufferedReader(new FileReader(inpath));
        int N = Integer.parseInt(in.readLine());
        String woc = in.readLine();
        in.close();
//        int N = 12;
//        String woc = "COWCOWCOWCOW";

        int lastW = 0;
        long sum = 0;
        int totalO = 0;
        int totalC = 0;
        int buffer = 0;
        int altbuffer = 0;
        int altCounter = 0;

        for (int z = 0; z < N; z++) {
            char current = woc.charAt(z);
            if (current == 'C') {
                totalC++;
            }
            else if (current == 'O') {
                buffer += totalC;
            }
            else {
//                lastW = buffer + totalO - 1 + lastW;
//                sum += lastW;
                sum += buffer;
            }
        }


        out = new BufferedWriter(new FileWriter(outpath));
        out.write(sum + "");
        out.close();
    }
}
