package programmers;

import java.util.*;

public class Q42587 {

    public static void main(String[] args){
        int[] priorities =new int[]{1, 1, 9, 1, 1, 1};

        System.out.println(solution(priorities,0));


    }

    public static int solution(int[] priorities, int location){
        int lenght = priorities.length;
        int priority = 1;

        Queue<int[]> copyArr = new LinkedList<>();

        for(int i=0;i<lenght;i++){
            copyArr.add(new int[]{priorities[i],i});
        }

        Arrays.sort(priorities);

        int pos_p = lenght-1;
        while(!copyArr.isEmpty()){
            int[] s = copyArr.remove();
            if(s[0] == priorities[pos_p]){

                if(s[1] == location){
                    return priority;
                }

                pos_p--;
                priority++;
                continue;
            }
            copyArr.add(s);


        }

        return 0;
    }
}
