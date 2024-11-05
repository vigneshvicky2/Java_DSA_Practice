import java.util.Scanner;

public class move_zero_to_last {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of array ");
        int len_arr = scanner.nextInt();
        int[] arr = new int[len_arr];
        int index =0;
        for(int i=0;i<len_arr;i++){
            System.out.println("Enter Array value "+ (i+1) );
            arr[i] = scanner.nextInt();
        }
        for(int i =0;i<len_arr;i++){
            if(arr[i]!=0){
                int temp_value =arr[i];
            arr[i]=arr[index];
            arr[index]=temp_value;
            index++;
            }
            
        }
        System.out.print("Modified Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
          
    }
}
