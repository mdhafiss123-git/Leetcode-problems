import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // Step 1: Add the new element to the empty queue (q2)
        q2.add(x);
        
        // Step 2: Move all existing elements from q1 to q2.
        // This forces the newly added element 'x' to stay at the front of q2!
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Step 3: Swap the names of the queues so q1 always holds the current stack state
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        // Since q1 keeps the top element at the front, we just dequeue it.
        return q1.remove();
    }
    
    public int top() {
        // Return the front element of q1 without removing it.
        return q1.peek();
    }
    
    public boolean empty() {
        // The stack is empty if q1 has no elements.
        return q1.isEmpty();
    }
}
