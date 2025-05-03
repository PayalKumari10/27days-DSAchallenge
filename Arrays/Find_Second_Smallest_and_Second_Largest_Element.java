import java.util.Arrays;

class ArrayUtils {
    //Bruteforce approach to find second smallest and second largest element in an array
    //Time complexity: O(nlogn) due to sorting the array
    //Space complexity: O(1) as we are not using any extra space
    public static void getElements(int[] arr, int nums) {
        if(nums == 0 || nums == 1) {
            System.out.println(-1);
            System.out.println("");
            System.out.println(-1);
            System.out.println("\n");
            return;
        }

        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[nums-2];
        System.out.println("Second smallest is: " + small);
        System.out.println("Second largest is: " + large);
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 4, 6, 7, 5};
        int n = arr.length;
        getElements(arr, n);
    }
}



//Best approach to find second smallest and second largest element in an array
//Time complexity: O(n) as we are traversing the array only once
//Space complexity: O(1) as we are not using any extra space

