import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt(), p = in.nextInt(), q = in.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }

        Arrays.sort(s);

        if (p == 0) {
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
        } else if (p == 1) {
            int positive = 0;
            for (int i = n-1; i >= 0; i--) {
                if (s[i] > 0) {
                    positive++;
                } else {
                    break;
                }
            }

            int remove = Math.min(positive, q);

            int noRelease = 0;
            for (int i = 0; i < n; i++) {
                if (i < n-remove) {
                    noRelease += s[i];
                } else {
                    noRelease -= s[i];
                }
            }

            int releaseNegative = Integer.MIN_VALUE;
            if (s[0] < 0) {
                releaseNegative = 0;

                for (int i = 1; i < n; i++) {
                    if (i < n-remove) {
                        releaseNegative += s[i];
                    } else {
                        releaseNegative -= s[i];
                    }
                }
            }

            int releasePositive = Integer.MIN_VALUE;
            if (s[n-1] > 0) {
                releasePositive = 0;
                remove = Math.min(positive-1, q);

                for (int i = 0; i < n-1; i++) {
                    if (i < n-1-remove) {
                        releasePositive += s[i];
                    } else {
                        releasePositive -= s[i];
                    }
                }
            }

            int dominance = Math.max(noRelease, Math.max(releaseNegative, releasePositive));
            out.println(dominance);
        } else {
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
        }

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
