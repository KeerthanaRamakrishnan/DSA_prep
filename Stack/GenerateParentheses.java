package Stack;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        int count = 4;
        System.out.println(generateParenthesis(count));//not working
        generateParenthesisWorking(4);
    }

    public static void generateParenthesisWorking(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        System.out.println(list);
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    private static List<String> generateParenthesis(int count) {
        Set<String> set = new HashSet<>();
        set.add("()");
        for(int i=1;i< count;i++){
            Set<String> tempSet = new HashSet<>();
            for (String value : set) {
                tempSet.add("("+value+")");
                tempSet.add("()"+value);
                tempSet.add(value+"()");
                String[] splilts = value.split("\\(\\)");
                for(int j=1;j< splilts.length;j++){

                }
            }
            if(i == 3){
                tempSet.add("(())(())");
            }
            set= tempSet;
        }
        return new LinkedList<>(set);
    }
}

//["()(())()()","(((()))())","((()(())))","()()(()())","(()(()))()","()(()()())","(()(()()))",
// "()((()))()","()((()()))","(()()()())","(((()())))","()()()()()","((()())())","(())()()()",
// "()(()())()","(()(())())","()(()(()))","(((())))()","(((())()))","()(((())))","(()((())))","()()(())()","()()((()))",
// "((()))()()","((())()())","((((()))))","((()()()))","(()()())()","(()()(()))","()((())())","((()()))()","((())())()","()()()(())","(()())()()"]


//["((())(()))","((()))(())","(()())(())","(())((()))","(())(()())","(())(())()", "(())()(())","()(())(())"]

//["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]

//[()()()(), (()())(), (()(())), ()()(()), (((()))), (())()(), ()((())), ()(())(), ()(()()), (()()()), ((()())), ((()))(), ((())())]

//["(())(())"]
//["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]