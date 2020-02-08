package com.github.saravanprathi.sorting;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[]= {5,3,2,1,9,4,6};
		int a[]= {9,3,2,1,8,4,6};
		int low=0,high=a.length-1;
		System.out.println(Arrays.toString(a));
		quicksort(a,low,high);
		System.out.println(Arrays.toString(a));
		}
	
	
	private static void quicksort(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		if(low>=high) {
			return;
		}	
		int pivot=low+(high-low)/2;
		int partition=partition(a,low,high,pivot);
		quicksort(a,low,partition-1);
		quicksort(a,partition,high);
	}

	private static int partition(int[] a, int low, int high, int pivot) {
		// TODO Auto-generated method stub
		while(low<=high) {
			while(a[low]<a[pivot]) {
				low++;
			}
			while(a[high]>a[pivot]) {
				high--;
			}
			if(low<=high) {
				swap(a,low,high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
