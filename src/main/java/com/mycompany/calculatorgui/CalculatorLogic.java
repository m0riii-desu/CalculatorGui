/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculatorgui;

import java.text.DecimalFormat;

/**
 *
 * @author Prime
 */
public class CalculatorLogic {
    DecimalFormat df = new DecimalFormat("0.00");
    private double num1;
    private double result;
    private String operator;

    public void setFirstOperand(double num, String op) {
        this.num1 = num;
        this.operator = op;
    }
    
    public void calculate(double num2) {
        
        if (operator == null) {
            result = num2;
            return;
        }
        
        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0)
                    throw new ArithmeticException(" ");

                result = num1 / num2;
            }
            default -> result = num2;
        }
    }

    public String getFormattedResult() {
        if (result % 1 == 0) {
            return String.valueOf((long) result);
        }
        
        return df.format(result);
    }
}
