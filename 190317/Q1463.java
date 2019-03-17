package baecjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1463 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] map = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        map[n] = 1;

        while (!queue.isEmpty()){
            int t = queue.poll();
            if(t%3 == 0 && t/3>0){
                if(map[t/3] == 0){
                    queue.add(t/3);
                    map[t/3] = map[t]+1;
                }
            }

            if(t%2 == 0 && t/2>0){
                if(map[t/2] == 0){
                    queue.add(t/2);
                    map[t/2] = map[t]+1;
                }
            }

            if(t-1>0){
                if(map[t-1] == 0){
                    queue.add(t-1);
                    map[t-1] = map[t]+1;
                }
            }
        }

        System.out.println(map[1]-1);

    }

}
