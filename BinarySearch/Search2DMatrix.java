package BinarySearch;


public class Search2DMatrix {
    public static void main(String[] args) {
        int [][]matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 1;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix,0,matrix.length-1,target);
    }

    private static boolean binarySearch(int[][] matrix, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            int[] currentMatrix = matrix[mid];
            if(currentMatrix[0] <= target && currentMatrix[currentMatrix.length-1] >=target){
                return bsearch(currentMatrix,0, currentMatrix.length-1, target);
            }else if (currentMatrix[0] >= target){
                return binarySearch(matrix,left,mid-1,target);
            } else if(currentMatrix[currentMatrix.length-1] <=target){
                return binarySearch(matrix,mid+1,right,target);
            }
        }
        return false;
    }
    public static boolean bsearch(int[] nums,int left,int right,int target){
        if(left<=right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                return bsearch(nums, mid + 1, right, target);
            } else if (nums[mid] > target) {
                return bsearch(nums, left, mid - 1, target);
            }
        }
        return false;
    }
}
