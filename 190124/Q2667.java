package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2667 {

    static int[] x = {1,-1,0,0};
    static int[] y = {0,0,1,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        String[] st;
        for(int i=0;i<n;i++){
            st = br.readLine().split("");

            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st[j]);

            }

        }

        String result = "";

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //모든 맵을 한번씩 돌며 방문하지 않은 곳이 있는지 확인한다.
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    queue.add(new int[]{i,j});
                    int count = 1;
                    while (!queue.isEmpty()){
                        int[] xy = queue.poll();

                        for(int k = 0 ; k< 4;k++){
                            int tx = xy[0]+x[k];
                            int ty = xy[1]+y[k];
                            if(tx>=0 && ty>=0 && tx<n && ty<n && map[tx][ty] == 1){
                                map[tx][ty] = 0;
                                queue.add(new int[]{tx,ty});
                                count++;
                            }
                        }

                    }

                    result += count + " ";

                }

            }
        }

        String[] an = result.split(" ");
        int[] rean = new int[an.length];
        for(int i=0;i<an.length;i++){
            rean[i] = Integer.parseInt(an[i]);
        }
        Arrays.sort(rean);
        System.out.println(an.length);
        for(int i=0;i<an.length;i++){
            System.out.println(rean[i]);
        }

    }

}
