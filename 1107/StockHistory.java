/*
10.9
topcoder .탐색 범위 한정 알고리-03 .주식 투자 시뮬레이션

 */

package questions;

import java.util.Arrays;

public class StockHistory {
    public static void main(String[] args){

        String[] stockPrices = {"40 50 60",
                                "37 48 50",
                                "100 48 50",
                                "105 48 47",
                                "110 50 52",
                                "110 50 52",
                                "110 51 54",
                                "109 49 53"};


        System.out.println(maximunEarnings(100,20,stockPrices));

        System.out.println(maximunEarnings(1000,0,new String[]{"10 20 30","15 24 32"}));

    }
    public static int maximunEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices){

        double[][] nums = new double[stockPrices.length][];
        double earn = 0;
        double initialMax = 0;
        int splen = stockPrices.length;

        //string으로 넘어온 값을 배열로 변환
        for(int i=0;i<splen;i++)
            nums[i] = Arrays.stream(stockPrices[i].split(" ")).mapToDouble(Double::parseDouble).toArray();

        //매 달 얻는 이익이 최대인 주가를 저장하는 변수
        double mMax;
        double premMax=0;
        for(int i=splen-2;i>=0;i--){

            mMax = 0;
            for(int j=0;j<nums[i].length;j++){
                //매 달 팔 때 얻는 주가를 계산하는 변수
                double stock = ((nums[splen-1][j]/nums[i][j])-1);

                if(mMax<stock){
                    mMax = stock;
                }

            }

            System.out.println(mMax +"  "+initialMax + "  "+premMax);

            if(premMax < mMax){
                if(initialMax<mMax){
                    earn+=monthlyContribution*initialMax;
                    initialMax = mMax;
                }else{
                    earn+=monthlyContribution*mMax;
                }
                premMax = mMax;
            }else{
                earn+=monthlyContribution*premMax;

            }

        }

        earn += initialMax*initialInvestment;

        return (int)earn;
    }
}
