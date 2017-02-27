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

}
