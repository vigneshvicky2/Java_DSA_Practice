// Problem Statement

// Given an array of integers, count the number of smaller elements that appear to the right of each element. Implement a solution using merge sort to efficiently count these elements. Output the result as an array of counts corresponding to each element in the original array.

// Example

// Input:

// 4

// 5 2 6 1

// Output: 

// 2 1 1 0 


// ﻿Explanation:

// To the right of 5, there are 2 smaller elements (2 and 1).

// To the right of 2, there is only 1 smaller element (1).

// To the right of 6, there is 1 smaller element (1).

// To the right of 1, there is 0 smaller element.

// Input format :
// The first line of input contains a single integer n, representing the length of the array.

// The second line contains n space-separated integers, representing the elements of the array.

// Output format :
// The output prints a single line containing the counts of smaller elements for each value in the array, separated by a space.



// Refer to the sample output for formatting specifications.

// Code constraints :
// The given test cases fall under the following specifications:

// 1 ≤ n ≤ 20

// -100 ≤ elements ≤ 100

// Sample test cases :
// Input 1 :
// 4
// 5 2 6 1
// Output 1 :
// 2 1 1 0 
// Input 2 :
// 2
// -1 -1
// Output 2 :
// 0 0 

import java.util.Scanner;

public class Day7 {

    static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if (n == 0) return result;
        mergeSort(nums, result, 0, n - 1);
        return result;
    }

    // Modified merge sort to count smaller elements on the right
    static void mergeSort(int[] nums, int[] result, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSort(nums, result, left, mid);
        mergeSort(nums, result, mid + 1, right);
        merge(nums, result, left, mid, right);
    }

    // Merge step with counting
    static void merge(int[] nums, int[] result, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = nums[mid + 1 + i];
        }
        
        int i = 0, j = 0, k = left;
        int rightCount = 0;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                result[left + i] += rightCount;
                nums[k] = leftArr[i];
                i++;
            } else {
                rightCount++;
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArr[] if any
        while (i < n1) {
            result[left + i] += rightCount;
            nums[k] = leftArr[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArr[] if any
        while (j < n2) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int[] result = countSmaller(nums);
        
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        
        scanner.close();
    }
}
