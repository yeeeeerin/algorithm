/*
9.5
topcoder .03 .암호

내가 푼 방법 가장 큰 수를 찾아 +1하거나 1이 있을 때 거기에 +1을 하여 곱함

간단한 방법 가장 작은 수에 +1하여 곱함
 */

public class di1 {
    public static void main(String args[]){

        Integer[] number = new Integer[]{1000,999,998,997,996,995};

        System.out.println(anwser2(number));
    }

    public static long anwser2(Integer[] number){
        long mul = 1;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<number.length;i++){
            if (min > number[i])
                min = i;
        }

        number[min]++;

        for (int i=0;i<number.length;i++){
            mul*=number[i];
        }

        return mul;
    }

    public static long anwser(Integer[] number){

        int max = 0;
        boolean one = false;
        long mul = 1;

        for (int i=0;i<number.length;i++){

            if(number[i] == 1 && !one) {
                one = true;
                number[i]++;
                break;
            }

            if(max<number[i]) {
                max = i;
            }

        }

        if (!one){
            number[max]++;
        }

        for(int i=0;i<number.length;i++){
            mul *= number[i];
        }

        return mul;
    }
}
