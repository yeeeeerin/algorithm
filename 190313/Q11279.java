package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11279 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){

            int order = Integer.parseInt(br.readLine());
            if (order == 0){
                if (queue.isEmpty()){
                    System.out.println("0");
                }else {
                    System.out.println(queue.remove());
                }
            }else{
                queue.add(order);
            }

        }



    }
}
