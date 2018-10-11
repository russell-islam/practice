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
	public static String longestCommonPrefix(String[] strs) {
		String out = "";
		int i = 0, count;
		char cur;
		while(true)
		{
			cur = 0;
			count = 1;
			for (String str : strs)
			{
				if (str.length() == i)
					return out;
				if (cur == 0)
				{
					cur = str.charAt(i);
				}
				else
				{
					if (cur == str.charAt(i))
						count++;
				}
			}
			if (count == strs.length)
				out+= cur;
			else
				break;
			i++;
		}
		return out;
    }
	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if (needle.length() > haystack.length())
			return -1;
		int i = 0, si, sj;
		for(;i < haystack.length();)
		{
			if (haystack.charAt(i) != needle.charAt(0))
			{
				i++;
			}
			else
			{
				si = i;
				sj = 0;
				while(si < haystack.length() && sj < needle.length() && haystack.charAt(si++) == needle.charAt(sj++))
				{
					if ((si - i) == needle.length())
						return i;
				}
				i++;
			}
		}
        
		return -1;
    }
	public static int strStr2(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if (needle.length() > haystack.length())
			return -1;
		char[] big = haystack.toCharArray();
		char[] small = needle.toCharArray();
		int i = 0; int j =0, si, sj;
		for(;i < haystack.length() - needle.length() + 1 && j < needle.length();)
		{
			si = i;
			sj = 0;
			while(si < big.length && sj < small.length && big[si++] == small[sj++])
			{
				if ((si - i) == needle.length())
					return i;
			}
			i++;
		}
        
		return -1;
	}
	public static int lengthOfLastWord(String s) {
        String str = s.trim();
        if (str.length() == 0)
        	return 0;
        String out = "";
        int last = str.length() -1;
        while(last >= 0 && str.charAt(last) != ' ')
        {
        	out += str.charAt(last);
        	last--;
        }
        return out.length();
    }
	static void test()
	{
		//String[] strs = {};
		//String[] strs = {"flower","flow","flight"};
		System.out.println(lengthOfLastWord("Hello World"));
	}

}
