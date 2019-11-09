import java.util.Arrays;

public class ArrayMerger {

	// O(n+m)
	public static int[] arrMerger(int[] arr, int[] arr1) {
		int[] merger = new int[arr.length + arr1.length];
		int xMoveOfArray1 = 0;
		int xMoveOfArray2 = 0;
		int pointer = 0;
		while (xMoveOfArray1 < arr.length || xMoveOfArray2 < arr1.length) {
			int val = 0;
			if (xMoveOfArray1 < arr.length && xMoveOfArray2 < arr1.length) {
				if (arr[xMoveOfArray1] < arr1[xMoveOfArray2]) {
					val = arr[xMoveOfArray1];
					xMoveOfArray1++;
				} else {
					val = arr1[xMoveOfArray2];
					xMoveOfArray2++;
				}
			} else {
				if (xMoveOfArray1 >= arr.length && xMoveOfArray2 < arr1.length) {
					val = arr1[xMoveOfArray2];
					xMoveOfArray2++;
				} else if (xMoveOfArray2 >= arr1.length && xMoveOfArray1 < arr.length) {
					val = arr[xMoveOfArray1];
					xMoveOfArray1++;
				}
			}
			merger[pointer] = val;
			pointer++;
		}
		return merger;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 5, 9, 10, 15, 20 };
		int arr2[] = { 2, 3, 8, 13 };
		System.out.println(Arrays.toString(arrMerger(arr1, arr2)));
	}
}
