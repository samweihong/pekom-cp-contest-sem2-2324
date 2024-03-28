import java.io.*;
import java.util.*;

public class Group1 {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int k = in.nextInt();
        while (k-- > 0) {
            int n = in.nextInt();
            int t = in.nextInt();

            ArrayList<PriorityQueue<Integer>> timelist = new ArrayList<>();
            for (int i = 0; i <= t; i++) {
                timelist.add(new PriorityQueue<>(Collections.reverseOrder()));
            }

            for (int i = 0; i < n; i++) {
                int money = in.nextInt(), time = in.nextInt();
                timelist.get(time).add(money);
            }

            for (int i = 0; i < t; i++) {
                for (int count = 0; !timelist.get(i).isEmpty() && count <= i; count++) {
                    int add = timelist.get(i).poll();
                    timelist.get(i + 1).add(add);
                }
            }

            int res = 0;
            while (!timelist.get(t).isEmpty()) {
				res += timelist.get(t).poll();
			}
            out.println(res);
        }

        out.flush();
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
