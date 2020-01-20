package feb2015;

import java.io.*;


public class CensoringBruteForce2 {

    public static void main(String[] args) throws IOException {


        long startTime = System.currentTimeMillis();

        String inpath = "/Users/henry/Desktop/projects/USACO/past/original15.in";
        String outpath = "/Users/henry/Desktop/projects/USACO/past/censor.out";
        BufferedReader in = new BufferedReader(new FileReader(inpath));
        BufferedWriter out;

        String line = in.readLine();
        String key = in.readLine();
        in.close();
//        StringBuilder x = new StringBuilder();
//        x.append(line);
        while (true) {
            int t = line.indexOf(key);
            if (t < 0) {
                break;
            }
            line = line.substring(0,t) + line.substring(t+key.length());


        }

        long endTime = System.currentTimeMillis();
        System.out.println(String.format("time elapsed = %d", endTime -startTime));
        out = new BufferedWriter(new FileWriter(outpath));
        out.write(line);
        out.close();
        BufferedReader asdsdg  = new BufferedReader(new FileReader("/Users/henry/Desktop/projects/USACO/past/15.out"));

        System.out.println(line);
    }
}