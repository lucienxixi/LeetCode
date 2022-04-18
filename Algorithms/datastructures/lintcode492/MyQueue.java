package datastructures.lintcode492;

import java.util.LinkedList;


public class MyQueue {
    /*
     * @param item: An integer
     * @return: nothing
     */

    LinkedList<Integer> linkedList = new LinkedList<Integer>();

    public void enqueue(int item) {
        // write your code here
        linkedList.add(item);
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        return linkedList.remove();
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
