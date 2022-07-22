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
    public ListNode partition(ListNode head, int x) {
      ListNode temp1=new ListNode(-1);
        ListNode h1=temp1;
        ListNode temp2=new ListNode(-1);
        ListNode h2=temp2;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode newe=new ListNode(curr.val);
            if(curr.val<x)
            {
                temp1.next=newe;
                temp1=temp1.next;
            }
            else
            {
                temp2.next=newe;
                temp2=temp2.next;
            }
            curr=curr.next;
        }
        temp1.next=h2.next;
        return h1.next;
    }
}