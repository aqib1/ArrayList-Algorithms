import java.util.Arrays;

public class MainClass {

	// o(nlogn + mlogn) time complexity
	// sort y array
	// find the count for 0,1,2,3,4
	// if x < y then x^y > y^x with some exceptions
	// with some exceptions
	// if value of x=0 then count +=0
	// if value of x=1 then count no of zeros in y
	// count += no of zeros and no of 1 from y
	// if x = 2 then - (no's of 3 + no's of 4 from x)
	// if x = 3 then + (no's of 2 from y)

	public static int countFirstArrayPowerAginstSecond(int x[], int y[]) {
		// sort array y
		int count = 0;
		Arrays.sort(y);
		int[] count1To4 = count1To4InArray(y);
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 0) {
				count += 0;
			} else if (x[i] == 1)
				count += count1To4[0];
			else {
				int idx = Arrays.binarySearch(y, x[i]);
				if (idx < 0) {
					int v = (Math.abs(idx + 1));
					if (v <= y.length - 1)
						count += (y.length - v);
				} else {
					if (idx < y.length - 1)
						count += y.length - (idx + 1);
				}
				// increase no of pairs for 0 and 1 -> y
				// if x=2 then decrease number of pairs - sum for 3 and 4
				// if x=3 then increase no of pairs for y = 2
				count += (count1To4[0] + count1To4[1]);

				if (x[i] == 2)
					count -= (count1To4[3] + count1To4[4]);

				if (x[i] == 3)
					count += count1To4[2];
			}
		}
		return count;
	}

	private static int[] count1To4InArray(int[] y) {
		// count value against the index -> 0-> count of 0
		// index -> 1 -> count of 1
		// index -> 2 -> count of 2
		// index -> 3 -> count 0f 3
		// index -> 4 -> count of 4
		int[] count = new int[5];
		for (int x = 0; x < y.length; x++) {
			if (y[x] < 5) {
				count[y[x]]++;
			}
		}
		return count;
	}

	// O(n)2
	public static int countFirstArryPoweAginstSecond(int arr1[], int arr2[]) {
		int count = 0;
		for (int c = 0; c < arr1.length; c++) {
			for (int b = 0; b < arr2.length; b++) {
				if (Math.pow(arr1[c], arr2[b]) > Math.pow(arr2[b], arr1[c])) {
					count++;
				}
			}
		}
		return count;
	}

	public static int inversionOfArray(int[] y) {
		int count = 0;
		for (int x = 0; x < y.length - 1; x++) {
			for (int z = x + 1; z < y.length; z++) {
				if (y[x] > y[z]) {
					int small = y[z];
					y[z] = y[x];
					y[x] = small;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 3, 5 };
		System.out.println(inversionOfArray(arr));

//		int[] arr1 = { 2, 1, 6 };
//		int[] arr2 = { 1, 5 };
//		System.out.println(Arrays.binarySearch(arr2, 6));
//		System.out.println(countFirstArrayPowerAginstSecond(arr1, arr2));
	}
}
