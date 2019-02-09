package practice;


public class LinkList {
	private ListNode head;
	public LinkList()
	{
		this.head = null;
	}
	public LinkList(int key)
	{
		this.head = new ListNode(key);
	}
	public LinkList(ListNode node)
	{
		this.head = node;
	}
	public void insertTail(int key)
	{
		if(this.head == null)
		{
			this.head = new ListNode(key);
			return;
		}
		ListNode p = this.head;
		while(p.next != null)
			p = p.next;
		p.next = new ListNode(key);
	}
	public void insertHead(int key)
	{
		if(this.head == null)
		{
			this.head = new ListNode(key);
			return;
		}
		this.head = new ListNode(key, this.head);
	}
	public void insertSorted(int key)
	{
		// Ascending
		if(this.head == null)
		{
			this.head = new ListNode(key);
			return;
		}

		ListNode n = new ListNode(key);
		if(head.val>= key)
		{
			n.next = head;
			head = n;
			return;
		}
		ListNode cur = head;
		// Move cur as long as cure.next is greater such that cur < key < cur.next
		while ( cur.next != null && cur.next.val < key)
		{
			cur = cur.next;
		}
		{
			n.next = cur.next;
			cur.next = n;
		}
	}
	public void printList()
	{
		if(this.head == null)
			return;
		ListNode p  = this.head;
		String out = "";
		while(p != null)
		{
			out += p.val;
			if(p.next != null)
				out += "-->";
			p = p.next;
		}
		System.out.println(out);
	}
	public static void test()
	{
		LinkList l1 = new LinkList(10);
	
		l1.insertSorted(15);
		l1.insertSorted(5);
		l1.insertSorted(25);
		l1.insertSorted(2);
		l1.insertSorted(12);
		l1.insertSorted(50);
		l1.insertSorted(100);
		l1.insertSorted(80);
		l1.printList();
		
		LinkList l2 = new LinkList(10);
		
		l2.insertSorted(-4);
		l2.insertSorted(53);
		l2.insertSorted(1);
		l2.insertSorted(2);
		l2.insertSorted(12);
		l2.insertSorted(78);
		l2.insertSorted(24);
		l2.insertSorted(1000);
		l2.printList();
		
		ListNode res = mergeTwoLists(null, null);
		new LinkList(res).printList();
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		
		ListNode tail = ret;
		while( true)
		{
			if( l1 == null)
			{
				tail.next = l2;
				break;
			}
			if (l2 == null)
			{
				tail.next = l1;
				break;
			}
			if ( l1.val <= l2.val)
			{
				tail.next = l1;
				l1=l1.next;
			}
			else
			{
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
			
		}
		return ret.next;
    }
}
class ListNode
{
	int val;
	ListNode next;
	public ListNode(int key)
	{
		this.val = key;
		this.next = null;
	}
	public ListNode(int key, int next)
	{
		this.val = key;
		this.next = new ListNode(next);
	}
	public ListNode(int key, ListNode next)
	{
		this.val = key;
		this.next = next;
	}
	public ListNode(Object key, Object next)
	{
		this.val = (int)key;
		this.next = (ListNode)next;
	}
	
}
class ListNodeChar
{
	char val;
	ListNodeChar next;
	public ListNodeChar(char key)
	{
		this.val = key;
		this.next = null;
	}
	public ListNodeChar(char key, char next)
	{
		this.val = key;
		this.next = new ListNodeChar(next);
	}
	public ListNodeChar(char key, ListNodeChar next)
	{
		this.val = key;
		this.next = next;
	}
	public ListNodeChar(Object key, Object next)
	{
		this.val = (char)key;
		this.next = (ListNodeChar)next;
	}
	public void addToTail(char c)
	{
		ListNodeChar p = this;
		while ( p.next != null)
			p = p.next;
		p.next = new ListNodeChar(c);
	}
	public void print()
	{
		ListNodeChar p = this;
		String out = "";
		while ( p != null)
		{
			out += "-->" + p.val;
			p = p.next;
		}
		System.out.println(out);
	
	}
	public static void test()
	{
		ListNodeChar head = new ListNodeChar('a');
		head.addToTail('b');
		head.addToTail('c');
		head.addToTail('d');
		head.addToTail('e');
		head.print();
	}
	
}