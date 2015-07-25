package Problem4;

public class Problem4 {
	
	
	
    public double findMedianSortedArrays(int A[], int B[]) {
    	    	
    	//we can first transfer the objective to the same length
    	double MedA = A[A.length/2];
    	double MedB = B[B.length/2];
    	int indexofMedian = (A.length+B.length)/2;
    	if (MedA < MedB)
    	{
    		int Aexclusd = A.length/2; //A已经排除了这么多，从
      		int target = indexofMedian - Aexclusd; // still need so many to find median
      		findmedianofsamelength(A,A.length/2+1,A.length/2+1+target,B,0,target-1);
    	}
    	else 
    	{
    		
    		int Bexclusd = B.length/2;
    		int target = indexofMedian - Bexclusd; // still need so many to find median
    	}
    	
    	
    	
    	return findTwoMedian(A, 0, A.length, B, 0, B.length) ;
        
    }
    
    private void findmedianofsamelength(int[] a, int i, int j, int[] b, int k,
			int l) {
		// TODO Auto-generated method stub
		
	}

	private double findTwoMedian(int A[], int Afirst, int Alast, int B[], int Bfirst, int Blast) 
    {
    	double MedA = findMe(A,Afirst,Alast);
    	double MedB = findMe(B,Bfirst,Blast);
    	
    	if (MedA < MedB)// then the median appears in the right part of A, and left part of B.
    	{
    		
    	}
    	else
    	{
    		
    	}
    	return 0.0;
    }
    
    private int findMe(int A[], int low, int high) // return the median of array A, with low and high index.
    
    {
    	return A[(high+low)/2];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
