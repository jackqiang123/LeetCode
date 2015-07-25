package Problem1;

import java.util.HashMap;

public class Problem1 {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
		int first;
		int last;
		for (int i = 0; i < numbers.length; i++) {
			if (mymap.containsKey(target - numbers[i])) {
				first = i;
				last = mymap.get(target - numbers[i]);

				if (first > last) {
					int temp = last;
					last = first;
					first = temp;
				}
				return new int[] { first, last };
			} else
				mymap.put(numbers[i], i);

		}

		return null;

	}
}