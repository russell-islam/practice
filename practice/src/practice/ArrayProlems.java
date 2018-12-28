
package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayProlems {
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
	public static int removeDuplicates(int[] nums) {
		int i, count=0;
		
		for ( i = 0; i < nums.length; i++)
		{
			while(i < nums.length - 1 && nums[i] == nums[i+1])
				i++;
			nums[count++] = nums[i];
		}
		return count;
        
    }
	static void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public static int searchBin(int[] nums, int low,int high, int target)
	{
		if (nums.length == 0)
			return 0;
		if (target < nums[low])
			return low;
		if (target > nums[high])
			return high + 1;
		int mid = (low + high) / 2;
		if(nums[mid] == target)
			return mid;
		if ( target > nums[mid])
		{
			return searchBin(nums, mid + 1, high, target );
		}
		return searchBin(nums, low, mid -1, target );
	}
	/*
	 * 		Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
			
			You may assume no duplicates in the array.
			
			Example 1:
			
			Input: [1,3,5,6], 5
			Output: 2
			
			Example 2:
			
			Input: [1,3,5,6], 2
			Output: 1
			
			Example 3:
			
			Input: [1,3,5,6], 7
			Output: 4
			
			Example 4:
			
			Input: [1,3,5,6], 0
			Output: 0


	 */
	public static int searchInsert(int[] nums, int target) {
        return searchBin(nums, 0, nums.length-1, target);
    }
	public static int maximumSumSubArray(int [] nums)
	{
		if (nums.length == 0)
			return 0;
		int maxGLobal = nums[0];
		int maxCurrent = nums[0];
		for (int i =1; i < nums.length; i++)
		{
			maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
			if (maxCurrent > maxGLobal)
				maxGLobal = maxCurrent;
		}
		return maxGLobal;
	}
	/*
	 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

		The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
		
		You may assume the integer does not contain any leading zero, except the number 0 itself.
		
		Example 1:
		
		Input: [1,2,3]
		Output: [1,2,4]
		Explanation: The array represents the integer 123.
		
		Example 2:
		
		Input: [4,3,2,1]
		Output: [4,3,2,2]
		Explanation: The array represents the integer 4321.


	 */
	public static int[] plusOne(int[] digits) {
        if (digits.length == 0)
        {
        	return new int[] {1};
        }
        int cur, carry = 1, i;
        for (i = digits.length -1; i >=0; i--)
        {
        	cur = digits[i] + carry;
        	digits[i] = cur % 10;
        	carry = cur / 10;
        }
        if ( carry ==1)
        {
        	int[] arr = new int [digits.length + 1];
        	arr[0] = carry;
        	for (i =0; i < digits.length; i++)
        		arr[i+1] = digits[i];
        	return arr;
        }
        return digits;
        
    }
	public static void mergeTwoSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int c = m + n -1;
        int i = m -1;
        int j = n -1, max;
        for (; i>= 0 || j >= 0;)
        {
        	if ( i >= 0 && j >= 0)
        	{
        		if (nums1[i] > nums2[j])
        		{
        			max = nums1[i];
        			i--;
        		}
        		else
        		{
        			max = nums2[j];
        			j--;
        		}
        	}
        	else if ( i < 0)
        	{
        		max = nums2[j];
        		j--;
        	}
        	else
        	{
        		max = nums1[i];
        		i--;
        	}
        	nums1[c--] = max;
        }
    }
	
	public static IntInt[] convert2( int[] arr)
	{
		IntInt ret[] = new IntInt[arr.length];
		int i;
		for (i=0; i < arr.length; i++)
		{
			
			ret[i] = new IntInt(arr[i]);
		}
		return ret;
	}
	public static int[] convert12( IntInt[] arr)
	{
		int ret[] = new int[arr.length];
		int i;
		for (i=0; i < arr.length; i++)
		{
			
			ret[i] = arr[i].x;
		}
		return ret;
	}
	public static void testArrayWithFunc()
	{
		int a = -2, b = 5, c=10;
		Integer []arr = {1, -5, 10, 50, 34, -40};
		 Arrays.sort(arr, new Comparator<Integer>() {
	            public int compare(Integer x1, Integer x2) {
	                int first = a * x1 * x1 + b * x1 + c;
	                int second = a * x2 * x2 + b * x2 + c;
	                return first> second? 1: first < second? -1:0;
	            }
	        });
		 System.out.println(Arrays.toString(arr));
	}
	static void test()
	{
		testArrayWithFunc();
	}

}
class IntInt
{
	int x;
	public IntInt(int i)
	{
		x=i;
	}
	
};
