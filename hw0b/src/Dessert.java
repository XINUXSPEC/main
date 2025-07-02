import java.util.HashSet;

public class Dessert {

    int flavor,price;
    static int numDesserts;

    /*that prints the flavor and price of the dessert
    along with the total number of desserts created so far, separated by a space.*/
    public void printDessert(){
        System.out.println(flavor+" "+price+" "+numDesserts);
    }
    public Dessert(int flavor,int price){
        this.flavor=flavor;
        this.price=price;
        this.numDesserts++;
    }

    public static void main(String[] args){
        System.out.print("I love dessert!");
    }
}
