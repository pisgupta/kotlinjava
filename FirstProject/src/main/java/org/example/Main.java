package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    private int add(int i, int j) {
        return i + j;
    }

    private int sub(int i, int j) {
        return i - j;
    }

    private int mul(int i, int j) {
        return i * j;
    }

    private int div(int i, int j) {
        return i / j;
    }

    private int root(int i) {
        return i * i;
    }

    public boolean isNumberIsPrime(int num) {
        boolean flag = true;
        for (int i = 2; i < num; i++) {
            if (num % 2 == 0) {
                flag = false;
            }
        }
        return flag;
    }


    public void bubbleSortAscending() {
        int[] numbers = {5, 2, 8, 1, 9, 3};
        int n = numbers.length;
        int temp = 0;

        // Nested loops to compare and swap elements
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap if the current element is greater than the next element
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        // Display the sorted results
        System.out.println("Sorted numbers in ascending order:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    // Main function that coordinates the sorting
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Helper function to merge two subarrays
    private static void merge(int[] array, int left, int mid, int right) {
        // Calculate sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        Main m = new Main();
        System.out.println(m.add(10, 23));
        System.out.println(m.sub(10, 23));
        System.out.println(m.mul(10, 23));
        System.out.println(m.div(10, 10));
        System.out.println(m.root(55));
        System.out.println(m.isNumberIsPrime(11));
        m.bubbleSortAscending();

        int[] numbers = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array: " + Arrays.toString(numbers));

        // Call mergeSort on the entire array
        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted Array:   " + Arrays.toString(numbers));

    }
}