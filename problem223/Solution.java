package problem223;
//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//Rectangle Area
//Assume that the total area is never beyond the maximum possible value of int.
public class Solution {
    public int computeArea(int Alx, int Aby, int Arx, int Aty, int Blx, int Bby, int Brx, int Bty) {
    	int Aarea = (Aty-Aby)*(Arx-Alx);
       	int Barea = (Bty-Bby)*(Brx-Blx);
       	int interlevave = getinterval(Alx,Aby,Arx,Aty,Blx,Bby,Brx,Bty);
       	return Aarea+Barea-interlevave;
    	
    }
	private int getinterval(int alx, int aby, int arx, int aty, int blx,
			int bby, int brx, int bty) {
	if (arx <= blx ||alx >= brx || aby >= bty || bby >=aty) return 0;	
	int ty = Math.min(aty, bty);
	int by = Math.max(aby, bby);
	int lx = Math.max(alx, blx);
	int rx = Math.min(arx, brx);
	return (ty-by)*(rx-lx);
	
	
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
