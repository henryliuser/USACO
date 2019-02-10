/*
ID: henryli3
LANG: JAVA
PROG: dualpal
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class dualpal {
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
        String inpath = "dualpal.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/dualpal.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        int S = in.nextInt();
        int[] ans = new int[N];
        int nextIndex = 0;

        while (true) {
            S++;
            int numPal = 0;
            for (int z = 2; z <= 10; z++) {
                if (isPalindrome(convertBase(S,z))) numPal++;
                if (numPal == 2) break;
            }
            if (numPal == 2) {
                ans[nextIndex] = S;
                nextIndex++;
            }
            if (nextIndex == N) break;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("dualpal.out"));
        for (int z = 0; z < N; z++) {
            out.write(ans[z] + "\n");
            System.out.println(ans[z] );
        }
        out.close();

    }
}
