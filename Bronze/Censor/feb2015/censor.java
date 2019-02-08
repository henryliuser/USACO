package Censor.feb2015;// 2/21/2015 (written in contest)
// Solution to 2015 February USACO Bronze Problem: Censoring

import java.util.*;
import java.io.*;

public class censor {

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        BufferedReader stdin = new BufferedReader(new FileReader("/Users/henry/Desktop/projects/USACO/past/original15.in"));
        FileWriter fout = new FileWriter(new File("/Users/henry/Desktop/projects/USACO/past/censor.out"));

        String line = stdin.readLine();
        String text = stdin.readLine();



        // Stores a look up table of transitions between substrings.
        int[][] f = new int[text.length()][26];
        f[0][text.charAt(0)-'a'] = 1;

        // Where do you go from state [i,j]?
        for (int i=1; i<f.length; i++) {
            for (int j=0; j<26; j++) {
                String next = text.substring(0, i) + (char)('a'+j);
                f[i][j] = prefix(next, text);
            }
        }

        int cur = 0;
        Stack<Integer> s = new Stack<Integer>();
        StringBuilder ans = new StringBuilder();

        // Now, just simulate what they ask, with a stack, for speed.
        for (int i=0; i<line.length(); i++) {

            // Get this state (# of matching chars...)
            cur = f[cur][line.charAt(i)-'a'];

            // The very beginning nothing matches.
            if (cur == 0) {
                ans.append(makeStr(text, s));
                ans.append(line.charAt(i));
                s = new Stack<Integer>();
            }

            // We got a match, pop off these characters.
            else if (cur == text.length()) {
                for (int j=0; j<text.length()-1; j++)
                    s.pop();
                cur = s.empty() ? 0 : s.peek();
            }

            // Just push.
            else
                s.push(cur);
        }

        // In case there's stuff in the stack, you have to add it back.
        if (s.size() > 0) ans.append(makeStr(text, s));

        System.out.println(ans);
        System.out.printf("Time elapsed: %d\n", System.currentTimeMillis()- startTime);
        fout.write(ans+"\n");
        fout.close();
        stdin.close();
    }

    // Efficiently makes the string by adding each char from s.
    public static StringBuilder makeStr(String text, Stack<Integer> s) {
        StringBuilder ans = new StringBuilder();
        while (s.size() > 0)
            ans.insert(0, text.charAt(s.pop()-1));
        return ans;
    }

    // Returns the max length prefix match, using brute force.
    public static int prefix(String sub, String total) {
        for (int i=sub.length(); i>0; i--)
            if (sub.substring(sub.length()-i).equals(total.substring(0, i)))
                return i;
        return 0;
    }
}

class pair {

    public int x;
    public int y;

    public pair(int myx, int myy) {
        x = myx;
        y = myy;
    }
}