/*
ID: henryli3
LANG: JAVA
PROG: milk
*/
import java.util.*;
import java.io.*;
public class milk {

    static class Farmer implements Comparable {
        int price = 0;
        int amount = 0;
        Farmer(int P, int A) {
            price = P;
            amount = A;
        }
        @Override
        public int compareTo(Object a) {
            Farmer b = (Farmer)a;
            return this.price-b.price;
        }
        @Override
        public String toString() {
            return price + " " + amount;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("milk.in"));
        ArrayList<Farmer> list = new ArrayList();
        int priceCounter = 0;
        int N = in.nextInt();
        int M = in.nextInt();
        for (int z = 0; z < M; z++) {
            list.add(new Farmer(in.nextInt(),in.nextInt()));
        }
        Collections.sort(list);
        for (Farmer a: list) {
            if (a.amount > N) {
                priceCounter += N*a.price;
                break;
            }
            else {
                priceCounter += a.price*a.amount;
                N-=a.amount;
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("milk.out"));
        out.write(priceCounter + "\n");
        System.out.println(priceCounter);
        out.close();

    }

}
