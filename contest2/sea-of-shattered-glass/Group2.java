import java.io.*;
import java.util.*;

public class Group2 {
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

        long paintyAttackFirst = -d[0] + c[1];
        long paintyAttackSecond = -d[1] + c[0];
        long happiness = Math.min(paintyAttackFirst, paintyAttackSecond);

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
