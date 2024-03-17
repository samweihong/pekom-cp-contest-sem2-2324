import java.io.*;
import java.util.*;

public class Group1 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt(), p = in.nextInt(), q = in.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }

        Arrays.sort(s);
        int positive = 0;
        for (int i = n-1; i >= 0; i--) {
            if (s[i] > 0) {
                positive++;
            } else {
                break;
            }
        }

        int remove = Math.min(positive, q);

        int dominance = 0;
        for (int i = 0; i < n; i++) {
            if (i < n-remove) {
                dominance += s[i];
            } else {
                dominance -= s[i];
            }
        }
        out.println(dominance);

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
