package test;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int []arr = new int[]{3,7,1,11,5};
	int i =0; int j = arr.length-1;
	while(i<=j)
	{
		i++;
		if (i==j)
		{System.out.println(arr[i]);}
		j--;
		}
	System.out.println(arr[j]);
	}
	

}

