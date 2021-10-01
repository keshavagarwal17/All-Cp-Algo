    public class CocktailSort   
    {  
    static int temp;   
    static void Cocktail(int a[], int n)  
    {  
        boolean is_swapped = true;  
        int begin = 0,i;  
        int end = n - 1;  
       
        while (is_swapped) {  
            is_swapped = false;  
         for (i = begin; i < end; ++i) {  
                if (a[i] > a[i + 1]) {  
                temp = a[i];  
            a[i]=a[i+1];  
            a[i+1]=temp;                  
            is_swapped = true;  
                }  
            }  
     if (!is_swapped)  
                break;  
     is_swapped = false;  
     for (i = end - 1; i >= begin; --i) {  
         if (a[i] > a[i + 1])   
        {  
              temp = a[i];  
          a[i]=a[i+1];  
          a[i+1]=temp;  
          is_swapped = true;  
             }  
          }  
            ++begin;  
        }  
    }  
    public static void main(String[] args) {  
          
        int arr[] = {0, 10, 2, 8, 23, 1, 3, 45},i;  
        int n = arr.length;  
        Cocktail(arr, n);  
        System.out.println("printing sorted array :\n");  
         for (i = 0; i < n; i++)  
            System.out.print(arr[i]+" ");  
        System.out.println();  
        }  
    }  
