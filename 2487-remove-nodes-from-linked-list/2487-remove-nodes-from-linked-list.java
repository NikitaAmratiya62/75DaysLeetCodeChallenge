/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode fwd=null;
        ListNode curr=head;
        while(curr!=null){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        ListNode head2=reverse(head);
        ListNode i=head2;
        ListNode j=head2.next;
        while(j!=null){
            if(j.val>=i.val){
                i.next=j;
                i=j;
            }
            j=j.next;
        }
        i.next=j;
        return reverse(head2);

    }
}