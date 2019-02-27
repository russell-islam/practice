package practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueProb {
	
	public static void test()
	{
		MedianStream ms = new MedianStream();
		ms.add(5);
		ms.add(10);
		ms.add(30);
		ms.add(50);
		ms.add(25);
		ms.add(100);
		ms.print();
	}
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
	public void add(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
 
        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }
 
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
    public String getStringFromPQ(PriorityQueue<Integer> queue)
    {
    	if (queue.size()  == 0) {
    		return "[]";
    	}
    		
    	String out="[";
    	Iterator<Integer> itr = queue.iterator(); 
        while (itr.hasNext()) 
            out += itr.next() + " ,";
        out = out.substring(0, out.length() - 2);
        out += "]";
    	return out;
    }
	void print()
	{
		System.out.println(getStringFromPQ(minHeap));
		System.out.println(getStringFromPQ(maxHeap));
		System.out.println(findMedian());
	}
}
class MedianSortedArray
{
	double getMedian(int[] arr1, int[] arr2)
	{
		int median = 0;
		int minIndex = 0;
		int n= arr1.length, m = arr2.length;
		int maxIndex = n -1;
		int i =0, j=0;
		while (minIndex <= maxIndex)
		{
			i = (minIndex + maxIndex) / 2;
			j = (n + m) / 2 - i;
			if ( i < n && j > 0 && arr1[j-1] > arr2[i]) {
				minIndex = i + 1;
			}
			else if ( i > 0 && i < m && arr1[i -1] > arr2[j])
			{
				maxIndex = i -1;
			}
			else
			{
				if ( i == 0)
				{
					median = arr2[j-1];
				}
				else if ( j== 0)
				{
					median = arr1[i-1];
				}
				else
				{
					median = Integer.max(arr1[i-1], arr2[j-1]);
				}
				break;
			}
		}
		// calculating the median. 
	    // If number of elements is odd there is  
	    // one middle element. 
	    if ((n + m) % 2 == 1) 
	        return (double)median; 
	          
	    // Elements from a[] in the second half is an empty set.     
	    if (i == n) 
	        return (median+arr2[j]) / 2.0; 
	          
	    // Elements from b[] in the second half is an empty set. 
	    if (j == m) 
	        return (median + arr1[i]) / 2.0; 
	      
	    return (median + Math.min(arr1[i], arr2[j])) / 2.0; 
	}
}
