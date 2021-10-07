// Binary Search in C++

#include <iostream>
using namespace std;

int binarySearch(int array[], int x, int low, int high) {
  if (high >= low) {
    int mid = low + (high - low) / 2;
    if (array[mid] == x)
      return mid;
    if (array[mid] > x)
      return binarySearch(array, x, low, mid - 1);
    return binarySearch(array, x, mid + 1, high);
  }

  return -1;
}

int main(void) {
  int len;
  cout<<"Enter Length of Array: "<<endl;
  cin>>len;
  int array[len];
    cout<<"Enter Elements of Array: "<<endl;
  for(int i =0; i<len;i++){
      cin>>array[i];
  }
  int x;
  cout<<"Enter the number you want to search: "<<endl;
  cin>>x;
  int n = sizeof(array) / sizeof(array[0]);
  int result = binarySearch(array, x, 0, n - 1);
  if (result == -1)
    printf("Not found");
  else
    printf("Element is found at index %d", result);
}