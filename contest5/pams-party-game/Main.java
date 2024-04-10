import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static class LinkedList {
        static class Node {
            int value;
            Node next;
            Node prev;

            Node(int value) { this.value = value; }
        }

        Node head = null;
        Node tail = null;

        Node addLast(int v) {
            Node newNode = new Node(v);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            return newNode;
        }

        Node delete(Node node) {
            Node next = node.next;

            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }

            return next;
        }

        Node addAfter(Node node, int v) {
            Node newNode = new Node(v);
            newNode.next = node.next;
            node.next = newNode;
            newNode.prev = node;
            if (newNode.next == null) {
                tail = newNode;
            } else {
                newNode.next.prev = newNode;
            }
            return newNode;
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int x = in.nextInt();
        n *= 2;
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            names.add(in.next());
        }

        ArrayList<LinkedList.Node> nodes = new ArrayList<>();
        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            nodes.add(list.addLast(i));
        }

        LinkedList.Node mic = list.head;
        String query = in.nextLine();
        for (int i = 0; i < x; i++) {
            char c = query.charAt(i);

            if (c == 'B') {
                mic = mic.prev;
            } else if (c == 'C') {
                mic = mic.next;
            } else if (c == 'D') {
                int cur = mic.value;
                mic = list.delete(mic);
                if (mic == null) mic = list.head;

                list.addLast(cur);
                nodes.set(cur, list.tail);
            } else if (c == 'E') {
                int cur = mic.value;
                mic = list.delete(mic);
                if (mic == null) mic = list.head;

                int partner = (cur % 2 == 1) ? cur - 1 : cur + 1;
                LinkedList.Node partnerNode = nodes.get(partner);
                nodes.set(cur, list.addAfter(partnerNode, cur));
            } else {
                int cur = mic.value;
                int partner = (cur % 2 == 1) ? cur - 1 : cur + 1;
                out.println(names.get(partner));
            }
        }

        out.println();
        for (LinkedList.Node node = list.head; node != null; node = node.next) {
            out.println(names.get(node.value));
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
