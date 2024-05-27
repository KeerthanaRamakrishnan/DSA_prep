package Stack;


import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[]{"4","3","-"};
        System.out.println(calculate(tokens));
    }

    private static int calculate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens){
            if(token.equals("+")){
                Integer number1 = stack.pop();
                Integer number2 = stack.pop();
                stack.push(number1+number2);
            }else if(token.equals("*")){
                Integer number2 = stack.pop();
                Integer number1 = stack.pop();
                stack.push(number1*number2);
            }else if(token.equals("/")){
                Integer number2 = stack.pop();
                Integer number1 = stack.pop();
                stack.push(number1/number2);
            }else if(token.equals("-")){
                Integer number2 = stack.pop();
                Integer number1 = stack.pop();
                stack.push(number1-number2);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
