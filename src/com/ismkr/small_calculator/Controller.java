package com.ismkr.small_calculator;

/**
 * @author Islem
 * @date 24 September 2020
 */

import java.awt.EventQueue;

public class Controller {

	private static CalculatorView calculatorView;
	
	private Calculator calculator;
	
	public Controller() {
		calculatorView = new CalculatorView(this);
		calculator = new Calculator(this);
	}

	/**
	 * Passing parameters to the  @{Calculator} when a button is clicked
	 * @param action
	 * @param currentNumber
	 * @param completeFormula
	 */
	public void actionPerformed(String action, String currentNumber, String completeFormula) {
		calculator.actionPerformed(action, currentNumber, completeFormula);
	}


	/**
	 * Updating the @{CalculatorView} with the new values calculated by the @{Calculator}
	 * @param currentNumber
	 * @param completeFormula
	 */
	public void update(String currentNumber, String completeFormula) {
		calculatorView.update(currentNumber, completeFormula);
	}
	
	
	
	/**
	 * The main method
	 * @param args
	 */

	public static void main(String[] args) {
		new Controller();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculatorView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
