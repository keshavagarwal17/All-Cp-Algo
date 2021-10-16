import java.util.ArrayList;
import java.util.Scanner;
//program to count total number of subsets in an array which has a particular sum given as input. 
public class subs {
    public static int totalSubsSum(int[] a,int n,int sum){
        int[][] dp = new int[n+1][sum+1];
        for(int c=0;c<=sum;++c){
            dp[0][c] = 0;
        }
        for(int i=0;i<=n;++i){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;++i){
            for(int c=1;c<=sum;++c){
                if(c - a[i-1] >= 0){
                    dp[i][c] = dp[i-1][c]+dp[i-1][c-a[i-1]];
                }
                else{
                    dp[i][c] = dp[i-1][c];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;++i)a[i] = in.nextInt();
        System.out.println(totalSubsSum(a,n,sum));
    }
}
