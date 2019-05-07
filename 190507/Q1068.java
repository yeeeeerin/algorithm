package baecjoon;

import java.util.*;

public class Q1068 {

    static Tree[] tree;
    static int delete;
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tree = new Tree[n+1];
        int root = 0;

        for(int i=0;i<n;i++){
            tree[i] = new Tree();
            int parent = sc.nextInt();
            if(parent != -1){
                tree[parent].children.add(i);
                tree[i].parent = parent;
            }else{
                root = i;
            }
        }

        delete = sc.nextInt();
        tree[delete] = null;

        if(delete == root){
            System.out.println(0);
        }else {
            System.out.println(bfs(root));
        }

    }

    public static class Tree{
        int parent;
        List<Integer> children;

        Tree(){
            parent = 0;
            children = new LinkedList<>();
        }
    }

    public static int bfs(int root) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if(node < n && node != delete) {

                Iterator<Integer> it= tree[node].children.iterator();
                if(!it.hasNext()){
                    count++;
                }
                while (it.hasNext()){
                    queue.add(it.next());
                }

            }
        }

        if(count == 0){
            return 1;
        }
        return count;
    }

}
