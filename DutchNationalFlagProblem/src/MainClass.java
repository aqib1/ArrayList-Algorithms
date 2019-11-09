import java.util.Arrays;

public class MainClass {
	public static int[] dutchNationalFlagProblem(int[] arr) {
		int min = 0, medium = 0, max = arr.length - 1;
		while (medium <= max) {
			switch (arr[medium]) {
			case 0:
				arr[min] = arr[min] + arr[medium];
				arr[medium] = arr[min] - arr[medium];
				arr[min] = arr[min] - arr[medium];
				++min;
				++medium;
				break;
			case 1:
				medium++;
				break;
			case 2:
				arr[medium] = arr[medium] + arr[max];
				arr[max] = arr[medium] - arr[max];
				arr[medium] = arr[medium] - arr[max];
				max--;
				break;
			default:
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 2, 1, 2, 0, 0, 1, 1, 2, 2, 0 };
//		   a = a + b;
//		   b = a - b;
//		   a = a - b;
		System.out.println(Arrays.toString(dutchNationalFlagProblem(arr)));
	}
}
