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
	public void insertLast(int key)
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
	public void insertFirst(int key)
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
		if(this.head == null)
		{
			this.head = new ListNode(key);
			return;
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
		}
		System.out.println(out);
	}
	public static void test()
	{
		LinkList test = new LinkList(10);
		test.insertFirst(5);
		test.insertLast(15);
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