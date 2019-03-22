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
				ArrayProlems.swap(arr, i, j);
			}
		} 
		ArrayProlems.swap(arr, high, i+1);
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
		//int[] arr = {1, 0, 2, 1, 0 , 0, 1, 2 ,0,1,2, 0, 2, 1};
		SortingUtil utl = new SortingUtil();
		int[] x = {1, 2,3};
		int[] y = {1};
		//ArrayProlems.print_array(arr);
		//utl.quickSort(arr, 0, arr.length-1);
		//Array_prb.print_array(arr);
		//utl.sort_0_1_2s(arr);
		//ArrayProlems.print_array(arr);
		System.out.println(utl.findMedianTwoSortedArray(x, y));
	}
	public void sort_0_1_2s(int[] nums) {
		int h = nums.length -1;
		int l =0, m =0, tmp;
		while(m <= h) {
			switch(nums[m]) {
			case 0:
				// swap l++ m++
				tmp = nums[l];
				nums[l] = nums[m];
				nums[m] = tmp;
				l++; m++;
				break;
			case 1:
				//m++
				m++;
				break;
			case 2:
				///swap m , h--
				tmp = nums[m];
				nums[m] = nums[h];
				nums[h] = tmp;
				h--;
				break;
			}
		}
	}
	public double findMedianTwoSortedArray(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findMedianTwoSortedArray(nums2, nums1);
		int x = nums1.length, y = nums2.length;
		int low = 0, high = x;
		int maxLeftX, minRightX, maxLeftY, minRightY, px, py;
		while (low <= high) {
			px = ( low + high) /2;
			py = (x + y + 1) / 2 - px;
			maxLeftX = (px == 0)? Integer.MIN_VALUE: nums1[px-1];
			maxLeftY = (py == 0)? Integer.MIN_VALUE: nums2[py-1];
			minRightX = (px == x)? Integer.MAX_VALUE: nums1[px];
			minRightY = (py == y)? Integer.MAX_VALUE: nums2[py];
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// Calculate median
				if ( (x + y) % 2 == 0) {
					return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)))/2;
				}
				else
					return Math.max(maxLeftX, maxLeftY);
			}
			else if ( maxLeftX > minRightY) {
				high = px -1;
			}
			else
				low = px + 1;
			
		}
		return 1.0;
	}

}
