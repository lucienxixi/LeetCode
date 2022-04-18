package datastructures.lintcode492;
/*
lintcode492. Implement Queue by Linked List

follow up: using array to implement queue?
 */
class Node {
    int val;
    Node next;
    public Node() {}
    public Node(int val) {
        this.val = val;
        this.next = null;
    }

}

public class MyQueue1 {

    Node head = null;
    Node tail = null;


    public void enqueue(int item) {
        // write your code here
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
    }


    /*
     * @return: An integer
     */

    public int dequeue() {
        // write your code here
        if (head != null) {
            int value = head.val;
            head = head.next;
            return value;
        }
        else {
            return -1;
        }

    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(5);
        myQueue.enqueue(1);
        myQueue.enqueue(3);
        myQueue.enqueue(2);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        MyQueue myQueue1 = new MyQueue();
        myQueue1.enqueue(2);
        System.out.println(myQueue1.dequeue());
    }


}