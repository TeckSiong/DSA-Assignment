/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class getDelivery {
    
    Scanner scan = new Scanner(System.in);
    
    public void start(){
    
        String select ="";
        
        
       
        System.out.println("\n\n\nKindly key in the customer's contact number  (10-digit):");
        select = scan.nextLine();
        
        if(!select.matches("[1-9][0-9]{9,14}")){
            System.out.println("\n\n\n");
            System.out.println("=========Customer Details=========");
            System.out.println("Customer Name             : Mr.Ng"); 
            System.out.println("Phone number              : " + select); 
            System.out.println("Address                   : 156 Jalan Abdulah SuperMan 1/2, Kuala Lumpur "); 
            System.out.println("Total amount to pay   (RM): 136.90\n\n\n"); 
            
            
        }
        else
           System.out.println("\n\n\n\n !!! Incorrect Phone number !!! \n\n\n\n"); 
       
    
        
        MainMenu m = new MainMenu();
        m.main();
    }
    
}
