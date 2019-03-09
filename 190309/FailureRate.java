package kakao;

import java.util.*;

public class FailureRate {

    public static void main(String[] args){
        int N=4;
        int[] stages={4,4,4,4,4};
        int[] num = new int[N+1];
        HashMap<Integer,Double> rate_anser = new HashMap<>();
        int[] answer = new int[N];
        for(int i : stages){
            num[i-1]++;
        }

        for(int i=0;i<N;i++){
            int k=0;
            if(i>0){
                for(int j=0;j<i;j++){
                    k+=num[j];
                }
            }
            rate_anser.put(i+1,(double) num[i]/(stages.length-k));
        }

        int count =0;
        Iterator it = sortByValue(rate_anser).iterator();
        while (it.hasNext()){
            answer[count] = (int)it.next();
            count++;
        }

    }

    public static List sortByValue(final Map map) {

        List<String> list = new ArrayList();

        list.addAll(map.keySet());



        Collections.sort(list,new Comparator() {

            public int compare(Object o1,Object o2) {

                Object v1 = map.get(o1);

                Object v2 = map.get(o2);


                return ((Comparable) v1).compareTo(v2);

            }

        });



        Collections.reverse(list); // 주석시 오름차순

        return list;

    }
}
