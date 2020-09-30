import java.util.*;

class RadixSort
{
    public static int random(int max, int min){
        return ((int) (Math.random()*(max - min))) + min; 
        }
    static int findMaximum(int a[], int n)
    {
        int p = a[0];
        for (int i = 1; i < n; i++)
            if (a[i] > p)
                p = a[i];
        return p;
    }

    static void sorting(int a[], int n, int x)
    {
        int oArray[] = new int[n]; 
        int count[] = new int[10];
        int i;
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (a[i]/x)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

       
        for (i = n - 1; i >= 0; i--)
        {
            oArray[count[ (a[i]/x)%10 ] - 1] = a[i];
            count[ (a[i]/x)%10 ]--;
        }

        for (i = 0; i < n; i++)
            a[i] = oArray[i];
    }

    static void radixSort(int a[], int n)
    {

        int z = findMaximum(a, n);

        for (int x = 1; z/x > 0; x *= 10)
            sorting(a, n, x);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int n;
        long a1=0,b1=0,c1=0;
        System.out.print(" size of the array : ");
        n = scan.nextInt();
        int[] increasingArray = new int[n];
        int[] decreasingArray = new int[n];
        int[] randomArray = new int[n];
        
        for(int i=0;i<n;i++)
        {
            increasingArray[i] = i;
            decreasingArray[i] = n-i;
            randomArray[i] = random(1,n);
        }

            int[] a = new int [n];
            int[] b = new int [n];
            int[] c = new int [n];

            int k=10;
            while(k>0)
            {
                for(int i = 0 ; i < n ; i++)
                {
                    a[i] = increasingArray[i];
                    b[i] = decreasingArray[i];
                    c[i] = randomArray[i];
                }

                 long startA = System.nanoTime();
                radixSort(a,n);        
                 long durationA = (System.nanoTime() - startA);

                 long startB = System.nanoTime();
                radixSort(b,n);        
                 long durationB = (System.nanoTime() - startB);

                 long startC = System.nanoTime();
                radixSort(c,n);        
                 long durationC = (System.nanoTime() - startC);
                 a1=a1+durationA;
                 b1=b1+durationB;
                 c1=c1+durationC;
                 
                System.out.println("The time required  for a[] is : " + durationA/1000 + " nanoseconds.");
                System.out.println("The time required  for b[] is : " + durationB/1000 + " nanoseconds.");
                System.out.println("The time required  for c[] is : " + durationC/1000 + " nanoseconds.");
                k--;
            }
            System.out.println("\n\n");
            System.out.println("The time required  for a[] is : " + a1/10000 + " nanoseconds.");
            System.out.println("The time required  for b[] is : " + b1/10000 + " nanoseconds.");
            System.out.println("The time required  for c[] is : " + c1/10000 + " nanoseconds.");
    }

}
