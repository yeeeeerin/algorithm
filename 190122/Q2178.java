package baecjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

    static int[] x = {0,0,1,-1};
    static int[] y = {-1,1,0,0};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st =  new StringTokenizer(br.readLine());

        //배열 크기 받기
        int h = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][v];

        Queue<int[]> queue = new LinkedList<>();


        //값 받기
        for(int i = 0; i<h;i++){
            String[] s = br.readLine().split("");
            for(int j=0;j<v;j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        queue.add(new int[]{0,0});

        while (!queue.isEmpty()){

            int[] a = queue.poll();

            for(int i=0;i<4;i++){
                int tx = a[1]+x[i];
                if(a[0]+y[i]>=0 && a[0]+y[i]<h && tx>=0 && tx<v){

                    if(map[a[0]+y[i]][tx]>1 || map[a[0]+y[i]][tx] == 0)
                        continue;

                    queue.add(new int[]{a[0]+y[i],tx});

                    map[a[0]+y[i]][tx] = map[a[0]][a[1]] + 1;

                }
            }

        }

        System.out.println(map[h-1][v-1]);






    }
}
