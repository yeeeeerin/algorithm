package baecjoon;

import java.util.Scanner;
/*
* 0일때
* 9일때
* 나머지 를 나눠서 풀어야한다.
*
* 테스트케이스는 맞는데 왜 백준에서 틀리다하는지 모르겠다;;
* */
public class Q10844 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] dp = new long[n+1][10];
        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                if(j==0){
                    dp[i][0] = dp[i-1][1];
                }else if(j==9){
                    dp[i][9] = dp[i-1][8];
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
                }
            }
        }

        long result = 0;
        for(long i:dp[n]){
            result += i;
        }

        System.out.println(result%1000000000);

    }
}
