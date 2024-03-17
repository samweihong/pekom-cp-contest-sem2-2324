import java.io.*;
import java.util.*;

public class Group2 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = in.nextInt();
        }

        long bestGold = 0, bestEnter = 0, bestExit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long gold = 0;
                for (int k = i; k <= j; k++) {
                    gold += r[k];
                }
                if (gold > bestGold || (gold == bestGold && j - i < bestExit - bestEnter)) {
                    bestGold = gold;
                    bestEnter = i;
                    bestExit = j;
                }
            }
        }

        if (bestGold == 0) {
            out.println("better leave");
        } else {
            out.print(bestGold + " " + (bestEnter+1) + " " + (bestExit+1));
        }
        out.close();
    }

    private static class Scanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine(){
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }

    }
}
