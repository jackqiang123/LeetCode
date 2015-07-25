package problem173;
import java.util.Stack;

import TreeNode.TreeNode;
//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.


public class BSTIterator {
	private Stack<TreeNode> mystack; 
    public BSTIterator(TreeNode root) {
    	mystack = new Stack<TreeNode>();
        add(root);
    }

    private void add(TreeNode node) {
		 if (node == null) return;
		 if (node.right != null) 
			 add(node.right);
		 mystack.push(node);
		 if (node.left != null) 
			 add(node.left);
		
	}

	/** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mystack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	
        return mystack.pop().val;
    }
    public static void main(String[]arg)
    {
    	TreeNode root = new TreeNode(1);
    	 BSTIterator i = new BSTIterator(root);
    	 while (i.hasNext())  System.out.println(i.next());
    	
    	
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
