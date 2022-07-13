// { Driver Code Starts
import java.util.*;
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next, prev;
    Node(int key)
    {
        data = key;
        next = prev = null;
    }
}

class Driverclass
{
    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        int a1 = sc.nextInt();
	        Node head = new Node(a1);
	        Node temp = head;
	        
	        for (int i = 1;i < n;i++)
	        {
	            int a = sc.nextInt();
	            Node n1 = new Node(a);
	            n1.prev = temp;
	            temp.next = n1;
	            temp = n1;
	        }
	        
	        head = new LinkedList().sortDoubly(head);
	        printList(head);
	    }
	}
	public static void printList(Node node)
	{
	    Node temp = node;
	    while(node != null)
	    {
	        System.out.print(node.data + " ");
	        temp = node;
	        node = node.next;
	    }
	    System.out.println();
	    while(temp != null)
	    {
	        System.out.print(temp.data + " ");
	        temp = temp.prev;
	    }
	    System.out.println();
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class LinkedList
{
    //Function to sort the given doubly linked list using Merge Sort.
   
    static Node sortDoubly(Node head)
    {
        // add your code here
        if(head==null||head.next==null) return head;
        
        Node slow = head;
	Node fast = head;
	Node prev = null;
	
	while (fast!=null && fast.next!=null) {
	    prev = slow;
	    slow = slow.next;
	    fast = fast.next.next;
	}
	prev.next = null;
	slow.prev = null;
	
	Node head1 = sortDoubly(head);
	Node head2 = sortDoubly(slow);
	return mergeSort(head1, head2);
    }
    static Node mergeSort(Node h1,Node h2)
    {
        Node dummy=new Node(-1);
        Node res=dummy;
        while(h1!=null&&h2!=null)
        {
            if(h1.data<=h2.data)
            {
                dummy.next=h1;
                h1.prev=dummy;
                
                h1=h1.next;
            }
            else
            {
               dummy.next=h2;
                h2.prev=dummy;
                
                h2=h2.next; 
            }
            dummy=dummy.next;
        }
        while(h1!=null)
        {
               dummy.next=h1;
                h1.prev=dummy;
                dummy=dummy.next;
                h1=h1.next;
        }
        while(h2!=null)
        {
               dummy.next=h2;
                h2.prev=dummy;
                dummy=dummy.next;
                h2=h2.next;
        }
       
       
       
      Node re=res.next;
      re.prev=null;
        return re;
    }

   //Function to sort the given doubly linked list using Merge Sort.
      

   
}