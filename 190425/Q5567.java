package baecjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Q5567 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] people = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            people[x][y] = 1;
            people[y][x] = 1;

        }

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=1;i<=n;i++){
            if(people[1][i] == 1){
                hashSet.add(i);
                for(int j=1;j<=n;j++){
                    if(people[i][j] == 1){
                        hashSet.add(j);
                    }
                }
            }

        }

        System.out.println(hashSet.size()-1);
    }
}
