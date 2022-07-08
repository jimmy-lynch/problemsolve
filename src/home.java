import java.lang.Math.*;

import static java.lang.Math.max;

public class home {

    public static void main(String args[]) {
        //answer is 7
        int[] testArr1 = new int[]{-1,2,-3,6,1};
        System.out.println(largestSubSum(testArr1));

        //answer is 2, 9
        int[] testArr2 = new int[]{5,3,2,6,9,4};
        int[] answer = largeSmall(testArr2);
        System.out.println(answer[0] + ", " + answer[1]);

        //missing 27
        int[] testArr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
        System.out.println(missingNum(testArr3));



    }


    public static int largestSubSum(int[] arr) {
        //big oh of n, utilizing kadane's algorithm
        int size = arr.length;
        int curr_max = 0;
        int max = 0;
        for(int x = 0; x < size; x++) {
            curr_max = max(arr[x],arr[x] + curr_max);
            if (curr_max > max) {
                max = curr_max;
            }
        }
        return max;
    }

    public static int[] largeSmall(int[] arr) {
        /*realistically should implement a sorting method, would probably select mergesort, utilized a mergesort algorithm from the internet,
        which I did slightly adjust, although I am incredibly familiar with sorting algorithms, implementation, and recursion to where I could come up with it
        on my own if needed*/

        mergeSort(arr, arr.length);
        int[] largeSmall = new int[] {arr[0], arr[arr.length - 1]};
        return largeSmall;
    }

    public static void mergeSort(int[] a, int n) {
        //saying if the amount of items within is < 2, return.
        if (n < 2) {
            return;
        }
        int middle = n / 2;
        // left array
        int[] left = new int[middle];
        // right array
        int[] right = new int[n - middle];

        //left
        for (int i = 0; i < middle; i++) {
            //putting items into the left array
            left[i] = a[i];
        }

        //right
        for (int i = middle; i < n; i++) {
            //putting items into the right array
            right[i - middle] = a[i];
        }

        mergeSort(left, middle);
        mergeSort(right, n - middle);

        //combine the two
        int x = 0;
        int y = 0;
        int z = 0;
        while (x < middle && y < n - middle) {
            if (left[x] <= right[y]) {
                a[z++] = left[x++];
            } else {
                a[z++] = right[y++];
            }
        }
        while (x < middle) {
            a[z++] = left[x++];
        }
        while (y < n - middle) {
            a[z++] = right[y++];
        }
    }

    public static int missingNum(int[] arr) {
        //may not be the most efficient answer, Big o of n, a more comprehensive binary sort would pribably be more efficeint.
        //assuming sorted

        for(int x = 0; x <= 100; x++) {
            if (x+1 != arr[x]) {
                return x + 1;
            }
        }
        //failsafe if there is actually no missing number
        return 0;
    }
}

/*
Task 1: Given an integer array, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum?

Task 2: How do you find the largest and smallest number in an unsorted integer array?

Task3: How do you find the missing number in a given integer array of 1 to 100?
 */
