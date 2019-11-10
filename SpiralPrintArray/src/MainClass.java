import java.util.Objects;

public class MainClass {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printSpiral(arr, 3, 3);

	}

	private static void printSpiral(int[][] arr, int N, int M) {
		if (Objects.isNull(arr) || arr.length == 0) {
			throw new IllegalArgumentException("Array is empty of null!!");
		}

		int limit = N * M;
		int rowIncrement = 0;
		int colIncrement = 1;
		int row = 0, col = 0;
		for (int x = 0; x < limit; x++) {
			System.out.print(arr[row][col] + " ");
			arr[row][col] = Integer.MIN_VALUE;
			int rlimit = row + rowIncrement;
			int climit = col + colIncrement;
			if (rlimit >= N || climit >= M || rlimit < 0 || climit < 0 || arr[rlimit][climit] == Integer.MIN_VALUE) {
				int temp = rowIncrement;
				rowIncrement = colIncrement;
				colIncrement = -temp;
			}

			row += rowIncrement;
			col += colIncrement;
		}

	}

}
