class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode k=dummy;
        // ListNode i=l1;
        // ListNode j=l2;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                k.next=l1;
                l1=l1.next;
            }
            else{
                k.next=l2;
                l2=l2.next;
            }
            k=k.next;
        }
        if(l1!=null) k.next=l1;
        if(l2!=null) k.next=l2;
        return dummy.next;
    }
}