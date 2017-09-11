/**
 * Merge.java, you MUST SUBMIT this file.
 *
 * Multiple Implementations of merge sort involving Magic Boxes
 *
 * I have used a similar implementation of the code given to us in standard merge sort for my 8-sortmerge sort
 *
 * TODO: @Kazi Rahma
 * TODO: @12
 * TODO: 14th October 2016
 */

public class Merge{
	public MagicBox magicBox = new MagicBox();  
	public int count; //Counter for the number of comparisons in the standard algorithm
	public int boxCalledCount = 0;
	
	/**
	 * sortMerge
	 * A standard merge sort
	 *
	 * @param array: The array to be sorted.
	 */
	public void sortMerge(int[] array) {
		//Implemented merge sort and increment "count" 
		//to keep track of the number of pairwise comparisons
		if (array.length <= 1) return;

		// Split the array in half
		int[] first = new int[array.length / 2];
		int[] second = new int[array.length - first.length];
		System.arraycopy(array, 0, first, 0, first.length);
		System.arraycopy(array, first.length, second, 0, second.length);

		// Sort each half
		sortMerge(first);
		sortMerge(second);

		// Merge the halves together, overwriting the original array
		standardMerge(first, second, array);
	}
   
	/**
	 * standardMerge
	 *
	 * merges two arrays back together for merge sort
	 *
	 * @param a the first array being merged
	 * @param b the second array being merged
	 * @param result the target array where the other two arrays are being merged
	 */
	private void standardMerge(int[] a, int[] b, int[] result) {
		// Merge both halves into the result array
		// Next element to consider in the first array
		int aIndex = 0;
		// Next element to consider in the second array
		int bIndex = 0;

		// Next open position in the result
		int j = 0;
		// As long as neither iFirst nor iSecond is past the end, move the
		// smaller element into the result.

		while (aIndex < a.length && bIndex < b.length) {
			count++;
			if (a[aIndex] < b[bIndex]) {
				result[j] = a[aIndex];
				aIndex++;
			} else {
				result[j] = b[bIndex];
				bIndex++;
			}
			j++;
		}
		// copy what's left
		System.arraycopy(a, aIndex, result, j, a.length - aIndex);
		System.arraycopy(b, bIndex, result, j, b.length - bIndex);
    }
	
	
	/**
	 * TODO: sortMerge8Sort
	 * Merge Sort the array using the 8-Sort Box
	 *
	 * @param array: The array to be sorted.
	 */
	public void sortMerge8Sort(int[] array) {



		if (array.length <= 1) return; //now

		//if the length of the array is not 8 or less then continue dividing it
		int[] first = new int[array.length/2];
		int[] second = new int[array.length - first.length];

		//copy elements into the first and second arrays
		System.arraycopy(array, 0, first, 0, first.length);
		System.arraycopy(array, first.length, second, 0, second.length);

		//call sort on first and second arrays recursively
		sortMerge8Sort(first);
		sortMerge8Sort(second);

		//call merge function
		standardMerge8Sort(first, second, array);
	}

	private void standardMerge8Sort(int[] a, int[] b, int[] result){
		int aIndex = 0; //index to keep track of elements in array a
		int bIndex = 0;//index to keep track of elements in array b
		int j = 0; //index to keep track of elements in the final array
		int[] newarray = new int[8];
		int[] rank = new int[8]; //array to store the indices

		while (aIndex < a.length && bIndex < b.length){
			newarray[0] = a[aIndex];
			newarray[1] = b[bIndex];
			for(int k = 2; k < 8; k++){
				newarray[k] = Integer.MAX_VALUE;
			}
			rank = magicBox.eightSort(newarray);
			if(rank[0] == 0){
				result[j++] = a[aIndex++];
			}
			else{
				result[j++] = b[bIndex++];
			}
		}

		while (aIndex < a.length){
			result[j++] = a[aIndex++];
		}
		while (bIndex < b.length){
			result[j++] = b[bIndex++];
		}

	}

private void printarray(int[] array){
	for(int i = 0; i < array.length; i++){
		System.out.printf("%d ", array[i]);
	}
	System.out.println();
}



}
 /* Merge.java, you MUST SUBMIT this file. 
  * Do not modify any variable definition
  */
