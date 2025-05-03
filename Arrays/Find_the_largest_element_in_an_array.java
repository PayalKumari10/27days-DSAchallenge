// import java.util.*;

// class Solution { 
//     //Brute force approach to find the largest element in an array
//     //TC : O(N*log(N))    SC : O(n)
//     public static void main (String[] args) {
//         int arr1[] = {2,5,1,3,0};
//         System.out.println("Largest element in arr1: " + new Solution().largestElement(arr1));
//         int arr2[] = {8,10,5,7,9};
//         System.out.println("Largest element in arr2: " + new Solution().largestElement(arr2));
//     }
//     // Function to find the largest element in an array
//     public int largestElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length - 1];
//     }
// }




// Optimized approach to find the largest element in an array
//TC : O(N)    SC : O(1)

class Solution {
    public static void main(String args[]) {
        int arr1[] = {2,5,1,3,0};
        System.out.println("The Largest element in arr1 is: " + largestElement(arr1));
        int arr2[] = {8,10,5,7,9};
        System.out.println("The Largest element in arr2 is: " + largestElement(arr2));
           }

           public static int largestElement(int arr[]) {
            int max = arr[0]; // Initialize max to the first element of the array
         for(int i = 0; i< arr.length; i++) { // Start from the second element
             if(arr[i] > max) { // If the current element is greater than max
                 max = arr[i]; // Update max to the current element
             }
            }
              return max; // Return the largest element found
         }
    } 

    
