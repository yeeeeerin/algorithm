package baecjoon;

import java.util.Scanner;

public class Q11727 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();


        if(n==1){
            System.out.println(1);
            return;
        }else if(n==2){
            System.out.println(3);
            return;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 3;
        for(int i=2;i<n;i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }

        System.out.println(dp[n-1]);

    }
}
