package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q6603 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] ss = br.readLine().split(" ");
        while (true){
            String[] s = br.readLine().split(" ");
            if (s[0].equals("0")) break;
            n = Integer.parseInt(s[0]);
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i+1]);
            }

            for (int i = 0; i <= (n - 6); i++)
                dfs(0, i, new int[]{arr[i], 0, 0, 0, 0, 0});
            System.out.println();
        }

    }

    static void dfs(int height, int pos, int[] s){

        if(height == 5){
            for(int i=0;i<6;i++)
                System.out.print(s[i]+ " ");
            System.out.println();
            return;
        }

        if(pos+1 >= n) return;
        for(int i=pos+1;i<n;i++){
            if((n-i) > (n-height+1)){
                continue;
            }

            s[height+1] = arr[i];
            dfs(height+1,i,s);
        }

    }
}
