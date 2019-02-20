/*
ID: henryli3
LANG: JAVA
PROG: namenum
*/
import java.util.*;
import java.io.*;
public class namenum {

    static String convert(String s) {
        StringBuilder ans = new StringBuilder();
        for (int z = 0; z <s.length(); z++) {
            switch (s.charAt(z)) {
                case 'A': case 'B': case 'C': ans.append(2 + "");break;
                case 'D': case 'E': case 'F': ans.append(3 + "");break;
                case 'G': case 'H': case 'I': ans.append(4 + "");break;
                case 'J': case 'K': case 'L': ans.append(5 + "");break;
                case 'M': case 'N': case 'O': ans.append(6 + "");break;
                case 'P': case 'R': case 'S': ans.append(7 + "");break;
                case 'T': case 'U': case 'V': ans.append(8 + "");break;
                case 'W': case 'X': case 'Y': ans.append(9 + "");break;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("namenum.in"));
        String N = in.nextLine();
        in.close();
        in = new Scanner(new File("dict.txt"));
        boolean has = false;
        BufferedWriter out = new BufferedWriter(new FileWriter("namenum.out"));
        while (in.hasNextLine()) {
            String a = in.nextLine();
            String name = convert(a);
            if (name.equals(N)) {
                has = true;
                out.write(a + "\n");
            }
        }
        if (!has) out.write("NONE\n");
        in.close();
        out.close();
        System.exit(0);

    }
}
