/*
ID: henryli3
LANG: JAVA
PROG: namenum
*/
import java.util.*;
import java.io.*;
public class namenumBad {
    static boolean debug = false;

    static void oni(int i, char[] c) {
        int index = Integer.parseInt(brandName.charAt(i) + "")-2;
        for (int a = 0; a < 3; a++) {
            c[i] = mapping[index][a];
            if (i+1 != brandName.length()) oni(i+1,c);
            else possible[counter++] = new String(c);
        }
    }

    static char[][] mapping = new char[][] {
            {'A','B','C'},
            {'D','E','F'},
            {'G','H','I'},
            {'J','K','L'},
            {'M','N','O'},
            {'P','R','S'},
            {'T','U','V'},
            {'W','X','Y'}
    };

    static String brandName;
    static String[] possible;
    static int counter = 0;

    public static void main(String[] args) throws IOException {

        String inpath = "namenum.in";
        if (!debug) {
            Scanner in = new Scanner(new File(inpath));
            brandName = in.next();
        }
        if (debug) brandName = "4734";



        int combinations = (int)Math.pow(3,brandName.length());
        possible = new String[combinations];

        char[] chars = new char[brandName.length()];
        oni(0,chars);
        Scanner in1 = new Scanner(new File("dict.txt"));
        ArrayList<String> dict = new ArrayList();
        while (in1.hasNextLine()) {
            dict.add(in1.nextLine());
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("namenum.out"));
        boolean b = false;
        for (String s: dict) {
            for (String a: possible) {
                if (s.equals(a)) {
                    b = true;
                    out.write(s + "\n");
                }
            }
        }
        if (!b) out.write("NONE\n");
        out.close();
    }
}
