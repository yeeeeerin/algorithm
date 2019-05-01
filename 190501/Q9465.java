package baecjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q9465 {

    public static int max(int a,int b){
        return a>b?a:b;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=0;k<t;k++) {
            int n = sc.nextInt();
            int[] map = new int[n * 2 + 1];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    map[(i + 1) + (j * 2)] = sc.nextInt();
                }
            }

            int[] p = new int[n * 2 + 1];
            p[1] = map[1];
            p[2] = map[2];
            p[3] = map[2] + map[3];
            p[4] = map[1] + map[4];

            for (int i = 5; i <= n * 2; i++) {
                if (i % 2 == 1) {
                    p[i] = max(p[i - 1], p[i - 3])+map[i];
                } else {
                    p[i] = max(p[i - 3], p[i - 5])+map[i];
                }
            }

            Arrays.sort(p);

            System.out.println(p[n * 2]);
        }


    }
}
