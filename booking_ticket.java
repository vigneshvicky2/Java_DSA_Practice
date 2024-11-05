import java.util.Scanner;

class booking_ticket{
    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter No tickets of you want ");
        int quant = scanner.nextInt();
        int[] age = new int[quant];
        System.out.println("Enter the age if all age are same or If different Enter 0 ");
        int des = scanner.nextInt();
        if(des>0){
            if(des>60){
                sum = quant*30;
        }
        else if(des<12){
            sum = quant*20;
        }
        else{
            sum =quant*60;
        }
        }
        else{
            for (int i = 0; i < quant; i++) {
                System.out.println("Enter Age of Person " + (i+1));
                age[i] = scanner.nextInt();
                if(age[i]>60){
                        sum +=30;
                }
                else if(age[i]<12){
                    sum += 20;
                }
                else{
                    sum +=60;
                }
            }
        }
        
        System.out.println("Total Price "+sum);
    }
}