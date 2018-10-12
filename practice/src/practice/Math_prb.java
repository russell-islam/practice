package practice;

public class Math_prb {
	final static int max_int_root = 46340;
	/*
	 * Implement int sqrt(int x).

		Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
		
		Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
		
		Example 1:
		
		Input: 4
		Output: 2
		
		Example 2:
		
		Input: 8
		Output: 2
		Explanation: The square root of 8 is 2.82842..., and since 
		             the decimal part is truncated, 2 is returned.
		

	 */
	static int mySqrt(int x)
	{
		if ( x ==0 || x == 1)
			return x;
		int start =1;
		int  end = x/2;
		if ( end > max_int_root)
			end = max_int_root;
		int mid = (start + end) / 2;
		int ans = 0;
		
		while(start <= end)
		{
			if ( mid * mid == x)
				return mid;
			if (mid * mid < x)
			{
				start = mid +1;
				ans = mid;
			}
			else
			{
				end = mid -1;
			}
			mid = (start + end) / 2;
		}
		return ans;
	}
	public static void test()
	{
		System.out.println(mySqrt(0));
	}

}
