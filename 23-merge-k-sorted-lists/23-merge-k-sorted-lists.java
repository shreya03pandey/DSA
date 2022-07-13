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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode>pq=new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2)
            {
                if(l1.val>l2.val)
                    return 1;
                else
                    if(l1.val<l2.val)
                        return -1;
                else
                    return 0;
            }
        });
        
           for(ListNode node:lists)
           {
               if(node!=null)
                   pq.add(node);
           }
            ListNode dummy=new ListNode(-1);
            ListNode curr=dummy;
            while(!pq.isEmpty())
            {
                ListNode x=pq.poll();
                curr.next=x;
                curr=curr.next;
                if(x.next!=null)
                    pq.add(x.next);
            }
            return dummy.next;
        }
}