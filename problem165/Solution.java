package problem165;
//compare version number 0.1<1.1<1.2<13.37
public class Solution {
	public static int compareVersion(String ver1, String ver2)
	{
		String v1[] = ver1.split("\\.");
		String v2[] = ver2.split("\\.");
		int l1 = v1.length;
		int l2 = v2.length;
		int bit = 0;
		while(bit < l1 && bit <l2)
		{
			if (Integer.parseInt(v1[bit])>Integer.parseInt(v2[bit]))
				return 1;
			else if (Integer.parseInt(v1[bit])<Integer.parseInt(v2[bit]))
				return -1;		
			bit++;
		}
		while(bit < l1)
		{
			if (Integer.parseInt(v1[bit]) > 0)
				return 1;
			bit++;
		}
			
		while(bit < l2)
		{
			if (Integer.parseInt(v2[bit]) > 0)
				return -1;
			bit++;
		}
		
		
		
		
		return 0;
		
	}
	public static void main(String[] args) {
		String v1 = "1.0";
		String v2 = "01";
		System.out.println(compareVersion(v1,v2));
	}

}
