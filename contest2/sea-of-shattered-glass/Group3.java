import java.io.*;
import java.util.*;

public class Group3 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
        }

        long happiness = Long.MAX_VALUE;

        for (int first = 0; first < n; first++) {
            int second = 0; while (second == first) second++;
            int third = 0; while (third == first || third == second) third++;

            long krabsAttackSecond = c[second] - d[third];
            long krabsAttackThird = c[third] - d[second];
            long krabsHappiness = Math.max(krabsAttackSecond, krabsAttackThird);

            happiness = Math.min(happiness, -d[first] + krabsHappiness);
        }

        out.println(happiness);

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
