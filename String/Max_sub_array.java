// Given an integer array nums, find the contiguous subarray (containing at least one number) that has the largest sum, and return its sum.
// For example:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The contiguous subarray [4,-1,2,1] has the largest sum = 6.
// Input: nums = [1]
// Output: 1
// Input: nums = [5,4,-1,7,8]
// Output: 23
// Input Format:
// Input contains two line.
// First line of the input contains N value.
// Second line contains N number of array elements.
// Output Format:
// display the maximum sum.
// Constraints:
// 1<= N <=100000
// -10^6<= arr[ele] <= 10^6
// Time Complexity: O(n)
// Space Complexity: O(1)
// Sample Input 1:
// 7
// 1 2 3 4 5 6 7
// Sample Output 1:
// 28
// Sample Input 2:
// 8
// 1 1 -4 -5 -7 -9 -11 1
// Sample Output 2:
// 2
  
class Max_sub_array {
    public static  int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            sum = sum + nums[i];
            if(max<sum){
                max = sum;
                 }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}