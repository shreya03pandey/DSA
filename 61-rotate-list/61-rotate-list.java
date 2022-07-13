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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return head;
        ListNode slow=head,fast=head;
        int s=1;
        while(fast.next!=null)
        {
            s++;
            fast=fast.next;
        }
        for(int i=s-k%s;i>1;i--)
        {
           slow=slow.next;
        }
        fast.next=head;
        ListNode temp=slow.next;
        slow.next=null;
        return temp;
        
    }
}