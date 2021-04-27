package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int Add(String input) {
		input = input.trim();
		if(input.equals("")) {
			return 0;
		}
		if(input.startsWith("//")){
			Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);
            int sum = 0 , val;
            while(matcher.find()){
                val = Integer.parseInt(input.substring(matcher.start(),matcher.end()));
                sum += val;
            }
			return sum;
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
