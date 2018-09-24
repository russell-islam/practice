package practice;

import java.util.Arrays;

public class SortingUtil {
	
	public int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];
		int i = low -1;
		for(int j = low; j < high; j++)
		{
			if(arr[j] <= pivot)
			
			{
				i++;
				Array_prb.swap(arr, i, j);
			}
		} 
		Array_prb.swap(arr, high, i+1);
		return i + 1;
	}
	public void quickSort(int[] arr, int low, int high)
	{
		if ( low < high)
		{
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	public void merge(int[] arr, int l, int m, int r)
	{}
	public void mergeSort(int[] arr, int l, int r)
	{
		int m = (l + r) /2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		merge(arr, l, m, r);
	}
	private void heapify(int[] arr, int n, int i)
	{
		int max = i;
		int l = 2 * i +1;
		int r = 2*i + 2;
		int tmp;
		if (l < n && arr[l] > arr[max])
		{
			max = l;
		}
		if (r < n && arr[r] > arr[max])
		{
			max =r;
		}
		if (max != i)
		{
			tmp = arr[i];
			arr[i] = arr[max];
			arr[max] = tmp;
			heapify(arr, n, max);
		}
	}
	private void heapSort(int[] arr)
	{
		int n = arr.length;
		int i, tmp;
		for (i = n/2 -1; i >=0; i--)
		{
			heapify(arr,n, i);
		}
		for (i = n-1; i >=0; i--)
		{
			tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapify(arr,i, 0);
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void test()
	{
		//int[] arr = {1, 100, 5 , 10, 70, 80 , 40, 25, 45};
		int[] arr = {12, 11, 13, 5, 6, 7};
		SortingUtil utl = new SortingUtil();
		Array_prb.print_array(arr);
		//utl.quickSort(arr, 0, arr.length-1);
		//Array_prb.print_array(arr);
		utl.heapSort(arr);
	}

}
