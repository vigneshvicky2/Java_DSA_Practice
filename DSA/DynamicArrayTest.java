import java.util.Scanner;
class DynamicArray{
     private int arr[];
     private int size;
     private int capacity;
     private static final int initial_capacity =16;
     DynamicArray(){
         size=0;
         arr = new int[initial_capacity];
         capacity=initial_capacity;
     }
    public void add(int val){
         if(size==capacity){
             expandArray();
         }
         arr[size]=val;
         size++;
    }
    private void expandArray(){
         capacity *=2;
         arr = java.util.Arrays.copyOf(arr,capacity);
    }
    public void display(){
        System.out.println("Element present in the list");
         for(int i =0; i<size;i++){
             if (i==0){
                 System.out.print("[" + arr[i] + " ");
             } else if (i==size-1) {
                 System.out.print(arr[i] + "]");
             }
             else {
                 System.out.print(arr[i] + " ");
             }
         }
    }
    public void insert(int val,int pos){
        if(size==capacity){
            expandArray();
        }
         for(int i=size-1;i>=pos;i--){
             arr[i-1]=arr[i];
         }
        arr[pos]= val;
        size++;
    }
    public void delete(int pos){
        for(int i=pos+1;i<size;i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        if (capacity > initial_capacity && capacity > 3*size){
            shrinkarr();
        }
    }
    public void deleteAtEnd(){
        for(int i=size-1;i<size;i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        if (capacity > initial_capacity && capacity > 3*size){
            shrinkarr();
        }
    }
    public void deleteAtbegining(){
        for(int i=1;i<size;i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        if (capacity > initial_capacity && capacity > 3*size){
            shrinkarr();
        }
    }
    public void find_index(int val){
         int ind= -1;
         for(int i =0; i<size;i++){
             if(arr[i]==val){
                 ind = i;
             }
         }
        if(ind>0){
            System.out.println("Element found at index " + ind);
        }
        else{
            System.out.println("Element not found");
        }

    }
    public void is_elemnt_present(int val){
        int ind= -1;
        for(int i =0; i<size;i++){
            if(arr[i]==val){
                ind = i;
            }
        }
        if(ind>0){
            System.out.println("Element present in Array");
        }
        else{
            System.out.println("Element not present in array");
        }
    }
    public void reset(){
        size=0;
    }

    private void shrinkarr(){
         capacity /=2;
         arr = java.util.Arrays.copyOf(arr,capacity);
    }

}

public class DynamicArrayTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pos, val;
        DynamicArray list = new DynamicArray();
        boolean show_menu = true;
        String response;
        do {
                System.out.println("\n~~~~~~~~~ List Menu ~~~~~~~~~");
                System.out.println("1. Insert at End");
                System.out.println("2. Display the List");
                System.out.println("3. Insert at Specific Position");
                System.out.println("4. Delete from Specific Position");
                System.out.println("5. Delete at End");
                System.out.println("6. Delete from beginning");
                System.out.println("7. Show index of elemet");
                System.out.println("8. Is value present?");
                System.out.println("9. Reset array");
                System.out.println("10.Exit");
                System.out.print("Enter your choice (1-10): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Option 1 selected: Insert at End");
                        System.out.println("Enter value: ");
                        val = scanner.nextInt();
                        list.add(val);
                        break;
                    case 2:
                        System.out.println("Option 2 selected: Display the List");
                        list.display();
                        break;
                    case 3:
                        System.out.println("Option 3 selected: Insert at Specific Position");
                        System.out.println("Enter value: ");
                        val = scanner.nextInt();
                        System.out.println("Enter position(starts from 0): ");
                        pos = scanner.nextInt();
                        list.insert(val, pos);
                        break;
                    case 4:
                        System.out.println("Option 4 selected: Delete from Specific Position");
                        System.out.println("Enter position(starts from 0): ");
                        pos = scanner.nextInt();
                        list.delete(pos);
                        break;
                    case 5:
                        System.out.println("Option 5 selected: Delete Element at End");
                        list.deleteAtEnd();
                        break;
                    case 6:
                        System.out.println("Option 6 selected: Delete from beginning");
                        list.deleteAtbegining();
                        break;
                    case 7:
                        System.out.println("Option 7 selected: Show index of elemet");
                        System.out.println("Enter value: ");
                        val = scanner.nextInt();
                        list.find_index(val);
                        break;
                    case 8:
                        System.out.println("Option 8 selected: Is value present");
                        System.out.println("Enter value: ");
                        val = scanner.nextInt();
                        list.is_elemnt_present(val);
                        break;
                    case 9:
                        System.out.println("Option 9 selected: Reset array");
                        list.reset();
                        break;
                    case 10:
                        System.out.println("Exiting the program. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            System.out.println();
            System.out.println("Do you want to display the menu again? (yes:1/no:0): ");
            response = scanner.next();
            } while (response.equalsIgnoreCase("1"));
            System.out.println("Exiting the program. Goodbye!");
            scanner.close();
        }
    }

