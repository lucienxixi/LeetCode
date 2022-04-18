package datastructures.lc225;
// use 1 queue
import java.util.LinkedList;
import java.util.Queue;

public class MyStack1 {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack1() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int temp = queue.poll();
            queue.add(temp);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
