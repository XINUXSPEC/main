import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: Fill in this function.
        Map<Character,Integer> map=new HashMap<>(26);
        for (int i = 0; i <26 ; i++) {
            map.put((Character)(char)('a'+i),i+1);
        }
        return map;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: Fill in this function.
        Map<Integer,Integer> map=new HashMap<Integer,Integer>(nums.size());
        int len=nums.size();
        for (int i = 0; i < len; i++) {
            int item=nums.get(i);
            map.put(item,item*item);
        }
        return map;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: Fill in this function.
        Map<String,Integer> map=new HashMap<String, Integer>(words.size());
        int len=words.size();

        for (int i = 0; i <words.size() ; i++) {
            if(map.get(words.get(i))==null){
                map.put(words.get(i),1);
            }else{
                map.put(words.get(i),map.get(words.get(i))+1) ;
            }
        }

        return map;
    }
}
