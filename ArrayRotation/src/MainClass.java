import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.IntStream;

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

	// O(n)
	public static int findValue(int[] ar, int val) {
		if (Objects.isNull(ar) || ar.length == 0)
			throw new IllegalArgumentException("Array is empty");
		int value;
		if ((value = IntStream.of(ar).filter(x -> x == val).findAny().orElse(-1)) == -1)
			throw new RuntimeException("Value =" + val + " not found");
		else
			return value;
	}

	// if array is sorted => n log(n)
	// then solution can be log(n)
	public static int _findValue(int[] ar, int val) {
		if (Objects.isNull(ar) || ar.length == 0)
			throw new IllegalArgumentException("Array is empty");
		Arrays.sort(ar);
		if (Objects.isNull(ar) || ar.length == 0)
			throw new IllegalArgumentException("Array is empty");
		int mid = ar.length / 2;
		while (mid >= 0) {
			if (val == ar[mid])
				return val;
			if (val < ar[mid])
				--mid;
			else
				++mid;
		}
		return -1;
	}

	// nlog(n) -> K largest element
	public static int kLargestElementFromArray(int[] arr, int k) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new IllegalArgumentException("Array is empty");
		Arrays.sort(arr);
		return arr[arr.length - k];
	}

	// o(n * n) -> K largest element
	public static int kLargestElementUsingTreeMap(int[] arr, int k) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new IllegalArgumentException("Array is empty");
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int x = 0; x < arr.length; x++) {
			map.put(arr[x], x);
		}
		Entry<Integer, Integer> entry = map.entrySet().stream().filter(x -> x.getValue() == (arr.length - k)).findAny()
				.orElse(null);
		return entry.getKey();
	}

	// pythagorean triplet a^2 + b^2 = c^2
	public static boolean pythagoreanTriplet(int arr[]) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new IllegalArgumentException("Array is empty");
		Arrays.sort(arr);
		int min, max;
		int pointer = arr.length - 1;
		for (int x = arr.length - 2; x >= 0; --x) {
			min = 0;
			max = x;
			while (min < max) {
				double sumCores = Math.pow(arr[min], 2) + Math.pow(arr[max], 2);
				double pointerSqr = Math.pow(arr[pointer], 2);
				if (pointerSqr == sumCores)
					return true;
				if (sumCores < pointerSqr)
					min++;
				else
					max--;
			}
			--pointer;
		}
		return false;
	}

	// rotate array 90 degree
	public static int[][] rotateAMatrixBy90(int[][] arr) {
		int max = arr.length - 1;
		int[][] rotate = new int[arr.length][arr.length];
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				rotate[x][y] = arr[y][max];
			}
			max--;
		}
		return rotate;
	}

	// One directional Subarry
	public static int[] oneDirSubArrBySum(int[] arr, int sum) {
		for (int x = 0; x < arr.length; x++) {
			Supplier<IntStream> turncate;
			final int efctivX = x;
			if ((turncate = () -> IntStream.of(arr).limit(efctivX)).get().sum() == sum) {
				return turncate.get().toArray();
			}
		}
		return null;
	}

	// sub-array by sum
	public static int[] subArrBySum(int[] arr, int sum) {
		int[] index = new int[2];
		for (int outer = 0; outer < arr.length; outer++) {
			int collect = arr[outer];
			index[0] = outer;
			for (int inner = outer + 1; inner < arr.length; inner++) {
				collect += arr[inner];
				if (sum == collect) {
					index[1] = inner;
					return index;
				}
				if (collect > sum)
					break;
			}
		}
		return null;
	}

	// count the triplets
	public static int countTheTripplets(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new IllegalArgumentException("Array is empty");
		int count = 0;
		if (arr.length == 2)
			return count;
		Arrays.sort(arr);
		for (int x = 0; x < arr.length - 2; x++) {
			int first = arr[x];
			int second = arr[x + 1];
			for (int y = x + 2; y < arr.length; y++) {
				int sum;
				if ((sum = first + second) == arr[y]) {
					count++;
				}
				if (sum > arr[y])
					break;
			}
		}

		return count;
	}

	// get maximum sum of continous array
	public static int getMaxSumOfContinousSubArr(int[] arr) {
		int currentCal = 0;
		int lastMaxVal = Integer.MIN_VALUE;
		for (int x = 0; x < arr.length; x++) {
			currentCal += arr[x];
			if (currentCal > lastMaxVal) {
				lastMaxVal = currentCal;
			}
			if (currentCal < 0)
				currentCal = 0;
		}
		return lastMaxVal;
	}

	// missing element in sorted array using recursion
	public static void missingElementInSortedArray(int[] arr) {
		ArrayList<Integer> li = new ArrayList<>();
		findMissingUsingRecurrsion(arr, li);
	}

	private static void findMissingUsingRecurrsion(int[] arr, ArrayList<Integer> li) {
		int medium = arr.length / 2;
		if (medium == 0) {
			if (li.size() == 0) {
				li.add(arr[medium]);
			} else {
				if (arr[medium] - li.get(li.size() - 1) == 1) {
					li.add(arr[medium]);
				} else {
					li.add(arr[medium] - 1);
					li.add(arr[medium]);
					System.out.println((arr[medium] - 1) + " missing");
					return;
				}
			}
			return;
		}
		findMissingUsingRecurrsion(Arrays.copyOfRange(arr, 0, medium), li);
		findMissingUsingRecurrsion(Arrays.copyOfRange(arr, medium, arr.length), li);
	}

	// find missing element
	public static int findMissingElement(int[] arr) {
		int missing = -111111;
		Arrays.sort(arr);
		for (int x = 1; x < arr.length; x++) {
			if (arr[x - 1] + 1 != arr[x]) {
				return arr[x - 1] + 1;
			}
		}
		return missing;
	}

	// without sorting
	public static long findMissingElementWithoutSort(int[] arr) {
		Supplier<IntStream> supplier = () -> IntStream.of(arr);
		int minVal = supplier.get().min().orElse(Integer.MIN_VALUE);
		int maxVal = supplier.get().max().orElse(Integer.MAX_VALUE);
		return IntStream.range(minVal, maxVal + 1).sum() - supplier.get().sum();
	}

	public static void main(String[] args) {
		int arr[] = { 5, 3, 1, 2 };
		System.out.println(findMissingElementWithoutSort(arr));
//		System.out.println(countTheTripplets(arr));
//		int arr[] = { 3, 1, 4, 6, 5 };
//		System.out.println(Arrays.toString(subArrBySum(arr, 15)));
//		int arr[][] = { { 2, 3, 1 }, { 5, 6, 2 }, { 7, 8, 9 } };
//		System.out.println(Arrays.deepToString(rotateAMatrixBy90(arr)));
//		System.out.println(pythagoreanTriplet(arr));
//		System.out.println(findValue(arr, 3));
//		System.out.println(_findValue(arr, 3));
//		System.out.println(Arrays.toString(circularRotate(arr)));
//		System.out.println(Arrays.toString(circularRotate(arr)));
	}
}
