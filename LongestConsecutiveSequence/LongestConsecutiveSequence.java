package LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //    int[] nums = new int[]{0, 4, 5, 1, 3, 2};
    //    int[] nums = new int[]{100,4,200,1,3,2};
        int[] nums = new int[]{1,2,0,1};
//        int[] nums = new int[]{100, 4,200,201,202,203,204, 1, 3, 2};

        naiveApproach(nums);
        System.out.println(optimised(nums));
    }
    private static void naiveApproach(int[] nums) {
        SortedSet<Integer> ts = new TreeSet<>();

        for (int num : nums) {
            ts.add(num);
        }

        int maxLen = 0;
        int count = 0;
        int prev = Integer.MAX_VALUE;
        Iterator<Integer> i = ts.iterator();
        while (i.hasNext()) {
            count++;
            Integer current = i.next();
            if ((prev + 1) == current) {
                if (count == 1) {
                    count++;
                }
                maxLen = Integer.max(count, maxLen);
            } else {
                count = 0;
            }
            prev = current;
        }
        if (nums.length == 1) {
            maxLen = 1;
        }
        System.out.println(maxLen);
    }
    public static Integer optimised(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] + 1 ) == nums[i]) {
                count++;
                maxLen = Integer.max(count, maxLen);
            }else{
                count = 1;
            }
        }
        return maxLen;
    }
}
