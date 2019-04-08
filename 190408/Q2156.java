package baecjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2156 {
    public static long max(long a,long b){
        return a>b?a:b;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] wain = new int[n];
        for(int i=0;i<n;i++){
            wain[i] = sc.nextInt();
        }

        if(n==1){
            System.out.println(wain[0]);
            return;
        }else if(n==2){
            System.out.println(wain[0] + wain[1]);
            return;
        }

        long[] dp = new long[n];

        dp[0] = wain[0];
        dp[1] = wain[0]+wain[1];
        dp[2] = max(wain[0]+wain[2],wain[1]+wain[2]);
        dp[2] = max(dp[2],dp[1]);



        for(int i=3;i<n;i++){
            //지금꺼 전꺼를 마셨을 때랑 지금꺼와 전전꺼를 마셨을때 비교
            dp[i] = max(wain[i]+wain[i-1]+dp[i-3],dp[i-2]+wain[i]);
            //지금꺼를 안마셨을때를 비교
            dp[i] = max(dp[i],dp[i-1]);
        }

        System.out.println(dp[n-1]);

    }
}
