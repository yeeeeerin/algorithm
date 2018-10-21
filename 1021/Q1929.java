package baecjoon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Q1929 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();

        boolean[] arr = new boolean[b+3];


        for(int i=2;i<=b;i++){

            if(arr[i] == true)
                continue;

            for(int j=1;j*i<=b;j++){
                arr[j*i] = true;
            }

            if(i>=a)
                System.out.println(i);
        }

    }

}
