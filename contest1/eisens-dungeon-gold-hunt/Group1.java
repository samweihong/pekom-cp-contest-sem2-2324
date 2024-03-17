import java.io.*;
import java.util.*;

public class Group1 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = in.nextInt();
        }

        long bestGold = 0, bestEnter = -1, bestExit = -1;
        for (int i = 0; i < n; i++) {
            bestGold += r[i];
            if (r[i] != 0) {
                if (bestEnter == -1) bestEnter = i;
                bestExit = i;
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
