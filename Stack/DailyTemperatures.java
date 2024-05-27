package Stack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(temperatures));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] warmerDayCount = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = temperatures.length-1; i>=0;i--){
            if(stack.isEmpty()){
                warmerDayCount[i]=0;
                stack.push(i);
            }else if(temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
                warmerDayCount[i]=stack.peek()-i+1;
            }else{
                Integer index = stack.peek();
                int value = 0;
                while(!stack.isEmpty() && temperatures[i]>=temperatures[index]) {
                    value = index - i;
                    index=stack.peek();
                    stack.pop();
                }
                value = stack.isEmpty() ? 0: value;
                warmerDayCount[i]=value;
                stack.push(i);
            }
        }
        return warmerDayCount;
    }
}
