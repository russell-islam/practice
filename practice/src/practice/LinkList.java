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
		if(head.key>= key)
		{
			n.next = head;
			head = n;
			return;
		}
		ListNode cur = head;
		// Move cur as long as cure.next is greater such that cur < key < cur.next
		while ( cur.next != null && cur.next.key < key)
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
			out += p.key;
			if(p.next != null)
				out += "-->";
			p = p.next;
		}
		System.out.println(out);
	}
	public static void test()
	{
		LinkList test = new LinkList(10);
	
		test.insertSorted(15);
		test.insertSorted(5);
		test.insertSorted(25);
		test.insertSorted(2);
		test.insertSorted(12);
		test.insertSorted(50);
		test.insertSorted(100);
		test.insertSorted(80);
		test.printList();
	}
}
class ListNode
{
	int key;
	ListNode next;
	public ListNode(int key)
	{
		this.key = key;
		this.next = null;
	}
	public ListNode(int key, int next)
	{
		this.key = key;
		this.next = new ListNode(next);
	}
	public ListNode(int key, ListNode next)
	{
		this.key = key;
		this.next = next;
	}
}