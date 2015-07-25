package problem146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
//otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present.
//    When the cache reached its capacity,
//it should invalidate the least recently used item before inserting a new item.
class bdnode {
	int val;
	int key;
	bdnode pre;
	bdnode next;

	public bdnode(int k, int v, bdnode p, bdnode n) {
		key = k;
		val = v;
		pre = p;
		next = n;
	}
}

class blist {
	bdnode left;
	bdnode right;

	public void add(bdnode n) {
		right.next = n;
		n.pre = right;
		this.right = n;
	}

	public int remove()// return this remove key
	{
		int kk = left.key;
		if (left == right) return kk;
		this.left = this.left.next;
		this.left.pre = null;
		return kk;
	}

	public void visited(bdnode n) {
		//System.out.println("visiting " + n.key);
		if (right == n) return;
		if (left == n) left = left.next;
		bdnode ll = n.pre;
		bdnode rr = n.next;
		if (ll != null)
			ll.next = rr;
		if (rr != null)
			rr.pre = ll;
		right.next = n;
		n.pre = right;
		this.right = n;
		//System.out.println("left is  " + left.key + " right is " + right.key );
//		System.out.println("current double list is ");
//		bdnode b =left;
//		while(b!=null)
//		{	
//			System.out.print(b.key + " ,");
//			b = b.next;
//		}
//		System.out.println();
		}
}

public class LRUCache {
	HashMap<Integer, bdnode> mymap;
	blist list;
	int capacity;

	public LRUCache(int capacity) {
		mymap = new HashMap<Integer, bdnode>();
		list = new blist();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (mymap.containsKey(key)) {
			bdnode n = mymap.get(key);
			list.visited(n);
			return n.val;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (mymap.isEmpty())
		{
			bdnode n = new bdnode (key,value,null,null);
			list.right = n;
			list.left = n;
			mymap.put(key, n);
		}
		else if (mymap.containsKey(key)) {
			bdnode n = mymap.get(key);
			n.val = value;
			list.visited(n);
		} else if (mymap.size() == this.capacity){
			bdnode n = new bdnode(key, value, null, null);
			int kk = list.remove();
			list.add(n);
			mymap.remove(kk);
			mymap.put(key, n);

		}
		else 
		{
			bdnode n = new bdnode(key, value, null, null);
			list.add(n);mymap.put(key, n);
		}
	}
	public static void main(String[]args)
	{
		LRUCache  t = new LRUCache(2);
		t.set(2, 1);
		t.set(1, 1);
		t.get(2);
		t.set(4, 1);
		t.get(1);
		t.get(2);
		
		
	}
}