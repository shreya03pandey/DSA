/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int l1=0,l2=0;
         ListNode head1=headA,head2=headB;
        while(head1!=null)
        {
            l1++;
            head1=head1.next;
        }
        while(head2!=null)
        {
            l2++;
            head2=head2.next;
        }
       
        
        while(l1>l2)
        {
          headA=headA.next;
            l1--;
        }
         while(l2>l1)
        {
          headB=headB.next;
            l2--;
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}