package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Q1927 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int command = Integer.parseInt(br.readLine());

            if(command == 0){
                if(queue.isEmpty()) System.out.println(0);
                else{
                    System.out.println(queue.poll());
                }
            }
            else {
                queue.add(command);
            }
            
        }
    }
}
