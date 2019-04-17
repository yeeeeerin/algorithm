import java.util.*;

public class Main {
 public static int max(int a,int b){
  return a>b?a:b;
 }
 public static void main(String[] args)
 {
  Scanner sc = new Scanner(System.in);
  int n=sc.nextInt();
  int[] price=new int[n+1];
  int[] dp=new int[n+1];
  
  for(int i=1;i<=n;i++){
   price[i]=sc.nextInt();
  }
  

  for(int i=1;i<=n;i++){
   for(int j=1;j<=i;j++){
    if(dp[i]<dp[i-j]+price[j]){
     dp[i]=dp[i-j]+price[j];
    }
   }
  }
  System.out.println(dp[n]);
 }

}
