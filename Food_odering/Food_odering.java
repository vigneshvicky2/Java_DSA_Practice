import java.util.HashMap;
import java.util.Scanner;
public class Food_odering {
    public static void main(String[] args) {
        int pizza_price=200;
        int burger_price=180;
        int briyani_price=250;
        int dosa_price=80;
        int idly_price=50;
        int total_cost=0;
        double discont_price=0;
        String[] Food_name={"Pizza","Burger","Biriyani","Dosa","idly"};
        HashMap<String, Integer> Food_And_quant= new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Pizza: 200\n2.Burger: 180\n3.Biriyani: 250\n4.Dosa: 80\n5.Idly: 50");
        System.out.print("Enter how many of food you want to buy: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Number of the food : ");
            int key = scanner.nextInt();
            if(key<=5){
            System.out.print("Enter Quantity of the Food: ");
            int value = scanner.nextInt();
            if(key==1){
                Food_And_quant.put(Food_name[0], value);
            }
            else if(key==2){
                Food_And_quant.put(Food_name[1], value);
            }
            else if(key==3){
                Food_And_quant.put(Food_name[2], value);
            }
            else if(key==4){
                Food_And_quant.put(Food_name[3], value);
            }
            else{
                Food_And_quant.put(Food_name[4], value);
            }

            }
            else{
                System.out.println("Invalid Selection");
                break;
            } 
            
    
        }
        for(String food : Food_And_quant.keySet() ){
            int Quantity =Food_And_quant.get(food);
            int price = get_price(food);
            total_cost += price*Quantity;
        }
        System.out.println("Total Price "+total_cost);
        if(total_cost>500){
            System.out.println("you are eligible for 10% discount");
            System.out.println("Before discont "+total_cost);
            double diff = total_cost*0.10;
            discont_price =total_cost-diff;
            System.out.println("Discount amount"+diff);
            System.out.println("After 10% discount "+discont_price);
        }
        else{
            System.out.println("You are not eligible for discount");
        }

}
private static int get_price(String food_name){
    if (food_name.equals("Pizza")) {
        return 200;
    } else if (food_name.equals("Burger")) {
        return 180;
    } else if (food_name.equals("Biriyani")) {
        return 250;
    } else if (food_name.equals("Dosa")) {
        return 80;
    } else if (food_name.equals("Idly")) {
        return 50;
    } else {
        return 0; 
    }

}
}

