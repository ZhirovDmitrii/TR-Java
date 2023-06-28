package telran.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.function.Function;

public interface InputOutput {
//	===== abstract methods =====
	
	String inputString(String prompt);	// will take a string
	void output(Object obj);	// will send information
	
	
//	===== default methods =====
	
	// take object and get String
	default void outputLine(Object obj){
		output(obj.toString());
	}
	
	/*
	 * 1. tell to user the information which need to enter
	 * 2. if anything wrong - throw exception with the message
	 * 3. give the function for validation
	 */
	default <R> R inputObject(String prompt, String errorPrompt, Function<String, R> mapper) {
		while(true) {
			String text = inputString(prompt);
			if(text == null) {
				return null;
			}
			
			R res = mapper.apply(text);
			if(res != null) {
				return res;
			} else {
				// error message
				outputLine(errorPrompt);
			}
		}
	}
	
	// check that the input number is an integer
	default Integer inputInteger(String prompt) {
		return inputObject(prompt, "It's not integer number", s ->
		{
			try {
				Integer res = Integer.parseInt(s);
				return res;
			} catch (NumberFormatException e) {
				return null;
			}
		});
	}
	
	// if item number less or greater (in menu)
	default Integer inputInteger(String prompt, Integer min, Integer max) {
		return inputObject(prompt, 
				String.format("It's not integer number in range [%d-%d]", min, max), s ->
		{
			try {
				Integer res = Integer.parseInt(s);
				return res >= min && res <= max ? res : null;
			} catch (Exception e) {
				return null;
			}
		});
	}
	
	// check operators -+*/
	default String inputString(String prompt, List<String> options) {
		return inputObject(prompt, "String is not in option", s -> options.contains(s) ? s : null);
	}
	
//	===== HOMEWORK =====
	
	// check that the input number is a double
	default Double inputDouble(String prompt) {
		return inputObject(prompt, "It's not double number", s -> {
			try {
				Double res = Double.parseDouble(s);
				return res;
			} catch (NumberFormatException e) {
				return null;
			}
		});
	}
	
	// check that the input number is a long
	default Long inputLong(String prompt) {
		return inputObject(prompt, "It's not long number", s ->{
			try {
				Long res = Long.parseLong(s);
				return res;
			} catch (NumberFormatException e) {
				return null;
			}
		});
	}
	
	default LocalDate inputDate(String prompt, String format) {
		return inputObject(prompt, "It's not date", s -> {
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
				return LocalDate.parse(s,dtf);
			} catch (DateTimeParseException e) {
				return null;
			}
		});
	}
}
