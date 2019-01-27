package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] map = new int[size][size];
        int[][] answer = new int[size][size];

        //입력값을 받음
        for(int i=0;i<size;i++){
            String[] s = br.readLine().split(" ");
            for (int j=0;j<size;j++){

                map[i][j] = Integer.parseInt(s[j]);

            }
        }

        //계산
        for(int i=0;i<size;i++){
            Queue<int[]> queue = new LinkedList<>();

            for(int j=0;j<size;j++){
                if(map[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }

            while (!queue.isEmpty()){
                int[] pos = queue.poll();
                answer[i][pos[1]] = 1;

                for(int j=0;j<size;j++){
                    if(answer[i][j]==0 && map[pos[1]][j] == 1){
                        queue.add(new int[]{pos[1],j});
                    }
                }

            }

        }

        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }

    }
}
