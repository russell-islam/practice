package practice;

public class DynamicProgramming {
	
	public int dp_subset_sum(int[] arr, int target, int i, int[][] dp)
	{
		int to_ret;
		
		if ( target == 0)
		{
			return 1;
		}
		else if (i < 0)
		{
			return 0;
		}
		else if (dp[i][target] != -1)
		{
			return dp[i][target];
		}
		else if ( target < arr[i])
		{
			to_ret = dp_subset_sum(arr, target, i -1, dp);
		}
		
		else
		{
			to_ret = dp_subset_sum(arr, target - arr[i], i -1, dp) + dp_subset_sum(arr, target, i -1, dp);
		}
		dp[i][target] = to_ret;
		return to_ret;
			
	}
	public void subsetSum()
	{
		int arr[] = { 2, 4 , 6, 10};
		int target = 16;
		int[][] dp = new int[arr.length][target + 1];
		Array_prb.init_2d(dp, -1);
		System.out.println(dp_subset_sum(arr, target, arr.length - 1, dp));
	}
	private int lps_r(char[] arr, int start, int end)
	{
		if (start == end)
			return 1;
		else if(arr[start] == arr[end] && end == start +1)
			return 2;
		if (arr[start] == arr[end])
			return lps_r(arr, start + 1, end -1) + 2;
		else
		{
			int res1 = lps_r(arr, start + 1, end);
			int res2 = lps_r(arr, start, end -1);
			return Integer.max(res1, res2);
		}
	}
	private int lps_dp(String str)
	{
		char arr[] = str.toCharArray();
		int len = arr.length;
		int dp[][] = new int [len][len];
		Array_prb.init_2d(dp, 0);
		int i , j, k;
		for( i = 0; i < len; i++)
			dp[i][i] = 1;
		for( k =2; k <= len; k++)
		{
			for ( i = 0; i < len - k + 1; i++)
			{
				j = i + k -1;
				if( arr[i] ==  arr[j] && k ==2)
					dp[i][j] = 2;
				if(arr[i] == arr[j])
				{
					dp[i][j] = dp[i + 1][j-1] + 2;
				}
				else
				{
					dp[i][j] = Integer.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		return dp[0][len -1];
	}
	public void test_lps()
	{
		String str = "GEEKS FOR GEEKS";
		char[] arr = str.toCharArray();
		System.out.println(lps_dp(str));
		
	}
	
	public static void test()
	{
		DynamicProgramming dp = new DynamicProgramming();
		dp.test_lps();
	}

}
