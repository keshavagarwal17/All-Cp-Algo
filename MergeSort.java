import java.util.*;

public class MergeSort{
    public static void mergesort(int p,int q,int [] arr)
    {
        if(p<q)
        {
            int k=(p+q)/2;
            mergesort(p,k,arr);
            mergesort(k+1,q,arr);
            merge(arr,p,k,q);

        }
    }
    public static void merge(int [] arr,int p,int k,int q)
    {
        int n1=k-p+2;
        int n2=q-k+1;
        int []l1=new int [n1];
        int []l2=new int [n2];
        l1[n1-1]=Integer.MAX_VALUE;
        l2[n2-1]=Integer.MAX_VALUE;
        for(int i=0;i<n1-1;i++)
        {
            l1[i]=arr[i+p];
        }
        for(int i=0;i<n2-1;i++)
        {
            l2[i]=arr[i+k+1];
        }
        int i=0,j=0;
        for(int b=p;b<=q;b++)
        {
            if(l1[i]<=l2[j])
            {
                arr[b]=l1[i];
                i++;
            }
            else
            {
                arr[b]=l2[j];
                j++;
            }
        }
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int n;
        System.out.print("Enter the size of the array : ");
        n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int r = 3*n;
        for(int i=0;i<n;i++)
        {
            a[i] = i;
            b[i] = n-i;
            c[i] = rand.nextInt(r);
        }

            int[] a1 = new int [n];
            int[] b1 = new int [n];
            int[] c1 = new int [n];

            for(int j = 0 ; j < 15 ; j++)
            {
                for(int i = 0 ; i < n ; i++)
                {
                    a1[i] = a[i];
                    b1[i] = b[i];
                    c1[i] = c[i];
                }

                final long startTimeA = System.nanoTime();
                mergesort(0,n-1,a1);        
                final long durationA = (System.nanoTime() - startTimeA);

                final long startTimeB = System.nanoTime();
                mergesort(0,n-1,b1);        
                final long durationB = (System.nanoTime() - startTimeB);

                final long startTimeC = System.nanoTime();
                mergesort(0,n-1,c1);        
                final long durationC = (System.nanoTime() - startTimeC);
                System.out.println("The time required for merge sort for a[] is : " + durationA + " nanoseconds.");
                System.out.println("The time required for merge sort for b[] is : " + durationB + " nanoseconds.");
                System.out.println("The time required for merge sort for c[] is : " + durationC + " nanoseconds.");
                System.out.println(" ");
            }
    }
}
