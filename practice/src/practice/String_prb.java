package practice;

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
	static void test()
	{
		int out = longestNonRepeatingSubstring("PQSTPRQMNO");
		System.out.println(out);
	}

}
