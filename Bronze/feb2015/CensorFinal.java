package feb2015;

import java.io.*;


public class CensorFinal {

    public static void main(String[] args) throws IOException {


//        long startTime = System.currentTimeMillis();

        String inpath = "censor.in";
        String outpath = "Censoring/censor.out";
        BufferedReader in = new BufferedReader(new FileReader(inpath));
        BufferedWriter out;

        String line = in.readLine();
        String key = in.readLine();
        in.close();
        StringBuilder x = new StringBuilder();
        int c = 0;
        while (c<line.length()) {
            x.append(line.charAt(c));
            c++;
            if (x.length() >= key.length()){
                int diff = x.length() - key.length();
                if (x.substring(diff).equals(key)) {
                    x.delete(diff,x.length());
                }
            }
        }

//        long endTime = System.currentTimeMillis();
//        System.out.println(String.format("time elapsed = %d", endTime -startTime));
        out = new BufferedWriter(new FileWriter(outpath));
        out.write(x.toString());
        out.close();
        System.out.println(x.toString());
    }
}