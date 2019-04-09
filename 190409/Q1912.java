import java.util.*;

public class Main {

 public static int max(int a,int b){
  return a>b? a:b;
 }
  
 public static void main(String[] args)
 {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] numbers = new int[n];
  for(int i=0;i<n;i++){
   numbers[i]=sc.nextInt();
  }
  
  int[] dp = new int [n];
  
  if(n==1){
   System.out.println(numbers[0]);
   return;
  }
  
  dp[0] = numbers[0];
  for(int i=1;i<n;i++){
   dp[i]=max(numbers[i]+dp[i-1], numbers[i]);
  }
  
  Arrays.sort(dp);
  System.out.println(dp[n-1]);
   
 }

}
