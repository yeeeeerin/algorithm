package baecjoon;

import java.util.*;

public class Q1065 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 99;

        if(n<100){
            count = n;
        }else{

            for(int i = 111;i<=n;i++) {
                int a, b, c;

                a = i / 100;
                b = (i - a * 100) / 10;
                c = i % 10;

                if ((b - a) == (c - b)) {
                    count++;
                    System.out.println("a = "+a+" b = "+b+" c = "+c);
                }


            }

        }

        System.out.println(count);

        sc.close();

    }


}
