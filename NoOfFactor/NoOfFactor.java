import java.lang.Math;
import java.util.Scanner;

public class NoOfFactor {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number for which you need to find no. of factors");
        int number = scanner.nextInt();
        int totalFactor = 0;
        for(int i=1; i<=Math.sqrt(number); i++) {
            if(number % i == 0){
                if((number/i) != i) {
                    totalFactor+=2;
                }else{
                    totalFactor++;
                }
            }
        }
        System.out.println(totalFactor);
    }
}