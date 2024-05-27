package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{9};
        int target = 1;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        return bsearch(nums,0,nums.length-1,target);
    }

    public static int bsearch(int[] nums,int left,int right,int target){
        if(left<=right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return bsearch(nums, mid + 1, right, target);
            } else if (nums[mid] > target) {
                return bsearch(nums, left, mid - 1, target);
            }
        }
        return -1;
    }
}
