package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int min = search(nums,0);
        System.out.println(min);
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0]==target){
                return 0;
            }
            else {
                return -1;
            }
        }
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] == target){
                return left;
            }else if(nums[right] == target){
                return right;
            }

            int mid = left + ((right - left)/2);
            if(nums[left] < nums[mid] && nums[left] <=target && target >= nums[mid]){
                right = mid;
            }else if(nums[left] > nums[])
            if(nums[left] <=target && target >= nums[mid] ){
                right = mid;
            }else if(nums[mid] <=target && target >= nums[right]){
                left= mid;
            }else {
                break;
            }

        }
        return -1;
    }
}
