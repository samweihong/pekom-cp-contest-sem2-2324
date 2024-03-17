import java.io.*;
import java.util.*;

public class Group1 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        Integer[] d = new Integer[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
        }

        Arrays.sort(d, Collections.reverseOrder());

        long happiness = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                happiness -= d[i];
            } else {
                happiness += 1;
            }
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
