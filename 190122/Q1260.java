package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {

    static int[][] path;
    static int v;
    static int n;

    static int[] visit;

    public static void dfs(int v){

        System.out.print(v+1);

        visit[v] = 1;

        for(int i=0;i<n;i++){
            if(visit[i] == 1 || path[v][i] == 0)
                continue;
            dfs(i);
        }


    }

    public static void bfs(){


        int[][] c_path = path;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);

        while (!queue.isEmpty()){

            int a = queue.poll();

            if(c_path[a][a] == -1)
                continue;

            for(int i=0;i<n;i++){
                if(c_path[a][i] == 1){
                    queue.add(i);
                }
            }

            c_path[a][a] = -1;

            System.out.print(a+1);


        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        //정점의 개수
        n = Integer.parseInt(st.nextToken());
        //간선의 개수
        int m = Integer.parseInt(st.nextToken());
        //탐색을 시작할 정점의 신호
        v = Integer.parseInt(st.nextToken())-1;


        visit = new int[n];

        path = new int[n][n];

        for(int i=0 ;i<m;i++){
            String[] s = br.readLine().split(" ");

            path[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
            path[Integer.parseInt(s[1])-1][Integer.parseInt(s[0])-1] = 1;
        }

        dfs(v);
        System.out.println();
        bfs();

    }
}
