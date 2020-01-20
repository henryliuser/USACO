/*
ID: henryli3
LANG: JAVA
PROG: barn1
*/
import java.util.*;
import java.io.*;
public class barn1 {

    static class Gap implements Comparable {
        int position;
        int gap;
        Gap(int a, int b) {
            position = a;
            gap = b;
        }
        @Override
        public int compareTo(Object a) {
            Gap x = (Gap) a;
            return x.gap - this.gap; //descending order
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
        answerCount = stalls.get(C-1)-stalls.get(0)+1;
        for (int z = 0; z < C; z++) {
            if (z > 0) gaps.add(new Gap(z, stalls.get(z) - stalls.get(z - 1)));
        }

        Collections.sort(gaps);
        if (M == 1) answerCount = stalls.get(C - 1) - stalls.get(0) + 1;
        else if (M >= C) answerCount = C;
        else for (int z = 0; z < M-1; z ++) answerCount -= (gaps.get(z).gap-1);
        BufferedWriter out = new BufferedWriter(new FileWriter("barn1.out"));
        out.write(answerCount + "\n");
        System.out.println(answerCount);
        out.close();
    }
}