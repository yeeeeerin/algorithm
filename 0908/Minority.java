/*
소수 구하기
 */


import java.util.ArrayList;


public class Minority {
    public static void main(String args[]){

        int []a = {1,2,3};
        minorityCount(1,a);
    }

    public static int minorityCount(int amount, int[] numbers){


        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i=2;i<100;i++){
            arrayList.add(i);
        }


        System.out.println(arrayList.get(1));


        int point = 0;
        while (true){

            for (int i=point+1;i<arrayList.size();i++){
                if(arrayList.get(i)%arrayList.get(point) == 0){
                    arrayList.remove(i);

                }
            }
            point++;

            if (point >= arrayList.size()){
                break;
            }

            System.out.println(arrayList);

        }


        System.out.println(arrayList);


        return 1;

    }
}
