package practice;

import java.util.ArrayList;
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
	/*
	 * Given two binary strings, return their sum (also a binary string).

		The input strings are both non-empty and contains only characters 1 or 0.
		
		Example 1:
		
		Input: a = "11", b = "1"
		Output: "100"
		
		Example 2:
		
		Input: a = "1010", b = "1011"
		Output: "10101"


	 */
	public static String addBinary(String a, String b)
	{
		if (b.length() ==0)
			return a;
		if (a.length() == 0)
			return b;
		int i = a.length() -1, j= b.length() -1;
		String ret = "";
		int sum =0, carry =0, bit1, bit2;
		for (;i >=0 || j>=0;)
		{
			bit1 =0;
			bit2=0;
			if ( i >= 0)
			{
				bit1 = Character.getNumericValue(a.charAt(i));
			}
			if (j >= 0)
			{
				bit2 = Character.getNumericValue(b.charAt(j));
			}
			sum = bit1 + bit2 + carry;
			carry = 0;
			if (sum >= 2)
			{
				sum = sum -2;
				carry = 1;
			}
			ret = sum + ret;
			i--;
			j--;
		}
		if (carry ==1)
			return "1" + ret;
		return ret;
	}
	private static String insertCharAt(String st, int index, char c)
	{
		if (index < 0 || index > st.length())
			throw new java.lang.RuntimeException("this is not quite as bad");
		String out = "";
		String first = st.substring(0, index);
		String last = st.substring(index);
		out = first + c + last;
		return out;
	}
	private static ArrayList<String> getPermutations(String st)
	{
		if (st == null)
			return null;
		ArrayList<String> permutations = new ArrayList<String>();
		if (st.length() == 0)
		{
			permutations.add(st);
			return permutations;
		}
		char c = st.charAt(0);
		String remainder = st.substring(1);
		String tmp;
		ArrayList<String> words = getPermutations(remainder);
		for(String word: words)
		{
			for (int i =0; i <= word.length(); i++)
			{
				tmp = insertCharAt(word, i, c);
				permutations.add(tmp);
			}
		}
		return permutations;
	}
	public static int[] createLPSArray(String pattern)
	{
		int len = pattern.length();
		char[] charArray = pattern.toCharArray();
		int arr[] = new int [len];
		int i =1, j =0;
		
		while (i < len)
		{
			if (charArray[i] == charArray[j])
			{
				arr[i] = arr[j] + 1;
				j++;
			}
			else
			{
				j = arr[i-1];
			}
			i++;
		}
		return arr;
	}
	public static int kmpSubstringSearch(String str, String pat)
	{
		int[] lps = createLPSArray(pat);
		int n = str.length(), m = pat.length();
		int i =0, j=0;
		while(i < n)
		{
			if (str.charAt(i) == pat.charAt(j)) {
				j++;
				i++;
			}
			else if( str.charAt(i) != pat.charAt(j) && i < n)
			{
				if (j != 0)
				{
					j = lps[j-1];
				}
				else
				{
					i++;
				}
			}
			
			if ( j== pat.length())
				return i - j;
		}
		return -1;
		
	}
	private static void longestPalindromManacher(String st)
	{
		int newlen = st.length() * 2 + 3;
		char[] T = new char [newlen];
		int[] P = new int [newlen];
		ArrayProlems.init_single_array(P, 0);
		int i, j=0, R =0, C =0, mirr;
		T[0] = '$';
		int maxPal = 0, maxIndex = 0;
		T[newlen - 1] = '@';
		for ( i =1; i < newlen -1; i++)
		{
			if ( i % 2 == 0)
				T[i] = st.charAt(j++);
			else
				T[i] = '#';
		}
		
		for (i = 1; i < T.length -1; i++)
		{
			mirr = 2 * C - i;
			if ( i < R)
			{
				P[i] = Math.min(R - i, P[mirr]);
			}
			while (T[i + (1 + P[i])] == T[i  - (1 + P[i])])
			{
				P[i]++;
			}
			if (P[i] > maxPal)
			{
				maxIndex = i;
				maxPal = P[i];
			}
			if ( i + P[i] > R)
			{
				R = i + P[i];
				C = i;
			}
		}
		System.out.println("Max Pal length: " + maxPal);
	}
	static void test()
	{
		//String[] strs = {};
		//String[] strs = {"flower","flow","flight"};
		//longestPalindromManacher("ABABABA");
		int index = kmpSubstringSearch("xabacdabacde", "abacdef");
		System.out.println("Pattern found ar index: " + index);
		/*
		System.out.println(getPermutations(null));
		System.out.println(getPermutations(""));
		System.out.println(getPermutations("A"));
		System.out.println(getPermutations("AB"));
		System.out.println(getPermutations("ABCD"));
		*/
	}

}
