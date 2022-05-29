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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode first=head;
        int k=n;
        while(k-->0)
        {
            first=first.next;
        }
         if(first==null)
               return head.next;
        ListNode sec=head;
        while(first.next!=null)
        {
            first=first.next;
            sec=sec.next;
        }
        if(sec.next!=null)
        sec.next=sec.next.next;
        return head;
    }
}