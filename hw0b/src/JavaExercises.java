import java.util.ArrayList;
import java.util.List;

public class JavaExercises {

    /**
     * Returns an array [1, 2, 3, 4, 5, 6]
     */
    public static int[] makeDice() {
        // TODO: Fill in this function.
        int[] arr={1,2,3,4,5,6};
        return arr;
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        // TODO: Fill in this function.
        if (customer=="Ergun"){
            String[] str={"beyti", "pizza", "hamburger", "tea"};
            return  str;
        }else if (customer=="Erik"){
            String[] str={"sushi", "pasta", "avocado", "coffee"};
            return  str;
        }
        String[] str={"","",""};
        return  str;
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        // TODO: Fill in this function.
        int min=1211222,max=-121212;
        for (int a:array){
            if (a<min){
                min=a;
            }
            if (a>max){
                max=a;
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
            x=x/2;
        }else{
            x=x*3+1;
        }
        return hailstoneHelper(x,list);
    }

}
