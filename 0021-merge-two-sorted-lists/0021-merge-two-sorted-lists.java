class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode k=dummy;
        ListNode i=l1;
        ListNode j=l2;
        while(i!=null && j!=null){
            if(i.val<=j.val){
                k.next=i;
                i=i.next;
            }
            else{
                k.next=j;
                j=j.next;
            }
            k=k.next;
        }
        if(i!=null) k.next=i;
        if(j!=null) k.next=j;
        return dummy.next;
    }
}