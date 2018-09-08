/*
9.6
topcoder .04 .재미있는 수학

내가 푼 방법 : 주어진 진수 -1을 한 후 제곱이 되는 수가 있는지 찾아본다.
 */

import java.util.ArrayList;

public class di1 {
    public static void main(String args[]){

        System.out.println(anwser(10));
    }

    public static ArrayList<Integer> anwser(int jinsu){

        int a = jinsu -1;
        int b;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(a);
        while (true){
            b = a/2;
            if (b != 0) {
                for (int i = b; i > 0; i--) {
                    if ((b * b) == a) {
                        result.add(b);
                        a = b;
                        break;
                    }
                }
            }
            else break;
        }

        return result;
    }
}
