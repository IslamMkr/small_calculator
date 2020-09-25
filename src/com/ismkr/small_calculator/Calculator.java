package com.ismkr.small_calculator;

/**
 * @author Islem
 * @date 24 September 2020
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
	
	private final String[] ARITHMETIC_OPERATORS = new String[] {
			"+", "-", "/", "*"
	};
	
	private Controller controller;

	public Calculator(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Performs a certain logic depending on the values passed
	 * @param action
	 * @param currentNumber
	 * @param completeFormula
	 */
	public void actionPerformed(String action, String currentNumber, String completeFormula) {
		if (Character.isDigit(action.charAt(0))) {
			if (currentNumber.equals("0")) controller.update(action, completeFormula);
			else controller.update(currentNumber + action, completeFormula);
		} else if(isArithmetic(action)) {
			if(!currentNumber.contentEquals("0")) {
				String number = "";
				if(currentNumber.charAt(currentNumber.length() - 1) == '.') number = currentNumber.substring(0, currentNumber.length() - 1);
				else number = currentNumber;

				if(currentNumber.charAt(0) == '-') controller.update("0", completeFormula + " (" + number + ") " + action);
				else controller.update("0", completeFormula + " " + number + " " + action);
			} else {
				completeFormula = completeFormula.substring(0, completeFormula.length() - 1) + action;
				controller.update(currentNumber, completeFormula);
			}
		} else if(action.contentEquals("C")) {
			controller.update("0", completeFormula);
		} else if(action.contentEquals("CE")) {
			controller.update("0", "");
		} else if(action.contentEquals("X")) {
			String number = currentNumber.substring(0, currentNumber.length() - 1);
			if(number.isBlank()) {
				controller.update("0", completeFormula);
			} else {
				controller.update(number, completeFormula);
			}
		} else if(action.contentEquals("+/-")) {
			if(!currentNumber.contentEquals("0")) {
				if(currentNumber.charAt(0) != '-') {
					controller.update("-" + currentNumber, completeFormula);
				} else {
					controller.update(currentNumber.substring(1, currentNumber.length()), completeFormula);
				}
			}
		} else if(action.contentEquals(".")) {
			if(!currentNumber.contains(".")) {
				controller.update(currentNumber + ".", completeFormula);
			}
		} else {
			String number = "";
			
			if(completeFormula.isEmpty()) controller.update(currentNumber, completeFormula);
			
			if(currentNumber.charAt(currentNumber.length() - 1) == '.') number = currentNumber.substring(0, currentNumber.length() - 1);
			else number = currentNumber;
			
			String formula = (currentNumber.charAt(0) == '-') ? completeFormula + " (" + number + ")" : completeFormula + " " + number;
			
			String result = multiDivCalculator(formula);

			controller.update(result, "");
		}
	}
	
	/**
	 * Calculate the multiplications and divisions first then pass the results
	 * to calculate method that return the final result
	 * @param formula
	 * @return
	 */
	private String multiDivCalculator(String formula) {
		ArrayList<String> parts = new ArrayList<>(Arrays.asList(formula.split(" ")));
		if(parts.get(0).isBlank()) parts.remove(0);
		
		int index;
		
		while ((index = getFirstIndex(parts)) != -1) {
			String numberOne = parts.get(index - 1);
			numberOne = (numberOne.contains("(")) ? numberOne.substring(1, numberOne.length() - 1) : numberOne;
			String numberTwo = parts.get(index + 1);
			numberTwo = (numberTwo.contains("(")) ? numberTwo.substring(1, numberTwo.length() - 1) : numberTwo;
			
			if (parts.get(index).contentEquals("*")) {
				String result = "" + (Double.parseDouble(numberOne) * Double.parseDouble(numberTwo));
				parts.set(index, result);
			} else {
				String result = "" + (Double.parseDouble(numberOne) / Double.parseDouble(numberTwo));
				parts.set(index, result);
			}
			
			parts.remove(index - 1);
			parts.remove(index);
		}
		
		return calculate(parts);
	}
	
	
	/**
	 * TODO: CALCULATE THE FINAL RESULT
	 * @param formula
	 * @return
	 */
	private String calculate(ArrayList<String> parts) {
		String sign = "";
		double result = 0;
		
		for(String part : parts) {
			if(isArithmetic(part)) {
				sign = part;
			} else {
				String number = "";
				
				if (part.contains("(")) number = part.substring(1, part.length() - 1);
				else number = part;
				
				if(sign.isEmpty()) result += Double.parseDouble(number);
				else if(sign.contentEquals("+")) result += Double.parseDouble(number);
				else result -= Double.parseDouble(number);
			}
		}
		
		if(result - ((int) result) == 0.0) 
			return "" + ((int) result);
		
		return "" + result;
	}

	/**
	 * Return true is the action string is an arithmetic operator
	 * @param action
	 * @return
	 */
	private boolean isArithmetic(String action) {
		for(int i=0; i < ARITHMETIC_OPERATORS.length; i++) 
			if(ARITHMETIC_OPERATORS[i].contentEquals(action))
				return true;
		
		return false;
	}
	
	
	/**
	 * Return the first index of * or / in an ArrayList
	 * @param parts
	 * @return
	 */
	private int getFirstIndex(ArrayList<String> parts) {
		for(int i=0; i < parts.size(); i++) 
			if(parts.get(i).contentEquals("*") || parts.get(i).contentEquals("/"))
				return i;
		return -1;
	}
	
}
