//Brust force /Optimal approach

import java.util.*;

public class Main {
  //O(n) time complexity and O(1) space complexity
    public static boolean isSorted(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 4, 3, 2, 1};

        System.out.println("Array 1 is sorted: " + isSorted(array1));
        System.out.println("Array 2 is sorted: " + isSorted(array2));
    }
}  

