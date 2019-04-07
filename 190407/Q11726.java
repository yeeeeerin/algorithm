package baecjoon;

import java.util.Scanner;

public class Q11726 {

    public static long[] dp;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new long[n];

        if(n == 1){
            System.out.println(1);
        }else if(n == 2){
            System.out.println(2);
        }else {
            dp[0] = 1;
            dp[1] = 2;

            for(int i=2 ;i<n;i++){
                dp[i] = dp[i-1]%10007+dp[i-2]%10007;
                dp[i] %= 10007;
            }

            System.out.println(dp[n-1]);
        }

    }
}
