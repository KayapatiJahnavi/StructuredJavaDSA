class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // ✅ Fix: Add this static method inside ListNode
    public static ListNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("[]")) return null;

        data = data.replaceAll("\\[|\\]|\\s", "");
        String[] parts = data.split(",");

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }

        return dummy.next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}

// Optional: Use this for local testing
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head = ListNode.deserialize("[1,1,2,3,3]");
        ListNode result = sol.deleteDuplicates(head);
        printList(result);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
