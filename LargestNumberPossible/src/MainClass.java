import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>(Arrays.asList("54", "546", "548", "60"));

		li.sort((x, y) -> {
			String xy = x + y;
			String yx = y + x;
			return xy.compareTo(yx) > 0 ? -1 : 1;
		});

		String val = "";
		for (String l : li)
			val += l;

		System.out.println(Long.parseLong(val));

	}
}
