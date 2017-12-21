/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import ADT.MainMenuADT;
import java.util.Scanner;

/**
 *
 * @author Teck Siong
 */
public class MainMenu {

    public static MainMenuADT<Domain.HRExecutive> hList = new MainMenuADT<>();
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
        System.out.println("");
        System.out.print("Please select your status : ");
        String status = scan.nextLine();
        switch (status) {
            case "1":
                addStaff();
                break;

            case "2":
                System.out.println("");
                DelManMaintain r = new DelManMaintain();
                r.updDelMan();
                break;

            case "4":
                System.out.println("");
                DMLogin dm = new DMLogin();
                dm.login();
                break;

        }
    }
    
    public void addStaff(){
        Domain.HRExecutive.HRStaffDetails();
        HRStaffLogin();
    }

    public void HRStaffLogin() {

            System.out.println("==================================================");
            System.out.println("Staff Login (e - exit)");
            System.out.println("==================================================");
            System.out.print("ID Number: ");
            id = scan.next();
            if (!id.equals("e")) {
                for (i = 0; i < hList.getSize(); i++) {
                    if (Integer.parseInt(id) == hList.getData(i).getHrID()) {
                        System.out.print("Enter your password : ");
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
        System.out.println("====================================================");
        System.out.println("Select Your Action~");
        System.out.println("====================================================");
        System.out.println("1. Register Delivery Men");
        System.out.println("2. Update Delivery Men Information");
        System.out.println("3. Assign Jobs");
        System.out.println("4. Get customer delivery information");
        System.out.println("5. Check Pending Delivery");
        System.out.println("6. Report");
        System.out.println("0. Exit");
        System.out.println("====================================================");
        System.out.print("Enter Your Action : ");
        String s = scan.nextLine();
        switch (s) {
            case "1":
                System.out.println("");
                dm.addInitial();
                break;

            case "2":
                System.out.println("");
                dm.updDelMan();
                break;

//            case 3:
//                System.out.println("");
//                TrackDeliveryStatus a = new TrackDeliveryStatus();
//                a.CheckStatus();
//                RegisterDelMen r = new RegisterDelMen();
//                r.menu();
//                break;
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
}
