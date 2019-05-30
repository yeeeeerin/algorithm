package baecjoon;

import java.util.*;

public class Q11004 {
    public static void main(String[] args){
        TreeSet<Integer> tree = new TreeSet<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i< n;i++)
            tree.add(sc.nextInt());

        Iterator<Integer> it = tree.iterator();
        for(int i=0;i<k-1;i++){
            it.next();
        }

        System.out.println(it.next());

    }
}
