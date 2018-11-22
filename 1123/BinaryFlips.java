/*
11.23
topcoder .응용문제-01 .바이너리 플립
동적계획 + 깊이우선
string으로 풀었을 때 버전
 */

package questions;


public class BinaryFlips {

    static int[] dps;
    static String[] kindOfK;
    static int[] rkindOfKindex;
    static String result = "";
    static int Klen;

    public static void main(String[] args){
        System.out.println(minimalMoves(100000,100000,578));
    }

    public static int minimalMoves(int A,int B,int K){
        if((A+B)<K){
            return -1;
        }

        Klen = K+1;
        String init ="";

        dps = new int[A+B+1];
        kindOfK = new String[Klen];
        rkindOfKindex = new int[Klen];

        //k의 종류를 구함
        for (int i=0;i<Klen;i++){
            kindOfK[i] = "";
            for (int j=i;j<K;j++){
                kindOfK[i]+="0";
            }

            for(int j=0;j<i;j++){
                kindOfK[i]+="1";
            }

            //System.out.println(kindOfK[i]);
            rkindOfKindex[i] = K-i;
        }

        //주어진 A와 B의 조합으로 결과값을 만든다.
        for(int i=0;i<A+B;i++){
            if(i<A){
                result+="0";
            }else {
                result+="1";
            }
            //초기 값
            init+="1";
        }

        int anwser = count(init)-1;
        if(anwser == Integer.MAX_VALUE){
            anwser = -1;
        }
        return anwser;
    }

    //before는 바로 전 값의 포지션을 저장한다.
    public static int count(String init){
        if(init.equals(result)){
            return 1;
        }
        int index;
        if(!init.contains("0")){
            index = init.length();
        }else {
            index = init.lastIndexOf("0")+1;
        }

        if(dps[index] == 0){
            System.out.println(init);
            dps[index] = 1;
            int min = Integer.MAX_VALUE;
            int tmp = Integer.MAX_VALUE;
            for(int i=0;i<Klen;i++){
                if( init.contains(kindOfK[i])){
                    tmp = count(init.replaceFirst(kindOfK[i],kindOfK[rkindOfKindex[i]]));
                }
                if(min>tmp) min = tmp;
            }
            min+=1;
            return min;
        }
        return Integer.MAX_VALUE;
    }

}
