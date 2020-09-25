package com.ismkr.small_calculator;

/**
 * @author Islem
 * @date 24 September 2020
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorView extends JFrame implements ActionListener {

	private Controller controller;
	
	private JLabel formulaLabel;
	private JLabel currentNumberLabel;
	
	public CalculatorView(Controller controller) {
		this.controller = controller;
		
		setTitle("Calculator");
		setSize(310, 380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		formulaLabel = new JLabel();
		formulaLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		formulaLabel.setForeground(new Color(105, 105, 105));
		formulaLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		formulaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		formulaLabel.setBounds(0, 5, 290, 25);
		contentPane.add(formulaLabel);
		
		currentNumberLabel = new JLabel("0");
		currentNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		currentNumberLabel.setForeground(new Color(0, 0, 0));
		currentNumberLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 40));
		currentNumberLabel.setBounds(0, 35, 290, 50);
		contentPane.add(currentNumberLabel);
		
		JButton CEButton = new JButton("CE");
		CEButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		CEButton.setBackground(new Color(245, 245, 245));
		CEButton.setBounds(0, 86, 72, 50);
		CEButton.setBorderPainted(false);
		CEButton.addActionListener(this);
		contentPane.add(CEButton);
		
		JButton CButton = new JButton("C");
		CButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		CButton.setBackground(new Color(245, 245, 245));
		CButton.setBounds(74, 86, 72, 50);
		CButton.setBorderPainted(false);
		CButton.addActionListener(this);
		contentPane.add(CButton);
		
		JButton xButton = new JButton("X");
		xButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		xButton.setBackground(new Color(245, 245, 245));
		xButton.setBounds(149, 86, 72, 50);
		xButton.setBorderPainted(false);
		xButton.addActionListener(this);
		contentPane.add(xButton);
		
		JButton divButton = new JButton("/");
		divButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		divButton.setBackground(new Color(245, 245, 245));
		divButton.setBounds(222, 86, 72, 50);
		divButton.setBorderPainted(false);
		divButton.addActionListener(this);
		contentPane.add(divButton);
		
		JButton multiplicationButton = new JButton("*");
		multiplicationButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		multiplicationButton.setBackground(new Color(245, 245, 245));
		multiplicationButton.setBounds(222, 137, 72, 50);
		multiplicationButton.setBorderPainted(false);
		multiplicationButton.addActionListener(this);
		contentPane.add(multiplicationButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		sevenButton.setBackground(new Color(255, 255, 255));
		sevenButton.setBounds(0, 137, 72, 50);
		sevenButton.setBorderPainted(false);
		sevenButton.addActionListener(this);
		contentPane.add(sevenButton);
		
		JButton eightButton = new JButton("8");
		eightButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		eightButton.setBackground(new Color(255, 255, 255));
		eightButton.setBounds(74, 137, 72, 50);
		eightButton.setBorderPainted(false);
		eightButton.addActionListener(this);
		contentPane.add(eightButton);
		
		JButton nineButton = new JButton("9");
		nineButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		nineButton.setBackground(new Color(255, 255, 255));
		nineButton.setBounds(149, 137, 72, 50);
		nineButton.setBorderPainted(false);
		nineButton.addActionListener(this);
		contentPane.add(nineButton);
		
		JButton minusButton = new JButton("-");
		minusButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		minusButton.setBackground(new Color(245, 245, 245));
		minusButton.setBounds(222, 188, 72, 50);
		minusButton.setBorderPainted(false);
		minusButton.addActionListener(this);
		contentPane.add(minusButton);
		
		JButton fourButton = new JButton("4");
		fourButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		fourButton.setBackground(new Color(255, 255, 255));
		fourButton.setBounds(0, 188, 72, 50);
		fourButton.setBorderPainted(false);
		fourButton.addActionListener(this);
		contentPane.add(fourButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		fiveButton.setBackground(new Color(255, 255, 255));
		fiveButton.setBounds(74, 188, 72, 50);
		fiveButton.setBorderPainted(false);
		fiveButton.addActionListener(this);
		contentPane.add(fiveButton);
		
		JButton sixButton = new JButton("6");
		sixButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		sixButton.setBackground(new Color(255, 255, 255));
		sixButton.setBounds(149, 188, 72, 50);
		sixButton.setBorderPainted(false);
		sixButton.addActionListener(this);
		contentPane.add(sixButton);
		
		JButton plusButton = new JButton("+");
		plusButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		plusButton.setBackground(new Color(245, 245, 245));
		plusButton.setBounds(222, 239, 72, 50);
		plusButton.setBorderPainted(false);
		plusButton.addActionListener(this);
		contentPane.add(plusButton);
		
		JButton oneButton = new JButton("1");
		oneButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		oneButton.setBackground(new Color(255, 255, 255));
		oneButton.setBounds(0, 239, 72, 50);
		oneButton.setBorderPainted(false);
		oneButton.addActionListener(this);
		contentPane.add(oneButton);
		
		JButton twoButton = new JButton("2");
		twoButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		twoButton.setBackground(new Color(255, 255, 255));
		twoButton.setBounds(74, 239, 72, 50);
		twoButton.setBorderPainted(false);
		twoButton.addActionListener(this);
		contentPane.add(twoButton);
		
		JButton threeButton = new JButton("3");
		threeButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		threeButton.setBackground(new Color(255, 255, 255));
		threeButton.setBounds(149, 239, 72, 50);
		threeButton.setBorderPainted(false);
		threeButton.addActionListener(this);
		contentPane.add(threeButton);
		
		JButton equalButton = new JButton("=");
		equalButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		equalButton.setBackground(new Color(72, 209, 204));
		equalButton.setBounds(222, 290, 72, 50);
		equalButton.setBorderPainted(false);
		equalButton.addActionListener(this);
		contentPane.add(equalButton);
		
		JButton signButton = new JButton("+/-");
		signButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		signButton.setBackground(new Color(245, 245, 245));
		signButton.setBounds(0, 290, 72, 50);
		signButton.setBorderPainted(false);
		signButton.addActionListener(this);
		contentPane.add(signButton);
		
		JButton zeroButton = new JButton("0");
		zeroButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		zeroButton.setBackground(new Color(255, 255, 255));
		zeroButton.setBounds(74, 290, 72, 50);
		zeroButton.setBorderPainted(false);
		zeroButton.addActionListener(this);
		contentPane.add(zeroButton);
		
		JButton pointButton = new JButton(".");
		pointButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		pointButton.setBackground(new Color(245, 245, 245));
		pointButton.setBounds(149, 290, 72, 50);
		pointButton.setBorderPainted(false);
		pointButton.addActionListener(this);
		contentPane.add(pointButton);
		
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.actionPerformed(((JButton) e.getSource()).getText(), 
									currentNumberLabel.getText(), 
									formulaLabel.getText());
	}

	/**
	 * Updates the UI
	 * @param currentNumber
	 * @param completeFormula
	 */
	public void update(String currentNumber, String completeFormula) {
		this.currentNumberLabel.setText(currentNumber);
		this.formulaLabel.setText(completeFormula);
	}
}
