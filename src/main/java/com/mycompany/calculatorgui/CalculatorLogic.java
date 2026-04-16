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
class Addition extends MathOperations {
    @Override
    public double execute(double n1, double n2) { return n1 + n2; }
}

class Subtraction extends MathOperations {
    @Override
    public double execute(double n1, double n2) { return n1 - n2; }
}

class Multiplication extends MathOperations {
    @Override
    public double execute(double n1, double n2) { return n1 * n2; }
}

class Division extends MathOperations {
    @Override
    public double execute(double n1, double n2) {
        if (n2 == 0) throw new ArithmeticException();
        return n1 / n2;
    }
}

public class CalculatorLogic {
    DecimalFormat df = new DecimalFormat("0.00");
    private double num1;
    private MathOperations currentOp;
    private double result;
    
    public void setFirstOperand(double val, String opType) {
        this.num1 = val;
        
        // This links the String from the button to the actual Class logic
        this.currentOp = switch (opType) {
            case "+" -> new Addition();
            case "-" -> new Subtraction();
            case "*" -> new Multiplication();
            case "/" -> new Division();
            default -> null;
        };
    }
    
    public void calculate(double num2) {
        if (currentOp != null) {
            result = currentOp.execute(num1, num2);
        } else{
            result = num2;
        }
    }

    public String getFormattedResult() {
        if (result % 1 == 0) {
            return String.valueOf((long) result);
        }
        
        return df.format(result);
    }
}
