import java.util.Arrays;
import java.util.HashMap;

public class FindOriginalArray {
    public static void main(String[] args) {
        int[] arr = {2,4,1,8,3,9,5,10};

        for(int num:findOriginalArray(arr)){
            System.out.println(num);
        }
    }
    
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(changed);
        int[] original = new int[n / 2];
        int index = 0;

        for (int num : changed) {
            if (countMap.get(num) == 0) {
                continue;
            }

            if (countMap.getOrDefault(num * 2, 0) == 0) {
                return new int[0]; 
            }
            original[index++] = num;
            countMap.put(num, countMap.get(num) - 1);
            countMap.put(num * 2, countMap.get(num * 2) - 1);
        }
        return original;
    }
}