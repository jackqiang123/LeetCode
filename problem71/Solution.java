package problem71;

import java.util.Stack;

//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//click to show corner cases.
//
//Corner Cases:
//Did you consider the case where path = "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".
public class Solution {
    public static String simplifyPath(String path) {
    	
    	String [] result = path.split("/");
    	//for (String k : result) System.out.println(k);
    	Stack<String> mystack = new Stack<String>();
    	
    	for (int i = 0; i < result.length; i++)
    	{
    		if (result[i].equals(".") || result[i].equals("")) {	continue;}
    		if (result[i].equals("..")) {if (!mystack.isEmpty()) mystack.pop();}
    		else mystack.push(result[i]);
    	}
    	
    	if (mystack.isEmpty()) return "/";
    	
    	
    	StringBuilder r = new StringBuilder();
    	
        while(mystack.isEmpty()!=true)
        {
        String t = mystack.pop();
        r.insert(0, t);
        r.insert(0, "/");
        }
        
        return r.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println("1" == "1");
		System.out.println(simplifyPath("/../"));
	}

}
