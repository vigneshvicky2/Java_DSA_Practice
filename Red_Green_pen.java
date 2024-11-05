import java.util.Scanner;
public class Red_Green_pen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of array ");
        int len_arr = scanner.nextInt();
        int count =0;
        int[] arr = new int[len_arr];
        for(int i=0;i<len_arr;i++){
            System.out.println("Enter Array value "+ (i+1) );
            arr[i] = scanner.nextInt();
        }
        for(int i =1;i<len_arr-1;i++){
            if(arr[i]%2==0){
                count +=1;
            }
        }
        System.out.println("No of times Green pen switched to Red Pen: "+count);
    }
}
