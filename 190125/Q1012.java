package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1012 {

    static int[] sx = {-1,1,0,0};
    static int[] sy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] result = new int[t];

        //테스트케이스만큼 돌아감
        for(int i=0;i<t;i++) {
            String[] s = br.readLine().split(" ");

            //가로세로와 배추심어진 위치 개수
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);

            boolean[][] map = new boolean[m][n];

            //배추가 심어진 좌표들을 저장해
            int[][] save = new int[k][2];

            for(int j=0;j<k;j++){
                String[] xy = br.readLine().split(" ");

                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                map[x][y] = true;

                save[j][0] = x;
                save[j][1] = y;

            }

            Queue<int[]> queue = new LinkedList<>();

            for(int[] xy:save){

                if(!map[xy[0]][xy[1]])
                    continue;

                queue.add(xy);

                while (!queue.isEmpty()){
                    int[] a = queue.poll();
                    for(int j=0;j<4;j++) {
                        int tx = a[0] + sx[j];
                        int ty = a[1] + sy[j];
                        if (tx>=0 && tx<m && ty>=0 && ty<n && map[tx][ty]){
                            queue.add(new int[]{tx,ty});
                            map[tx][ty] = false;
                        }
                    }
                }

                result[i]++;

            }


        }

        for(int i=0;i<t;i++){
            System.out.println(result[i]);
        }



    }
}
