package datastructures.lc225;
/*
  lc225. Implement Stack using Queues

  use 2 queue
 */
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue1.size();
        int top ;
        for (int i = 0; i < size - 1; i++) {
            top = queue1.poll();
            queue2.add(top);
        }
        top = queue1.poll();
        Queue temp;
        temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return top;
    }

    /** Get the top element. */
    public int top() {
        int size = queue1.size();
        int top = 0;
        for (int i = 0; i < size; i++) {
            top = queue1.poll();
            queue2.add(top);
        }
        Queue temp;
        temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


