package practice;
/**
 * Count number of islands in a zero one matrix
 */
public class Island {
	
	int ROWS = 5;
	boolean[][] visited = new boolean[ROWS][ROWS];
	int[][] matrix = new int[][]{{1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
       };;
	public Island()
	{
		
	}
	private boolean isSafe(int row, int col)
	{
		return row >= 0 && row < ROWS && col >=0 && col < ROWS && (matrix[row][col] == 1 && !visited[row][col]);
	}
	private void DFS(int row , int col)
	{
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
 
        for (int k = 0; k < 8; ++k)
            if (isSafe(row + rowNbr[k], col + colNbr[k]) )
                DFS(row + rowNbr[k], col + colNbr[k]);
	}
	public int numberOfIslands()
	{
		int count = 0;
		int i, j;
		for(i = 0; i < ROWS; i++)
		{
			for(j = 0; j < ROWS; j++)
			{
				if(matrix[i][j] == 1 && isSafe(i, j))
				{
					count++;
					DFS(i, j);
				}
			}
		}
		return count;
	}
	public static void test()
	{
		Island il = new Island();
		System.out.println(il.numberOfIslands());
	}
}
