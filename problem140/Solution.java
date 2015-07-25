package problem140;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//Given a string s and a dictionary of words dict, add spaces in s to 
// construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].
public class Solution {
//	static Map<String,String> cache;
    public static List<String> wordBreak(String s, Set<String> wordDict) {
    List<String> res = new LinkedList<String>();
    for(int j = s.length() - 1; j >= 0; j--){
        if(wordDict.contains(s.substring(j)))
            break;
        else{
            if(j == 0)
                return res;
        }
    }
  //  cache = new HashMap<String,String>();
    int len = s.length();
    if (len == 0) return res; 
    backtrack(res,s,wordDict,0,"");
    return res;
    }

	private static void backtrack(List<String> res, String s, Set<String> wordDict, int start, String cur) {
	
		int len = s.length();
		if (len == start) {res.add(cur.trim());return;}
		//look at the remaining exists or not?
//		if (cache.containsKey(s.substring(start)))
//		{
//			res.add((cur+" "+cache.get(s.substring(start))).trim());return;
//		}
		for (int i = start; i <len; i++)
		{
			String sub = s.substring(start,i+1);
			if (!wordDict.contains(sub)) continue;
			int orignial = cur.length();
			cur = cur + sub + " ";
			//cache.put(s.substring(0,start), cur);
			backtrack(res,s,wordDict,start+sub.length(),cur);
			cur = cur.substring(0, orignial);
		}
		
	}
	public static void main(String []args)
	{//["a", "cats", "and", "sand", "dog"].
		Set<String> d = new TreeSet<String>();
	//	d.add("a");d.add("aa");
		d.add("aaa");d.add("aaaa");
		List<String> r = wordBreak("aaaaaaa",d);
		for (String s : r)
			System.out.println(s);
	}
}
