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
    public ListNode removeLeadingZeros(ListNode head) {
        while (head != null && head.val == 0 && head.next != null) {
            head = head.next;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1=removeLeadingZeros(head1);
        head2=removeLeadingZeros(head2);
        head1=reverse(head1);
        head2=reverse(head2);
        ListNode t1=head1;
        ListNode t2= head2;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        while(t1!=null || t2!=null){
            int x=(t1!=null)?t1.val:0;
            int y=(t2!=null)?t2.val:0;
            int sum=carry+x+y;
            carry=sum/10;
            curr.next=new ListNode (sum%10);
            curr=curr.next;
            
            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;
        }
        if(carry!=0){
            curr.next=new ListNode (carry);
        }
        return reverse(dummy.next);
    }

}