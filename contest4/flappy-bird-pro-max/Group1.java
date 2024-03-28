import java.io.*;
import java.util.*;

public class Group1 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int count(int[] h, int init) {
        int res = 0;
        for (int i = 0; i < h.length; i++) {
            if (h[i] >= init) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int h = in.nextInt(), n = in.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = in.nextInt();
            bottom[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE, count = 0;
        for (int i = 1; i <= h; i++) {
            int ads = count(bottom, i) + count(top, h-i+1);
            if (ads < min) {
                min = ads;
                count = 1;
            } else if (ads == min) {
                count++;
            }
        }
        out.println(min + " " + count);

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
