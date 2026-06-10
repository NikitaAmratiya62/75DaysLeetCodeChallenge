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
    public ListNode reverse(ListNode head2){
        ListNode prev=null;
        ListNode fwd=null;
        ListNode curr=head2;
        while(curr!=null){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast= head;
        while(fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        head2=reverse(head2);
        ListNode i=head;
        ListNode j=head2;
        int sum,max=-1;
        while(i!=null && j!=null){
            sum=i.val+j.val;
            max=Math.max(sum,max);
            i=i.next;
            j=j.next;
        }
        return max;
    }
}