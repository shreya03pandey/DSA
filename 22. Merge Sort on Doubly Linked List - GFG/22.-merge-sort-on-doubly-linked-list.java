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
   
    

   //Function to sort the given doubly linked list using Merge Sort.
      static Node getMid(Node root){
       if(root == null) return null;
       Node fast = root.next, slow = root;
       while(fast != null && fast.next != null){
           slow =  slow.next;
           fast = fast.next.next;
       }
       return slow;
   }
   
   static Node sort(Node left, Node right){
       Node Result = null, dummy = null, pre = null;
       while(left != null && right != null){
           if(left.data < right.data){
               if(Result == null){
                   Result = left;
                   dummy = Result;
               } else {
                   dummy.next = left;
                   left.prev= dummy;
                   dummy = dummy.next;
               }
               
               
               left = left.next;
           } else {
               if(Result == null){
                   Result = right;
                   dummy = Result;
               } else {
                   dummy.next = right;
                   right.prev= dummy;
                   dummy = dummy.next;
               }
               
               right = right.next;
           }
       }
       
       if(left != null){
               if(Result == null){
                   Result = left;
                   dummy = Result;
               } else {
                   dummy.next = left;
                   left.prev= dummy;
                   dummy = dummy.next;
               }
               
               
               left = left.next; 
       } else if(right != null){
               if(Result == null){
                   Result = right;
                   dummy = Result;
               } else {
                   dummy.next = right;
                   right.prev= dummy;
                   dummy = dummy.next;
               }
               right = right.next;
       }
       
       return Result;
   }
   
   static Node merge(Node root){
           if(root.next == null) return root;
           Node mid = getMid(root);
           Node temp = mid.next;
           mid.next = null;
           temp.prev = null;
           Node left = merge(root);
           Node right = merge(temp);
           Node result = sort(left, right);
           return result;
   }
   
   static Node sortDoubly(Node head){
       return merge(head);
   }


   
}