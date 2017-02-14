package practice;

public class Math_prb {
	final static int max_int_root = 46340;
	
	static int find_sqrt(int val)
	{
		if ( val ==0 || val == 1)
			return val;
		int start =2;
		int  end = val/2;
		if ( end > max_int_root)
			end = max_int_root;
		int mid = (start + end) / 2;
		int ans = 0;
		
		while(start <= end)
		{
			if ( mid * mid == val)
				return mid;
			if (mid * mid < val)
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

}
