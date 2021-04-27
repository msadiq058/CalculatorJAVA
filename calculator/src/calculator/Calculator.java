package calculator;

public class Calculator {
	public static int Add(String input) {
		if(input.equals("")) {
			return 0;
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
		//return -1;
	}
}
