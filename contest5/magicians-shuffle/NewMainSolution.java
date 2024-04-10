import java.io.*;
import java.util.*;

public class NewMainSolution {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        ListNode head = null;
        ListNode curr = head;

        if (n == 0) {
            out.println("there is no card");
            out.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                head = new ListNode(in.nextInt());
                curr = head;
                continue;
            }
            curr.next = new ListNode(in.nextInt());
            curr = curr.next;
        }

        ListNode ans = sortList(head);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int startingInd = in.nextInt();
            int endingInd = in.nextInt();
            int targetInd = in.nextInt();
            ans = moveSegmentToIndex(ans, startingInd, endingInd, targetInd, n);
        }
        for(int i = 0; i < m; i++){
            int value = in.nextInt();
            int index = in.nextInt();
            ans = insertAtIndex(ans, index, value);
        }
        while (ans != null) {
            out.print(ans.val);
            if (ans.next != null) {
                out.print(" ");
            }
            ans = ans.next;
        }
        out.close();
    }

    public static ListNode insertAtIndex(ListNode head, int index, int value) {
        ListNode newNode = new ListNode(value);

        if (index == 0) {
            newNode.next = head;
            return newNode;
        }
        ListNode current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
        return head;
    }
    
    public static ListNode moveSegmentToIndex(ListNode head, int startingInd, int endingInd, int targetInd, int n) {
        ListNode prev = head;
        ListNode curr = head;
        if (startingInd == targetInd || endingInd == targetInd) {
            return head;
        }
        ListNode target = null;
        ListNode prevStart = null;
        ListNode start = null;
        ListNode end = null;
        int ind = 0;
        while (curr != null) {
            if (target != null && start != null && end != null) {
                break;
            }
            if (ind == targetInd) {
                target = curr;
            }
            if (ind == startingInd) {
                prevStart = prev;
                start = curr;
            }
            if (ind == endingInd) {
                end = curr;
            }
            prev = curr;
            curr = curr.next;
            ind++;
        }
        if (startingInd == 0) {
            head = end.next;
        } else {
            prevStart.next = end.next;
        }
        end.next = target.next;
        target.next = start;
        return head;
    }

    public static ListNode mergeTwo(ListNode L1, ListNode L2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (L1 != null && L2 != null) {
            if (L1.val <= L2.val) {
                curr.next = L1;
                L1 = L1.next;
            } else {
                curr.next = L2;
                L2 = L2.next;
            }
            curr = curr.next;
        }
        if (L1 != null) {
            curr.next = L1;
        } else {
            curr.next = L2;
        }
        return dummy.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = findMiddle(head);
        ListNode nextToMid = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextToMid);

        return mergeTwo(left, right);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
