import java.util.*;
import java.io.*;

public class meetings3 {

    static class Cow implements Comparable {
        int w,x,v;
        double timeTilBarn;
        Cow(int a, int b, int c) {
            w = a;
            x = b;
            v = c;
        }
        public int compareTo(Object o) {
            Cow a = (Cow)o;
            return this.x-a.x;
        }
        HashSet<Cow> collided = new HashSet();
    }

    static class Barning implements Comparable {
        double time;
        Cow c;
        Barning(double a, Cow c) {time = a; this.c = c;}
        public int compareTo(Object o) {
            Barning a = (Barning)o;
            if (this.time < a.time) return -1;
            else if (this.time > a.time) return 1;
            else return 0;
        }
    }

    static double timeTil(Cow a, Cow b) {
        return ((double)a.x - b.x)/(b.v-a.v);
    }

    static double timeTil(Cow a, int b) {
        return ((double)b-a.x)/a.v;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("meetings.in"));
        int N = in.nextInt();
        int L = in.nextInt();
        int activeWeight = 0;

        ArrayList<Cow> cows = new ArrayList(); //populate the array
        for (int z = 0; z < N; z++) {
            int temp = in.nextInt();
            activeWeight += temp;
            cows.add(new Cow(temp,in.nextInt(),in.nextInt()));
        }
        double halfTotal = activeWeight/2.0;
        double barnWeight = 0;
        Collections.sort(cows);

        ArrayList<Barning> barnings = new ArrayList();
        ArrayList<Double> collisions = new ArrayList();
        int collisionCounter = 0; //answer

        for (int z = 0; z < N; z++) {
            Cow a = cows.get(z);
            if (a.v < 0) {
                barnings.add(new Barning(timeTil(a,0),a));
                for (int b = 0; b < z; b++) {
                    Cow c = cows.get(b);
                    if (c.v > 0) {
                        if (!a.collided.contains(c)) {
                            collisions.add(timeTil(a, c));
                            c.collided.add(a);
                            a.collided.add(c);
                        }
                    }
                }
            }
            else {
                barnings.add(new Barning(timeTil(a, L),a));
                for (int b = z+1; b < N; b++) {
                    Cow c = cows.get(b);
                    if (c.v < 0) {
                        if (!a.collided.contains(c)) {
                            collisions.add(timeTil(a, c));
                            c.collided.add(a);
                            a.collided.add(c);
                        }
                    }
                }
            }
        }

        Collections.sort(collisions);
        Collections.sort(barnings);
        boolean done = false;
        for (Barning b: barnings) {
            double t = b.time;
            for (int z = 0; z < collisions.size(); z++) {
                double c = collisions.get(z);
                if (t >= c) { //maybe this is >=
                    collisionCounter++;
                    collisions.remove(0);
                    z--;
                }
            }
            barnWeight += b.c.w;
            if (barnWeight >= halfTotal) {
                done = true;
                break;
            }
//            if (done) break;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("meetings.out"));
        out.write(collisionCounter + "\n");
        System.out.println(collisionCounter);
        out.close();

    }

}
