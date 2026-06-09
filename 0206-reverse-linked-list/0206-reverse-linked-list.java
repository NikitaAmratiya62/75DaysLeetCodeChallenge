class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fwd = null;

        while (curr != null) {
            fwd = curr.next; 
            curr.next = prev;              
            prev = curr;                   
            curr = fwd;              
        }

        return prev;
    }
}