/*
 * WarmUp
 *
 * The class where you will implement all of 
 * the warm up methods for project 2. 
 *
 * You MUST SUBMIT this file.
 * Do NOT modify variable & method defintion.
 * TODO: @Kazi Rahma
 * TODO: @12
 * TODO: 14th October 2016
 */


public class WarmUp {
	private MagicBox magicBox = new MagicBox();
	//int counter = 0;
	//int j = 1;
	/**
	 * TODO: min8Min
	 *
	 * returns the minimum element of the given array as determined using 8Min
	 *
	 * @param array - the array of integers being checked
	 * @return min: the value of the least element in array
	 */
	public int min8Min(int[] array){
		int min = 0;
		int minindex = 0;

		//making a copy of the original array
		int[] copyarray = new int[array.length];
		for(int i = 0; i < copyarray.length; i++) {
			copyarray[i] = array[i];
		}

		for(int i = 0; i < array.length - 1; i+=7) {

			int[] newarray = new int[8]; //make a new array of size 8 to be passed to the 8-min function

			//if the length of the remaining array to be check is less than 8 then get inside this
			if((copyarray.length - (i)) < 8 ) {
				System.arraycopy(copyarray, i, newarray, 0, (copyarray.length - (i)));
				for(int j = (copyarray.length - (i)); j < 8; j++){
					newarray[j] = Integer.MAX_VALUE;
				}
				minindex = magicBox.eightMin(newarray);
				min = newarray[minindex];
			}
			else {
				System.arraycopy(copyarray, i, newarray, 0, 8);//taking 8 elements at a time
				minindex = magicBox.eightMin(newarray); //getting the index of the minimum of 8 elements
				min = newarray[minindex]; //getting the minimum element
				copyarray[i + 7] = newarray[minindex]; //replacing the i+7th element with the minimum

			}
		}
		return min;
	}




	/**
	 * TODO: isSorted8Sort
	 *
	 * checks if the given array is sorted in increasing order using the 8-Sort Magic Box
	 *
	 * @param array - the array of integers being checked
	 * @return: true if sorted, false otherwise
	 */
	public boolean isSorted8Sort(int[] array){

		//copy the original array to work with it
		int[] copyarray = new int[array.length];
		for(int i = 0; i < copyarray.length; i++) {
			copyarray[i] = array[i];
		}

		for(int i = 0; i < copyarray.length - 1; i+=7) {

			int[] newarray = new int[8];

			//if the remaining elements to check is less than 8 than pad it with MAX_VALUE
			if(copyarray.length - i < 8) { //cheanged 1 to i

				System.arraycopy(copyarray, i, newarray, 0, copyarray.length-i);
				for(int j = copyarray.length-i; j < 8; j++){
					newarray[j] = Integer.MAX_VALUE;
				}

			}
			else{

				System.arraycopy(copyarray,i, newarray,0, 8);
			}

			int[] rank = new int[8];
			rank = magicBox.eightSort(newarray); //geting the rank of the elements in the array

			for(int k = 0; k < 7; k++) {
				if(rank[k+1] - rank[k] == 1){ //checking the indices returned by the 8-sort Magic box
					continue;
				}
				else{
					return false;
				}
			}

		}

		return true; //i wrote return true
	}

	/**
	 * TODO: isSorted8Min
	 *
	 * checks if the given array is sorted in increasing order using the 8-Min Magic Box
	 *
	 * @param array - the array of integers being checked
	 * @return: true if sorted, false otherwise
	 */
	public boolean isSorted8Min(int[] array){
		int minindex;
		int[] copyarray = new int[array.length];
		for(int i = 0; i < copyarray.length; i++) {
			copyarray[i] = array[i]; //copying the original array
		}

		int[] newarray = new int[8];

		int i = 0;
		while (i < copyarray.length - 1) {

			if(copyarray.length - i < 8) {
				System.arraycopy(copyarray, i, newarray, 0, copyarray.length-i);
				for(int j = copyarray.length-i; j < 8; j++) {
					newarray[j] = Integer.MAX_VALUE;
				}
			}
			else{
				System.arraycopy(copyarray, i, newarray,0, 8);

			}
			minindex = magicBox.eightMin(newarray);
			if(minindex != 0){
				return false;
			}
			i++;
		}
		return true; //I wrote return true
	}

	private void printarray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.printf("%d ", array[i]);
		}
		System.out.println();
	}


}
