
//Using Memoization
long helper(int n,long *arr)
{
    if(n<=1)
        return 1;
    if(n==2)
        return 2;
    if(arr[n]!=-1)
        return arr[n];
    arr[n]= helper(n-1,arr)+helper(n-2,arr)+helper(n-3,arr);
    return arr[n];
}




long staircase(int n)
{
    long *arr=new long[n+1];
    for(int i=0;i<=n;i++)
        arr[i]=-1;
    return helper(n,arr);
	
}


//Using DP
long staircase(int n)
{
    long *arr=new long[n+1];
  	arr[0]=arr[1]=1;
    arr[2]=2;
    for(int i=3;i<=n;i++)
    {
        arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
    }	
    return arr[n];
}