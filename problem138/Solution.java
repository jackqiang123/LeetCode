package problem138;

import java.util.HashMap;
import java.util.HashSet;

//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//Return a deep copy of the list.
 class RandomListNode {
     int label;
    RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) return null;
    	RandomListNode copyhead = new RandomListNode(head.label);
    	RandomListNode result = copyhead;
    	RandomListNode truehead = head;
    	HashMap<RandomListNode,RandomListNode> mymap = new HashMap<RandomListNode,RandomListNode>();
    	
    	mymap.put(truehead, copyhead);
    	
    	while(truehead.next!=null)
    	{   
    		truehead = truehead.next;
    		copyhead.next = new RandomListNode(truehead.label);
    		copyhead = copyhead.next;
    		mymap.put(truehead, copyhead);    		
    	}
    	truehead = head;
    	copyhead = result;
    	while(truehead!=null)
    	{   
    		RandomListNode truerandom = truehead.random;
    		RandomListNode copyrandom = mymap.get(truerandom);
    		copyhead.random = copyrandom;
    		truehead = truehead.next;
    		copyhead = copyhead.next;    		
    	}
    	 	
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
