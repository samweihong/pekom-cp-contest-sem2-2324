import java.io.*;
import java.util.*;

public class Group2 {
    static Scanner in = new Scanner(System.in);

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
            System.out.println(answer);
        }

        System.out.flush();
    }
}
