package algorithmProject;
import java.util.ArrayList;

class MergeSort
{
	void merge(ArrayList<Double> arr, int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;
		int n3;
		int n4;

		/* Create temp arrays */
		ArrayList<Double> L = new ArrayList<Double> (n1);
		ArrayList<Double> R = new ArrayList<Double> (n2);

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i) {
			n3 = l + i;
			L.add(arr.get(n3));
		}
		for (int j = 0; j < n2; ++j) {
			n4 = m + 1 + j;
			R.add(arr.get(n4));
		}
		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L.get(i) <= R.get(j)) {
				arr.set(k, L.get(i));
				i++;
			}
			else {
				arr.set(k, R.get(j));
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr.set(k, L.get(i));
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr.set(k, R.get(j));
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(ArrayList<Double> arr, int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(ArrayList<Double> arr)
	{
		int n = arr.size();
		for (int i = 0; i < n; ++i)
			System.out.print(arr.get(i) + " ");
		System.out.println();
	}

	// Driver code
	public static ArrayList<String> sortedArray(ArrayList<String> array)
	{
		ArrayList<Double> arr = new ArrayList<Double>();
		
		ArrayList<String> returnArray = new ArrayList<String>();
		
		for(int i = 0; i< array.size(); i++){
			arr.add(Double.parseDouble(array.get(i)));
		}

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.size() - 1);

		System.out.println("\nSorted array");
		printArray(arr);
		
		for (double j: arr)
			returnArray.add(Double.toString(j));
		return returnArray;
	}
}
