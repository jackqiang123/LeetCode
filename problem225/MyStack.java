package problem225;
import java.util.LinkedList;
import java.util.Queue;

//Implement the following operations of a stack using queues.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//empty() -- Return whether the stack is empty.
//Notes:
//You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
//Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
//You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
//Update (2015-06-11):
//The class name of the Java function had been updated to MyStack instead of Stack.
class MyStack {
	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();
	private int top;

	// Push element x onto stack.
	public void push(int x) {
		if (!q1.isEmpty()) {
			q1.add(x);
		} else
			q2.add(x);
		top = x;
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (!q1.isEmpty()) {
			int size = q1.size();
			int temp;
			for (int i = 0; i < size - 1; i++) {
				temp = q1.remove();
				q2.add(temp);
				if (i == size - 2)
					top = temp;
			}
			q1.remove();

		} else {
			int size = q2.size();
			int temp;
			for (int i = 0; i < size - 1; i++) {
				temp = q2.remove();
				q1.add(temp);
				if (i == size - 2)
					top = temp;
			}
			q2.remove();
		}
	}

	// Get the top element.
	public int top() {
		return top;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return (q1.isEmpty() && q2.isEmpty());
	}
	
//	public static void main(String[]args)
//	{
//		MyStack s = new MyStack();
//		for (int i = 0 ;i < 5;i++)
//		{
//			s.push(i);
//			System.out.println(i);
//		}
//		while(s.empty() == false)
//		{
//			System.out.println(s.top);
//			s.pop();
//		}
//	}
}