package baecjoon;

import java.util.Scanner;

public class Q1010 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();

            long N_SUM = 1;
            long M_SUM = 1;
            if(M>N/2){

                for(int j=N; j>M;j--){
                    N_SUM*=j;
                }


                for(int j=1;j<=N-M;j++){
                    M_SUM*=j;
                }
            }else {

                for (int j = N; j > N - M; j--) {
                    N_SUM *= j;
                }

                for (int j = 1; j <= M; j++) {
                    M_SUM *= j;
                }
            }

            System.out.println(N_SUM/M_SUM);
        }
    }
}
