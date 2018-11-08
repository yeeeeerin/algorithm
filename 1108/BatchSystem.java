/*

11.8
topcoder .탐색 범위 한정 알고리-04 .배치시스템

 */

package questions;

import java.util.Arrays;

public class BatchSystem {

    public static void main(String[] args){
        int[] d = {100,200,50};
        String[] u = {"d","s","w"};
        int[] resualt =schedule(d,u);

        for (int i=0;i<resualt.length;i++){
            System.out.print(resualt[i]+" ");
        }
    }

    static int[] schedule(int[] duration, String[] user){

        int dulen = duration.length;

        int[][] result = new int[dulen][dulen];

        int j = 0;
        int scount;
        int ucount=0;
        //겹치는 애들 저장
        for(int i=0;i<dulen;i++){
            if(!user[i].equals("-1")){
                scount = 1;
                result[j][0] = duration[i];
                result[j][scount] = i+1;
                for(int k = i+1;k<dulen;k++){
                    if(user[i].equals(user[k])){
                        scount++;
                        result[j][scount] = k+1;
                        result[j][0] += duration[k];
                        user[k] = "-1";

                    }
                }

                j++;
                ucount++;
            }
        }

        //배열 정렬
        for(int i=0;i<ucount;i++){
            for(int k=0;k<ucount-i-1;k++){
                if(result[k+1][0]<result[k][0]){
                    int[] temp = Arrays.copyOf(result[k+1],dulen);
                    result[k+1] = Arrays.copyOf(result[k],dulen);
                    result[k] = Arrays.copyOf(temp,dulen);
                }
            }
        }

        //순서 뽑아내기
        int[] daan = new int[dulen];
        int daan_c = 0;
        for(int i=0;i<dulen;i++){
            for (int k=1;k<dulen;k++){

                if(result[i][k] != 0){
                    daan[daan_c] =result[i][k]-1;
                    daan_c++;
                }
                System.out.print(result[i][k]+" ");
            }
            System.out.println();
        }

        return daan;
    }
}
