#include<bits/stdc++.h>
using namespace std;

//This is brute force
int countMinStepsToOne(int n)
{
	if(n<=1)
        return 0;
    int a=countMinStepsToOne(n-1)+1;
    int b=INT_MAX;
    if(n%2==0)
        b=countMinStepsToOne(n/2)+1;
    a=min(a,b);
    int c=INT_MAX;
    if(n%3==0)
        c=countMinStepsToOne(n/3)+1;
    a=min(a,c);
    return a;
}

//This is memoization
int helper(int n,int *arr)
{
    if(n==1)
        return 0;
    if(arr[n]!=-1)
        return arr[n];
    int a=helper(n-1,arr)+1;
    int b=INT_MAX;
    if(n%2==0)
        b=helper(n/2,arr)+1;
    a=min(a,b);
    int c=INT_MAX;
    if(n%3==0)
        c=helper(n/3,arr)+1;
    arr[n]=min(a,c);
    return arr[n];
}
int countMinStepsToOne(int n)
{
    int *arr=new int[n+1];
    for(int i=0;i<n+1;i++)
        arr[i]=-1;
   return helper(n,arr);
}



//This is DP
int countStepsToOne(int n)
{
	int *arr=new int[n+1];
    arr[0]=0;
    arr[1]=0;
    arr[2]=1;
    for(int i=3;i<=n;i++)
    {
        int a=arr[i-1];
        int b=INT_MAX;
        if(i%2==0)
            b=arr[i/2];
        a=min(a,b);
        int c=INT_MAX;
        if(i%3==0)
            c=arr[i/3];
        arr[i]=min(a,c)+1;
    }
    return arr[n];
    
}