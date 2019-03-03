package baecjoon;

import java.util.Scanner;

public class Q1987 {

    static int[] x = {0,0,1,-1};
    static int[] y = {-1,1,0,0};
    static String[] arr;

    static int r,c;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();

        arr = new String[r];
        for(int i = 0;i<r;i++){
            arr[i] = scanner.next();
        }

        System.out.println(dfs(new int[]{0,0},String.valueOf(arr[0].charAt(0)),1));

    }

    static int dfs(int[] pos,String s,int height){
        int max_height = height;
        for(int i=0;i<4;i++){
            int pos_x = pos[0] + x[i];
            int pos_y = pos[1] + y[i];

            if(pos_x >= 0 && pos_x < r && pos_y >= 0 && pos_y < c ){
                char c = arr[pos_x].charAt(pos_y);
                if(s.contains(String.valueOf(c))){
                    continue;
                }
                int a = dfs(new int[]{pos_x,pos_y}, s+arr[pos_x].charAt(pos_y),height+1);
                if(max_height < a){
                    max_height = a;
                }

            }
        }
        return max_height;
    }
}
