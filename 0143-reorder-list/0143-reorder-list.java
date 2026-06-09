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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        head2=reverse(head2);
        ListNode i=head;
        ListNode j=head2;
        ListNode dummy=new ListNode(-1);
        ListNode k=dummy;
        while(i!=null || j!=null){
            if(i!=null){
                k.next=i;
                k=k.next;
                i=i.next;
            }
            if(j!=null){
                k.next=j;
                k=k.next;
                j=j.next;
            }
            k.next=null;
        
        }
    }
}