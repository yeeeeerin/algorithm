/*
11.19
topcoder .탐색 범위 한정 알고리즘-09 .해밀턴 패스

풀이
1.3개이상 연결되어 있으면 0
2.연결되어 있는것들 중에 한바퀴 도는 형태면 0

나머지로 묶여져 있는 형태로 !
묶여져있는것들은 각각 2의n승을 곱하여 답을 계산한다.
 */

package questions;

public class HamiltonPath {

    public static void main(String[] args){
        String[] roads ={
                "NNNNNY",
                "NNNNYN",
                "NNNNYN",
                "NNNNNN",
                "NYYNNN",
                "YNNNNN"
        };
        System.out.println(countPaths(roads));
    }

    public static int countPaths(String[] roads){
        int result = 1;

        int k =0;
        int[] rpc = new int[roads.length];

        for (int i=0;i<roads.length;i++){

            int[] count = new int[roads.length];

            if(2<countOccurrencesOf(roads[i], 'Y')){
                return 0;
            }


            int tmp = i;
            if(roads[tmp].contains("Y")){
                k++;
            }

            while(roads[tmp].contains("Y")){
                int ypos = roads[tmp].indexOf("Y");
                count[tmp]++;
                rpc[tmp] = k;
                if(count[tmp] >= 2 ){
                    return 0;
                }

                roads[tmp] = roads[tmp].replaceFirst("Y","N");
                if(tmp == 0){
                    roads[ypos] = 'N'+ roads[ypos].substring(1,roads.length);
                }else{
                    roads[ypos] = roads[ypos].substring(0,tmp)+'N'+roads[ypos].substring(tmp+1,roads.length);
                }


                tmp = ypos;
            }

        }


        for(int i=1;i<=(k+1);i++){
            result*=i;
        }

        if(k > 0)
            result*=(int) Math.pow(2,k);

        return result;
    }

    public static int countOccurrencesOf(String s, char ch){
        int count = 0;
        char[] c = s.toCharArray();
        for (int i=0;i<c.length;i++){

            if(c[i] == ch){
                count++;
            }

        }

        return count;

    }
}
