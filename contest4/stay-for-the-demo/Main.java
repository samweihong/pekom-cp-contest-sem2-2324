import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static long count(int[] a, int[] b, int t) {
        long count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (t < a[i]) continue;
            count += (t - a[i]) / b[i] + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] c = new int[m], d = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = in.nextInt();
            d[i] = in.nextInt();
        }

        int i = 1, j = t-1;
        int res = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            boolean pos = count(a, b, mid) <= count(c, d, t - mid);
            if (pos) {
                res = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        out.println(res);
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
