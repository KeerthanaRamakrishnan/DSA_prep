package BinarySearch;

public class FindMin {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        int min = findMin(nums);
        System.out.println(min);
    }
    public static int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return bsearch(nums,0,nums.length-1,Integer.MAX_VALUE);
    }

    public static int bsearch(int[] nums, int left, int  right,int min) {
        if(left == right){
            return min;
        }
        int mid = left + ((right - left)/2);
        if(nums[left] < nums[mid] & nums[mid] > nums[right]){
            return bsearch(nums,mid,right,Math.min(Math.min(nums[mid],nums[right]), min));
        }else{
            return bsearch(nums,left,mid,Math.min(Math.min(nums[mid],nums[left]), min));
        }
    }
}
