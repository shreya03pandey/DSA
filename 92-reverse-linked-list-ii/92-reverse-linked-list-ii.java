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
    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode prev=null;
        ListNode curr=new ListNode(-1);
        curr.next=head;
        int n=left-1;
        int m=right-left;
        while(n-->0)
            curr=curr.next;
 
        ListNode rev=curr.next;
        while(m-->0)
        {
            ListNode temp=rev.next;        
            rev.next=rev.next.next;
            temp.next=curr.next;
            curr.next=temp;
        }
            if(left==1)
            head=curr.next;
         
            return head;
    }
}