import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class di1 {
    public static void main(String args[]){

        String [] first = new String[]{"f","g","s","f"};
        String [] second = new String[]{"h","f","f","b"};

        System.out.println(anwser(first,second));
    }

    public static int anwser(String[] first, String[] second){

        HashMap<String,Integer> hobbes = new HashMap<>();

        for(int i=0;i<first.length;i++){
            if (hobbes.get(first[i]) == null){
                hobbes.put(first[i],1);
            }else if(hobbes.get(first[i]) > 0){
                int hobbyCount = hobbes.get(first[i]);
                hobbyCount += 1;
                hobbes.replace(first[i],hobbyCount);
            }

            if (hobbes.get(second[i]) == null){
                hobbes.put(second[i],1);
            }else if(hobbes.get(second[i]) > 0){
                int hobbyCount = hobbes.get(second[i]);
                hobbyCount += 1;
                hobbes.replace(second[i],hobbyCount);
            }
        }

        int max = 0;
        Iterator<String> iterator = hobbes.keySet().iterator();

        while (iterator.hasNext()){
            int value = hobbes.get(iterator.next());
            if(value > max){
                max = value;
            }
        }

        return max;
    }
}
