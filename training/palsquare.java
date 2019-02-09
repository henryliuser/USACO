/*
ID: henryli3
LANG: JAVA
PROG: palsquare
*/


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class palsquare {
    static boolean debug = false;

    static public boolean isPalindrome(String x) {
        for (int z = 0; z < x.length()/2; z++) {
            if (x.charAt(z) == x.charAt(x.length()-z-1));
            else return false;
        }
        return true;
    }

    static public String convertBase(int n, int base) {
        ArrayList<Integer> denominations = new ArrayList(); //keep track of place values
        for (int z = 0;; z++) {
            int t = (int)Math.pow(base,z);
            if (t > n) break;
            else denominations.add(t);
        }

        StringBuilder ans = new StringBuilder();
        int remainder = n;
        for (int z = denominations.size()-1; z >=0; z--) {
            int temp = denominations.get(z);
            int temp2 = remainder/temp;
            if (temp2 > 9) {
                char x = (char)(55 + temp2);
                ans.append(x);
            }
            else ans.append(remainder/temp);
            remainder %= temp;
        }

        return ans.toString();

    }

    public static void main(String[] args) throws IOException {
        String inpath = "palsquare.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/palsquare.in";
        Scanner in = new Scanner(new File(inpath));
        int B = in.nextInt();
        in.close();

        BufferedWriter out = new BufferedWriter(new FileWriter("palsquare.out"));
        for (int z = 1; z <= 300; z++) {
            int n = z * z;
            if ( isPalindrome(convertBase(n,B)) ) {
                String outer = convertBase(z, B) + " " + convertBase(n, B);
                System.out.println(outer);
                out.write(outer + "\n");
            }
        }
        out.close();


    }
}
