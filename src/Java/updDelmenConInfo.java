package Java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Teck Siong
 */
public class updDelmenConInfo {

    Scanner scan = new Scanner(System.in);
    String ans;
    int i;
    int c;

    public void updDelmenConInfo() {

        System.out.println("----------------------------------------------------");
        System.out.println("Update Delivery Men's Information");
        System.out.println("Enter 'exit' to cancel the Update");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Delivery men's ID : ");
        ans = scan.nextLine();
        int count = 0;
        if (!ans.equals("exit")) {
            for (i = 0; i < RegisterDelMen.ad.size(); i++) {
                if (Integer.parseInt(ans) == RegisterDelMen.ad.get(i).getDelmenId()) {
                    System.out.println("");
                    result();
                    count = 1;
                }
                if (count == 1) {
                    System.out.println("Invalid ID number!");
                    System.out.println("");
                    updDelmenConInfo();
                }
            }
        } else {
            System.out.println("");
            exit();
        }
        System.out.println("----------------------------------------------------");
    }

    public void exit() {
        System.out.println("You have cancel the Update~");
        System.out.print("Do You want to Update again? (Y/N)");
        ans = scan.nextLine();
        switch (ans) {
            case "Y":
                System.out.println("");
                updDelmenConInfo();
                break;
            case "N":
                System.out.println("Thanks for using our system~");
                System.out.println("");
                break;
            default:
                System.out.println("Invalid input! (Y/N)");
                System.out.println("");
                exit();
                break;
        }
    }

    public void result() {
        System.out.println("====================================================");
        System.out.println("Delivery Men's Information");
        System.out.println("====================================================");
        System.out.println("ID Number       : " + RegisterDelMen.ad.get(i).getDelmenId());
        System.out.println("Name            : " + RegisterDelMen.ad.get(i).getDelmenName());
        System.out.println("Contact Number  : " + RegisterDelMen.ad.get(i).getContactNum());
        System.out.println("Home Address    : " + RegisterDelMen.ad.get(i).getHomeAddress());
        System.out.println("Join Date       : " + RegisterDelMen.ad.get(i).getJoinDate());
        System.out.println("Status          : " + RegisterDelMen.ad.get(i).getStatus());
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("************************");
        System.out.println("Update for > ");
        System.out.println("1. Contact Number");
        System.out.println("2. Home Address");
        //System.out.println("3. Status");
        System.out.println("0. Exit");
        System.out.println("************************");
        String update = scan.nextLine();
        System.out.println("");
        switch (update) {
            case "1":
                System.out.println("'exit' to exit the update~");
                System.out.print("Enter new contact number : ");
                String upd = scan.nextLine();
                if (!upd.equals("exit")) {

                    Pattern pattern = Pattern.compile("\\d{3}-\\d{7,8}");
                    Matcher matcher = pattern.matcher(upd);
                    if (!matcher.matches()) {
                        System.out.println("Invalid Format! E.g. 011-23456789");
                        System.out.println("");
                        result();
                    } else {
                        System.out.println("");
                        System.out.println("Update Successful!");
                        RegisterDelMen.ad.get(i).setContactNum(upd);
                        System.out.println("");
                        finalResult();
                    }
                } else {
                    System.out.println("");
                    exit();
                }
                break;
            case "2":
                System.out.println("'exit' to exit the update~");
                System.out.print("Enter new Home Address : ");
                String home = scan.nextLine();
                if (!home.equals("exit")) {
                    System.out.println("");
                    System.out.println("Update Successful!");
                    RegisterDelMen.ad.get(i).setHomeAddress(home);
                    System.out.println("");
                    finalResult();
                } else {
                    System.out.println("");
                    exit();
                }
                break;
            /*case "3":
                System.out.println("*******************************************");
                System.out.println("1. Retired");
                System.out.println("2. Resigned");
                System.out.println("0. Exit");
                System.out.println("*******************************************");
                System.out.print("Select the working status : ");
                int status = scan.nextInt();
                switch (status) {
                    case 1:
                        System.out.println("");
                        System.out.println("Update Successful!");
                        RegisterDelMen.ad.get(i).setStatus("Retired");
                        System.out.println("");
                        finalResult();
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("Update Successful!");
                        RegisterDelMen.ad.get(i).setStatus("Resigned");
                        System.out.println("");
                        finalResult();
                        break;
                    case 0:
                        System.out.println("");
                        exit();
                        break;
                }
                break;*/
            case "0":
                exit();
                break;
            default:
                System.out.println("Invalid input! (1/2/0)");
                System.out.println("");
                result();
                break;
        }
    }

    public void finalResult() {
        System.out.println("====================================================");
        System.out.println("Delivery Men's Information");
        System.out.println("====================================================");
        System.out.println("ID Number       : " + RegisterDelMen.ad.get(i).getDelmenId());
        System.out.println("Password        : " + RegisterDelMen.ad.get(i).getPassword());
        System.out.println("Name            : " + RegisterDelMen.ad.get(i).getDelmenName());
        System.out.println("Contact Number  : " + RegisterDelMen.ad.get(i).getContactNum());
        System.out.println("Home Address    : " + RegisterDelMen.ad.get(i).getHomeAddress());
        System.out.println("Join Date       : " + RegisterDelMen.ad.get(i).getJoinDate());
        System.out.println("Status          : " + RegisterDelMen.ad.get(i).getStatus());
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("****************************************************");
        System.out.println("Do you want continue? [Y/N]");
        System.out.println("****************************************************");
        String con = scan.nextLine();
        System.out.println("");
        switch (con) {
            case "Y":
                result();
                break;
            case "N":
                System.out.println("Thanks for using our system~");
                System.out.println("");
                updDelmenConInfo();
                break;
            default:
                System.out.println("Invalid input! (Y/N)");
                System.out.println("");
                finalResult();
                break;
        }
    }
}
