/* Sorting Excercise */

import java.util.Random;

class Sort
{
 
    public static void main (String[] args)
    {
	  // Testing quick sort method
        testQuickSort ();
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

    // Quick sort 

    public static int[] quickSort (int[] tab)
    {
    	if(tab.length <=1){
    		return tab;
		}
		recSort(0,tab.length-1, tab);
      return tab;
    }
    private static void recSort(int start, int end, int[] tab){
    	if(start< end) {
			var p = partition(start, end, tab);
			recSort(start, p - 1, tab);
			recSort(p + 1, end, tab);
		}
	}
	private static int partition(int start, int end, int[] tab){
    	var pivot =	tab[end];
    	var lowB = start-1;
    	for(int i=start;i<=end-1;i++){
    		if(tab[i] <= pivot){
    			lowB++;
    			var temp= tab[i];
    			tab[i]=tab[lowB];
    			tab[lowB] = temp;
			}
		}
		var temp= tab[lowB+1];
    	tab[lowB+1] = tab[end];
    	tab[end] = temp;
    	return lowB+1;
    }
    // Testing 

    public static boolean testQuickSort ()
    {
	int[] a = null;
	boolean ok = true;
	System.out.println ("Testing quick sort.");

	for (int i = 0; ok && i < 10; ++i)
	    {
		a = randomArray(20);
		a = quickSort (a);
     		ok = isSorted(a);
	    }
	if (! ok)
	    {
		System.out.println ("Error: Incorrectly sorted, result was: ");
		printArray (a);
	    }
	else
	    {
		System.out.println ("Test passed.");
	    }
	return ok;
    }

    public static boolean isSorted (int[] a)
    {
	boolean sorted = true;
	for (int i = 0; sorted && i < a.length; ++i)
	    if (a[i] != i)
		sorted = false;
	return sorted;
    }

    private static void printArray (int[] tab)
    {
	System.out.print ("(");
	for (int i = 0; i < tab.length-1; ++i)
	    System.out.print (tab[i] + " ");
	System.out.println (tab[tab.length-1] + ")");
    }

    private static Random r = new Random ();

    private static int[] randomArray (int n)
    {
	int[] keys = new int [n];
	for (int i = 0; i < n; ++i)
	    keys[i] = i;
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
