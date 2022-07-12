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
		   
		      head = new Solution().mergeSort(head);
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
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null||head.next==null)
        return head;
        Node mid=findMid(head);
        Node midd=mid.next;
        mid.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(midd);
        Node combo=merge(left,right);
        return combo;
        
    }
    static Node merge(Node left,Node right)
    {
        if(left==null&&right==null)
        return left;
        if(left==null&&right!=null)
        return right;
        else
        if(left!=null&&right==null)
        return left;
        Node dummy=new Node(-1);
        Node curr=dummy;
        while(left!=null&&right!=null)
        {
            if(left.data<=right.data)
            {
                curr.next=left;
                curr=curr.next;
                left=left.next;
            }
            else
            {
               curr.next=right;
                curr=curr.next;
                right=right.next; 
            }
        }
        if(left!=null)
        curr.next=left;
        else
        curr.next=right;
        return dummy.next;
    }
    static Node findMid(Node head)
    {
         Node slow=head;
        Node fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
        slow=slow.next;
        fast=fast.next.next;
        }
        return slow;
    }
    
}


