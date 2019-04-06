/**
 * 
 */
package group3.finalproj.util;

import java.util.*;

/**
 * @author Andrew Hum
 *
 */

// Initial code taken from Princeton's algs4 website, edited and adjusted to fit our project.
public class Heap {

	// This class should not be instantiated.
	private Heap() {}

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param pq the array to be sorted
	 */
	public static void sort(ArrayList<String> pq) {
		int n = pq.size();
		for (int k = n / 2; k >= 1; k--)
			sink(pq, k, n);
		while (n > 1) {
			exch(pq, 1, n--);
			sink(pq, 1, n);
		}
	}

	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private static void sink(ArrayList<String> pq, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(pq, j, j + 1))
				j++;
			if (!less(pq, k, j))
				break;
			exch(pq, k, j);
			k = j;
		}
	}

	/***************************************************************************
	 * Helper functions for comparisons and swaps. Indices are "off-by-one" to
	 * support 1-based indexing.
	 ***************************************************************************/
	private static boolean less(ArrayList<String> pq, int i, int j) {
		return pq.get(i-1).compareTo(pq.get(j-1)) < 0;
	}

	private static void exch(ArrayList<String> pq, int i, int j) {
		String swap = pq.get(i - 1);
		pq.set(i - 1, pq.get(j - 1));
		pq.set(j - 1, swap);
	}

	// print array to standard output
	private static void show(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

	/**
	 * Reads in a sequence of strings from standard input; heapsorts them; and
	 * prints them to standard output in ascending order.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		a.add("6");
		a.add("3");
		a.add("11");
		Heap.sort(a);
		show(a);
	}
}
