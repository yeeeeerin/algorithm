package baecjoon;

import java.util.Scanner;

public class Q11053 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] map = new int[n];
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i=0;i<n;i++){
            map[i] = sc.nextInt();
        }
        int max;
        int result = 0;
        for(int i=0;i<n;i++){
            max = 0;
            for(int j=0;j<=i;j++){
                if(map[i]>map[j]){
                    if(max < dp[j]){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
            if(result < dp[i]){
                result = dp[i];
            }
        }

        System.out.println(result);

    }
}
