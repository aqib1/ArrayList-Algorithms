import java.util.Objects;
import java.util.stream.IntStream;

public class MainClass {
	// O(n)^2
	public static int equilibriumOn2(int[] arr) {
		int start = 0, end = arr.length - 1, leftSum = 0, rightSum = 0;
		int pointer = 1;
		while (pointer < end - 1) {
			leftSum = IntStream.range(start, pointer).map(x -> arr[x]).sum();
			rightSum = IntStream.range(pointer + 1, end + 1).map(x -> arr[x]).sum();
			if (leftSum == rightSum)
				return arr[pointer];
			pointer++;
		}

		return -1;
	}

	// O(n)
	public static int equilibrium(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0) {
			throw new IllegalArgumentException("Array can't be null or empty");
		}
		int countLeft = arr[0], countRight = arr[arr.length - 1];
		int left = 1;
		int right = arr.length - 2;
		while (left < right) {
			if (countLeft == countRight) {
				countLeft += arr[left];
				countRight += arr[right];
				++left;
				--right;
			}
			if (countLeft < countRight) {
				countLeft += arr[left];
				++left;
			} else if (countLeft > countRight) {
				countRight += arr[right];
				--right;
			}
		}
		if (countLeft == countRight) {
			return arr[left];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 4, 6, 2, 2, 2 };
		System.out.println(equilibriumOn2(arr));
	}
}
