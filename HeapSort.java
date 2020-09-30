import java.util.*;

class heapSort {
	public static void heapSort(int arr[]) 
    { 
        int n = arr.length;  
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 

        for (int i=n-1; i>0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, i, 0); 
        } 
    } 
  
    
    public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2;  
  
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            heapify(arr, n, largest); 
        } 
    } 
  
    
    public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
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
                heapSort(a1);        
                final long durationA = (System.nanoTime() - startTimeA);

                final long startTimeB = System.nanoTime();
                heapSort(b1);        
                final long durationB = (System.nanoTime() - startTimeB);

                final long startTimeC = System.nanoTime();
                heapSort(c1);        
                final long durationC = (System.nanoTime() - startTimeC);
                System.out.println("The time required for heapSort for a[] is : " + durationA + " nanoseconds.");
                System.out.println("The time required for heapSort for b[] is : " + durationB + " nanoseconds.");
                System.out.println("The time required for heapSort for c[] is : " + durationC + " nanoseconds.");
                System.out.println(" ");
            }
  	}
}