package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4963 {

    static int[] x = {1,1,1,-1,-1,-1,0,0};
    static int[] y = {-1,0,1,-1,0,1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            int[][] map = new int[h][w];
            int[][] map2 = new int[h][w];

            for(int i=0;i<h;i++){
                String[] s = br.readLine().split(" ");
                for(int j=0;j<w;j++){
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            int count = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){

                    if(map[i][j] == 1 && map2[i][j] != 1){
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i,j});
                        map2[i][j] = 1;

                        while (!queue.isEmpty()){
                            int[] xy =queue.poll();
                            for(int k=0;k<8;k++){
                                int px = xy[0] + x[k];
                                int py = xy[1] + y[k];

                                if(px>=0 && px<h && py>=0 && py<w){
                                    if(map[px][py] == 1 && map2[px][py] != 1){
                                        queue.add(new int[]{px,py});
                                        map2[px][py] = 1;
                                    }
                                }
                            }
                        }

                        count++;
                    }

                }

            }

            System.out.println(count);

        }




    }
}
