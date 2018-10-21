package baecjoon;

import java.util.Scanner;

public class Q1003 {

    static int[][] path = new int[41][2];


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[][] a = new int[count][2];
        for(int i=0;i<count;i++){
            a[i] = fibonacci(sc.nextInt());
        }

        for(int i=0;i<count;i++)
            System.out.println(a[i][0]+" "+a[i][1]);


    }

    public static int[] fibonacci(int n) {
        if (n == 0) {
            return new int[]{1,0};
        } else if (n == 1) {
            return new int[]{0,1};
        } else {
            if(path[n][0] == 0 && path[n][1] == 0) {
                path[n-1] = fibonacci(n - 1);
                path[n-2] = fibonacci(n - 2);
            }
            return new int[]{path[n-1][0]+path[n-2][0],path[n-1][1]+path[n-2][1]};
        }
    }
}
