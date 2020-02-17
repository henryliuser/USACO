import java.util.*;
import java.io.*;

public class meetings {

    static class Cow implements Comparable {
        double w,x,v;
        double timeTilBarn;
        Cow(int a, int b, int c) {
            w = a;
            x = b;
            v = c;
        }
        Cow(Cow c){this.w=c.w; this.x=c.x; this.v=c.v;}

        public int compareTo(Object o) {
            Cow a = (Cow)o;
            if (this.x < a.x) return -1;
            else if (this.x > a.x) return 1;
            else return 0;
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
            if (a.v < 0) { //going back
                int numBehindComingTowards = 0;
                int numAheadComingTowards = 0;
                Cow rightMost = null;
                for (int b = 0; b < z; b++) {
                    Cow c = cows.get(b);
                    if (c.v > 0) {
                        if (rightMost == null) rightMost = c;
                        numBehindComingTowards++;
                        if (!a.collided.contains(c)) {
                            collisions.add(timeTil(a, c));
//                            int w = a.w;
//                            a.w = c.w;
//                            c.w = w;
                            c.collided.add(a);
                            a.collided.add(c);
                        }
                    }
                }
                for (int b = z +1; b < N;b++) {
                    Cow c = cows.get(b);
                    if (c.v < 0) numAheadComingTowards++;
                }
                if (numBehindComingTowards > numAheadComingTowards) {
                    Cow temp = new Cow(a);
                    temp.x = (temp.x+rightMost.x)/2.0;
                    temp.v *= -1;
                    barnings.add(new Barning(timeTil(temp,L),temp));
                }
                else barnings.add(new Barning(timeTil(a,0),a));
            }


            else { //going forwards
                ArrayList<Cow> rightTowards = new ArrayList();
                ArrayList<Cow> leftTowards = new ArrayList();
                Cow leftMost = null;
                Cow rightMost = null;
                for (int b = N-1; b > z; b--) {
                    Cow c = cows.get(b);
                    if (c.v < 0) {
                        rightTowards.add(c);
                        if (rightMost == null) rightMost = c;
                        if (!a.collided.contains(c)) {
                            collisions.add(timeTil(a, c));
                            c.collided.add(a);
                            a.collided.add(c);
                        }
                    }
                }
                for (int b = 0; b < z; b++) {
                    Cow c = cows.get(b);
                    if (c.v > 0) {
                        leftTowards.add(c);
                    }
                }
                    //k this shit not gonna work i giveu p
                int destination = 0;
                Cow temp = null;
                if (leftTowards.size() > rightTowards.size()) {
                    temp = new Cow(leftTowards.get(rightTowards.size()-1));
                    temp.v *= -1;
                    destination = L;
                }
                else if (rightTowards.size() == 0) {}
                else if (rightTowards.size()-leftTowards.size() == 1) {
                    temp = new Cow(rightMost);
                }
                barnings.add(new Barning(timeTil(temp,0),temp));
//                else barnings.add(new Barning(timeTil(a, L),a));
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
