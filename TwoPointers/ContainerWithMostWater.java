package TwoPointers;

import java.util.Map;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(calculate(height));
    }

    private static int calculate(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            maxWater = Math.max(maxWater, (Math.min(height[start], height[end])) * (end - start));
            if(height[end] < height[start]){
                end--;
            }else{
                start++;
            }
        }
        return maxWater;
    }
}
