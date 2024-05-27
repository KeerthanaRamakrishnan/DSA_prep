package ProductOfArrayExceptSelf;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String args[]) {
        int[] number = new int[]{1, 2, 3, 4};
        int numberCount = number.length;
        int[] prefixProduct = new int[numberCount];
        int[] suffixProduct = new int[numberCount];
        int[] output = new int[numberCount];
        prefixProduct[0] = 1;
        suffixProduct[numberCount - 1] = 1;
        for (int i = 1; i < numberCount; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * number[i - 1];
        }
        for (int i = numberCount - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * number[i + 1];
        }
        for(int i = 0; i < numberCount ; i++){
            output[i] = prefixProduct[i] * suffixProduct[i];
        }
        System.out.println(Arrays.toString(output));
    }
}