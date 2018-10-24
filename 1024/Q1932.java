package baecjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q1932 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int[][] arr = new int[count][count];

        int a;
        arr[0][0] = scanner.nextInt();
        for(int i=1;i<count;i++){
            for(int j=0;j<=i;j++){
                a = scanner.nextInt();

                if(j == 0) {
                    arr[i][j] = arr[i-1][j] + a;
                }else if(j == i){
                    arr[i][j] = arr[i-1][j-1] + a;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-1])+a;
                }
            }
        }

        Arrays.sort(arr[count-1]);

        System.out.println(arr[count-1][count-1]);
    }

}
