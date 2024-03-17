import java.io.*;
import java.util.*;

public class Group2 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int a1 = in.nextInt(), b1 = in.nextInt();
            int a2 = in.nextInt(), b2 = in.nextInt();
            long[] time = new long[3];
            for (int i = 0; i < 3; i++) {
                time[i] = in.nextLong();
            }

            for (long t : time) {
                int count = 0;
                if (((t-1) % (a1 + b1)) < a1) count++;
                if (((t-1) % (a2 + b2)) < a2) count++;

                if (count == 0) {
                    out.println("none");
                } else if (count == 1) {
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
