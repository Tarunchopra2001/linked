import java.util.*;
public class linkedlist2{
    class Node{
        int data ;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;

        }
    }
    private Node head;
    //method to revese the linked list iteratively
    public void reveseiterater(){
        if(head == null||head.next == null){
            return;

        }
        Node preNode =null;
        Node currNode = head;
        Node NextNode = null;

        while(currNode !=null){
            NextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = NextNode;
        }
        head = preNode;
    }

    //method to revese the linked list recursively
    public Node reveseRecursive(Node head){
        if(head == null|| head.next == null){
            return head;
        }
        Node newHead = reveseRecursive(head.next);
        head .next.next =head;
        head.next = null;
        return newHead; 
    }
    //helper method to ad element to the end of the list
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next !=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    //helper method to the print the list

    public void printlist(){
        Node currNode = head;
        while (currNode !=null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        linkedlist2 list = new linkedlist2();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.print("original list:");
        list.printlist();

        list.reveseiterater();
        System.out.print("revesed list (iterative):");
        list.printlist();

        list.head = list.reveseRecursive(list.head);
        System.out.print("revese list(recusive):");
        list.printlist();
    }
}