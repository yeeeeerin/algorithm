/*
10.9
topcoder .동적계획법과 메모화-05 .악수

만약 한 사람이 다른사람을 잡아서 악수를 하게 되면 그 두명을 기준으로 양쪽으로 갈리게 되는 원리를 이용
 */

package questions;

public class HandsShaking {
    public long countPerfect(int n){

        int[] p = new int[n/2+2];

        p[0] = 1;
        p[1] = 1;


        int count;

        if(n%2==0){
            count=n/2+1;
        }else{
            count=n/2;
        }

        for(int i=2;i<count;i++){
            for(int j=i-1;j>=0;j--){
                if(j == i-1){
                    p[i]+=p[j];
                }else {
                    p[i] += p[j] * p[i - 1 - j];
                }
            }

            System.out.println(p[i]);
        }



        return p[count-1];

    }
}
