package practice;

import java.util.HashMap;
import java.util.Map;

public class IntegerProblem {
	/*
	 *  Given a 32-bit signed integer, reverse digits of an integer.
		
		Example 1:
		
		Input: 123
		Output: 321
		Example 2:
		
		Input: -123
		Output: -321
		Example 3:
		
		Input: 120
		Output: 21
		Note:
		Assume we are dealing with an environment which could only store integers within the 32-bit signed
		integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 
		when the reversed integer overflows.


	 */
	public static int reverse(int x) {
		int sum = 0;
        int rem;
        while(x != 0)
        {
            rem = x % 10;
            x = x /10;
            if (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE / 10 && rem > 7)) return 0;
            if (sum < Integer.MIN_VALUE/10 || (sum == Integer.MIN_VALUE / 10 && rem < -8)) return 0;
            sum = sum *10 + rem;
        }
        return sum;
    }
	
	public static boolean isPalindrom(int x)
	{
		if ( x < 0 || (x % 10 == 0 && x != 0) )
			return false;
		int revert = 0;
		
		while (x > revert)
		{
			revert = revert * 10 + x % 10;
			x = x / 10;
		}
		return x == revert || x == revert/10;
	}
	public static int atoi(String str)
	{
		str = str.trim();
		if (str.length() == 0)
			return 0;
		char first = str.charAt(0);
		int sign = 1;
		int ret = 0;
		int firstCharDigit = 0;
		int i = 0;
		if (!Character.isDigit(first))
		{
			firstCharDigit = 1;
			if( first == '-')
				sign = -1;
			else if ( first != '+')
				return 0;
            else
                sign = 1;
                
		}
		i += firstCharDigit;
		int cur;
        if ( i>= str.length())
            return 0;
		if (Character.isDigit(str.charAt(i)))
		{
			ret = sign * Character.getNumericValue(str.charAt(i));
			
		}
		else
			return 0;
		i++;
		for(; i < str.length() && Character.isDigit(str.charAt(i)); i++)
		{
			cur = Character.getNumericValue(str.charAt(i));
			
			if (ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE / 10 && cur > 7)) return Integer.MAX_VALUE;
            if (ret < Integer.MIN_VALUE/10 || (ret == Integer.MIN_VALUE / 10 && cur >= 8)) return Integer.MIN_VALUE;
			ret = ret * 10 + cur * sign;
		}
		return ret;
	}
	private static int get_roman_hlp(char c)
	{
		switch(c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
	private static int romanGeneration(String roman)
	{
		char[] arr = roman.toCharArray();
		int last = 0;
		int sum = 0;
		int cur;
		for (int i = arr.length - 1; i >= 0; i--)
		{
			cur = get_roman_hlp(arr[i]);
			
			if (cur < last) {
				sum -= cur;
			}
			else
			{
				sum += cur;
			}
					
			last = cur;
		}
		return sum;
	}
	/*
	 * Given an unsorted integer array, find the smallest missing positive integer.

			Example 1:
			
			Input: [1,2,0]
			Output: 3
			
			Example 2:
			
			Input: [3,4,-1,1]
			Output: 2
			
			Example 3:
			
			Input: [7,8,9,11,12]
			Output: 1
			
			Note:
			
			Your algorithm should run in O(n) time and uses constant extra space.

	 */
	public static int firstMissingPositive(int[] nums) {
        int max = 0;
        int i ;
        if (nums.length == 0)
        	return 1;
        max = nums[0];
        for (i =0; i< nums.length; i++)
        {
        	if (max < nums[i])
        		max = nums[i];
        }
        if (max < nums.length)
        	max = nums.length;
        int[] dp = new int[max + 2];
        for (i = 0; i < dp.length; i++)
        	dp[i] = -1;
        for (i = 0; i < nums.length; i++)
        {
        	if (nums[i] <=0)
        		continue;
        	dp[nums[i]] = 1;
        }
        for (i = 1; i < dp.length; i++)
        	if (dp[i] == -1)
        		return i;
        return -1;
        
    }
	public static int firstMissingPositive2(int[] nums) {
		if (nums.length == 0)
        	return 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = nums[0];
		for( int x: nums)
		{
			if ( x <= 0)
				continue;
			if (max < x)
				max =x;
			map.put(x, 1);
		}
		for ( int i =1; i <= max + 1 ; i++)
			if(!map.containsKey(i))
				return i;
		return -1;
	}
	public static void test()
	{
		//int[] nums = {7,8,9,11,12};
		//System.out.println(firstMissingPositive2(nums));
		//System.out.println(atoi("-2147483649"));
		
		//int out = reverse(1534236469);
		//out = reverse(12345);
		//System.out.println(Integer.MAX_VALUE);
		System.out.println(power(5,2));
		
		/*
		System.out.println(Integer.MIN_VALUE);
		System.out.println(out);
		System.out.println(isPalindrom(121));
		System.out.println(isPalindrom(12321));
		System.out.println(isPalindrom(-121));
		System.out.println(isPalindrom(0));
		System.out.println(isPalindrom(123456));
		System.out.println(Integer.MAX_VALUE);
		*/
	}
	public static int power(int x, int y)
	{
		int ret =1;
		if ( y == 0)
			return ret;
		if ( y== 1)
			return x;
		int half = power(x, y/2);
		if (y % 2 == 0)
			return half * half;
		return x * half * half;
	}

}
