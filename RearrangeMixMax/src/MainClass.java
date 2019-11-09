import java.util.Arrays;
import java.util.Objects;

public class MainClass {
	public static int[] re_arr(int[] arr) {
		if(Objects.isNull(arr) || arr.length == 0) {
			throw new IllegalArgumentException("Array can't be null or empty");
		}
//		Arrays.sort(arr); if not sorted
		int []re_arr = new int [arr.length];
		int max = arr.length-1 ,min = 0;
		int pointer = 0;
		while (min < max) {
			re_arr[pointer++] = arr[max];
			re_arr[pointer++] = arr[min];
			min++; max--;
		}

		return re_arr;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(re_arr(arr)));
	}
}
