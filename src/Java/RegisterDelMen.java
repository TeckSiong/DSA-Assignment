package Java;

import Domain.DeliveryMen;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterDelMen {

    Scanner scan = new Scanner(System.in);
    ArrayList<String> check = new ArrayList();
    ArrayList<DeliveryMen> ad = new ArrayList();
    String ans;
    int c;

    public void menu() {
        System.out.println("====================================================");
        System.out.println("Select Your Action~");
        System.out.println("====================================================");
        System.out.println("1. Register Delivery Men");
        System.out.println("2. Update Delivery Men Information");
        System.out.println("====================================================");
        System.out.print("Enter Your Action : ");
        int s = scan.nextInt();
        scan.nextLine();
        switch (s) {
            case 1:
                System.out.println("");
                DeliveryMenDetails();
                break;

            case 2:
                break;

            default:
                System.out.println("Invalid Input [1/2]");
                System.out.println("");
                menu();
                break;
        }
    }

    public void DeliveryMenDetails() {
        ad.add(new DeliveryMen(601001, "ABC123", "Jorn Lim", "011-12345678", "Pertaling Jaya", "13/11/2016", "Available"));
        ad.add(new DeliveryMen(601002, "Hii123", "Mark", "018-1234567", "Wangsa Maju", "10/11/2016", "Available"));
        ad.add(new DeliveryMen(601003, "Waa123", "Jolin", "017-1234567", "Setapak", "17/11/2016", "Available"));
        ad.add(new DeliveryMen(601004, "Qzz123", "Sam", "016-1234567", "Seremban", "21/11/2016", "Available"));
        ad.add(new DeliveryMen(601005, "Zaa123", "Zack", "013-1234567", "Port Dickson", "30/11/2016", "Available"));
        RegisterDelMen();
    }

    public void RegisterDelMen() {
        System.out.println("----------------------------------------------------");
        System.out.println("Delivery Men Registration");
        System.out.println("Enter 'exit' to cancel the registration");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Delivery Men Name : ");
        ans = scan.nextLine();
        if (!"exit".equals(ans)) {
            check.add(ans);
            System.out.print("Enter Contact Number : ");
            ans = scan.nextLine();
            if (!"exit".equals(ans)) {
                Pattern pattern = Pattern.compile("\\d{3}-\\d{7,8}");
                Matcher matcher = pattern.matcher(ans);
                if (!matcher.matches()) {
                    System.out.println("Invalid Format! E.g. 011-23456789");
                    System.out.println("");
                    RegisterDelMen();
                } else {
                    check.add(ans);
                    System.out.print("Enter Home Address : ");
                    ans = scan.nextLine();
                    if (!"exit".equals(ans)) {
                        check.add(ans);
                        System.out.println("----------------------------------------------------");
                        System.out.println("");
                        result();
                    } else {
                        exit();
                    }
                }
            } else {
                exit();
            }
        } else {
            exit();
        }
    }

    public void result() {
        System.out.println("====================================================");
        System.out.println("Please confirm the information~");
        System.out.println("====================================================");
        System.out.println("ID Number : " + DeliveryMen.getDelmenID());
        System.out.println("Name : " + check.get(0));
        System.out.println("Contact Number : " + check.get(1));
        System.out.println("Home Address : " + check.get(2));
        System.out.println("Join Date : " + getDateTime());
        System.out.println("Status : Available");
        System.out.println("====================================================");
        System.out.println("Confirm? (Y/N)");
        ans = scan.nextLine();
        switch (ans) {
            case "Y":
                DeliveryMen dm = new DeliveryMen(DeliveryMen.getDelmenID(), "ABC123", check.get(0), check.get(1), check.get(2), getDateTime(), "Available");
                ad.add(dm);
                System.out.println("Register Sucessful!");
                System.out.println("");
                check.clear();
                RegisterDelMen();
                break;
            case "N":
                System.out.println("Register Unsucessful!");
                System.out.println("");
                check.clear();
                RegisterDelMen();
                break;
            default:
                System.out.println("Invalid input! (Y/N)");
                System.out.println("");
                result();
                break;
        }
    }

    public void exit() {
        System.out.println("");
        System.out.println("You have cancel the registration~");
        System.out.println("Do You want to register again? (Y/N)");
        ans = scan.nextLine();
        switch (ans) {
            case "Y":
                RegisterDelMen();
                System.out.println("");
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

    private String getDateTime() {
        DateFormat joinDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return joinDate.format(date);
    }
}
