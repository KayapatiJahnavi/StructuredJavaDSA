class Solution {
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for the two lists
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // Pointers to build the lists
        ListNode before = beforeHead;
        ListNode after = afterHead;

        // Traverse original list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // End the "after" list
        after.next = null;

        // Connect before list with after list
        before.next = afterHead.next;

        return beforeHead.next;
    }

    // Helper to print list (for testing)
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    }
