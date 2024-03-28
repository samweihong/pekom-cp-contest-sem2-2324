import java.io.*;
import java.util.*;

public class Group2 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }
        int[] l = new int[m];
        for (int i = 0; i < m; i++) {
            l[i] = in.nextInt();
        }

        Arrays.sort(t);
        Arrays.sort(l);

        int answer = 0;
        int j = 0;
        for (int i = 0; i < m && j < n; i++) {
            if (l[i] < t[j]) continue;
            answer++;
            j++;
        }
        System.out.println(answer);
        System.out.close();
    }
}
