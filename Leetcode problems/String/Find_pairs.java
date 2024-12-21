// A company is organizing a fun game for its employees. N number of employees
// are participating in this game. Each employee can either compete in the game
// as an individual or as a pair with another employee. The task is to find the
// number of different ways in which N number of employees can be single or can
// be paired up.
// Condition:
// If the total count of employees is odd, then pairing is not allowed
// If the total count of employees is even, then employees can be single or
// can be paired up.
// Instructions:
// Each employee can be paired only once
// Each employee can only compete once
// Example1:
// input:
// 3 - no of employees
// out:
// 1
// exp:
// n=3 is odd number
// [1][2][3] all employees are single
// Example2:
// input:
// 4 - no of employees
// out:
// 10
// exp:
// n=4 is even number
// [1][2][3][4] all employees are single
// [1][2,3][4]
// [1][2][3,4]
// [1][3][2,4]
// [1,2][3][4]
// [1,2][3,4]
// [1,3][2][4]
// [1,4][2][3]
// [1,3][2,4]
// [1,4][2,3]
// Input Format:
// integer
// Output Format:
// Display the number of ways(integer)
// Constraints:
// 1<N<=10
// Sample Input 1:
// 3
// Sample Output 1:
// 1
// Sample Input 2:
// 4
// Sample Output 2:
// 10


class Find_pairs{
    public static int pairs(int n){
      if((n%2)==0){
        return (n*(n+1))/2;
      }
      else{
        return 1;
      }
      
    }
    public static void main(String[] args){
      int n =6;
      //int n=3;
      System.out.println(pairs(n));
      //System.out.println(pairs(3));
    }
  }