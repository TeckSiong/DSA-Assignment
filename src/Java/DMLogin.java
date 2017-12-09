/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.util.Scanner;

public class DMLogin {

    Scanner scan = new Scanner(System.in);
    String id;
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
            for (int i = 0; i < RegisterDelMen.ad.size(); i++) {
                if (Integer.parseInt(id) == RegisterDelMen.ad.get(i).getDelmenId()) {
                    System.out.print("Enter your password : ");
                    psw = scan.nextLine();
                    count = 1;
                    if (psw.equals(RegisterDelMen.ad.get(i).getPassword())) {
                        if (RegisterDelMen.ad.get(i).getAcc().equals("Active")) {
                            System.out.println("");
                            System.out.println("Login Successful!");
                            System.out.println("");
                            MainMenu mm = new MainMenu();
                            mm.main();
                            count = 1;
                        } else {
                            System.out.println("");
                            System.out.println("Your Account has been Deactivate!");
                            System.out.println("");
                            MainMenu mm = new MainMenu();
                            mm.main();
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
