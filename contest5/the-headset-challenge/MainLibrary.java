import java.io.*;
import java.util.*;

public class MainLibrary {
    static Scanner scanner = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        String input = scanner.nextLine();
        LinkedList<Character> letterList = new LinkedList<>();
        ListIterator<Character> cursor = letterList.listIterator();

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            switch (cur) {
                case '<':
                    if (cursor.hasPrevious())
                        cursor.previous();
                    break;
                case '>':
                    if (cursor.hasNext())
                        cursor.next();
                    break;
                case 'X':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                default:
                    cursor.add(cur);
                    break;
            }
        }
        for (char c : letterList) {
            out.print(c);
        }
        out.println();
        out.flush();
    }

    private static class Scanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
