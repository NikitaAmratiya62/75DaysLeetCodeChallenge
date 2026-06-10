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
        if(head2==null || head2.next==null) return head2;
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp=dummy;
        for(int i=1;i<left;i++){
            temp=temp.next;
        }
        ListNode tail1=temp;
        ListNode head2=temp.next;
        for(int i=1;i<=right-left+1;i++){
            temp=temp.next;
        }
        ListNode tail2=temp;
        ListNode head3=temp.next;
        tail1.next=null;
        tail2.next=null;
        reverse(head2);
        tail1.next=tail2;
        head2.next=head3;
        return dummy.next;
    }
}