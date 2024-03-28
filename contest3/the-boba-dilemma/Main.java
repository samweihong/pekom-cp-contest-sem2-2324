import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int k = in.nextInt();
        while (k-- > 0) {
            int n = in.nextInt();
            int t = in.nextInt();

            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int money = in.nextInt(), time = in.nextInt();
                map.putIfAbsent(time, new ArrayList<>());
                map.get(time).add(money);
            }

            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int time = t-1; time >= 0; time--) {
                for (int money : map.getOrDefault(time, Collections.emptyList())) {
                    pq.offer(money);
                }
                if (pq.isEmpty()) continue;
                int bestMoney = pq.poll();
                answer += bestMoney;
            }
            out.println(answer);
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
