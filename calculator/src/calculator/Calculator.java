package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int Add(String input) {
		input = input.trim();
		if(input.equals("")) {
			return 0;
		}
		
		Pattern negPattern = Pattern.compile("-[1-9][0-9]*");
		Matcher negMatcher = negPattern.matcher(input);
		
		if(negMatcher.find()) {
			StringBuffer exception = new StringBuffer();
			exception.append("negatives not allowed: ");
			exception.append(input.substring(negMatcher.start(),negMatcher.end())+" ");
			while(negMatcher.find()) {
				exception.append(input.substring(negMatcher.start(),negMatcher.end())+" ");
			}
			exception.deleteCharAt(exception.length()-1);
			throw new ArithmeticException(exception+"");
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
