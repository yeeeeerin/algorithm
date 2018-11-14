/*
11.14
topcoder .탐색 범위 한정 알고리즘-08 .둔근 모양의 국가들
 */

package questions;

public class CirclesCountry {

    public static void main(String[] args){
        int[] X = {1,-3,2,5,-4,12,12};
        int[] Y = {1,-1,2,5,5,1,1};
        int[] R = {8,1,2,1,1,1,2};
        int x1 = -5,y1 = 1;
        int x2 = 12,y2=1;
        System.out.println(leastBorders(X,Y,R,x1,y1,x2,y2));
    }

    public static int leastBorders(int[] X,int[] Y,int[] R, int x1,int y1,int x2,int y2){
        int count = 0;
        for(int i=0;i<X.length;i++){
            double len1 = Math.pow(Math.pow(X[i]-x1,2) + Math.pow(Y[i]-y1,2),0.5);
            double len2 = Math.pow(Math.pow(X[i]-x2,2) + Math.pow(Y[i]-y2,2),0.5);
            if(len1>R[i] && len2<R[i]){
                count++;
            }else if(len1<R[i] && len2>R[i]){
                count++;
            }
        }

        return count;
    }
}
