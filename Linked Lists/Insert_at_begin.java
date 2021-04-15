import java.util.*;
import java.lang.*;
import java.io.*;

class Node{

    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

public class Main
{
    public static void print(Node head){

        Node cur = head;
        while (cur!=null){

            System.out.print(cur.data+" ");
            cur = cur.next;

        }
    }

    public static Node insertBegin(Node head, int x){

        Node temp = new Node(x);
        temp.next = head;
        return head;

    }

    public static void main(String[] args) {

        Node head = null;
        head = insertBegin(head,30);
        head = insertBegin(head,20);
        head = insertBegin(head,10);
    }
}
