package baecjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {

    static int[] x = {0,0,1,-1};
    static int[] y = {-1,1,0,0};

    public static void main(String[] args){

        int count = 0;
        int max = 1;

        Scanner sc = new Scanner(System.in);

        Queue<int[]> queue = new LinkedList<>();

        int size_x = sc.nextInt(),size_y = sc.nextInt();

        int[][] arr =new int[size_y][size_x];
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 1){
                    queue.add(new int[]{i,j});
                }else if(arr[i][j] == -1){
                    count++;
                }

            }
        }

        while (!queue.isEmpty()){

            int[] a = queue.poll();


            for(int i=0;i<4;i++){

                if(a[0]+x[i]<size_y && a[0]+x[i]>=0 && a[1]+y[i]>=0 && a[1]+y[i]<size_x){

                    if(arr[a[0]+x[i]][a[1]+y[i]] != 0){
                        continue;
                    }

                    queue.add(new int[]{a[0]+x[i],a[1]+y[i]});
                    arr[a[0]+x[i]][a[1]+y[i]] = arr[a[0]][a[1]]+1;
                    if (max < arr[a[0]+x[i]][a[1]+y[i]]){
                        max = arr[a[0]+x[i]][a[1]+y[i]];
                    }
                }
            }

            count++;

        }

        if(count != size_x*size_y){
            System.out.println(-1);
        }else {
            System.out.println(max-1);
        }

    }
}
