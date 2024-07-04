 class Solution {
    public ListNode mergeNodes(ListNode head) {
        // Initialize pointers
        ListNode ptr = head.next; // Pointer to traverse and sum the nodes
        ListNode sumPtr = ptr; // Pointer to update the node with the sum

        while (sumPtr != null) {
            int sum = 0;
            // Sum all values until a zero is encountered
            while (sumPtr.val != 0) {
                sum += sumPtr.val;
                sumPtr = sumPtr.next;
            }

            // Update the node's value with the sum
            ptr.val = sum;
            // Move sumPtr to the first node of the next block
            sumPtr = sumPtr.next;
            // Move ptr to the next node to update
            ptr.next = sumPtr;
            ptr = ptr.next;
        }
        return head.next;
    }
}
