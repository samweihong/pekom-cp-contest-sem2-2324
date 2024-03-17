import java.io.*;
import java.util.*;

public class Group3 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt(), p = in.nextInt(), q = in.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }

        Arrays.sort(s);
        int[] pre = new int[n];
        pre[0] = s[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + s[i];
        }

        int dominance = Integer.MIN_VALUE;
        for (int release = 0; release <= p; release++) {
            int harry = sum(pre, 0, n-release-q-1);
            int bandit = sum(pre, Math.max(0, n-release-q), n-release-1);
            dominance = Math.max(dominance, harry - bandit);
        }
        out.println(dominance);
        
        out.close();
    }

    static int sum(int[] pre, int i, int j) {
        if (i > j) return 0;
        return (i == 0) ? pre[j] : pre[j] - pre[i-1];
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
