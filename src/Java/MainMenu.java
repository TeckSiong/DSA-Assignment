package Java;

import Domain.Restaurant;
import java.util.Scanner;

/**
 *
 * @author Teck Siong
 */
public class MainMenu {

    Scanner scan = new Scanner(System.in);
    
    public void main(){
        System.out.println("===========================================");
        System.out.println("Your Current Status~");
        System.out.println("===========================================");
        System.out.println("1. HR Executive");
        System.out.println("2. Restaurant Owner");
        System.out.println("3. Customer");
        System.out.println("===========================================");
        System.out.println("");
        System.out.print("Please select your status : ");
        int ans = scan.nextInt();
        switch(ans){
            case 1:
                System.out.println("");
                RegisterDelMen d = new RegisterDelMen();
                d.menu();
                break;
                
            case 2:
                System.out.println("");
                Restaurant r = new Restaurant();
                r.Login();
                break;
                
            case 3 :
                System.out.println("");
                break;
                
            default:
                System.out.println("Invalid Input [1/2/3]");
                System.out.println("");
                main();
                break;
        }
    }
    
    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        m.main();
    }
}
