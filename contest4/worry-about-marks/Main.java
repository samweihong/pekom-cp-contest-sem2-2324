import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int left(double[] marks, double q) {
        int i = 0, j = marks.length - 1;
        int res = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (marks[mid] >= q) {
                j = mid - 1;
            } else {
                i = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    static int right(double[] marks, double q) {
        int i = 0, j = marks.length - 1;
        int res = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (marks[mid] <= q) {
                i = mid + 1;
            } else {
                j = mid - 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int N = in.nextInt();
        double[] marks = new double[N];
        for (int i = 0; i < N; i++) {
            marks[i] = in.nextDouble();
        }

        Arrays.sort(marks);

        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            double q = in.nextDouble();
            int left = left(marks, q);
            int right = right(marks, q);

            if (left == -1) {
                out.print("0 ");
            } else {
                out.print(left + 1 + " ");
            }
            if (right == -1) {
                out.print("0 ");
            } else {
                out.print(N - right + " ");
            }

            if (left == -1) {
                out.print("- ");
            } else {
                out.printf("%.2f ", marks[left]);
            }
            if (right == -1) {
                out.println("-");
            } else {
                out.printf("%.2f\n", marks[right]);
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
