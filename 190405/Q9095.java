package baecjoon;

import java.util.Scanner;

public class Q9095 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for(int i=0;i<n;i++) {
            int k = scanner.nextInt();
            System.out.println(dp[k - 1]);
        }
    }

}
