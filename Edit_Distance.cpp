

/*
*!Brute force Time complexity:O(3^n)
*! DP SOLUTION: TIme:O(m*n) space:O(m*n)
*!SPace optimized: Time:O(m*n) space:(m)

*/
//Brute force
#include<bits/stdc++.h>
using namespace std;
int editDistance(string s1, string s2) 
{

    if(s1.empty())
        return s2.size();
    if(s2.empty())
        return s1.size();
   
    if(s1==s2)
        return 0;
 
 int answer=0;   
 if(s1[0]!=s2[0])
 {
 int a=editDistance(s1.substr(1),s2);
 int b=editDistance(s1,s2.substr(1));
 int c=editDistance(s1.substr(1),s2.substr(1));
 answer=min(a,min(b,c))+1;
 }	 
    else
    {
        answer= editDistance(s1.substr(1),s2.substr(1));    
    }
    return answer;
    
}

//Better brute force, is to avoid using substr method
int min(int x, int y, int z) { return min(min(x, y), z); }
 
int editDist(string str1, string str2, int m, int n)
{
    if (m == 0)
        return n;
 
    
    if (n == 0)
        return m;
 
    if (str1[m - 1] == str2[n - 1])
        return editDist(str1, str2, m - 1, n - 1);
 
   
    return 1
           + min(editDist(str1, str2, m, n - 1), // Insert
                 editDist(str1, str2, m - 1, n), // Remove
                 editDist(str1, str2, m - 1,
                          n - 1) // Replace
             );
}


//*Memoization


int helper(string s1,string s2,int **arr)
{
    int m=s1.size();
    int n=s2.size();
    if(s1.empty())
        return s2.size();
    if(s2.empty())
        return s1.size();
    if(s1==s2)
        return 0;
    if(arr[m][n]!=-1)
        return arr[m][n];
    if(s1[0]!=s2[0])
    {
        int a,b,c;
        a=helper(s1.substr(1),s2,arr);
        b=helper(s1,s2.substr(1),arr);
        c=helper(s1.substr(1),s2.substr(1),arr);
       arr[m][n]= min(a,min(b,c))+1;
    }
    else
        arr[m][n]=helper(s1.substr(1),s2.substr(1),arr);
    return arr[m][n];
}


int editDistance(string s1, string s2)
{
    int m=s1.size();
    int n=s2.size();
    int i,j;
	int **arr=new int*[m+1];
    for(i=0;i<=m;i++)
        arr[i]=new int[n+1];
    for(i=0;i<=m;i++)
        for(j=0;j<=n;j++)
            arr[i][j]=-1;
    return helper(s1,s2,arr);
    
}





// * Solution through DP

 int editDistance(string s, string t) {
        int m,n,i,j;
        m=s.size();
        n=t.size();
        vector<vector<int>> dp(m+1,vector<int>(n+1));
        
        
        dp[0][0]=0;
      
        for(i=1;i<=n;i++)
        dp[0][i]=i;
        
        for(i=1;i<=m;i++)
        dp[i][0]=i;
        
        for(i=1;i<=m;i++){
            for(j=1;j<=n;j++){
    
                if(s[i-1]==t[j-1])
                dp[i][j]=dp[i-1][j-1];
                else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    int c = dp[i-1][j-1];
                    dp[i][j]=min(a,min(b,c))+1;
                }
            }
        }
        return dp[m][n];
    }


