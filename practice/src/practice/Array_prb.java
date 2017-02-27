package practice;

public class Array_prb {
	static void print_array(int[] arr)
	{
		String out = "";
		for(int i=0; i < arr.length; i++)
		{
			out += arr[i] + ", ";
		}
		out = out.substring(0, out.length()-2);
		System.out.println(out);
			
	}
	static void print_2darray(int[][] arr)
	{
		for ( int i = 0; i < arr.length; i++)
			print_array(arr[i]);
	}
	static void trest_array_reduce()
	{
		int arr[] = {1,2,3,4,5,6,4,2,3, 4};
		int len =  arr.length;
		int dp[][] = new int [len +1][len+1];
		init_2d(dp, -1);
		int res = get_reduced_size(arr, 0, len -1, dp);
		print_array(arr);
		System.out.println("Rudeced size: " + res);
		
	}
	static void init_single_array(int[] arr, int val)
	{
		for(int j = 0; j < arr.length; j++)
			arr[j] =  val;
	}
	static void init_2d(int[][] arr, int val)
	{
		for ( int i = 0; i < arr.length; i++)
			init_single_array(arr[i], val);
	}
	static int get_reduced_size(int [] arr, int low, int high, int[][] dp)
	{
		if(dp[low][high] != -1)
			return dp[low][high];
		if( high - low + 1 < 3)
			return high - low + 1;
		
		int res = 1 + get_reduced_size(arr, low + 1, high, dp);
		int i, j;
		
		for (i = low + 1; i <= high -1 ; i++)
		{
			for ( j = i + 1; j <= high; j++)
			{
				if(arr[i] ==  arr[low] + 1 && arr[j] == arr[low] + 2 && get_reduced_size(arr, low +1 , i -1, dp) == 0
						&& get_reduced_size(arr, i +1 , j-1, dp) == 0)
					res = Integer.min(res, get_reduced_size(arr, j+1, high, dp));
			}
		}
		
		dp[low][high] = res;
		return res;
	}
	static void test_subset_sum()
	{
		int[] arr = {6,8,4,3};
		int size = test_subset_sum_exact_length(arr, 0, 15);
	}
	static int test_subset_sum_exact_length(int[] arr, int start, int sum)
	{
		if ( sum < 0)
			return -1;
		if (sum== 0)
			return 0;
		int len;
		for(int i = start; i < arr.length;i++)
		{
			len = test_subset_sum_exact_length(arr, i + 1, sum - arr[i]);
			if( len >=0)
			{
				System.out.println(arr[i]);
				return len + 1;
			}
		}
		return -1;
	}

}
