package baecjoon;

import java.util.Scanner;

public class Q1149 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int[][] price_odd = new int[count][3];
        int[][] price_even = new int[count][3];

        int odd = 0;
        int even = 0;

        int a,b,c;

        for(int i=0;i<count;i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            if(price_even[i][0] != 1001)
                price_even[i][0] = a;
            if(price_even[i][1] != 1001)
                price_even[i][1] = b;
            if(price_even[i][2] != 1001)
                price_even[i][2] = c;

            if(price_odd[i][0] != 1001)
                price_odd[i][0] = a;
            if(price_odd[i][1] != 1001)
                price_odd[i][1] = b;
            if(price_odd[i][2] != 1001)
                price_odd[i][2] = c;

            if((i+1)%2 == 1) {

                if(a<=b && a<=c){         //a가 제일 작을 때
                    //System.out.println("odd[0]in");
                    odd+=a;
                    if(i < count-1) {
                        price_odd[i + 1][0] = 1001;
                    }
                }else if(b<=a && b<=c){   //b가 제일 작을 때
                    odd+=b;
                    if(i < count-1)
                        price_odd[i+1][1] = 1001;
                }else{
                    odd+=c;
                    if(i < count-1)
                        price_odd[i+1][2] = 1001;
                }

            }else{

                if(a<=b && a<=c){
                    even+=a;
                    price_even[i-1][0] = 1001;
                    if(i == count-2){
                        price_even[i+1][0] = 1001;
                    }
                }else if(b<=a && b<=c){
                    even+=b;
                    price_even[i-1][1] = 1001;
                    if(i == count-2){
                        price_even[i+1][1] = 1001;
                    }
                }else{
                    even+=c;
                    price_even[i-1][2] = 1001;
                    if(i == count-2){
                        price_even[i+1][2] = 1001;
                    }
                }

            }

        }



        for(int i=0;i<count;i++){

            //홀수면
            if((i+1)%2==1){

                a=price_even[i][0];
                b=price_even[i][1];
                c=price_even[i][2];


                even+=Math.min(a,Math.min(b,c));
            }else{

                a=price_odd[i][0];
                b=price_odd[i][1];
                c=price_odd[i][2];

                odd+=Math.min(a,Math.min(b,c));
            }
        }


        System.out.println(Math.min(even,odd));


    }


}
