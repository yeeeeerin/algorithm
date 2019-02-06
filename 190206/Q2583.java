package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2583 {

    static int[] px = {0,0,1,-1};
    static int[] py = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        boolean[][] map = new boolean[m][n];

        for(int i=0;i<k;i++){
            String[] xy = bufferedReader.readLine().split(" ");
            for(int y=Integer.parseInt(xy[0]);y<Integer.parseInt(xy[2]);y++){
                for (int x=Integer.parseInt(xy[1]);x<Integer.parseInt(xy[3]);x++){
                    map[x][y] = true;
                }
            }
        }


        int answer = 0;
        List<Integer> answer_size = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j])
                    continue;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                map[i][j] = true;
                int count = 0;
                while (!queue.isEmpty()){
                    int[] xy = queue.poll();
                    int x = xy[0];
                    int y = xy[1];
                    count++;
                    for(int l=0;l<4;l++){
                        if(x+px[l]>=0 && x+px[l]<m && y+py[l]>=0 && y+py[l]<n){
                            if(!map[x+px[l]][y+py[l]]){
                                map[x+px[l]][y+py[l]] = true;
                                queue.add(new int[]{x+px[l],y+py[l]});

                            }
                        }
                    }
                }

                answer_size.add(count);
                answer++;

            }
        }


        Collections.sort(answer_size);
        System.out.println(answer);
        for(Integer ss : answer_size){
            System.out.print(ss + " ");
        }


    }

}
