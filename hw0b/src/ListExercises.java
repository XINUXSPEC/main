import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        if (L.isEmpty()){
            return  0;
        }
        int total=0;
        for (int i = 0; i < L.size(); i++) {
            total+=L.get(i);
        }
        return  total;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> even=new ArrayList<>(L.size()) ;
        for (int i = 0; i < L.size(); i++) {
            if (L.get(i)%2==0){
                even.add(L.get(i));
            }
        }
        return even;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        if (L1.isEmpty()||L2.isEmpty()){
            return  new ArrayList<Integer>();
        }
        List<Integer> CommonItem=new ArrayList<Integer>(Math.min(L1.size(),L2.size()));
        int len1=L1.size(),len2=L2.size();

        for (int i = 0; i <L1.size() ; i++) {
            for (int j = 0; j < L2.size(); j++) {
                if (L1.get(i).equals(L2.get(j))){
                    CommonItem.add(L1.get(i));
                }
            }
        }   

        return CommonItem;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int i=0,count=0,len=words.size();
        while (i<len){
            String s=words.get(i);
            int len1=s.length();
            for (int j = 0; j < len1; j++) {
                if (words.get(i).charAt(j)==c){
                    count++;
                }
            }
            i++;
        }
        return count;
    }
}
