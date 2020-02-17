import java.util.*;
import java.io.*;
public class milkvisits2 {

    static class Farm {
        char type;
        int num; //DEBUG CLARITY
        ArrayList<Farm> children = new ArrayList();
        Farm(char x, int a) {type = x; num = a;}
    }

    static Farm[] farms;
    static StringBuilder ans;

    static boolean done = false;
    static HashMap<Character, Integer> counts = new HashMap();

    static void dfs(Farm start, Farm goal) {
        if (start.children.size()==0) {
            counts.put(start.type,counts.get(start.type)-1);
        }
        else {
//            int H = 0, G = 0;
            for (Farm a:start.children) {

                if (a == goal) {
                    done = true;
//                    counts.put('G',counts.get('G')-G);
//                    counts.put('H',counts.get('H')-H);
                    return;
                }
                if (a.type == 'H') {
//                    H++;
                    counts.put(a.type,counts.get(a.type)+1);
                }
                else if (a.type == 'G') {
//                    G++;
                    counts.put(a.type,counts.get(a.type)+1);
                }
                dfs(a,goal);
                if (done) return;
            }
            counts.put(start.type,counts.get(start.type)-1);



        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("milkvisits.in"));
        int N = in.nextInt();
        int M = in .nextInt();
        farms = new Farm[N];
        ans = new StringBuilder();
        String prefs = in.next();
        counts.put('H',0);
        counts.put('G',0);
        for (int z = 0; z < N; z++) farms[z] = new Farm(prefs.charAt(z),z+1);
        for (int z = 0; z < N-1; z++) farms[in.nextInt()-1].children.add(farms[in.nextInt()-1]);

        for (int z = 0; z < M; z++) {
            Farm a = farms[in.nextInt()-1];
            Farm b = farms[in.nextInt()-1];
            char C = in.next().charAt(0); //charAt thing is stupid but yes "H" => 'H'
            if (a.num == b.num) {
                if (a.type==C)ans.append("1");
                else ans.append("0");
            }
            else if (a.type == C || b.type == C) ans.append("1");
            else {
                dfs(a,b);
                if ( (C == 'H' && counts.get('H') > 0) || (C == 'G' && counts.get('G') > 0) ) ans.append("1");
                else ans.append("0");
            }

            done = false; //reset shit
            counts.put('H',0);
            counts.put('G',0);

        }

        BufferedWriter out = new BufferedWriter(new FileWriter("milkvisits.out"));
        out.write(ans.toString() + "\n");
        System.out.println(ans.toString());
        out.close();

    }



}
