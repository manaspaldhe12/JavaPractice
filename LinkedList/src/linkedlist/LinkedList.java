package linkedlist;

class Node {
    int data;
    Node next;
}

public class LinkedList {

    public static Node reverse (Node original){
        Node reversed;
        Node temp = new Node();
        temp.data=original.data;
        temp.next=null;

        while (original != null){
            Node temp2= new Node();
            temp2.next=temp;
            temp2.data=original.data;
            temp=temp2;
            original=original.next;
        }
        reversed = temp;
        return reversed;
    }
    
    public static void main(String[] args) {
        Node test = new Node();
        Node test_copy = test;
        for (int i=1; i<10; i++){
            test_copy.data=i;
            test_copy.next=new Node();
            test_copy=test_copy.next;
        }        
        test_copy.data=10;
        
        test_copy=test;
        while (test_copy != null){
            System.out.println(test_copy.data);
            test_copy=test_copy.next;
        }
        
        Node reversed = null;
        reversed = reverse(test);

        test_copy=reversed;
        while (test_copy != null){
            System.out.println(test_copy.data);
            test_copy=test_copy.next;
        }
        
    }
}
