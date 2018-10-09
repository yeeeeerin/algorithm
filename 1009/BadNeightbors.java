/*
10.9
topcoder .동적계획법과 메모화-03 .나쁜 이웃집 사람들

 */
package questions;


public class BadNeightbors {


    public int maxDonations(int[] donations){

        int[][] odd = new int[donations.length][donations.length];
        odd[0][0] = donations[0];
        odd[1][1] = donations[1];
        odd[2][2] = donations[2] + Math.max(odd[0][0],odd[1][1]);

        int[][] even = new int[donations.length][donations.length];
        even[0][0] = 0;
        even[1][1] = donations[1];
        even[2][2] = donations[2];

        for(int i=3;i<donations.length;i++){

            even[i][i] = Math.max(even[i-2][i-2],even[i-3][i-3]);
            if(donations.length-1 == i){
                break;
            }
            odd[i][i] = Math.max(odd[i-2][i-2],odd[i-3][i-3]) + donations[i];
        }

        return Math.max(odd[odd.length-2][odd.length-2], even[even.length-1][even.length-1]);

    }

}
