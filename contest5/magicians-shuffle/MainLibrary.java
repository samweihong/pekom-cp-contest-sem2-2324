import java.io.*;
import java.util.*;

public class MainLibrary {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();

        if (n == 0) {
            out.println("there is no card");
            out.close();
            return;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        list.sort(null);

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();

            if (c > b) {
                c -= b - a + 1;
            }

            List<Integer> temp = list.subList(a, b+1);
            LinkedList<Integer> sub = new LinkedList<>(temp);
            temp.clear();
            list.addAll(c+1, sub);
        }

        for (int i = 0; i < m; i++) {
            int o = in.nextInt(), p = in.nextInt();
            list.add(p, o);
        }

        StringBuilder sb = new StringBuilder();
        for (int v : list) {
            sb.append(v).append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        out.println(sb);

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
