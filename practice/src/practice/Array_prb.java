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
	static void test_array_reduce()
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
	/*
	 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
		
		We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
		
		If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
		
		Example 1:
		
		Input: 
		nums = [1, 7, 3, 6, 5, 6]
		Output: 3
		Explanation: 
		The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
		Also, 3 is the first index where this occurs.
		
		Example 2:
		
		Input: 
		nums = [1, 2, 3]
		Output: -1
		Explanation: 
		There is no index that satisfies the conditions in the problem statement.

	 */
	public static int pivotIndex(int[] arr) {
		
		int left =0, right;
		int sum = 0;
		for(int x:arr) sum+=x;
		for (int i = 0; i < arr.length; i++)
		{
			right = sum - left - arr[i];
			if ( left == right)
				return i;
			left += arr[i];
		}
		return -1;
        
    }
	static void test()
	{
		int[] arr = {-1,-1,-1,-1,-1,0};
		int ind = pivotIndex(arr);
		System.out.println(ind);
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
	static void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
