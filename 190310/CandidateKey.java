//소요시간 1시간 40분

package kakao;

import java.util.HashMap;
import java.util.Map;

public class CandidateKey {

    static int relation_lenght;

    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };


        int[] primary_key = findKey(relation);
        relation_lenght = relation[0].length;
        int answer = primary_key.length;
        String[] s = findMap(relation_lenght-primary_key.length).split(" ");

        String[][] new_relation=  new String[relation.length][relation_lenght-primary_key.length];

        int count = 0;
        for(int i=0;i<relation_lenght;i++){
            boolean flag = false;
            for(int j :primary_key){
                if(j == i){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            for(int k=0;k<relation.length;k++){
                new_relation[k][count] = relation[k][i];
            }
            count++;

        }

        //패턴 돌아가는거
        for(String ts : s){

            HashMap<String,Integer> hashMap = new HashMap<>();
            for(int i=0;i<relation.length;i++){
                String hashString = "";
                for(String tts:ts.split("")){
                    int pos = Integer.parseInt(tts)-1;

                    hashString += new_relation[i][pos];
                }

                hashMap.put(hashString,0);
            }

            if(hashMap.size() == relation.length){
                answer++;
            }

        }

        System.out.println(answer);

    }

    static String findMap(int n){
        String s = "";
        for(int j=2;j<n;j++) {
            for (int i = 1; i < n; i++) {
                s += dfs(i + 1, 1, j, String.valueOf(i));
            }
        }
        return s;
    }

    static String dfs(int pos,int height,int n,String path){
        if(height == n){
            return path+" ";
        }

        if(pos >= relation_lenght){
            return "";
        }

        String s = "";
        for(int i=pos;i<relation_lenght;i++){
            s+=dfs(i+1,height+1,n,path+i);
        }

        return s;
    }



    public static int[] findKey(String[][] relation){

        String ss = "";
        for(int i=0;i<relation[0].length;i++){
            Map<String,Integer> a = new HashMap<>();
            for(String[] s : relation){
                a.put(s[i],1);
            }

            if(a.size() == relation.length){
                ss += i+" ";
            }
        }

        String[] temp = ss.split(" ");
        int[] keys = new int[temp.length];
        for(int i=0;i<temp.length;i++){
            keys[i] = Integer.parseInt(temp[i]);
        }
        return keys;
    }

}
