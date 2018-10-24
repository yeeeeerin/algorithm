package baecjoon;

import java.util.Scanner;

public class Q1149 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int[][] arr = new int[count][count];
        int[][] arr2 = new int[count][count];


        for(int i=0;i<count;i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
        }

        arr2[0][0] = arr[0][0];
        arr2[0][1] = arr[0][1];
        arr2[0][2] = arr[0][2];

        for(int i=1;i<count;i++){
            arr2[i][0] += Math.min(arr2[i-1][1],arr2[i-1][2])+arr[i][0];
            arr2[i][1] += Math.min(arr2[i-1][0],arr2[i-1][2])+arr[i][1];
            arr2[i][2] += Math.min(arr2[i-1][1],arr2[i-1][0])+arr[i][2];
        }

        System.out.println(Math.min(arr2[count-1][0],Math.min(arr2[count-1][1],arr2[count-1][2])));



    }


}
