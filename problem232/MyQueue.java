package problem232;

import java.util.Stack;

//mplement Queue using Stacks Total Accepted: 515 Total Submissions: 1388 My Submissions Question Solution 
//Implement the following operations of a queue using stacks.
//
//push(x) -- Push element x to the back of queue.
//pop() -- Removes the element from in front of queue.
//peek() -- Get the front element.
//empty() -- Return whether the queue is empty.
//Notes:
//You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
//Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
//You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).class MyQueue {
// Push element x to the back of queue.
class MyQueue {
    // Push element x to the back of queue.
	private Stack<Integer> enstack = new Stack<Integer>();
	private Stack<Integer> destack = new Stack<Integer>();
    public void push(int x) {
        while (!destack.isEmpty())
        {
        	enstack.push(destack.pop());
        }
        enstack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	while (!enstack.isEmpty())
    	{
    		destack.push(enstack.pop());
    	}
    	destack.pop();
        
    }

    // Get the front element.
    public int peek() {
     	while (!enstack.isEmpty())
    	{
    		destack.push(enstack.pop());
    	}
    	return destack.peek();
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return enstack.isEmpty() && destack.isEmpty();
    }
}