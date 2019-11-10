import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class MainClass {

	public int[] subArrIndexBySum(int[] arr, int k) {
		Supplier<IntStream> sup = () -> IntStream.of(arr);
		for (int x = 0; x < arr.length; x++) {
			int effectiveX = x;
			if (sup.get().limit(effectiveX).sum() == k) {
				return sup.get().toArray();
			}
		}
		return null;
	}

	public static int[] subArrayIndexBySumSort(int[] arr, int k) {
		int[] index = new int[2];
		int count = 0;
		for (int x = 0; x < arr.length - 1; x++) {
			count = arr[x];
			index[0] = x;
			if (count > k)
				continue;
			for (int y = (x + 1); y < arr.length; y++) {
				count += arr[y];
				if (count == k) {
					index[1] = y;
					return index;
				}
				if (count > k)
					break;
			}
		}

		return index;
	}

	public static int countTripllets(int[] arr) {
		int count = 0;
		Arrays.sort(arr);
		for (int x = 0; x < arr.length - 2; x++) {
			int n1 = arr[x];
			int n2 = arr[x + 1];
			for (int y = x + 2; y < arr.length; y++) {
				int sum = n1 + n2;
				if(sum < arr[y]) break;
				if(sum > arr[y]) continue;
				if(sum == arr[y]) count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = {1,5,3,2};
		System.out.println(countTripllets(arr));
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		System.out.println(Arrays.toString(subArrayIndexBySumSort(arr, 15)));
	}
}
