//Initial Template for Java

import java.io.*;
import java.util.*;

class matrix_chain
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] memo  = new int[100][100];;
    static int matrixMultiplication(int n, int arr[])
    {
        
        for(int[] row:memo)
        Arrays.fill(row,-1);
        return solve(arr,1,n-1);
        
    }
    public static int solve(int [] a,int i,int j)
    {
        if(i>=j)
        return 0;
        if(memo[i][j]!=-1)
        return memo[i][j];
        memo[i][j] = Integer.MAX_VALUE;
        for(int k = i;k<j;k++)
        {
            int x = solve(a,i,k)+solve(a,k+1,j)+(a[i-1]*a[k]*a[j]);
            memo[i][j]=Math.min(memo[i][j],x);
            
        }
        return memo[i][j];
    }
}