import java.util.*;
import java.io.*;
public class gymnastics2 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("gymnastics.in"));
        int K = in.nextInt();
        int N = in.nextInt();
        HashMap<Integer,HashSet<Integer>>[] orders = new HashMap[K];
        for (int z = 0; z < K; z++) { //populate the orders array
            int[] temp = new int[N]; //for each Line, store in an array
            orders[z] = new HashMap();
            for (int c = 0; c < N; c++) { //for each Cow in each Line,
                temp[c] = in.nextInt(); //store the Number in the array
            }
            for (int c = 0; c < N; c++) {
                HashSet temp2 = new HashSet();  //for each Cow in each Line, create hashset (below)
                for (int b = c+1; b < N; b++) {
                    temp2.add(temp[b]);  //add the cows placing below current cow
                }
                orders[z].put(temp[c],temp2); //add number,array(below) pair to hashmap
            }
        }

        int consistPair = 0; //answer

        for (int z= 0 ; z< N; z++) { //for each Cow in the first line
            HashSet<Integer> temp = orders[0].get(z+1); //store the list/hashset of cows placing below
            for (int x: temp) { //go through each cow placing below
                for (int a = 1; a < K; a++) { //go through the rest of the lines
                    if (!orders[a].get(z+1).contains(x)) break; //store the list/set of cows placing below that same Cow but in the new line, (now we need to compare)
                    if (a == K-1) consistPair++; //if you make it to the end without breaking, thats a consistent pair
                }
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("gymnastics.out"));
        out.write(consistPair + "\n");
        System.out.println(consistPair);
        out.close();

    }

}
