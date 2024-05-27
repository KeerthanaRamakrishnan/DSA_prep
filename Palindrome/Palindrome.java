package Palindrome;

public class Palindrome {
    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(isPalindrome(str,0,str.length()-1));
    }
    private static boolean isPalindrome(String str,int start, int end) {
        if(start < end){
            boolean i = str.charAt(start) == str.charAt(end);
            return i && isPalindrome(str,start+1, end-1);
        }
        return true;
    }
}
