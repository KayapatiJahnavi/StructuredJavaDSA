class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node before head to simplify edge cases
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy; // Pointer to the node before the current sequence

        while (head != null) {
            // If current value is duplicated
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with this value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Remove the duplicates
                prev.next = head.next;
            } else {
                // No duplicate, move prev forward
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
} 
