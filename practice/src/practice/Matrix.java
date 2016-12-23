package practice;

public class Matrix {
	
	static int[][] get2DMatrix(int r, int c)
	{
		int[][] ret = new int[r][c];
		int val = 0;
		for( int i = 0; i < r; i++)
			for( int j = 0; j < c; j++)
				ret[i][j] = val++;
		return ret;
	}
	static void print_2d_matrix(int[][] mat, int r, int c)
	{
		String out;
		for( int i = 0; i < r; i++)
		{
			out = "";
			for( int j = 0; j < c; j++)
				out += mat[i][j] + ",";
			System.out.println(out);
		}
	}

}
