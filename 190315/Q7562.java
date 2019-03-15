package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7562 {

    static int[] x = {1,2,2,1,-1,-2,-2,-1};
    static int[] y = {2,1,-1,-2,-2,-1,1,2};

    static int[][] map;
    static int l;

    static int[] cpos;
    static int[] fpos;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];

            cpos = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cpos[0] = Integer.parseInt(st.nextToken());
            cpos[1] = Integer.parseInt(st.nextToken());

            fpos = new int[2];
            st = new StringTokenizer(br.readLine(), " ");
            fpos[0] = Integer.parseInt(st.nextToken());
            fpos[1] = Integer.parseInt(st.nextToken());

            if(cpos[0] == fpos[0] && cpos[1] == fpos[1]) {
                System.out.println(0);
            }else {
                bfs(map);
                System.out.println(map[fpos[0]][fpos[1]]);
            }


        }

    }

    static void bfs(int[][] map){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(cpos);
        while (!queue.isEmpty()){
            int[]pos = queue.poll();
            for(int i=0;i<8;i++){
                int tx = pos[0] + x[i];
                int ty = pos[1] + y[i];
                if(tx < l && tx >=0 && ty < l && ty >= 0){
                    if (map[tx][ty] > 0) continue;
                    map[tx][ty] = map[pos[0]][pos[1]]+1;
                    queue.add(new int[]{tx,ty});
                }
            }
        }

        /*
        for(int k=0;k<l;k++){
            for(int j=0;j<l;j++){
                System.out.print(map[k][j]+" ");
            }
            System.out.println();
        }
        */


    }
/*
    static void dfs(int count, int[] pos){
        count++;
        for(int i=0;i<8;i++){
            int tx = pos[0] + x[i];
            int ty = pos[1] + y[i];
            if(tx < l && tx >=0 && ty < l && ty >= 0){
                if (count >= map[tx][ty] && map[tx][ty] !=0) continue;

                map[tx][ty] = count;
                dfs(count,new int[]{tx,ty});
            }
        }
    }

    */
}
