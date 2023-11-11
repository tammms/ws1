package shoppingcart;

import java.io.Console;
import java.util.LinkedList;

public class ShoppingCart{
    public static void main(String[] args) {

        System.out.println("Welcome to your shopping cart");
        LinkedList<String> supermarket = new LinkedList<>();
        boolean stop = false;

        while (!stop) {
            
            Console cons = System.console();
            String input = cons.readLine("\n>");
            
            input = input.trim().toLowerCase().replaceAll("[^\sa-zA-Z0-9]","");
            String[] inputArray = input.split(" ");

            

            switch (inputArray[0]) {
                case "add":

                boolean itemExists = false;
                for (int j =1; j<inputArray.length; j++){
                    for (int i =0; i<supermarket.size(); i++){
                        if(inputArray[j].equals(supermarket.get(i))){
                            System.out.printf("You already have %s in your cart", inputArray[j]);
                            itemExists = true;
                            break;
                        }

                    }

                    if(!itemExists){
                            supermarket.add(inputArray[j]);
                            System.out.printf("%s added to cart\n", inputArray[j]);

                        }}
                

                break;

                case "delete":
                if (inputArray.length>2){
                    System.out.println("Delete only 1 item each time");
                }
                else{
                    int deleteIndex;
                    deleteIndex = Integer.parseInt(inputArray[1]);
                    if(deleteIndex<= supermarket.size()){
                        System.out.printf("%s removed from cart", supermarket.get(deleteIndex-1));
                        supermarket.remove(deleteIndex-1);
                    }
                    else{
                        System.out.println("Incorrect item index");
                    }
                }
                    
                    break;
                
                case "list":
                
                if (supermarket.isEmpty()){
                    System.out.println("Your cart is empty");
                }
                else{
                    for(int i =0; i<supermarket.size(); i++){
                    System.out.println((i+1)+". " + supermarket.get(i));
                }
                }

                    break;

                case "stop":
                
                stop = true;

                break;

            
                default:
                System.out.println(

                """
                    \n Please start with the following:
                    1. list: to view items in cart
                    2. add: to add items to cart
                    3. delete: to delete items from cart\n
                                            """);
                    break;
            }

        
            
        }
        
        


    }
}

