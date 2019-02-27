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
		ArrayProlems.init_2d(dp, -1);
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
			return Utils.max(res1, res2);
		}
	}
	/**
	 * Longest palidrom sub sequence
	 * @param str
	 * @return
	 */
	private int lps_dp(String str)
	{
		char arr[] = str.toCharArray();
		int len = arr.length;
		int dp[][] = new int [len][len];
		ArrayProlems.init_2d(dp, 0);
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
					dp[i][j] = Utils.max(dp[i][j-1], dp[i+1][j]);
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
	public int climbStairs(int n) {
		if (n <=2)
			return n;
        int first = 1;
        int second = 2;
        int third = 0;
        for ( int i = 3; i <=n; i++)
        {
        	third = first + second;
        	first = second;
        	second = third;
        	
        }
        return third;
    }
	public int climbStairsdp(int n) {
		if (n == 0)
			return 0;
        int[] dp = new int [n+1];
        int i;
        dp[0] = 1;
        dp[1]= 1;

        for (i =2; i <= n; i++)
        	dp[i] = dp[i-1] + dp [i-2];
        return dp[n];
    }
	public static void test()
	{
		//int[] primes = {2,3,5};
		//UglyNumber.print_ugly_235(15);
		//UglyNumber.print_ugly_generic(primes, 15);
		LCS.test();
	}

}
class UglyNumber
{
	public static int min_3(int  x, int y, int z)
	{
		return  Math.min(Math.min(x,y),z);
	}
	public static void print_ugly_235(int range)
	{
		int i2 = 0, i3 = 0, i5 = 0;
		int next_multiple2 = 2;
		int next_multiple3 = 3;
		int next_multiple5 = 5;
		int ugly[] = new int[range];
		
		int count = 1;
		int next_ugly =1;
		ugly[0] = 1;
		while (count < range)
		{
			next_ugly = min_3(next_multiple2, next_multiple3, next_multiple5);
			ugly[count] = next_ugly;
			if (next_ugly == next_multiple2)
			{
				i2++;
				next_multiple2 = ugly[i2] * 2;
			}
			if (next_ugly == next_multiple3)
			{
				i3++;
				next_multiple3 = ugly[i3] * 3;
			}
			if (next_ugly == next_multiple5)
			{
				i5++;
				next_multiple5 = ugly[i5] * 5;
			}
			count++;
		}
		ArrayProlems.print_array(ugly);
	}
	public static void print_ugly_generic(int[] primes, int range)
	{
		int  len = primes.length;
		int indexes[] = new int[primes.length];
		int next_multiples[] = new int [primes.length];
		// init next
		for(int i =0; i < len; i++)
		{
			indexes[i] = 0;
			next_multiples[i] = primes[i];
		}
		int ugly[] = new int[range];
		
		int count = 1;
		int next_ugly =1;
		ugly[0] = 1;
		while (count < range)
		{
			next_ugly = ArrayProlems.min_array(next_multiples);
			ugly[count] = next_ugly;
			for(int i =0; i < len; i++)
			{
				if (next_multiples[i] == next_ugly)
				{
					indexes[i]++;
				}
				next_multiples[i] = primes[i] * ugly[indexes[i]];
			}
			count++;
		}
		ArrayProlems.print_array(ugly);
	}
}
class LCS{
	public int lcs(char[] X, char[] Y)
	{
	    int m = X.length; 
	    int n = Y.length;
	    int L[][] = new int[m+1][n+1];
	    int i, j;
	    for (i = 0; i <= m; i++)
	    {
	    	for (j = 0; j <= n; j++)
	    	{
	    		if (i == 0 || j == 0)
	    			L[i][j] = 0;
	    		else if ( X[i-1] == Y[j-1])
	    			L[i][j] = L[i-1][j-1] + 1;
	    		else
	    			L[i][j] = Integer.max(L[i-1][j], L[i][j-1]);
	    	}
	    }
		return L[m][n];
	}
	public int lcs(String s1, String s2)
	{
		return lcs(s1.toCharArray(), s2.toCharArray());
	}
	public static void test()
	{
		LCS lcs = new LCS(); 
	    String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    System.out.println("Length of LCS is" + " " + 
	                                  lcs.lcs( s1, s2) ); 
	}
}
