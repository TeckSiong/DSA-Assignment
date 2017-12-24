/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Client.ClockInClockOut;
import ADT.DelManADT;
import java.util.Scanner;

public class DMLogin {
    
    public static DelManADT<Domain.DeliveryMan> dList = new DelManADT<>();
    

    Scanner scan = new Scanner(System.in);
    public static String id;
    String psw;

    public void login() {
        System.out.println("====================================================");
        System.out.println("Login");
        System.out.println("Type 'exit' to main menu~");
        System.out.println("====================================================");
        System.out.print("Enter your ID       : ");
        id = scan.nextLine();
        int count = 0;
        if (!id.equals("exit")) {
            
            dList = DelManMaintain.dList;
            
            if(DelManMaintain.dList.isEmpty()){
                Domain.DeliveryMan.DeliveryMenDetails(); 
            }
            
            
            
            for (int i = 0; i < dList.getSize(); i++) {
                if (Integer.parseInt(id) == dList.getData(i).getDelmenId()) {
                    System.out.print("Enter your password : ");
                    psw = scan.nextLine();
                    count = 1;
                    if (psw.equals(dList.getData(i).getPassword())) {
                        if (dList.getData(i).getAcc().equals("Active")) {
                            System.out.println("");
                            System.out.println("Login Successful!");
                            System.out.println("");
                            ClockInClockOut cc = new ClockInClockOut();
                            cc.ClockInClockOut();
                            count = 1;
                            MainMenu mm = new MainMenu();
                            mm.MainMenu();
                            
                        } else {
                            System.out.println("");
                            System.out.println("Your Account has been Deactivate!");
                            System.out.println("");
                            MainMenu mm = new MainMenu();
                            mm.MainMenu();
                        }
                    }

                }
                if (count == 1) {
                    System.out.println("Invalid ID or Password!");
                    System.out.println("");
                    login();
                }
            }
        }
    }
}
