import java.util.*;
public class QuickSort{

    static int divide(int a[], int low, int high) 
    { 
        int p = a[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (a[j] < p) 
            { 
                i++;               
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        }  
        int temp = a[i+1]; 
        a[i+1] = a[high]; 
        a[high] = temp; 
  
        return i+1; 
    } 
  
  
    
    static void quickSort(int a[], int low, int high) 
    { 
        if (low < high) 
        { 
            int q = divide(a, low, high); 
            quickSort(a, low, q-1); 
            quickSort(a, q+1, high); 
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
                quickSort(a1,0,n-1);        
                final long durationA = (System.nanoTime() - startTimeA);

                final long startTimeB = System.nanoTime();
                quickSort(b1,0,n-1);        
                final long durationB = (System.nanoTime() - startTimeB);

                final long startTimeC = System.nanoTime();
                quickSort(c1,0,n-1);        
                final long durationC = (System.nanoTime() - startTimeC);
                System.out.println("The time required for quick sort for a[] is : " + durationA + " nanoseconds.");
                System.out.println("The time required for quick sort for b[] is : " + durationB + " nanoseconds.");
                System.out.println("The time required for quick sort for c[] is : " + durationC + " nanoseconds.");
                System.out.println(" ");
            }
    }
}