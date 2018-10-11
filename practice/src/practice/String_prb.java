package practice;

import java.util.Stack;

public class String_prb {
	
	static String CompressString(String in)
	{
		String out = "";
		char[] arr = in.toCharArray();
		int count = 0;
		for(int i = 0; i < arr.length; i++)
		{
			count = 1;
			for(int j = i+1; j < arr.length && arr[i] == arr[j];)
			{
				count++;
				i++;
				j++;
			}
			out += arr[i];
			if(count >1)
				out += String.valueOf(count);
		}
		return out;
	}
	static String DecompressString(String in)
	{
		String out = "";
		char[] arr = in.toCharArray();
		String count = "";
		char c= 0,prev=0;
		boolean isDigit = false;
		for(int i = 0; i < arr.length;i++)
		{
			c = arr[i];
			
			isDigit = (c >= '0' && c <= '9');
			if(isDigit)
			{
				count = ""+ c;
				for(int j = i+1; (arr[j] >= '0' && arr[j] <= '9'); j++)
				{
					
					count += arr[j];
					i++;
				}
				for(int j=1; j< Integer.parseInt(count); j++)
				{
					out +=String.valueOf(prev);
				}
			}
			else
			{
				out += String.valueOf(c);
				prev = c;
			}
		}
		return out;
	}
	static int longestNonRepeatingSubstring(String st)
	{
		int len = st.length();
		int prev_index = -1;
		int cur_len = 1;
		int max_len = 1;
		int visited[] = new int [256];
		int i;
		for (i = 0; i < 256; i++)
		{
			visited[i] = -1;
		}
		visited[st.charAt(0)] = 0;
		for ( i = 1; i < len ; i ++)
		{
			prev_index = visited[st.charAt(i)];
			if ( prev_index == -1 || i - cur_len > prev_index)
			{
				cur_len++;
			}
			else
			{
				if (cur_len > max_len)
					max_len = cur_len;
				cur_len = i - prev_index;
			}
			visited[st.charAt(i)] = i;
		}
		if(cur_len > max_len)
            max_len = cur_len;
         
        return max_len;
	}
	private static String getCount(String in)
	{
		char[] arr = in.toCharArray();
		int i, j, count;
		String out = "";
		for(i = 0; i < arr.length; i++)
		{
			count = 1;
			for ( j= i +1; j < arr.length && arr[i] == arr[j]; j++)
				count++;
			
			out = out + count + arr[i];
			if (count > 1)
			{
				i += count -1;
			}
		}
		return out;
	}
	public static String countAndSay(int n) {
		String res = "1";
		for (int i = 1; i <n ; i++)
			res = getCount(res);
		return res;
    }
	public static boolean isValid(String s)
	{
        Stack<Character> st = new Stack<Character>();
        int i = 0;
        char pop, cur;
        for (i = 0; i< s.length(); i++)
        {
        	cur = s.charAt(i);
        	if (cur == '(' || cur == '[' || cur ==  '{')
        	{
        		st.push(cur);
        	}
        	else
        	{
        		if(st.isEmpty())
        			return false;
        		pop = st.pop();
        		if (cur == '}' && pop != '{')
        			return false;
        		if (cur == ')' && pop != '(')
        			return false;
        		if (cur == ']' && pop != '[')
        			return false;
        	}
        }
        if (st.empty())
        	return true;
        return false;
        
        
    }
	static void test()
	{
		
		System.out.println(isValid("([)]"));
	}

}
