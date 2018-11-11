/*
11.11
topcoder .탐색 범위 한정 알고리즘-06 .자동차 대출
 */

package questions;

public class AutoLoan {
    public static void main(String[] args){

        System.out.println(interestRate(2000,510,4));

    }

    public static double interestRate(double price,double monthlyPayment,int loanTearm){

        double max = 100;
        double min = 0;
        double center = 100;
        while ((max - min) > 1e-9 && ((max - min)/max > 1e-9)){

            double result = rate(center/12,price,monthlyPayment,loanTearm);
            if(result>0){
                max -= ((max-min)/2);
                center = max - ((max-min)/2);
            }else {
                min = center;
                center = max - ((max-min)/2);
            }
        }

        return center;

    }

    public static double rate(double rate,double price,double monthlyPayment,int loanTearm){


        for(int i=0;i<loanTearm;i++){
            price += price*rate;
            price -= monthlyPayment;
            if(price < 0){
                return price;
            }
        }

        return price;
    }
}
