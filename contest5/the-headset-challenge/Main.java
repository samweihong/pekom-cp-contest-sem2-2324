import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static LinkedList.Node dummy = new LinkedList.Node(' ');

    static class LinkedList {
        Node head = dummy;
        Node tail = dummy;

        static class Node {
            char value;
            Node prev;
            Node next;

            Node(char value) {
                this.value = value;
            }
        }

        void deleteBefore(Node cur) {
            if (cur.prev == null) return;

            cur.prev = cur.prev.prev;

            if (cur.prev != null) {
                cur.prev.next = cur;
            } else {
                head = cur;
            }
        }

        void add(Node cur, char value) {
            LinkedList.Node newNode = new LinkedList.Node(value);
            newNode.next = cur;
            newNode.prev = cur.prev;

            cur.prev = newNode;

            if (newNode.prev != null) {
                newNode.prev.next = newNode;
            } else {
                head = newNode;
            }
        }
    }

    public static void main(String[] args) {
        String input = in.nextLine();

        LinkedList list = new LinkedList();
        LinkedList.Node cur = list.head;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '<') {
                if (cur.prev != null)
                    cur = cur.prev;
            } else if (c == '>') {
                if (cur.next != null)
                    cur = cur.next;
            } else if (c == 'X') {
                list.deleteBefore(cur);
            } else {
                list.add(cur, c);
            }
        }

        cur = list.head;
        while (cur != dummy) {
            out.print(cur.value);
            cur = cur.next;
        }
        out.println();

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
