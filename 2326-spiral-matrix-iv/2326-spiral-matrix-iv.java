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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] matrix=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(matrix[i],-1);
        }
        ListNode temp=head;
        int fr=0,fc=0,lr=m-1,lc=n-1;
        while(temp!=null && fr<=lr && fc<=lc){
             for(int j=fc;j<=lc && temp!=null;j++){
                matrix[fr][j]=temp.val;
                temp=temp.next;
            }
            fr++;
            for(int i=fr;i<=lr && temp!=null;i++){
                matrix[i][lc]=temp.val;
                temp=temp.next;
            }
            lc--;
            for(int j=lc;j>=fc && temp!=null;j--){
                matrix[lr][j]=temp.val;
                temp=temp.next;
            }
            lr--;
            for(int i=lr;i>=fr && temp!=null;i--){
                matrix[i][fc]=temp.val;
                temp=temp.next;
            }
            fc++;
            }
            return matrix;
    }
}