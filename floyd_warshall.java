//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class floyd_warshall
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    { int v = matrix.length;
        for(int k = 0;k<v;k++)
        for(int i = 0;i<v;i++)
        for(int j = 0;j<v;j++)
        {if(matrix[i][k]==-1 || matrix[k][j]==-1)continue;
        else if (matrix[i][j]==-1)
        matrix[i][j] = matrix[i][k]+matrix[k][j];
        else if(matrix[i][k]+matrix[k][j]<matrix[i][j])
            matrix[i][j] = matrix[i][k]+matrix[k][j];
        }
    }
}