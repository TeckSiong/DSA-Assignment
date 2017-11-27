package Java;

import Java.Restaurant;
import java.util.Scanner;

/**
 *
 * @author Teck Siong
 */
public class MainMenu {
    UpdateSchedule u = new UpdateSchedule();
    Scanner scan = new Scanner(System.in);

    public void main() {
        System.out.println("===========================================");
        System.out.println("Your Current Status~");
        System.out.println("===========================================");
        System.out.println("1. Staff");
        System.out.println("2. Restaurant Owner");
        System.out.println("3. Customer");
        System.out.println("===========================================");
        System.out.println("");
        System.out.print("Please select your status : ");
        int ans = scan.nextInt();
        switch (ans) {
            case 1:
                System.out.println("");
                RegisterDelMen d = new RegisterDelMen();
                d.HRDeteils();
                break;

            case 2:
                System.out.println("");
                Restaurant r = new Restaurant();
                r.Login();
                break;

            case 3:
                System.out.println("");
                customer();
                break;

            default:
                System.out.println("Invalid Input [1/2/3]");
                System.out.println("");
                main();
                break;
        }
    }

    public void customer() {
        System.out.println("====================================================");
        System.out.println("Select Your Action~");
        System.out.println("====================================================");
        System.out.println("1. Make Schedule Order");
        System.out.println("2. Place Order");
        System.out.println("3. Update Schedule Order");
        System.out.println("0. Exit");
        System.out.println("====================================================");
        System.out.print("Enter Your Action : ");
        int s = scan.nextInt();
        scan.nextLine();
        switch (s) {
            case 1:
                System.out.println("");
                MakeSchedule q = new MakeSchedule();
                q.MakeScheduleOrder();
                customer();
                break;

            case 2:
                System.out.println("");
                FoodMenu f = new FoodMenu();
                f.displayMenu();
                break;
                
            case 3:
                System.out.println("");
                
                u.UpdateSchedule();
                customer();
                break;

            case 0:
                System.out.println("");
                MainMenu m = new MainMenu();
                m.main();
                break;

            default:
                System.out.println("Invalid Input [1/2]");
                System.out.println("");
                customer();
                break;
        }
    }

    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        m.main();
    }
}
