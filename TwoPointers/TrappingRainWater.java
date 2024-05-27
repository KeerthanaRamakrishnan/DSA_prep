package TwoPointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height= new int[]{0,1,0,2,1,0,1,3,2,1,2,1}; //ans = 6
//        int height[]= new int[]{4,2,0,3,2,5}; //ans = 9
//        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}; //ans = 19
        System.out.println(trap(height));
        //((())), (())(),()(()),()()(),(()())
        }


//    private static int trap(int[] height) {
//        int start = 0;
//        int count = 0;
//        int[] prefixSum = new int[height.length];
//        prefixSum[0] = height[0];
//        for (int i = 1; i < height.length; i++) {
//            prefixSum[i] = prefixSum[i - 1] + height[i];
//        }
//        while (start < height.length) {
//            int end = start + 1;
//            if (height[start] == 0) {
//                start++;
//                continue;
//            }
//            int maxHeight =Integer.MIN_VALUE;
//            int tempEnd = end;
//            while (end < height.length) {
//                if (height[start] > height[end]) {
//                    if(maxHeight <= height[end]){
//                        tempEnd=end;
//                        maxHeight= height[end];
//                    }
//
//                    end++;
//                } else if (height[start] <= height[end]) {
//                    int length = Math.min(height[start], height[end]);
//                    int breadth = end - start - 1;
//                    int area = length * breadth;
//                    int walkArea = prefixSum[end - 1] - prefixSum[start];
//                    count += (area - walkArea);
//                    start = end - 1;
//                    break;
//                }
//                if(end == height.length){
//                    int length = Math.min(height[start], height[tempEnd]);
//                    int breadth = tempEnd - start - 1;
//                    int area = length * breadth;
//                    int walkArea = prefixSum[tempEnd - 1] - prefixSum[start];
//                    count += (area - walkArea);
//                    start = tempEnd - 1;
//                }
//            }
//            start++;
//        }
//        return count;
//    }
    public static int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0, maxRight = 0, result = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > maxLeft){
                    maxLeft = height[left];
                }
                else{
                    result += maxLeft - height[left];
                }

                left++;
            }
            else{
                if(height[right] > maxRight){
                    maxRight = height[right];
                }
                else{
                    result += maxRight - height[right];
                }

                right--;
            }
        }

        return result;
    }
}
