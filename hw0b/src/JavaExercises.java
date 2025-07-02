import java.util.ArrayList;
import java.util.List;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        // TODO: Fill in this function.
        return new int[]{1,2,3,4,5,6};
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        // TODO: Fill in this function.
        if (customer.equals("Ergun")){
            String[] s={"beyti", "pizza", "hamburger", "tea"};
            return  s;
        }else if (customer.equals("Erik")){
            String[] s={"sushi", "pasta", "avocado", "coffee"};
            return  s;
        }else{
            String[] s=new String[3];
            return  s;
        }
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        // TODO: Fill in this function.
        int max,min;
        max=-12921;
        min=12121;
        for (int i = 0; i < array.length; i++) {
            if (max<array[i]){
                max=array[i];
            }
            if (min>array[i]){
                min=array[i];
            }
        }
        return max-min;
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        // TODO: Fill in this function.
        list.add(x);
        if (x==1){
            return list;
        }
        if (x%2==0){
            return  hailstoneHelper(x/2,list);
        }
        return  hailstoneHelper(x*3+1,list);
    }

}
