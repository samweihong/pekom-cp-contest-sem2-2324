import java.io.*;
import java.util.*;

public class Group1 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int N = in.nextInt();
        double[] marks = new double[N];
        for (int i = 0; i < N; i++) {
            marks[i] = in.nextDouble();
        }

        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            double q = in.nextDouble();

            double left = -1, right = Double.MAX_VALUE;
            int leftCount = 0, rightCount = 0;
            for (int j = 0; j < N; j++) {
                if (marks[j] < q) {
                    left = Math.max(left, marks[j]);
                    leftCount++;
                } else if (marks[j] > q) {
                    right = Math.min(right, marks[j]);
                    rightCount++;
                }
            }

            out.print(leftCount + " " + rightCount + " ");
            if (left == -1) {
                out.print("- ");
            } else {
                out.printf("%.2f ", left);
            }
            if (right == Double.MAX_VALUE) {
                out.println("-");
            } else {
                out.printf("%.2f\n", right);
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
