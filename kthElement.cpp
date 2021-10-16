// K-th element of two sorted Arrays 

/* Question - Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array. */
#include <bits/stdc++.h>
using namespace std;

int kthElement(int arr1[], int arr2[], int n, int m, int k)
    {
        int i=0,j=0,l=1;
        
        while(i<n && j<m)
        {
            if(arr1[i] < arr2[j])
            {
                if(k==l)
                return arr1[i];
                l++;
                i++;
            }
            else if(arr1[i] > arr2[j])
            {
                if(k==l)
                return arr2[j];
                j++;
                l++;
            }
            else
            {

                if(k==l)
                return arr1[i];
                
                if(k==l+1)
                return arr1[i];
                
                i++;
                j++;
                l+=2;
            }
        } 
        while(i<n)
        {
            if(k==l)
            return arr1[i];
            
            i++;
            l++;
        }
        while(j<m)
        {
            if(k==l)
            return arr2[j];
            
            j++;
            l++;
        }
        
        return -1;
    }

int main()
{
    int arr1[] = {2, 3, 6, 7, 9};
    int arr2[] = {1, 4, 8, 10};
    cout << (kthElement(arr1,arr2,5,4,5)) << endl;

    return 0;
}
