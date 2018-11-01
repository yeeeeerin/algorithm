/*
11.01
topcoder .탐색 범위 한정 알고리즘-01 .다양한 색상의 상자와 공

bothcolor의 케이스를 중점으로 두고 계산
 */

package questions;

public class ColorfulBoxesAndBalls {
    public static void main(String[] args){
        System.out.println(getMaxinum(2,3,100,400,300));
    }

    public static int getMaxinum(int numRed,int numBlue,int onlyRed,int onlyBlue,int bothColor){

        int min = Math.min(numRed,numBlue);
        int maxValue = 0;
        int tmp;
        for(int i=0;i<=min;i++){
            tmp = (bothColor * i * 2) + (onlyRed * (numRed-i)) + (onlyBlue * (numBlue -i));
            if(maxValue < tmp){
                maxValue = tmp;
            }
        }

        return maxValue;
    }
}
