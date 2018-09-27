/*
9.27
topcoder .09 .쉬운마술카드

nnnn,yyyy 경우만 제외하고
n일 경우 2~15까지 들어있는 리스트에 그 카드에 들어있는 숫자를 제거해 남은 숫자를 return해주는 방법이다.
 */

package questions;

import java.util.ArrayList;

public class NumberMagicEasy {

    int[][] card = {
            {1,2,3,4,5,6,7,8},
            {1,2,3,4,9,10,11,12},
            {1,2,5,6,9,10,13,14},
            {1,3,5,7,9,11,13,15}
    };

    public int theNumber(String answer){

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=2;i<16;i++){
            result.add(i);
        }

        if (answer.equals("NNNN")){
            return 16;
        }else if(answer.equals("YYYY")){
            return 1;
        }

        for(int i=0;i<4;i++){
            if (answer.charAt(i) == 'N'){
                for(int j=0;j<8;j++){
                    if(result.contains(card[i][j]))
                        result.remove(result.indexOf(card[i][j]));
                }
            }
        }

        return result.get(0);
    }
}
