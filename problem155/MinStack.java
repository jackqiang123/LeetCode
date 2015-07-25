package problem155;


import java.util.Stack;

class MinStack {
	private Stack<Integer> mystack = new Stack<Integer>();
	private Stack<Integer> minstack  = new Stack<Integer>();;
	
    public void push(int x) {
        mystack.push(x);
       if (minstack.isEmpty() == true || minstack.peek()>=x)
    	   minstack.push(x);
    }

    public void pop() {
    	if (mystack.isEmpty()==false){
    	int x = mystack.pop();
    	if ( x == minstack.peek()) minstack.pop();
    	}
    }

    public int top() {
        return mystack.peek();
    }

    public int getMin() {
    	return minstack.peek();
        
    }
}
