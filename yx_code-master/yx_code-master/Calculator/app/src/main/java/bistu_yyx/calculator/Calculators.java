package bistu_yyx.calculator;

import android.util.Log;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class Calculators {
    public static double evaluateExpression(String expression){
        Log.d(expression, "evaluateExpression: ");
        Stack<Double> operandStack = new Stack<Double>();
        Stack<Character> operatorStack = new Stack<Character>();
        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");


        for (String token : tokens) {
            if (token.length() == 0){
                continue;
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/'||operatorStack.peek()=='s'
                        ||operatorStack.peek()=='c'||operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'||operatorStack.peek()=='s'
                        ||operatorStack.peek()=='c'||operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0)=='²'||token.trim().charAt(0)=='³'){
                while (!operatorStack.isEmpty()&&(operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='s'||operatorStack.peek()=='c')){
                    processAnOperatorTwo(operandStack,operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0)=='s'||token.trim().charAt(0)=='c'){
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0)=='√'){
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    if (operatorStack.peek()=='+'||operatorStack.peek()=='-'||operatorStack.peek()=='*'||operatorStack.peek()=='/')
                        processAnOperator(operandStack, operatorStack);
                    else if (operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√'||operatorStack.peek()=='s'||operatorStack.peek()=='c')
                        processAnOperatorTwo(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else {
                operandStack.push(new Double(token));
            }
        }
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek()=='+'||operatorStack.peek()=='-'||operatorStack.peek()=='*'||operatorStack.peek()=='/')
                processAnOperator(operandStack, operatorStack);
            else if (operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√'||operatorStack.peek()=='s'||operatorStack.peek()=='c')
                processAnOperatorTwo(operandStack, operatorStack);
        }
        return operandStack.pop();
    }
    public static void processAnOperator(Stack<Double> operandStack ,Stack<Character> operatorStack){
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        double op2 = operandStack.pop();
        if(op=='+')
            operandStack.push(op2+op1);
        else if (op=='-')
            operandStack.push(op2-op1);
        else if (op=='*')
            operandStack.push(op2*op1);
        else if (op=='/')
            operandStack.push(op2/op1);

    }
    public static void processAnOperatorTwo(Stack<Double> operandStack ,Stack<Character> operatorStack){
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        if (op=='²'){
            operandStack.push(op1*op1);
        }
        else if (op=='³'){
            operandStack.push(op1*op1*op1);
        }
        else if (op=='√'){
            operandStack.push(sqrt(op1));
        }
        else if (op=='s'){
            operandStack.push(Math.sin(op1*Math.PI/180));
        }
        else if (op=='c'){
            operandStack.push(Math.cos(op1*Math.PI/180));
        }
    }
    public static String insertBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'
                    || s.charAt(i) == '³' || s.charAt(i) == '²'||s.charAt(i)=='√'||s.charAt(i)=='s'||s.charAt(i)=='c') {
                result += " " + s.charAt(i) + " ";
            }
            else {
                result += s.charAt(i);
            }
        }
        Log.d(result, "insertBlanks: ");
        return result;
    }
}