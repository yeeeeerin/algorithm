//5월 24일
//백준 알고리즘
//1874번

import java.util.LinkedList;
import java.util.Scanner;

public class stack_1 {

    public static void main(String args[]){

        //초기화 작업
        Scanner input = new Scanner(System.in);

        int size;
        size = input.nextInt();

        int[] result = new int[size];
        int result_h = 0;

        int max_next = 0;

        LinkedList<Integer> temp1 = new LinkedList<Integer>(); //큐 기본 정렬된 숫자를 가지고 있다.
        LinkedList<Integer> temp2 = new LinkedList<Integer>(); //스택

        LinkedList<String> cal = new LinkedList<String>();

        //초기화
        for(int i=0;i<size;i++){
            result[i] = input.nextInt();
            temp1.offer(i+1);

        }

        for(int i =0;i<size;i++){
            if(result[i] == size){
                max_next=i;
                max_next++;
                break;
            }
        }

        //첫번째 작업

        System.out.println("result_h = " + result_h + " max_next = " + max_next);
        for(;result_h != max_next;){

            while(true){
                int temp_push = temp1.poll();
                temp2.push(temp_push);
                cal.offer("+");

                //test
                System.out.println("+" + temp_push);

                if(temp_push == result[result_h]){
                    break;
                }
            }

            while(true){
                int temp_pop;
                if(!temp2.isEmpty()) {
                    temp_pop = temp2.pop();


                    if (temp_pop == result[result_h]) {
                        temp1.offer(temp_pop);
                        result_h++;
                        cal.offer("-");

                        //test
                        System.out.println("-" + temp_pop);
                    } else {
                        temp2.push(temp_pop);
                        break;
                    }
                }
            }

        }


        while(!temp2.isEmpty()){
            temp1.offer(temp2.pop());
            cal.offer("-");
        }

        if (temp1.equals(result)){
            System.out.println(cal);
        }else{
            System.out.println("NO");
        }


    }


}
