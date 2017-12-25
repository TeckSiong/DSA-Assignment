/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.DelManADT;
import ADT.DelManInterface;
import java.util.Scanner;

/**
 *
 * @author Teck Siong
 */
public class MainMenu {

    public static DelManInterface<Domain.HRExecutive> hList = new DelManADT<>();
    Scanner scan = new Scanner(System.in);
    String id, psw;
    int count = 1;
    int i;

    public void MainMenu() {
        System.out.println("==================================================");
        System.out.println("Your Current Status~");
        System.out.println("==================================================");
        System.out.println("1. Staff");
        System.out.println("2. Restaurant Owner");
        System.out.println("3. Customer");
        System.out.println("4. Delivey Men");
        System.out.println("==================================================");
        System.out.print("Please select your status : ");
        String status = scan.nextLine();
        System.out.println("");
        switch (status) {
            case "1":
                addStaff();
                break;

            case "2":
                System.out.println("");
                Restaurant r = new Restaurant();
                r.Login();
                break;

            case "3":
                System.out.println("");
                custLogin custL = new custLogin();
                custL.Login();
                break;

            case "4":
                System.out.println("");
                
                
                DMLogin dm = new DMLogin();
                dm.login();
                break;
                
            default:
                System.out.println("Invalid Input [1/2/3]");
                System.out.println("");
                MainMenu();
                break;

        }
    }

    public void addStaff() {
        Domain.HRExecutive.HRStaffDetails();
        HRStaffLogin();
    }

    public void HRStaffLogin() {

        System.out.println("==================================================");
        System.out.println("Staff Login (e - exit)");
        System.out.println("==================================================");
        System.out.print("ID Number     : ");
        id = scan.next();
        String id1 = id.toLowerCase();
        if (!id1.equals("e")) {
            for (i = 0; i < hList.getSize(); i++) {
                if (Integer.parseInt(id) == hList.getData(i).getHrID()) {
                    System.out.print("Password      : ");
                    psw = scan.next();
                    if (psw.equals(hList.getData(i).getHrPassword())) {
                        System.out.println("");
                        staffMenu();
                    }
                }
            }
            count = 1;
            if (count == 1) {
                System.out.println("Invalid ID or Password!");
                System.out.println("");
                HRStaffLogin();
            }

        } else {
            MainMenu();
        }

    }

    public void staffMenu() {
        DelManMaintain dm = new DelManMaintain();
        System.out.println("==================================================");
        System.out.println("Select Your Action~");
        System.out.println("==================================================");
        System.out.println("1. Register Delivery Men");
        System.out.println("2. Update Delivery Men Information");
        System.out.println("3. Assign Jobs");
        System.out.println("4. Get customer delivery information");
        System.out.println("5. Check Pending Delivery");
        System.out.println("6. Report");
        System.out.println("0. Exit");
        System.out.println("==================================================");
        System.out.print("Enter Your Action : ");
        String s = scan.next();
        switch (s) {
            case "1":
                System.out.println("");
                dm.addInitial();
                break;

            case "2":
                System.out.println("");
                dm.updDelMan();
                break;

            case "3":
                System.out.println("");
                AssignDeliverymen a = new AssignDeliverymen();
                a.AssignDM();
                staffMenu();
                break;
//
//            case 4:
//                System.out.println("");
//                getDelivery g = new getDelivery();
//                g.start();
//                break;
            case "5":
                dm.trackStatus();
                break;

            case "6":
                System.out.println("");
                dm.report();
                break;

            case "0":
                System.out.println("");
                MainMenu();
                break;

            default:
                System.out.println("Invalid Input");
                System.out.println("");
                staffMenu();
                break;
        }
    }

    public void customer() {
        System.out.println("====================================================");
        System.out.println("Select Your Action~");
        System.out.println("====================================================");
        System.out.println("1. Make Schedule Order");
        System.out.println("2. Place Order");
        System.out.println("3. Check order remaing time");
        System.out.println("0. Exit");
        System.out.println("====================================================");
        System.out.print("Enter Your Action : ");
        int s = scan.nextInt();
        scan.nextLine();
        switch (s) {
            
            case 1:
                System.out.println("");
                ScheduleOrder q = new ScheduleOrder();
                q.MakeScheduleOrder();
                customer();
                break;

            case 2:
                System.out.println("");
                foodOrder f = new foodOrder();
                f.order();
                break;
            
            case 3:
                System.out.println("");

                TrackOrderStatus a1 = new TrackOrderStatus();
                a1.OrderStatus();

                break;
            
            case 0:
                System.out.println("");

                MainMenu();
                break;

            default:
                System.out.println("Invalid Input [1/2]");
                System.out.println("");
                customer();
                break;
        }
    }

    public void deliveryman() {

        System.out.println("====================================================");
        System.out.println("Select Your Action~");
        System.out.println("====================================================");
        System.out.println("1. Get customer details");
        System.out.println("2. Get schedule delivery order");

        System.out.println("0. Exit");
        System.out.println("====================================================");
        System.out.print("Enter Your Action : ");
        int s = scan.nextInt();
        scan.nextLine();
        switch (s) {
            case 1:
                System.out.println("");
                custLogin dm = new custLogin();
                dm.getno();
                break;
                
            case 2:
                System.out.println("");
                ScheduleOrder test = new ScheduleOrder();
                
                test.viewTodayScheduleOrder();
                deliveryman();
                break;

            case 0:
                System.out.println("");
                MainMenu();
                break;

            default:
                System.out.println("Invalid Input [1/2]");
                System.out.println("");
                customer();
                break;
        }

    }
    
    public static void main(String[] args) {
        // TODO code application logic here1
        MainMenu m = new MainMenu();
        m.MainMenu();
    }
}
