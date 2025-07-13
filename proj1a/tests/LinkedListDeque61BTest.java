import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

    private LinkedListDeque61B<Integer> list;

    @Test
     /** In this test, we have three different assert statements that verify that addFirst works correctly. */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         assertThat(lld1.toList()).isEmpty();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         lld1.addFirst("aaa");
         assertThat(lld1.toList()).containsExactly("aaa","front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
     }

     @Test
     /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();
         assertThat(lld1.toList()).isEmpty();
         lld1.addLast("front"); // after this call we expect: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** This test performs interspersed addFirst and addLast calls. */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

    // Below, you'll write your own tests for LinkedListDeque61B.

    @Test
    public void textIsEmpty(){
         Deque61B<Integer>  list=new LinkedListDeque61B<>() ;
         assertThat(list.isEmpty()).isTrue();
         list.addFirst(1);
         list.addFirst(2);
         assertThat(list.toList()).containsExactly(2,1).inOrder();
    }

    @Test
    public void textSize(){
        LinkedListDeque61B<Integer>  list=new LinkedListDeque61B<>() ;
        assertThat(list.size).isEqualTo(0);
        list.removeLast();
        assertThat(list.size).isEqualTo(0);
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(3);
        list.addLast(4);
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void textGet(){
         LinkedListDeque61B<Integer> list=new LinkedListDeque61B<>();
         list.addLast(1);
         assertThat(list.get(0)).isEqualTo(1);
         list.addLast(2);
         assertThat(list.get(3)).isNull();
         list.addLast(3);
         list.addFirst(4);
        assertThat(list.get(3)).isEqualTo(3);
    }

    @Test
    public void textGetRecursive(){
        LinkedListDeque61B<Integer> list=new LinkedListDeque61B<>();
        list.addLast(1);
        assertThat(list.getRecursive(0)).isEqualTo(1);
        list.addLast(2);
        assertThat(list.getRecursive(3)).isNull();
        list.addLast(3);
        list.addFirst(4);
        assertThat(list.getRecursive(3)).isEqualTo(3);
    }

    @Test
    public void textRemoveFirst(){
        LinkedListDeque61B<Integer> list=new LinkedListDeque61B<>();
        assertThat(list.removeLast()).isNull();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.removeFirst();
        assertThat(list.toList()).containsExactly(2,3,4,5,6,7,8);
        list.removeFirst();
        assertThat(list.toList()).containsExactly(3,4,5,6,7,8);
        list.addLast(8);
        list.removeFirst();
        assertThat(list.toList()).containsExactly(4,5,6,7,8,8);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        assertThat(list.toList()).isEmpty();
        list.addLast(1);
        list.addLast(2);//
        list.removeFirst();
        assertThat(list.toList()).containsExactly(2);
        list.removeFirst();
        assertThat(list.toList()).isEmpty();
    }

    @Test
    public void textRemoveLast(){
        LinkedListDeque61B<Integer> list=new LinkedListDeque61B<>();
        assertThat(list.removeLast()).isNull();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.removeLast();
        assertThat(list.toList()).containsExactly(1,2,3,4,5,6,7);
        list.removeLast();
        assertThat(list.toList()).containsExactly(1,2,3,4,5,6);
        list.addLast(8);
        list.removeLast();
        assertThat(list.toList()).containsExactly(1,2,3,4,5,6);
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        assertThat(list.toList()).isEmpty();
        list.addLast(1);
        list.addLast(2);
        list.removeLast();
        assertThat(list.toList()).containsExactly(1);
        list.removeLast();
        assertThat(list.toList()).isEmpty();
    }


}