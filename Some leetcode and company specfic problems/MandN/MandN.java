import java.util.Scanner;
class MandN{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1st Number ");
        int m = scanner.nextInt();
        System.out.println("Enter 2nd Number ");
        int n = scanner.nextInt();
        System.out.println(add(m,n));
        scanner.close();
}
public static int add(int m , int n) {
    
        int sum =0;
        if(m>n){
            return 0;
        }
        else{
            for(int i =m;i<=n;i++){
                sum +=i*i*i;
            }
        }
     return sum;
      
    }
}