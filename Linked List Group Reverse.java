class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;

        while (head != null) {
            Node groupStart = head;
            Node prev = null;
            Node curr = head;

            int count = 0;
            // reverse k nodes or until end of list
            while (count < k && curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // connect reversed group with previous part
            prevGroupEnd.next = prev;
            groupStart.next = curr;

            // move pointers
            prevGroupEnd = groupStart;
            head = curr;
        }

        return dummy.next;
    }
}

    
