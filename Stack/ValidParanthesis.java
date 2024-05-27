package Stack;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        System.out.println(checkParanthesisStack("()"));
        checkParanthesis("(){}[]");
    }

    private static boolean checkParanthesisStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if (stack.isEmpty() ||  stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() ||  stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
   return stack.isEmpty();

    }

    private static boolean checkParanthesis(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    list.add(s.charAt(i));
                    break;
                case '}':
                    if (!list.isEmpty()  && list.get(list.size()-1) == '{') {
                        list.removeLast();
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if (!list.isEmpty() && list.get(list.size()-1) == '(') {
                        list.removeLast();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!list.isEmpty()  && list.get(list.size()-1)  == '[') {
                        list.removeLast();
                    } else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return list.isEmpty();
    }
}


class MinStack {
    Stack<Integer> stack = new Stack();
    Integer min;
    public MinStack() {

    }

    public void push(int val) {
        this.stack.push(val);
        min = Math.min(val,this.min);
    }

    public void pop() {
        this.stack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            min = Math.min(min, integer);
        }
        return min;
    }
}
