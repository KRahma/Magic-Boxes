/**
 * Selection.java, you must SUBMIT this file.
 * Do not modify any variable definition
 *
 * Multiple Implementations of Selection sort involving Magic Boxes
 * I am using a similar implementation to the standard selection sort which is given to us
 *
 * TODO: @Kazi Rahma
 * TODO: @12
 * TODO: 14th October, 2016
 */

public class Selection{
	public MagicBox magicBox = new MagicBox();
	public long count;
	
	/**
	 * sortSelection
	 * A standard selection sort
	 *
	 * @param array: The array to be sorted.
	 */
	public void sortSelection(int[] array) {
        // a for loop to control the number of elements that finish sorting
        for (int left = 0; left < array.length - 1; left++) {
            int right = array.length - 1;
            int min = right; //index of the minimum element
	    
	    	// from last to first unsorted element, find the min
            // and place it into the first unsorted position
            while (right >= left) {
                if(array[right] < array[min]){
				    min = right;
				}
				count++;
			right--;
	    	}
            
			if(min!=left){
				int temp = array[left];
				array[left] = array[min];
				array[min] = temp;
			}
        }
	}
	
	/**
	 * TODO: sortSelection8Sort
	 * Selection Sort the array using the 8-Sort Box
	 *
	 * @param array: The array to be sorted.
	 */
	public  void sortSelection8Sort(int[] array) {

		/*for(int left = 0; left < array.length-1; left++){
			int[] passingarray = new int[array.length-left];
			int z = 0;
			System.arraycopy(array, left, passingarray, 0, array.length-left);

			int minindex = min8sortindex(passingarray);

			//for(int k = left; k < passingarray.length; k++){
			//	array[k] = passingarray[z++];
			//}

			int temp = array[left];
			array[left] = passingarray[minindex];
			array[left + minindex] = temp;
		}*/
		int minindex = 0;
		int min = Integer.MIN_VALUE;
		int temp = 0;
		int[] newarray;
		int[] rank;

		for(int left = 0; left < array.length - 1; left++){

			for(int i = 0; i < array.length -1 - left; i+=7){ //loop to take 8 elements including the minimum found each time

				newarray = new int[8];

				if(array.length - i - left < 8){
					System.arraycopy(array, i+left, newarray, 0, array.length-i-left);

					for(int j = array.length-i-left; j < 8; j++){
						newarray[j] = Integer.MAX_VALUE;
					}

					rank = magicBox.eightSort(newarray); //get the indices
					int minrank = rank[0]; //giving the index of minimum element in the newarray
					minindex = left + i + minrank;
					min = array[minindex];
				}
				else if(array.length - i - left == 8){
					System.arraycopy(array, i+left, newarray, 0, 8);
					rank = magicBox.eightSort(newarray);
					int minrank = rank[0];
					minindex = left + i + minrank;
					min = array[minindex]; //if there are only 8 elements left then no need to swap for finding the min in the next set
				}
				else{
					System.arraycopy(array, i+left, newarray, 0, 8);
					rank = magicBox.eightSort(newarray);
					int minrank = rank[0];
					minindex = left + i + minrank;
					min = array[minindex];
					temp = array[left+i+7];
					array[left+i+7] = array[minindex];
					array[minindex] = temp; //swap to find the min in the next set
				}
			}

			int temp2 = array[left];
			array[left] = min;
			array[minindex] = temp2;
		}
		/*int minindex1 = 0;
		int minindex2 = 0;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int temp1, temp2, temp3, temp4 = 0;
		int[] newarray = new int[8];
		int[] rank = new int[8];

		for(int left = 0; left < array.length - 1; left+=2){

			for(int i = 0; i < array.length - 1 - left; i+=6){

				if(array.length - i - left <= 8){
					if(array.length-i-left <8) {
						System.arraycopy(array, i + left, newarray, 0, array.length - i - left);
						for (int j = array.length - i - left; j < 8; j++) {
							newarray[j] = Integer.MAX_VALUE;
						}
					}
					else{
						System.arraycopy(array, i+left,newarray,0,8);
					}

					rank = magicBox.eightSort(newarray);
					int minrank1 = rank[0];
					int minrank2 = rank[1];
					minindex1 = left+i+minrank1;
					minindex2 = left+i+minrank2;
					min1 = array[minindex1];
					min2 = array[minindex2];
				}
				else{
					System.arraycopy(array, i+left, newarray, 0, 8);
					rank = magicBox.eightSort(newarray);
					int minrank1 = rank[0];
					int minrank2 = rank[1];
					minindex1 = left+i+minrank1;
					minindex2 = left+i+minrank2;
					min1 = array[minindex1];
					min2 = array[minindex2];
					temp1 = array[left+i+6];
					temp2 = array[left+i+7];
					array[left+i+6] = min1;
					array[left+i+7] = min2;
					array[minindex1] = temp1;
					array[minindex2] = temp2;
				}
			}

			temp3 = array[left];
			temp4 = array[left+1];
			array[left] = min1;
			array[left+1] = min2;
			array[minindex1] = temp3;
			array[minindex2] = te
		}*/

	}

	/**
	 * TODO: sortSelection8Min
	 * Selection Sort the array using the 8-Min Box
	 *
	 * @param array: The array to be sorted.
	 */
	public void sortSelection8Min(int[] array) {


		int minindex = 0;
		int min = Integer.MIN_VALUE;
		int temp = 0;

		for(int left = 0; left < array.length - 1; left++){

			for(int i = 0; i < array.length - 1 - left; i+=7){

				int[] newarray = new int[8];

				if(array.length-i-left < 8){

					System.arraycopy(array, i + left, newarray, 0, array.length - i - left);

					for(int j = array.length-i-left; j < 8; j++){
						newarray[j] = Integer.MAX_VALUE;
					}

					minindex = left + i + magicBox.eightMin(newarray);
					min = array[minindex];
				}
				else if(array.length - i - left == 8){
					System.arraycopy(array, i+left, newarray, 0, 8);
					minindex = left + i + magicBox.eightMin(newarray);
					min = array[minindex];
				}
				else{
					System.arraycopy(array, i + left, newarray, 0, 8);
					minindex = left + i + magicBox.eightMin(newarray);
					min = array[minindex];
					temp = array[left + i + 7];
					array[left+i+7] = array[minindex];
					array[minindex] = temp;
				}
			}

			int temp2 = array[left];
			array[left] = min;
			array[minindex] = temp2;


		}

	}


}


/**
 * Selection.java, you should SUBMIT this file.
 * Do not modify any variable definition
 */


