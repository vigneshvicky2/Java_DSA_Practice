// Next Largest Permutation

// Problem Statement:
// Given an array of integers representing a sequence of digits, find the next permutation of this sequence in lexicographically increasing order. If such a permutation is not possible, return the smallest permutation (sorted in ascending order).

// For example:

// Input: [1, 2, 3]

// Output: [1, 3, 2]

// Input: [3, 2, 1]

// Output: [1, 2, 3]

// Input: [1, 1, 5]

// Output: [1, 5, 1]

// Input Format:
// Input contains two line.
// First line of the input contains N value.
// Second line contains N number of array elements.
// Output Format:
// display the next Greatest permutation
// Constraints:
// The array nums must be modified in-place.
// The length of nums will be at least 1 and no longer than 10^4 .

// Sample Input 1:
// 3 1 2 3

// Sample Output 1:
// 1 3 2

// Sample Input 2:
// 9 1 5 8 4 7 6 5 3 1

// Sample Output 2:
// 1 5 8 5 1 3 4 6 7
  
  

class Next_permutaions {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);

        }
         reverse(nums,i+1);
    
        }
    public static  void swap(int nums[],int i,int j){
            int temp = nums[j];
            nums[j]=nums[i];
            nums[i]=temp;

    
        }
    public static void reverse(int nums[],int start){
            int end = nums.length-1;
            while(start<end){
            swap(nums, start, end);
            start++;
            end--;
            }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for(int i =0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}