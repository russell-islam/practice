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
			{
				out += mat[i][j];
				if(j!=c-1)
					out += ",";
			}
			System.out.println(out);
		}
	}
	static void print_rotate(int[][] mat, int r, int c)
	{
		int row = 0, col = 0, prev, cur, i;
		int m = r, n = c;
		while ( row < m && col < n)
		{
			if (row + 1 == m || col + 1 == n)
				break;
			prev = mat[row + 1][col];
			for( i = col; i < n; i++)
			{
				cur = mat[row][i];
				mat[row][i] = prev;
				prev = cur;
			}
			row++;
			for(i = row; i < m; i++)
			{
				cur = mat[i][n-1];
				mat[i][n-1] = prev;
				prev = cur;
			}
			n--;
			if ( row < m)
			{
				for( i = n-1; i>=col; i--)
				{
					cur = mat[m-1][i];
					mat[m-1][i] = prev;
					prev = cur;
				}
			}
			m--;
			if ( col < n)
			{
				for( i = m-1; i>=row; i--)
				{
					cur = mat[i][col];
					mat[i][col] = prev;
					prev = cur;
				}
			}
			col++;
			
		}
		print_2d_matrix(mat, r, c);
	}

}
