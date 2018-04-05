package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	
	public static void test()
	{
		QueueWithStackPopFaster test = new QueueWithStackPopFaster();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		System.out.println(test.peek());
		System.out.println(test.dequeue());
		System.out.println(test.peek());
		System.out.println(test.dequeue());
		System.out.println(test.peek());
		System.out.println(test.dequeue());
	}

};

class QueueWithStackPushFaster{
	Stack<Integer> stackFirst;
	Stack<Integer> stackSecond;
	public QueueWithStackPushFaster()
	{
		stackFirst = new Stack<Integer>();
		stackSecond = new Stack<Integer>();
	}
	public void enqueue(int val)
	{
		stackFirst.push(val);
	}
	public int dequeue()
	{
		if (!stackSecond.empty())
			return stackSecond.pop();
		while(!stackFirst.empty())
		{
			stackSecond.push(stackFirst.pop());
		}
		if (!stackSecond.empty())
			return stackSecond.pop();
		return -1;
	}
	public int peek()
	{
		if (!stackSecond.empty())
			return stackSecond.peek();
		while(!stackFirst.empty())
		{
			stackSecond.push(stackFirst.pop());
		}
		return stackSecond.peek();
	}
}
class QueueWithStackPopFaster{
	Stack<Integer> stackFirst;
	Stack<Integer> stackSecond;
	public QueueWithStackPopFaster()
	{
		stackFirst = new Stack<Integer>();
		stackSecond = new Stack<Integer>();
	}
	public void enqueue(int val)
	{
		while(!stackFirst.empty())
		{
			stackSecond.push(stackFirst.pop());
		}
		stackFirst.push(val);
		while(!stackSecond.empty())
		{
			stackFirst.push(stackSecond.pop());
		}
	}
	public int dequeue()
	{
		if (!stackFirst.empty())
			return stackFirst.pop();
		return -1;
	}
	public int peek()
	{
		if (!stackFirst.empty())
			return stackFirst.peek();
		return -1;
	}
}

class StackWithQueueEnqueueFatser
{
	Queue<Integer> firstQueue;
	Queue<Integer> secondQueue;
	public StackWithQueueEnqueueFatser()
	{
		firstQueue = new LinkedList<Integer>();
		secondQueue = new LinkedList<Integer>();
	}
	public void push(int val)
	{
		firstQueue.add(val);
		
	}
	
}

