// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node dummy1=new Node(-1);
         Node dummy2=new Node(-1);
           Node dummy3=new Node(-1);
           Node h1=dummy1;
           Node h2=dummy2;
           Node h3=dummy3;
           while(head!=null)
           {
               switch(head.data)
               {
                   case 0:h1.next=new Node(0);
                           h1=h1.next;
                           break;
                   case 1:h2.next=new Node(1);
                          h2=h2.next;
                          break;
                   case 2:h3.next=new Node(2);
                           h3=h3.next;
                           break;
               }
               head=head.next;
           }
           if(dummy2.next!=null)
           h1.next=dummy2.next;
           else
           h1.next=dummy3.next;
           h2.next=dummy3.next;
           h3.next=null;
           return dummy1.next;
           
    }
}


