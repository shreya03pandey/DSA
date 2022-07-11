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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
            return head;
      
        ListNode x=head;
        ListNode oddHead=x;
        ListNode y=head.next;
        ListNode evenHead=y;
        int i=3;
        ListNode curr=head.next.next;
        while(curr!=null)
        {
            if(i%2!=0)
            {
              x.next=curr;
                x=x.next;
            }
            else
            {
                y.next=curr;
                y=y.next;
            }
            curr=curr.next;
            i++;
        }
       x.next=evenHead;
        y.next=null;
        return head;
    }
}