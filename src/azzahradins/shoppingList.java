package azzahradins;

import java.util.ArrayList;

public class shoppingList {
    static ArrayList<String> shopping = new ArrayList<>();
    public static void main(String[] args) {
        shopping.add("energy drinks");
        shopping.add("car");
        if(shopping.contains("carrot")){
            System.out.println("healthy boy");
        }else{
            System.out.println("not so healthy");
        }
    }
}
