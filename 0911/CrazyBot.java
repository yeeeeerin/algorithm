/*
9.11
topcoder .07 .고장난 로봇

자신의 자식들을 다 더한 후 자기 자신을 곱하여 확률을 구하는 방법이다.
 */


public class CrazyBot {

    public static double[] origin_p = new double[4];
    public static int origin_n;

    public static void main(String[] args){
        System.out.println(getProbability(3,25,25,25,25));
    }

    public static double getProbability(int n, int east, int west, int south, int north){

        origin_p[0] = east/100.0;
        origin_p[1] = west/100.0;
        origin_p[2] = south/100.0;
        origin_p[3] = north/100.0;

        origin_n = n;

        return logic(n,origin_p[0],origin_p[1],origin_p[2],origin_p[3]);

    }

    public static double logic(int n, double east, double west, double south, double north){

        double probability_e = 0.0f;
        double probability_w = 0.0f;
        double probability_s = 0.0f;
        double probability_n = 0.0f;


        if (east != 0){
            if(n <= 0) return origin_p[0];

            probability_e = logic(n-1,origin_p[0],0,origin_p[2],origin_p[3]);

            //만약 기존 설정된 n에 도달한다면 자신의 퍼센트를 곱하지 않는다.
            if (n != origin_n) probability_e *= origin_p[0];

        }
        if (west != 0){

            if(n <= 0) return origin_p[1];

            probability_w = logic(n-1,0,origin_p[1],origin_p[2],origin_p[3]);
            if (n != origin_n) probability_w *= origin_p[1];

        }
        if (south != 0){
            if(n <= 0) return origin_p[2];

            probability_s = logic(n-1,origin_p[0],origin_p[1],origin_p[2],0);
            if (n != origin_n) probability_s *= origin_p[2];

        }
        if (north != 0){
            if(n <= 0) return origin_p[3];

            probability_n = logic(n-1,origin_p[0],origin_p[1],0,origin_p[3]);
            if (n != origin_n) probability_n *= origin_p[3];

        }

        //System.out.println(probability_e + probability_n + probability_s + probability_w);

        return (probability_e + probability_n + probability_s + probability_w);

    }


}
