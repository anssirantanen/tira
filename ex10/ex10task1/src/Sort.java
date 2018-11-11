/* Sorting Excercises */

import java.util.Arrays;
import java.util.Random;

class Sort
{
	public static void main (String[] args)
	{
		/* Test the sorting algorithms */
		int[] a = null;
		boolean ok = true;

		/* Insertion sort */
		a = randomArray(20);
		insertSort(a);
		if ( isSorted(a) != true)
		{
			System.out.println ("insertSort produced wrong result: ");
			printArray (a);
		}
		else
		{
			System.out.println ("insertSort seems to be ok!");
		}

		/* Selection sort */
		a = randomArray(20);
		selectSort(a);
		if ( isSorted(a) != true)
		{
			System.out.println ("selectSort produced wrong result: ");
			printArray (a);
		}
		else
		{
			System.out.println ("selectSort seems to be ok!");
		}

		/* Mergesort */
		a = randomArray(20);
		mergeSort(a);
		if ( isSorted(a) != true)
		{
			System.out.println ("mergeSort produced wrong result: ");
			printArray (a);
		}
		else
		{
			System.out.println ("mergeSort seems to be ok!");
		}

		/* Quicksort */
		a = randomArray(20);
		quickSort(a);
		if ( isSorted(a) != true)
		{
			System.out.println ("quickSort produced wrong result: ");
			printArray (a);
		}
		else
		{
			System.out.println ("quickSort seems to be ok!");
		}
	}

	public static void insertSort (int[] tab)
	{
		/* An exercise! */
		if(tab.length <= 1 ){
			return;
		}
		for(int i = 1; i<tab.length;i++){
			insertBackwards(i,tab);
		}
	}
	private static void insertBackwards(int moveIndex, int[] table){

		int cursor = moveIndex-1;
		var val = table[moveIndex];
		while(cursor > 0 && table[cursor-1]>val){
			cursor--;
		}
		if(cursor != moveIndex-1){
			System.arraycopy(table,cursor,table,cursor+1,moveIndex-cursor);
			table[cursor]=val;
		}else if(val < table[cursor]){
			table[moveIndex] = table[cursor];
			table[cursor] = val;
		}
	}

	public static void selectSort (int[] tab)
	{
		if(tab.length <=1){
			return;
		}
		for(int i=0;i<tab.length; i++){
			var min = tab[i];
			var swapIndex = i;
			for(int j = i;j<tab.length;j++){
				if(tab[j] < min){
					min = tab[j];
					swapIndex = j;
				}
			}
			if(swapIndex != i){
				swap(i,swapIndex,tab);
			}
		}
	}
	private static void swap(int left, int riht, int[] table){
		var temp = table[left];
		table[left]= table[riht];
		table[riht] = temp;
	}


    public static void mergeSort (int[] tab)
    {
		/* An exercise! */
	}

	private static Random qsr = new Random ();    

	/* 
	partition 

	chooses random pivot element from A[low..high], partitions 
	A[low..high] with respect to it and returns the final index p of the 
	pivot element thus after the call the following holds:
		A[i] <= A[p] when low <= i <= p     and 
		A[p] <= A[i] when   p <= i <= high
	*/

	private static int partition (int[] A, int low, int high)
	{
		int pivot, tmp, l, r;
		pivot = low + qsr.nextInt(high - low + 1);
		l = low;
		r = high-1;
		tmp = A[pivot];
		A[pivot] = A[high];
		A[high] = tmp;
		pivot = high;
		do
		{
			tmp = A[l];
			A[l] = A[r];
			A[r] = tmp;
			for(; l <= r && A[l] < A[pivot]; ++l)
			;
			for(; l <= r && A[pivot] < A[r]; --r)
			;
		}
		while (l <= r);
		tmp = A[l];
		A[l] = A[pivot];
		A[pivot] = tmp;
		return l;
	}
	
	
    public static int[] quickSort (int[] tab)
    {
	/* excercises */
	return tab;
    }

	
	/* Helper-functions for testing */

	public static boolean isSorted (int[] a)
	{
		boolean sorted = true;
		for (int i = 0; sorted && i < a.length; ++i)
		{
			if (a[i] != i)
			{
				sorted = false;
			}
		}
		return sorted;
	}

	private static void printArray (int[] tab)
	{
		System.out.print ("(");
		for (int i = 0; i < tab.length-1; ++i)
		{
			System.out.print (tab[i] + " ");
		}
		System.out.println (tab[tab.length-1] + ")");
	}

	private static Random r = new Random ();

	private static int[] randomArray (int n)
	{
		int[] keys = new int [n];
		for (int i = 0; i < n; ++i)
		{
			keys[i] = i;
		}
		for (int i = 0; i < n; ++i)
	    {
			int pos = i + r.nextInt(n-i);
			int tmp = keys[pos];
			keys[pos] = keys[i];
			keys[i] = tmp;
		}
		return keys;
	}
}
