package com.github.saravanprathi.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,8,4,1,6,9,7,3,10,5};
		System.out.println(Arrays.toString(a));
		mergesort(a,new int [a.length],0,a.length-1);
		System.out.println(Arrays.toString(a));
	}

	private static void mergesort(int[] a, int[] temp, int leftStart, int rightEnd) {
		// TODO Auto-generated method stub
		if(leftStart>=rightEnd) {
			return;
		}
		int middle=leftStart+(rightEnd-leftStart)/2;
		mergesort(a,temp,leftStart,middle);
		mergesort(a,temp,middle+1,rightEnd);
		mergehalves(a,temp,leftStart,rightEnd);
	}

	private static void mergehalves(int[] a, int[] temp, int leftStart, int rightEnd) {
		// TODO Auto-generated method stub
		int leftEnd=leftStart+(rightEnd-leftStart)/2;
		int rightStart=leftEnd+1;
		int size=rightEnd-leftStart+1;
		int left=leftStart,right=rightStart,index=leftStart;
		while(left<=leftEnd && right<=rightEnd) {
			if(a[left]<a[right]) {
				temp[index]=a[left];
				left++;
			}
			else {
				temp[index]=a[right];
				right++;
			}
			index++;
		}
		System.arraycopy(a,left, temp, index, leftEnd-left+1);
		System.arraycopy(a,right, temp, index, rightEnd-right+1);
		System.arraycopy(temp, leftStart, a, leftStart, size);
	}
}
