/*
9.10
topcoder .06 .친구 수

나랑 친구라면 친구수를 그냥 더하고 아니라면
나랑 친구가 아닌 사람과 나를 비교하여 겹치는 친구를 찾아 있다면 친구 수를 더하는 알고리즘
 */

import java.util.Arrays;

public class FriendScore {

    public static void main(String args[]){

        String[] friends = {"NNNNYNNNNN",
                            "NNNNYNYYNN",
                            "NNNYYYNNNN",
                            "NNYNNNNNNN",
                            "YYYNNNNNNY",
                            "NNYNNNNNYN",
                            "NYNNNNNYNN",
                            "NYNNNNYNNN",
                            "NNNNNYNNNN",
                            "NNNNYNNNNN",};

        System.out.println(highestScore(friends));
    }

    public static int highestScore(String[] friends){

        int[] friendScore = new int[friends.length];

        for(int i=0;i<friends.length;i++){

            for(int j=0;j<friends.length;j++){

                if (j==i){
                    continue;
                }

                //나랑 친구가 아니라면
                if(friends[i].charAt(j) == 'N'){

                    //나의 친구와 나와 친구가 아닌 사람의 친구를 비교하여 겹치는 친구가 있는지 확인한다.
                    for(int k=0;k<friends.length;k++){
                        if(friends[i].charAt(k) == 'Y' && friends[j].charAt(k) == 'Y'){
                            friendScore[i]++;
                        }
                    }

                }else {

                    friendScore[i]++;
                }
            }
        }

        Arrays.sort(friendScore);

        return friendScore[friendScore.length-1];
    }

}
