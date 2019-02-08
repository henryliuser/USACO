import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class badmilk {


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Text Files/badmilk.in"));
        int N = in.nextInt(); //number of people
        int M = in.nextInt(); //number of milks
        int D = in.nextInt();
        int S = in.nextInt();

        int[][] imbibals = new int[D][3];
        int[][] sick = new int[S][2];
        ArrayList<int[]>[] people = new ArrayList[N];
        ArrayList<int[]>[][] milks = new ArrayList[M][N];
        ArrayList<Integer> hitlist = new ArrayList<>();


        for (int z = 0; z < D; z++) {
            int p = in.nextInt(); //person p
            int m = in.nextInt(); //imbibed milk m
            int t = in.nextInt(); //at time t
            imbibals[z][0] = p;
            imbibals[z][1] = m;
            imbibals[z][2] = t;
            people[p-1].add(imbibals[z]);  //-1 for indexing purpose
            milks[m-1][p-1].add(imbibals[z]);
        }


        for (int z = 0; z < S; z++) {
            sick[z][0] = in.nextInt(); //person who got sick
            sick[z][1] = in.nextInt(); //time getting sick
        }


        for (int[] x:sick) {  //for each person who gets sick, see what they've drank before getting sick
            int t = x[1]; //time

            ArrayList<int[]> currentPerson = people[x[0]];
            for (int z = 0; z < currentPerson.size(); z++) {
               int[] currentImbibal = currentPerson.get(z);
               if (currentImbibal[2] < t) {
                   hitlist.add(currentImbibal[1]);
               }

            }
        }

        for (int z = 0; z< hitlist.size(); z++) {
            ArrayList<int[]>[] peo2ple = milks[z];
            for (int z1 = 0; z1 < peo2ple.length; z1++) {

            }

        }



    }
}
