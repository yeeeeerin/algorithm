/*
9.7
topcoder .05 .회문

회문이란 앞에서 읽으나 뒤에서 읽으나 같은 단어.
 */


public class ThePalindrome {
    public static void main(String args[]){
        System.out.println(find("abab"));
    }

    public static int find(String s){

        int i=0;

        while (true){

            //가리키는 위치가 중간지점을 넘어가게 되면 반복문을 멈춘다.
            if (i > s.length()-i){
                break;
            }

            //문자가 다르면 뒤에 임의의 문자를 추가시킨 후 비교한다.
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                s += "0";
            }
            i++;
        }


        return s.length();
    }
}

