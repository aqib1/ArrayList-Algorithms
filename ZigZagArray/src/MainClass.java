import java.util.Arrays;

public class MainClass {

	public static int[] zigZag(int[] arr) {
		// a < b > c < d > e
		// sort array, then swap 1 to 2, and 3 to 4 and so on
		Arrays.sort(arr);
		for (int x = 1; x < arr.length- 1; x += 2) {
			arr[x] = arr[x] + arr[x + 1];
			arr[x + 1] = arr[x] - arr[x + 1];
			arr[x] = arr[x] - arr[x + 1];
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = {4, 3, 7, 8, 6, 2, 1};
		System.out.println(Arrays.toString(zigZag(arr)));
	}

}
