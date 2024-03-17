import java.io.*;
import java.util.*;

public class Main {
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

        ArrayList<Pair<Integer, Integer>> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diff.add(new Pair<>(c[i] + d[i], i));
        }
        diff.sort(Collections.reverseOrder());

        long happiness = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                happiness -= d[diff.get(i).second];
            } else {
                happiness += c[diff.get(i).second];
            }
        }
        out.println(happiness);

        out.close();
    }

    private static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        U first;
        V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair<U, V> o) {
            return first.compareTo(o.first) == 0 ? second.compareTo(o.second) : first.compareTo(o.first);
        }
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
