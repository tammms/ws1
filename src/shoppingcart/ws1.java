package shoppingcart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ws1{
    public static void main(String[] args){

        //Console cons = System.console();
        System.out.println("Welcome to your shopping cart");

        List<String> supermarket = new LinkedList<>();
        Scanner input = new Scanner(System.in);
    
        boolean userinput = true;
        while(userinput){
            String inputList = input.nextLine();
            inputList = inputList.trim().toLowerCase();
            String[] splitItem = inputList.split("\\W+");

            if(splitItem[0].equals("list")){
                if(supermarket.size() == 0){
                    System.out.println("Your cart is empty");
                }
                else{
                for(int i = 0; i<supermarket.size(); i++){
                    System.out.printf((i+1) + ". "+ supermarket.get(i) +"\n");
                }
                } 
            }

            else if(splitItem[0].equals("add")){
                for(int i = 1; i<splitItem.length; i++){
                    boolean itemExists = false;
                    for(int j = 0; j<supermarket.size(); j++){
                        if((splitItem[i]).equals(supermarket.get(j))){
                            System.out.printf("you have %s in your cart \n", splitItem[i]);
                            itemExists = true;
                            break;
                        }
                        
                    }
                    if(!itemExists){ // to check if condition is not true
                    supermarket.add(splitItem[i]);
                    System.out.printf("%s added to cart \n",splitItem[i]);
                }
                }
            }
            else if(splitItem[0].equals("delete")){
                Integer deleteIndex = Integer.parseInt(splitItem[1]);
                if((deleteIndex -1) <= supermarket.size()){

                    System.out.printf("%s removed from cart",supermarket.get(deleteIndex-1));
                    supermarket.remove(deleteIndex-1);
                }
                else System.out.println("Incorrect item index");
            }
            else {System.out.println("start command with Add or Delete or list");}




    }
}}