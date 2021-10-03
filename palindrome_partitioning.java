//Initial Template for Java

import java.io.*;
import java.util.*;

class palindrome_partitioning{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp = new int[501][501];
    static int palindromicPartition(String s)
    {
        for(int [] rows:dp)
            Arrays.fill(rows,-1);
        return solve(s,0,s.length()-1);
    }
    public static int solve(String s,int i ,int j)
    {
        if(i>=j)
            return 0;
        if(palindrome(s,i,j))
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i;k<j;k++)
        { int l ,r;
            if(dp[i][k]!=-1)
                 l = dp[i][k];
            else
                 l = solve(s,i,k);
            
            if(dp[k+1][j]!=-1)
                 r = dp[k+1][j];
            else
                 r = solve(s,k+1,j);
            
            int x = 1+l+r;
            dp[i][j] = Math.min(x,dp[i][j]);
        }
        return dp[i][j];
    }
    public static boolean palindrome(String s,int i,int j)
    {
        if(i>j)
            return false;
        if(i==j)
            return true;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
            
        }
        return true;
    }
}