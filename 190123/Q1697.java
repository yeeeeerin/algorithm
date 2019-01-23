package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //수빈이의 위치
        int o = Integer.parseInt(st.nextToken());

        //동생의 위치
        int y = Integer.parseInt(st.nextToken());

        int[] map = new int[200002];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(o);

        int a;

        while (true){

            a = queue.poll();


            if(a-1>=0 && a-1<100001 && map[a-1] == 0){

                if(a-1 == y){
                    System.out.println(map[a]+1);
                    break;
                }

                map[a-1] = map[a]+1;
                queue.add(a-1);
            }

            if(a+1>=0 && a+1<100001 && map[a+1] == 0){

                if(a+1 == y){
                    System.out.println(map[a]+1);
                    break;
                }

                map[a+1] = map[a]+1;
                queue.add(a+1);
            }

            if(a*2>=0 && a*2<100001 && map[a*2] == 0){

                if(a*2 == y){
                    System.out.println(map[a]+1);
                    break;
                }

                map[a*2] = map[a]+1;
                queue.add(a*2);
            }


        }

    }

}
