/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.util.*;
import Java.MainMenu;
import Domain.custinfo;
import ADT.ADTOrder;
import ADT.OrderInterface;

/*
import static Java.getPhone.custinfo;*/

/**
 *
 * @author User
 */
public class custLogin {

    public Scanner scan = new Scanner(System.in);

    public static ADTOrder<custinfo> custinfo = new ADTOrder<>();

    public void Login() {

        String choose;
        do {
            System.out.println("Login or Registration Restaurant? 1. Registration 2.Login 3.Exit");
            choose = scan.nextLine();
            if (choose.equals("1")) {
                register();
                Login();
            } else if (choose.equals("2")) {
                boolean login = false;

                System.out.println("Login Page");
                System.out.println("==========");
                System.out.print("Please input a ID       : ");
                String ID = scan.nextLine();
                System.out.print("Please input a Password : ");
                String pass = scan.nextLine();
                /*
                System.out.print(custinfo.getEntry(0).getId() + "  "+ custinfo.getEntry(0).getpass());
                System.out.print(ID + pass);
                 */
                try {
                    for (int i = 0; i <= custinfo.getSize(); i++) {

                        if (ID.equals(custinfo.getEntry(i).getId()) && pass.equals(custinfo.getEntry(i).getpass())) {

                            System.out.println("\n\n\n======Login Sucessfully======");

                            MainMenu f = new MainMenu();
                            f.customer();

                            login = true;

                        }

                    }
                } catch (Exception ex) {

                    System.out.println("\n\n\nID and password entered is not registered");

                }

                if (login == false) {

                    System.out.println("Login Failed, Password or ID Invalid");

                    Login();
                }
            } else if (choose.equals("3")) {
                MainMenu m = new MainMenu();
                m.MainMenu();
            } else {
                System.out.println("Invalid Input");
            }
        } while (!choose.equals("1") && !choose.equals("3") && !choose.equals("2"));

    }

    public void register() {

        System.out.println("\n\n\n------Register new customer account------\n\n\n");

        String name = "";
        do {
            System.out.print("Kindly key in your Name : ");
            name = scan.nextLine();
            if (name.isEmpty()) {
                System.out.println("Invalid name...");
            }
        } while (name.isEmpty());

        String ph = "";
        do {
            System.out.print("Kindly enter Phone No : ");
            ph = scan.nextLine();
            if (ph.isEmpty()) {
                System.out.println("Invalid phone number......");
            }
        } while (ph.isEmpty());

        String gen = "";
        do {
            System.out.print("Kindly enter your gender (M/F)  : ");
            gen = scan.nextLine();
            if (gen.isEmpty()) {
                System.out.println("Invalid input......");
            }
        } while (gen.isEmpty());

        String addr = "";
        do {
            System.out.print("Enter your address  : ");
            addr = scan.nextLine();
            if (addr.isEmpty()) {
                System.out.println("Invalid input......");
            }
        } while (addr.isEmpty());

        String idd = "";
        do {
            System.out.print("Enter your Account ID : ");
            idd = scan.nextLine();
            if (idd.isEmpty()) {
                System.out.println("Invalid input......");
            }
        } while (idd.isEmpty());

        String pass = "";
        do {
            System.out.print("Enter your password : ");
            pass = scan.nextLine();
            if (pass.isEmpty()) {
                System.out.println("Invalid input......");
            }
        } while (pass.isEmpty());

        custinfo cust = new custinfo(idd, pass, name, ph, gen, addr);
        custinfo.add(cust);

        System.out.println("\n\n\n------Account Registered------\n\n\n");

        System.out.println("---Account Information---");
        System.out.println("ID          :" + idd);
        System.out.println("Password    :" + pass);
        System.out.println("Name        :" + name);
        System.out.println("Phone No    :" + ph);
        System.out.println("Gender      :" + gen);
        System.out.println("Address     :" + addr);

        System.out.println("\nPress any key to continue");

        scan.nextLine();

    }

    public void getno() {

        boolean state = false;

        System.out.println("\n\n\n======DeliveryMan - get customer details...\n\n\n");

        System.out.print("Kindly enter customer phone number   :");
        String ph = scan.nextLine();

        try {
            for (int i = 0; i <= custinfo.getSize(); i++) {

                if (ph.equals(custinfo.getEntry(i).getphone())) {

                    System.out.println("Name        :" + custinfo.getEntry(i).getname());
                    System.out.println("Phone No    :" + custinfo.getEntry(i).getphone());
                    System.out.println("Gender      :" + custinfo.getEntry(i).getgender());
                    System.out.println("Address     :" + custinfo.getEntry(i).getaddress());

                    System.out.println("\nPress any key to continue");
                    scan.nextLine();

                    MainMenu go = new MainMenu();
                    go.deliveryman();

                    state = true;
                }
            }
        } catch (Exception ex) {

            System.out.println("\n\n\nPhone number doesn't exist");

        }

        if (state == false) {

            System.out.println("Invalid input......");
            System.out.println("Press any key to continue");
            scan.nextLine();

            MainMenu m = new MainMenu();
            m.deliveryman();

        }

    }

}
