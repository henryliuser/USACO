package feb2015;

import java.io.*;
import java.util.Stack;


public class Censoring {

    public static void main(String[] args) throws IOException {



        String inpath = "/Users/henry/Desktop/projects/USACO/past/original15.in";
        String outpath = "/Users/henry/Desktop/projects/USACO/past/censor.out";
        BufferedReader in = new BufferedReader(new FileReader(inpath));
        BufferedWriter out;

        String line = in.readLine();
        String key = in.readLine();
        in.close();
        StringBuilder x = new StringBuilder();
        x.append(line);

        Stack<int[]> abigula = new Stack();

        int s = 0;
        int k = 0;
        while (s < x.length()) {
            if (x.charAt(s) == key.charAt(k)) {
                if (k == key.length()-1) {
                    x.delete(s-key.length()+1,s+1);
                    int[] fghjk = abigula.pop();
                    s = fghjk[0];
                    k = fghjk[1];
                }
                else {
                    k++;
                    s++;
                }
            }
            else if (k!=0) {
                int[] z = {s,k};
                abigula.push(z);
                s -= k-1;
                k = 0;
            }
            else {
                s++;
            }
        }





        out = new BufferedWriter(new FileWriter(outpath));
        out.write(x.toString());
        out.close();
        BufferedReader asdsdg  = new BufferedReader(new FileReader("/Users/henry/Desktop/projects/USACO/past/15.out"));
        if (x.toString().equals(asdsdg.readLine())) {
            System.out.println("yes");
        }
        System.out.println(x.toString());

    }

}
