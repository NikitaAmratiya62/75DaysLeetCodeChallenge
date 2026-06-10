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
    
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        
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
        return dummy.next;
        
    }
}