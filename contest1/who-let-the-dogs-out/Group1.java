import java.io.*;
import java.util.*;

public class Group1 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static void solve(int a, int b, int[] time, int[] count) {
        int maxTime = Math.max(time[0], Math.max(time[1], time[2]));
        long period = a + b;
        long timeOverPeriod = 1;
        for (int curTime = 1; curTime <= maxTime; curTime++) {
            for (int i = 0; i < 3; i++) {
                if (time[i] == curTime && timeOverPeriod <= a) {
                    count[i]++;
                }
            }
            timeOverPeriod++;
            if (timeOverPeriod > period) {
                timeOverPeriod = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int a1 = in.nextInt(), b1 = in.nextInt();
            int a2 = in.nextInt(), b2 = in.nextInt();
            int[] time = new int[3];
            for (int i = 0; i < 3; i++) {
                time[i] = in.nextInt();
            }

            int[] count = new int[3];
            solve(a1, b1, time, count);
            solve(a2, b2, time, count);

            for (int cnt : count) {
                if (cnt == 0) {
                    out.println("none");
                } else if (cnt == 1) {
                    out.println("one");
                } else {
                    out.println("both");
                }
            }
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
