package kakao;

import java.util.HashMap;
import java.util.Map;


public class OpenChat {
    public static void main(String[] args){
        String[] recode = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        Map<String,String> user = new HashMap<>();

        String[] answer2 = new String[recode.length];
        int count = 0;
        for(String s : recode){
            String[] t = s.split(" ");
            if (t[0].equals("Enter")){
                user.put(t[1],t[2]);
                answer2[count] =t[1]+" 님이 들어왔습니다.";
                count++;
            }else if(t[0].equals("Leave")){
                answer2[count] =t[1]+" 님이 나갔습니다.";
                count++;
            }else {
                user.put(t[1],t[2]);
            }
        }
        String[] answer = new String[count];
        for(int i=0;i<count;i++){
            String[] t = answer2[i].split(" ");
            t[0] = user.get(t[0]);
            answer[i] = t[0]+t[1]+" "+t[2];
        }

        for(String s:answer){
            System.out.println(s);
        }



    }

}
