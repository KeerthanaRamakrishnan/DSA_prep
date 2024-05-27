package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleAreaOptimised(heights));

    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        int largestRectangleAreaValue = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            if (heightStack.isEmpty()) {
                heightStack.push(heights[i]);
                indexStack.push(i);
                largestRectangleAreaValue = Integer.max(largestRectangleAreaValue, heights[i]);
            } else {
                if (heightStack.peek() <= heights[i]) {
                    heightStack.push(heights[i]);
                    indexStack.push(i);
                } else {
                    int lastElementPopped = indexStack.peek();
                    while (!heightStack.isEmpty() && !indexStack.isEmpty() && heightStack.peek() > heights[i]) {
                        largestRectangleAreaValue = Math.max(heightStack.peek() * (i - indexStack.peek()), largestRectangleAreaValue);
                        lastElementPopped = indexStack.pop();
                        heightStack.pop();
                    }
                    heightStack.push(heights[i]);
                    indexStack.push(lastElementPopped);
                }
            }
        }
        while (!heightStack.isEmpty() && !indexStack.isEmpty()) {
            largestRectangleAreaValue = Math.max(heightStack.peek() * (heights.length - indexStack.peek()), largestRectangleAreaValue);
            indexStack.pop();
            heightStack.pop();
        }
        return largestRectangleAreaValue;
    }
    public static int largestRectangleAreaOptimised(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}
