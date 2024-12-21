import java.util.ArrayList;
import java.util.Collections;

public class Intersection_Array {
    public static void main(String[] args) {
        int[] num1={3,1,2,6,7,8};
        int[] num2={2,3,4,5,7,9};
        ArrayList<Integer> Fin_res = new ArrayList<Integer>(); 
        for(int i=0;i<num1.length;i++){
            for(int j=0;j<num2.length;j++){
                if(num1[i]==num2[j] && !Fin_res.contains(num1[i])){
                 Fin_res.add(num1[i]);
                }
            }

        }
        Collections.sort(Fin_res);
        System.out.println(Fin_res);

        }
    }
