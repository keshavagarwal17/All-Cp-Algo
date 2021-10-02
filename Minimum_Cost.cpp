
#include<bits/stdc++.h>
using namespace std;

int helper(int **input,int m,int n,int i,int j)
{
    if(i>=m||j>=n)
        return INT_MAX;
    if(i==m-1&&j==n-1)
        return input[i][j];
    int a1=helper(input,m,n,i,j+1);
    int a2=helper(input,m,n,i+1,j);
    int a3=helper(input,m,n,i+1,j+1);
    return min(a1,min(a2,a3))+input[i][j];
}



int minCostPath(int **input, int m, int n)
{
	return helper(input,m,n,0,0);
}



// This is memoization



int helper(int **input,int m,int n,int i,int j,int **arr)
{
    if(i>=m||j>=n)
        return INT_MAX;
    if(i==m-1&&j==n-1)
        return input[i][j];
    if(arr[i][j]!=-1)
        return arr[i][j];
    int a1=helper(input,m,n,i,j+1,arr);
    int a2=helper(input,m,n,i+1,j,arr);
    int a3=helper(input,m,n,i+1,j+1,arr);
    arr[i][j]=min(a1,min(a2,a3))+input[i][j];
    return arr[i][j];
}


-
int minCostPath(int **input, int m, int n)
{
    int **arr;
    arr = new int *[m+1];
	for (int i = 0; i <= m; i++)
	{
		arr[i] = new int[n+1];
	}
    for(int i=0;i<=m;i++)
    {
    	for(int j=0;j<=n;j++)
            arr[i][j]=-1;
    }
	return helper(input,m,n,0,0,arr);
}


//Now taking the solution through DP


int minCostPath(int **input,int m,int n)
{
    int **arr;
    arr=new int*[m+1];
    for(int i=0;i<=m;i++)
        arr[i]=new int[n+1];
     for(int i=0;i<=m;i++)
    {
    	for(int j=0;j<=n;j++)
            arr[i][j]=INT_MAX;
    }
    arr[m][n]=input[m-1][n-1];
    for(int i=m;i>=1;i--)
    {
        for(int j=n;j>=1;j--)
        {
            int a,b,c;
            a=b=c=INT_MAX;
            //Initially took them as infinity, As infinity represents the index is not valid,so u cannot go there, and its value will be updated if we can go to a particular index
            if(i+1<=m&&j+1<=n)
            {
                a=arr[i+1][j+1];
                b=arr[i][j+1];
                c=arr[i+1][j];
            }
            else if(i+1<=m)
            {
            	c=arr[i+1][j];
            }
            else if (j+1<=n)
            {
                b=arr[i][j+1];
            }
            //Reason of this if statement is that we are initializing arr[m][n] and we don't want to initialize again,further if we do it then we will get wrong answer,bcoz this is the value which we are using for other ones, but if we try to initialize it then there is no value to use for it,SO a,b,c all will be INT_MAX
            if(i==m&&j==n)
                continue;
            arr[i][j]=min(a,min(b,c))+input[i-1][j-1];
        }
    }
    return arr[1][1];
	
}