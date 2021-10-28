package com.company;

import java.util.Arrays;

//Best Time Complexity N
//Worst time complexity N^2

public class Bubble_sort {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {1,3,2,5,4};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr){
        //run the steps n-1 times
        int count = 0 ;// count for how many times the array will get swapped before getting completely sorted
        for(int i = 0; i<arr.length; i++)
        {
            boolean swapped = false;
            //for each step, the max element will come at the last respective index
            for(int j = 1; j< arr.length - i; j++)
            {

                if(arr[j-1] > arr[j])
                {
                    //swap if the current item is smaller than the previous item
                    int swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                    swapped = true;
                }
            }
            count++;// you can also take value of i+1 instead of creating a new variable it will give same answer

            //it will check or every j and for i = 0(for an already sorted array)
            if(swapped == false){
                // means if the value remained false... it never gone inside the loop of j means the
                //array is already sorted and when it will go to increment i then
                // because of this condition the program will end

                // the condition will execute at every time the array gets sorted
                System.out.println(i+1);//this is for count
                break;
            }

        }


    }
}
