package calculator;

public class Calculator {
	public static int Add(String input) {
		input = input.trim();
		if(input.equals("")) {
			return 0;
		}
		if(input.contains("\n")) {
			input = input.replaceAll("\n", ",");
		}
		if(input.contains(",")) {
			String[] values = input.split(",");
			int sum = 0;
			for(String i:values) {
				sum += Integer.parseInt(i);
			}
			return sum;
		}
		return Integer.parseInt(input);
	}
}
