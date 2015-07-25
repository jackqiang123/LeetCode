package Problem136;
import java.util.HashMap;

public class Solution {

	public static int singleNumber(int[] A) {
		HashMap<Integer, Boolean> mymap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < A.length; i++) {
			if (mymap.containsKey(A[i]) == false)
				mymap.put(A[i], true);
			else if (mymap.containsKey(A[i]) == true)
				mymap.remove(A[i]);
		}
		
		Object dest[] = mymap.keySet().toArray();
		

		return (int)dest[0];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = new int[] { 3, 3,  2, 4,6,6,4};
		System.out.println(singleNumber(A));
	}

}
