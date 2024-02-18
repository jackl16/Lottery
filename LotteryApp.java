import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


/*
 * Todo:
 * add user inputted numbers and calculate a winning amount
 * User interface in the future
 * turn into a game with fake currency
 */

public class LotteryApp{
    public static int[] generateNumbers(int totalNums,int maxNum){
        //http://probability.infarom.ro/lottery.html
        int[] lottery_nums= new int [totalNums];
        
        Random random = new Random();

        // Generate random numbers and store them in the array
        for (int i = 0; i < totalNums; i++) {
            // Generate a random number within the specified range
            int num = random.nextInt(maxNum) + 1; // Adding 1 because nextInt generates from 0 (inclusive) to maxNum (exclusive)
            
            // Ensure uniqueness of generated numbers
            for (int j = 0; j < i; j++) {
                if (lottery_nums[j] == num) {
         
                    num = random.nextInt(maxNum) + 1;
         
                    j = -1;
                }
            }
            
 
            lottery_nums[i] = num;
        }
        Arrays.sort(lottery_nums);
        return lottery_nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        
        String name = scanner.nextLine();
        
        System.out.println("Hello, " + name + "! Welcome to the Lottery App.");
        
        System.out.print("Enter the total number of lottery numbers: ");
        int totalNums = scanner.nextInt();
        System.out.print("Enter the maximum number for the lottery: ");
        int maxNum = scanner.nextInt();
        int[] lotteryNumbers = generateNumbers(totalNums,maxNum);


        System.out.println("Lottery numbers:");
        for (int number : lotteryNumbers) {
            System.out.print(number + " ");
        }
        
        // Close the scanner
        scanner.close();
    }
    
}