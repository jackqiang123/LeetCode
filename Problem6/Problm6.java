package Problem6;

public class Problm6 {

	public static String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		int length = s.length();
		int column = length / (nRows + nRows - 2) * nRows+2;
		char[][] answer = new char[nRows][column];
		int index = 0;
		for (int c = 0; c < column && index < length; c++)
			for (int r = 0; r < nRows && index < length; r++) {
				if (c % (nRows - 1) == 0)
					answer[r][c] = s.charAt(index++);
				else {
					if (r == nRows - 1 - c % (nRows - 1))
						answer[r][c] = s.charAt(index++);
					 System.out.println("r:"+(nRows-1-c%(nRows-1))+";c="+c);
				}

			}
		index = 0;
		char[] builder = new char[length];
		for (int r = 0; r < nRows; r++)
			for (int c = 0; c < column; c++)
				if (answer[r][c] != '\u0000')
					builder[index++] = answer[r][c];

		return String.valueOf(builder);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] test = new char[3];
		test[2] = 'A';
		// for (char i :test)
		// System.out.println(i);
		System.out.println(convert("abcde", 4));
	}

}
