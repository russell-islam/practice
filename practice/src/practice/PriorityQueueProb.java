package practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueProb {
	

}
class MedianStream
{
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	int total;
	public MedianStream()
	{
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); 
		total= 0;
	}
	public void add(int item)
	{
		if (total == 0)
		{
			minHeap.add(item);
			total ++;
			return;
		}
		else if (total == 1)
		{
			int current;
			if (minHeap.size() > maxHeap.size())
			{
				current = minHeap.remove();
			}
			else
			{
				current = minHeap.remove();
			}
			if (current > item)
			{
				minHeap.add(current);
				maxHeap.add(item);
			}
			else
			{
				minHeap.add(item);
				maxHeap.add(current);
			}
			total++;
			return;
		}
		
		int minTop = minHeap.peek();
		if (minTop > item)
		{
			while (maxHeap.size() >= minHeap.size())
			{
				minHeap.add(maxHeap.remove());
			}
			maxHeap.add(item);
		}
		else
		{
			while (maxHeap.size() <= minHeap.size())
			{
				maxHeap.add(minHeap.remove());
			}
			maxHeap.add(item);
		}
		total++;
	}
	void print()
	{
		System.out.println(maxHeap.toString());
		System.out.println(minHeap.toString());
	}
}
