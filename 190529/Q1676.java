package baecjoon;

import java.util.Scanner;

public class Q1676 {
    public static void main(String[] args){
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        for(int i=5;i<=n;i+=5){
            a = i;
            while (a%5 == 0){
                count++;
                a/=5;
            }
        }

        System.out.println(count);
    }
}
