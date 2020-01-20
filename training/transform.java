/*
ID: henryli3
LANG: JAVA
PROG: transform
*/
import java.util.*;
import java.io.*;

public class transform {

    static int N = 0;
    static char[][] original;
    static char[][] output;

    public static void main(String[] args) throws IOException {
        String inpath = "transform.in";
        Scanner in = new Scanner(new File(inpath));

        N = in.nextInt();
        in.nextLine(); //positioning

        original = new char[N][N];
        output = new char[N][N];
        int answer = 0;

        for (int z = 0; z < N; z++) {
            String temp = in.next();
            for (int a = 0; a < N; a++) {
                original[z][a] = temp.charAt(a);
            }
        }

        for (int z = 0; z < N; z++) {
            String temp = in.next();
            for (int a = 0; a < N; a++) {
                output[z][a] = temp.charAt(a);
            }
        }

        if (output.equals(original)) answer = 6;
        else if (Arrays.deepEquals(clock90(original),output)) answer = 1;
        else if (Arrays.deepEquals(clock180(original),output)) answer = 2;
        else if (Arrays.deepEquals(clock270(original), output)) answer = 3;
        else {
            char[][] reflected = reflection(original);
            if (Arrays.deepEquals(reflected,output)) answer = 4;
            else if (Arrays.deepEquals(clock90(reflected),output)) answer = 5;
            else if (Arrays.deepEquals(clock180(reflected),output)) answer = 5;
            else if (Arrays.deepEquals(clock270(reflected),output)) answer = 5;
            else answer = 7;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("transform.out"));
        out.write((answer) + "\n");
        System.out.println(answer);
        out.close();

    }

    static char[][] clock90(char[][] in) {
        char[][] out = new char[N][N];
        for (int z = 0; z < N; z++) {
            String temp = new String(in[z]);
            for (int a = 0; a < N; a++) {
                out[a][N-z-1] = temp.charAt(a);
            }
        }
        return out;
    }

    static char[][] clock180(char[][] in) {
        char[][] out = new char[N][N];
        for (int z = 0; z < N; z++) {
            String temp = new String(in[z]);
            for (int a = 0; a < N; a++) {
                out[N-z-1][N-a-1] = temp.charAt(a);
            }
        }
        return out;
    }

    static char[][] clock270(char[][] in) {
        char[][] out = new char[N][N];
        for (int z = 0; z < N; z++) {
            String temp = new String(in[z]);
            for (int a = 0; a < N; a++) {
                out[N-a-1][z] = temp.charAt(a);
            }
        }
        return out;
    }

    static char[][] reflection(char[][] in) {
        char[][] out = new char[N][N];
        for (int z = 0; z < N; z++) {
            char[] temp = in[z];
            for (int a = 0; a < N; a++) {
                out[z][N-a-1] = temp[a];
            }
        }
        return out;
    }



    static void printArr(char[][] x) {
        for (char[] z: x) {
            for (char a: z) System.out.print(a);
            System.out.println();
        }
    }

}
