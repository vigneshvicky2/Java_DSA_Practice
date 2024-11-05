import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class largest_digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scanner.nextInt(); 
        Integer[] arr = new Integer[length(n)];
        int arr_len = length(n);
        int num_conv=0;
        for(int i = arr_len-1;i>=0;i--){
            arr[i] = n%10;
            n = n/10;
        }
        Arrays.sort(arr,Collections.reverseOrder());

        for(int i = 0;i<arr_len;i++){
            //System.out.println(arr[i]);
            num_conv = num_conv * 10 + arr[i]; 
        }
    
        // for (int number : arr) {
        //     //num_conv = num_conv * 10 + number; 
        //     System.out.println(arr[number]);
        // }
        System.out.println("Largest number:\n54554"+num_conv);
    }
    public static int length(int number) {
        if (number == 0) return 1; 
        return (int) Math.log10(Math.abs(number)) + 1; 
    }
}
