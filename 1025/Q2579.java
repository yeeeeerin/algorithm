package baecjoon;

import java.util.Scanner;

public class Q2579 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] arr = new int[count];
        int[]dp = new int[count];

        for(int i=0;i<count;i++){
            arr[i] = scanner.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1]+arr[0];
        dp[2] = Math.max(arr[0]+arr[2],arr[1]+arr[2]);

        for(int i=3;i<count;i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i] + arr[i-1]);
        }

        System.out.println(dp[count-1]);

    }

}
