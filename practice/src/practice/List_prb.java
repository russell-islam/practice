package practice;

import java.util.ArrayList;
import java.util.List;

public class List_prb {
	
	
	public static void print_dif_string_accross_lists(List<String> list1, List<String> list2, List<String> list3)
	{
		int i=0, j=0 ,k=0;
		int comp, comp2;
		String st1, st2, st3;
		String stateStr = "";
		String prev_omit ="";
		// Three list
		while(true)
		{
			st1 = "";
			st2 = "";
			st3="";
			stateStr = "";
			if(list1.size() != i)
			{
				st1 = list1.get(i);
				stateStr +="1";
			}
			else
			{
				stateStr +="0";
			}
			if(list2.size() !=  j)
			{
				st2 = list2.get(j);
				stateStr +="1";
			}
			else
			{
				stateStr +="0";
			}
			if(list3.size() != k)
			{
				stateStr +="1";
				st3 = list3.get(k);
			}
			else
			{
				stateStr +="0";
			}
			if(stateStr == "000")
				break;
			switch(stateStr)
			{
			case "001":
				if(prev_omit != st3)
				System.out.println(st3);
				k++;
				break;
			case "010":
				if(prev_omit != st2)
				System.out.println(st2);
				j++;
				break;
			case "100":
				if(prev_omit != st3)
				System.out.println(st1);
				i++;
				break;
			case "110":
				comp = st1.compareTo(st2);
				if(comp == 0)
				{
					prev_omit = st1;
					i++;
					j++;
				}
				else if(comp < 0)
				{
					if(prev_omit != st1)
						System.out.println(st1);
					i++;
				}
				else
				{
					if(prev_omit != st2)
						System.out.println(st2);
					j++;
				}
				break;
			case "101":
				comp = st1.compareTo(st3);
				if(comp == 0)
				{
					prev_omit = st1;
					i++;
					k++;
				}
				else if(comp < 0)
				{
					if(prev_omit != st1)
						System.out.println(st1);
					i++;
				}
				else
				{
					if(prev_omit != st3)
						System.out.println(st3);
					k++;
					
				}
				break;
			case "011":
				comp = st2.compareTo(st3);
				if(comp == 0)
				{
					prev_omit = st2;
					i++;
					j++;
				}
				else if(comp < 0)
				{
					if(prev_omit != st2)
						System.out.println(st2);
					j++;
				}
				else
				{
					if(prev_omit != st3)
						System.out.println(st3);
					k++;
				}
				break;
			case "111":
				comp = st1.compareTo(st2);
				if(comp == 0)
				{
					prev_omit = st1;
					i++;
					j++;
				}
				else if(comp < 0)
				{
					comp2 = st1.compareTo(st3);
					if(comp2 == 0)
					{
						prev_omit = st1;
						i++;
						k++;
					}
					else if(comp2 < 0)
					{
						if(prev_omit != st1)
							System.out.println(st1);
						i++;
					}
					else
					{
						if(prev_omit != st3)
							System.out.println(st3);
						k++;
					}
				}
				else
				{
					comp2 = st2.compareTo(st3);
					if(comp2 == 0)
					{
						prev_omit = st2;
						j++;
						k++;
					}
					else if(comp2 < 0)
					{
						if(prev_omit != st2)
							System.out.println(st2);
						j++;
					}
					else
					{
						if(prev_omit != st3)
							System.out.println(st3);
						k++;
					}
				}
				break;
				default:
					break;
			}
		}
		
	}
	public static void test_list_string()
	{
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		list1.add("aaa");
		list1.add("bbb");
		list1.add("bbb");
		list1.add("ddd");
		list1.add("xyxz");
		
		list2.add("aaa");
		list2.add("ccc");
		list2.add("hkp");
		
		list3.add("aaa");
		list3.add("aaa");
		list3.add("ddd");
		list3.add("eee");
		list3.add("fff");
		list3.add("lmn");
		print_dif_string_accross_lists(list1,list2, list3);
	}
	/*
	 * a-->a-->a-->b-->d-->e-->e-->h 
	 * output: a-->3-->b-->1-->d-->1-->e-->2-->h-->1
	 * Number of consecutive chars <= 9
	 */
	public static ListNodeChar compressCharList(ListNodeChar head)
	{
		ListNodeChar p = head;
		ListNodeChar out = new ListNodeChar(head.val);
		int count = 1;
		ListNodeChar q = p.next;
		ListNodeChar temp = out;
		
		while(q != null)
		{
			if (p.val == q.val) {
				count++;
			}
			else
			{
				temp.next = new ListNodeChar((char)(count + '0'));
				temp.next.next = q;
				temp = q;
				count = 1;
			}
			p = q;
			q = q.next;
		}
		temp.next = new ListNodeChar((char)(count + '0'));
		
		return out;
	}
	public static void testCompressCharList()
	{
		ListNodeChar head = new ListNodeChar('a');
		head.addToTail('a');
		head.addToTail('a');
		head.addToTail('b');
		head.addToTail('d');
		head.addToTail('e');
		head.addToTail('e');
		head.addToTail('h');
		ListNodeChar ret = compressCharList(head);
		ret.print();
		
	}

}
