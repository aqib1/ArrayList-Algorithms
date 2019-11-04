import java.util.Arrays;
import java.util.Objects;

public class MainClass {

	// circular rotate
	// 1,2,3,4,5,6,7 => 7,1,2,3,4,5,6
	public static <T> T[] circularRotate(T[] arr) {
		T end = arr[arr.length - 1];
		for (int x = arr.length - 2; x >= 0; x--)
			arr[x + 1] = arr[x];
		arr[0] = end;
		return arr;
	}

	// rotate by d numbers
	@SuppressWarnings("unchecked")
	public static <T> T[] rotate(T ar[], int d, int n) {
		if (Objects.isNull(ar) || ar.length == 0)
			throw new IllegalArgumentException("Array can't be null or empty");
		if (d > n - 1)
			throw new IllegalArgumentException("D > N");
		T[] reverse = (T[]) new Object[n];
		int start = 0;
		int last = ar.length - 1;
		for (int x = 0; x < n; x++) {
			if (d > 0) {
				reverse[last] = ar[x];
				last--;
			} else {
				reverse[start] = ar[x];
				start++;
			}
			d--;
		}
		return reverse;
	}

	// rotate array
	public static <T> T[] rotate(T[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new IllegalArgumentException("Array can't be null or empty");
		int start = 0;
		int last = arr.length - 1;
		while (start < last) {
			T st = arr[start];
			arr[start] = arr[last];
			arr[last] = st;
			start++;
			last--;
		}
		return arr;
	}

	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(circularRotate(arr)));
		System.out.println(Arrays.toString(circularRotate(arr)));
	}
}
