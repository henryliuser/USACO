/*
ID: henryli3
LANG: JAVA
PROG: barn1
*/
import java.io.*;
import java.util.*;
public class barn1old {

    static class Gap implements Comparable {
        int position;
        int gap;
        Gap(int a, int b) {position = a; gap = b;}
        @Override
        public int compareTo(Object a) {
            Gap x = (Gap)a;
            return x.gap-this.gap; //descending order
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("barn1.in"));
        int M = in.nextInt(); //# of boards
        int S = in.nextInt(); //# of stalls
        int C = in.nextInt(); //# of occupied stalls
        int answerCount = 0;
        ArrayList<Integer> stalls = new ArrayList();
        ArrayList<Gap> gaps = new ArrayList();
        for (int z = 0; z < C; z++) {
            int temp = in.nextInt();
            stalls.add(temp);
        }
        Collections.sort(stalls);
        for (int z = 0; z < C; z++) {
            if (z > 0) gaps.add(new Gap(z,stalls.get(z)-stalls.get(z-1)));
        }

        Collections.sort(gaps);
        if (M == 1) {
            answerCount = stalls.get(C-1)-stalls.get(0)+1;
        }
        else if (M >= C) answerCount = C;
        else {

            int[] positions = new int[M - 1];
            for (int z = 0; z < M - 1; z++) {
                positions[z] = gaps.get(z).position;
            }
            Arrays.sort(positions);
            int starter = stalls.get(0);
            int lastOne = 0;
            int posCounter = 0;
            boolean gapsDone = false;


            for (int z = 0; z < C; z++) {
                if (!gapsDone && z == positions[posCounter]) {
                    answerCount += lastOne - starter + 1;
                    starter = stalls.get(z);
                    posCounter++;
                    if (posCounter == M - 1) gapsDone = true;
                }
                if (z == C - 1) {
                    answerCount += stalls.get(z) - starter + 1;
                    break;
                }

                lastOne = stalls.get(z);
            }
        }


        BufferedWriter out = new BufferedWriter(new FileWriter("barn1.out"));
        out.write(answerCount + "\n");
        System.out.println(answerCount);
        out.close();

    }

}
