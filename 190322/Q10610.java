package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if(!s.contains("0")){
            System.out.println(-1);
            return;
        }

        String[] arr  = s.split("");

        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum+=Integer.parseInt(arr[i]);

        }

        if(sum%3 == 0){
            Arrays.sort(arr,new Comparator<String>(){
                public int compare(String o1,String o2){
                    return o2.charAt(0)-o1.charAt(0);
                }
            });
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
            }
            System.out.println();
        }else {
            System.out.println(-1);
        }
    }
}
