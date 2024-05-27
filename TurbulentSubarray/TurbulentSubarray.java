package TurbulentSubarray;

import java.util.*;

public class TurbulentSubarray {
    public static void main(String[] args) {
        // int[] arr = new int[]{9, 8, 1, 9, 4, 2, 10, 7, 8};
//        int[] arr = new int[]{0,1,1,0,1,0,1,1,0,0};
//        System.out.println(solution(arr));
        int[] numbers = new int[]{-1,0,1,2,-1,-4};
//        int target = 200;
        System.out.println(threeSumWorking(numbers));
    }

    //Input
//nums =
//[3,0,-2,-1,1,2]
//
//Use Testcase
//Output
//[[-2,-1,3],[-1,0,1]]
//Expected
//[[-2,-1,3],[-2,0,2],[-1,0,1]]
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int end = nums.length - 1;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int start = 0; start < end - 1; start++) {
            int sum1 = nums[start] + nums[start + 1] + nums[end];
            int innerStart = start + 1;
            int innerEnd = end - 1;
            if (sum1 == 0) {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(nums[start]);
                objects.add(nums[start + 1]);
                objects.add(nums[end]);
                set.add(objects);
            }
            int sum2 = nums[start] + nums[end - 1] + nums[end];
            if (sum2 == 0 && end - start != 2) {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(nums[start]);
                objects.add(nums[end - 1]);
                objects.add(nums[end]);
                set.add(objects);
            }
            if (sum1 < 0 || sum2 < 0) {
                start++;
            } else {
                end--;
            }
        }
        lists.addAll(set);
        return lists;
    }

    public static List<List<Integer>> threeSumWorking(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int start = 0; start < nums.length; start++) {
            if(start > 0 && start < nums.length - 1 && nums[start] == nums[start+1]) continue;
            int mid = start+1;
            int end = nums.length-1;
            while(mid < end){
                int sum = nums[start] + nums[mid] + nums[end];
                if(sum == 0){
                    ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(nums[start]);
                    objects.add(nums[mid]);
                    objects.add(nums[end]);
                    set.add(objects);
                    while(mid < end && nums[mid] == nums[mid+1]) mid++;
                    while(mid < end && nums[end] == nums[end-1]) end--;
                    mid++;
                    end--;
                }else if(sum > 0){
                    end--;
                }else {
                    mid++;
                }
            }
        }
        lists.addAll(set);
        return lists;
    }

    private static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int curSum = numbers[start] + numbers[end];
            if (curSum == target) {
                return new int[]{start + 1, end + 1};
            } else if (curSum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{0, 0};
    }

    private static int[] twoPointerTarget(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int sum;
        int prevEnd = end;
        int prevStart = start;
        do {
            sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                prevEnd = end;
                end = (end - start + 1) / 2;
                start = prevStart;
            } else {
                prevStart = start;
                start = (end - start + 1) / 2;
                end = prevEnd;
            }
        } while (start < end);
        return new int[]{0, 0};
    }

    private static int solution(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return length;
        }
        int curLen = 1;
        int maxLen = Integer.MIN_VALUE;
        char prevExp = 'D';
        for (int i = 0; i < length - 1; i++) {
            int currentNumber = arr[i];
            int nextNumber = arr[i + 1];
            if (prevExp == 'D') {
                if (currentNumber > nextNumber) {
                    prevExp = 'G';
                    curLen++;
                } else if (currentNumber < nextNumber) {
                    prevExp = 'L';
                    curLen++;
                }
            } else {
                if (prevExp == 'L') {
                    if (currentNumber > nextNumber) {
                        prevExp = 'G';
                        curLen++;
                    } else if (currentNumber < nextNumber) {
                        curLen = 2;
                    } else {
                        prevExp = 'D';
                        curLen = 1;
                    }
                } else if (prevExp == 'G') {
                    if (currentNumber < nextNumber) {
                        prevExp = 'L';
                        curLen++;
                    } else if (currentNumber > nextNumber) {
                        curLen = 2;
                    } else {
                        prevExp = 'D';
                        curLen = 1;
                    }
                }
            }

            maxLen = Math.max(maxLen, curLen);
//            System.out.printf("maxLen %d curLen %d currenTNumber %d nextNumber %d prev %c",maxLen,curLen,currentNumber,nextNumber,prevExp);
        }
        return maxLen;
    }

}


