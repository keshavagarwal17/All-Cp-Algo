import java.io.*;
import java.util.*;
class pages {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]a,int n,int m)
    { if(n<m)
    return -1;
      int  sum = 0;
      for(int i = 0;i<n;i++)
      sum += a[i];
      int s = 0,e = sum;
      int res = 0;
      while(s<=e)
      { 
        int mid = s+(e-s)/2;
        if(possible(a,n,m,mid))
        {
           res = mid;
           e = mid-1;
        }
        else
        s = mid+1;
      }
      return res;
    }
    public static boolean possible(int a[],int n,int m,int mid)
    { int s = 1;
    int sum = 0;
    for(int i = 0;i<n;i++)
    {
        if(a[i]>mid)
        return false;
        if(sum+a[i]>mid)
        { s++;
            sum = a[i];
            if(s>m)
            return false;
        }
        else
        sum+= a[i];
    }
    
    return true;    
    }
};