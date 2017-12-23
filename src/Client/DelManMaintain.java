/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.SortList;
import ADT.DelManADT;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Teck Siong
 */
public class DelManMaintain {

    public static DelManADT<Domain.DeliveryMan> dList = new DelManADT<>();
    public static DelManADT<Domain.ProductStatus> sList = new DelManADT<>();
    public static DelManADT<Domain.orders> oList = new DelManADT<>();
    Scanner scan = new Scanner(System.in);
    private String answer;

    public int checkInput(String answer) {
        String ans = answer.toLowerCase();
        if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("ye") || ans.equalsIgnoreCase("yes")) {
            return 1;
        } else if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")) {
            return 0;
        } else if (ans.equalsIgnoreCase("exit")) {
            return -999;
        } else {
            return -1;
        }
    }

    // Add new delivery man
    public void addInitial() {
        Domain.DeliveryMan.DeliveryMenDetails();
        Domain.ProductStatus.Status();
        Domain.orders.OrderList1();
        addDelMan();
    }

    public void addDelMan() {
        Domain.DeliveryMan newDelMan = new Domain.DeliveryMan();
        Matcher matcher;
        boolean cont = false;
        String con;

        do {
            System.out.println("==================================================");
            System.out.println("Register New Delivery Man");
            System.out.println("==================================================");

            System.out.print("Name               : ");
            answer = scan.nextLine();
            newDelMan.setDelmenName(answer);
            do {
                System.out.println("IC Number");
                System.out.print("(xxxxxx-xx-xxxx)   : ");
                answer = scan.nextLine();
                newDelMan.setIcNum(answer);

                Pattern pattern = Pattern.compile("\\d{6}-\\d{2}-\\d{4}");
                matcher = pattern.matcher(answer);
            } while (!matcher.matches());

            do {
                System.out.println("Contact Number ");
                System.out.print("(0xx-xxxxxxx)      : ");
                answer = scan.nextLine();
                newDelMan.setContactNum(answer);

                Pattern pattern = Pattern.compile("\\d{3}-\\d{7,8}");
                matcher = pattern.matcher(answer);
            } while (!matcher.matches());

            System.out.print("Address            : ");
            answer = scan.nextLine();
            newDelMan.setHomeAddress(answer);
            System.out.println("==================================================");
            System.out.println("");

            do {
                System.out.println("==================================================");
                System.out.println("Confirm Information");
                System.out.println("==================================================");
                System.out.println("ID Number       : " + Domain.DeliveryMan.getDelmenID());
                System.out.println("Name            : " + newDelMan.getDelmenName());
                System.out.println("IC Number       : " + newDelMan.getIcNum());
                System.out.println("Password        : IC Number");
                System.out.println("Contact Number  : " + newDelMan.getContactNum());
                System.out.println("Address         : " + newDelMan.getHomeAddress());
                System.out.println("Join Date       : " + newDelMan.getJoinDate());
                System.out.println("Status          : Available");
                System.out.println("Account         : Activated");
                System.out.println("==================================================");
                System.out.println("");
                System.out.print("Confirm ? (Y/N) ");
                con = scan.nextLine();
                System.out.println("");

                if (checkInput(con) == 1) {
                    dList.addData(new Domain.DeliveryMan(Domain.DeliveryMan.getDelmenID(), newDelMan.getIcNum(), newDelMan.getIcNum(), newDelMan.getDelmenName(), newDelMan.getContactNum(), newDelMan.getHomeAddress(), newDelMan.getJoinDate(), "Available", "Activated", 0));
                    break;
                } else if (checkInput(con) == -1) {
                    System.out.println("Invalid Input");
                }
            } while (checkInput(con) != 0);

            do {
                System.out.print("Register more ? (Y/N) ");
                String more = scan.nextLine();
                System.out.println("");
                if (checkInput(more) == 1) {
                    cont = true;
                    break;
                } else if (checkInput(more) == 0) {
                    System.out.println("Registration Cancel!");
                    cont = false;
                    System.out.println("");
                    MainMenu m = new MainMenu();
                    m.staffMenu();
                    break;
                }
            } while (checkInput(con) != -1);

        } while (cont == true);

    }

    // Update delivery man
    String ans;
    int i;
    int c;
    int count = 0;
    String acc;

    public void updDelMan() {
        System.out.println("----------------------------------------------------");
        System.out.println("Update Delivery Men's Information");
        System.out.println("Enter 'exit' to cancel the Update");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter Delivery men's ID : ");
        ans = scan.nextLine();
        String ans1 = ans.toLowerCase();
        if (!ans1.equals("exit")) {
            for (i = 0; i < dList.getSize(); i++) {
                if (Integer.parseInt(ans) == dList.getData(i).getDelmenId()) {
                    System.out.println("");
                    result();
                    count = 1;
                }
                if (count == 1) {
                    System.out.println("Invalid ID number!");
                    System.out.println("");
                    updDelMan();
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
        String ans1 = ans.toLowerCase();
        switch (ans1) {
            case "y":
                System.out.println("");
                updDelMan();
                break;
            case "n":
                System.out.println("");
                System.out.println("Thanks for using our system~");
                System.out.println("");
                MainMenu mm = new MainMenu();
                mm.staffMenu();
                break;
            default:
                System.out.println("");
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
        System.out.println("ID Number       : " + dList.getData(i).getDelmenId());
        System.out.println("Name            : " + dList.getData(i).getDelmenName());
        System.out.println("Contact Number  : " + dList.getData(i).getContactNum());
        System.out.println("Home Address    : " + dList.getData(i).getHomeAddress());
        System.out.println("Join Date       : " + dList.getData(i).getJoinDate());
        System.out.println("Status          : " + dList.getData(i).getStatus());
        System.out.println("Account         : " + dList.getData(i).getAcc());
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("************************");
        System.out.println("Update for > ");
        System.out.println("1. Contact Number");
        System.out.println("2. Home Address");
        System.out.println("3. Status");
        System.out.println("0. Exit");
        System.out.println("************************");
        String update = scan.nextLine();
        System.out.println("");
        switch (update) {
            case "1":
                System.out.println("'exit' to exit the update~");
                System.out.print("Enter new contact number : ");
                String upd = scan.nextLine();
                String upd1 = upd.toLowerCase();
                if (!upd1.equals("exit")) {

                    Pattern pattern = Pattern.compile("\\d{3}-\\d{7,8}");
                    Matcher matcher = pattern.matcher(upd);
                    if (!matcher.matches()) {
                        System.out.println("Invalid Format! E.g. 011-23456789");
                        System.out.println("");
                        result();
                    } else {
                        System.out.println("");
                        System.out.println("Update Successful!");
                        dList.getData(i).setContactNum(upd);
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
                    dList.getData(i).setHomeAddress(home);
                    System.out.println("");
                    finalResult();
                } else {
                    System.out.println("");
                    exit();
                }
                break;
            case "3":
                System.out.println("*******************************************");
                System.out.println("1. Retired");
                System.out.println("2. Resigned");
                System.out.println("3. Others");
                System.out.println("4. Available");
                System.out.println("0. Exit");
                System.out.println("*******************************************");
                System.out.print("Select the working status : ");
                String status = scan.nextLine();
                switch (status) {
                    case "1":
                        System.out.println("");
                        System.out.println("Update Successful!");
                        dList.getData(i).setStatus("Retired");
                        dList.getData(i).setAcc("Deactivate");
                        System.out.println("");
                        finalResult();
                        break;
                    case "2":
                        System.out.println("");
                        System.out.println("Update Successful!");
                        dList.getData(i).setStatus("Resigned");
                        dList.getData(i).setAcc("Deactivate");
                        System.out.println("");
                        finalResult();
                        break;
                    case "3":
                        System.out.println("");
                        System.out.print("Others > ");
                        String other = scan.nextLine();
                        other = scan.nextLine();
                        dList.getData(i).setStatus(other);
                        System.out.println("");
                        System.out.println("Account status > ");
                        System.out.println("1. Active");
                        System.out.println("2. Deactive");
                        System.out.println("0. Cancel");
                        acc = scan.nextLine();
                        System.out.println("");
                        account();

                    case "4":
                        System.out.println("");
                        System.out.println("Update Successful!");
                        dList.getData(i).setStatus("Available");
                        dList.getData(i).setAcc("Active");
                        System.out.println("");
                        finalResult();
                        break;

                    case "0":
                        System.out.println("");
                        exit();
                        break;
                }
                break;
            case "0":
                exit();
                break;
            default:
                System.out.println("Invalid input!");
                System.out.println("");
                result();
                break;
        }
    }

    public void account() {
        switch (acc) {
            case "1":
                finalResult();
                break;

            case "2":
                dList.getData(i).setAcc("Deactivate");
                finalResult();
                break;

            case "0":
                System.out.println("");
                exit();
                break;

            default:
                System.out.println("Invalid input! (1/2/0)");
                System.out.println("");
                account();
                break;
        }
    }

    public void finalResult() {
        System.out.println("====================================================");
        System.out.println("Delivery Men's Information");
        System.out.println("====================================================");
        System.out.println("ID Number       : " + dList.getData(i).getDelmenId());
        System.out.println("Password        : " + dList.getData(i).getPassword());
        System.out.println("Name            : " + dList.getData(i).getDelmenName());
        System.out.println("Contact Number  : " + dList.getData(i).getContactNum());
        System.out.println("Home Address    : " + dList.getData(i).getHomeAddress());
        System.out.println("Join Date       : " + dList.getData(i).getJoinDate());
        System.out.println("Status          : " + dList.getData(i).getStatus());
        System.out.println("Account         : " + dList.getData(i).getAcc());
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("****************************************************");
        System.out.println("Do you want continue? [Y/N]");
        System.out.println("****************************************************");
        String con = scan.nextLine();
        System.out.println("");
        String con1 = con.toLowerCase();
        switch (con1) {
            case "y":
                result();
                break;
            case "n":
                System.out.println("Thanks for using our system~");
                System.out.println("");
                count = 0;
                updDelMan();
                break;
            default:
                System.out.println("Invalid input! (Y/N)");
                System.out.println("");
                finalResult();
                break;
        }
    }

    // Search pendding order
    public void trackStatus() {
        boolean foundID = false;
        boolean foundData = false;
        int id = 0;
        int j;
        do {

            do {
                System.out.println("");
                System.out.print("Delvery Man's ID: ");
                id = scan.nextInt();
                for (j = 0; j < dList.getSize(); j++) {
                    if (id == dList.getData(j).getDelmenId()) {
                        foundID = true;
                    }
                }
                if (foundID == false) {
                    System.out.println("");
                    System.out.println("Delivery Man ID not found");
                }
            } while (foundID == false);

            do {

                for (int k = 0; k < sList.getSize(); k++) {
                    if (id == sList.getData(k).getDelManId()) {
                        foundData = true;
                    }

                }
                if (foundData == false) {
                    System.out.println("");
                    System.out.println("No data found!");
                }
            } while (foundData == false);
            System.out.println("");
            System.out.println("OrderID     FoodID    Food Name      Qauntity");
            System.out.println("------------------------------------------------");

            do {

                for (int B = 0; B < sList.getSize(); B++) {
                    for (int q = 0; q < oList.getSize(); q++) {
                        if (sList.getData(B).getOrderID() == oList.getData(q).getorderID()&& oList.getData(q).getStatus().equals("Pending") && sList.getData(B).getDelManId() == id) {
                            System.out.printf("%1d %10d %15s %10d \n", oList.getData(q).getorderID(), oList.getData(q).getfoodId(),oList.getData(q).getname(), oList.getData(q).getquantity());
                            foundData = true;
                        }
                    }

                }
                cont();

                if (foundData == false) {
                    System.out.println("Data not found!");
                }
            } while (foundData == false);

        } while (foundID == false || foundData == false);
    }

    public void cont() {
        MainMenu m = new MainMenu();
        System.out.println("");
        System.out.print("Do you want continue? (Y/N) ");
        String c = scan.next();
        String c1 = c.toLowerCase();
        switch (c1) {
            case "y":
                System.out.println("");
                m.staffMenu();
                break;

            case "n":
                System.out.println("");
                m.MainMenu();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid Input!");
                cont();
                break;
        }
    }

// Report
    public void report() {
        boolean checkDate = false;
        System.out.println("==================================================");
        System.out.println("Daily Report");
        System.out.println("==================================================");
        System.out.println("1. Total Deleveries Completed");
        System.out.println("2. Distance Travelled");
        System.out.println("3. Exit");
        System.out.println("==================================================");
        System.out.print("Selection: ");
        String s = scan.nextLine();
        switch (s) {
            case "1":
                do {
                    SortList sl = new SortList();
                    sl.bubble_srt(sList);
                    System.out.println("");
                    System.out.println("Date ");
                    System.out.print("xx/xx/xxxx : ");
                    String date = scan.nextLine();
                    System.out.println("");
                    System.out.println("======================================================================");
                    System.out.println("ID          Name            Contact Number          Total Deliveries");
                    System.out.println("======================================================================");
                    for (int j = 0; j < sList.getSize(); j++) {
                        for (int k = 0; k < dList.getSize(); k++) {
                            if (date.equals(sList.getData(j).getDate1()) && sList.getData(j).getStatus().equals("Delivered")) {
                                int id = sList.getData(j).getDelManId();
                                int t = sList.getData(j).getTrip();
                                if (id == dList.getData(k).getDelmenId()) {
                                    System.out.printf("%1s %13s %20S %15d \n", dList.getData(k).getDelmenId(), dList.getData(k).getDelmenName(), dList.getData(k).getContactNum(), t);
                                    checkDate = true;
                                }
                            }
                        }
                    }
                    if (checkDate == false) {
                        System.out.println("");
                        System.out.println("No Data found!");
                    }

                } while (checkDate == false);
                System.out.println("");
                again();
                break;

            case "2":
                do {
                    System.out.println("");
                    System.out.print("Date: ");
                    String date = scan.nextLine();
                    System.out.println("");
                    System.out.println("======================================================================");
                    System.out.println("ID       Name            Contact Number          Total Distance");
                    System.out.println("======================================================================");
                    for (int j = 0; j < sList.getSize(); j++) {
                        for (int k = 0; k < dList.getSize(); k++) {
                            if (date.equals(sList.getData(j).getDate1()) && sList.getData(j).getStatus().equals("Delivered")) {
                                int id = sList.getData(j).getDelManId();
                                if (id == dList.getData(k).getDelmenId()) {
                                    System.out.printf("%1s %10s %20s %15.2f \n", dList.getData(k).getDelmenId(), dList.getData(k).getDelmenName(), dList.getData(k).getContactNum(), dList.getData(k).getTotalDistance());
                                    checkDate = true;
                                }

                            }
                        }
                    }
                    if (checkDate == false) {
                        System.out.println("");
                        System.out.println("No Data found!");
                    }
                } while (checkDate == false);
                again();
                break;

            case "3":
                System.out.println("");
                MainMenu m = new MainMenu();
                m.staffMenu();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid Input!");
                System.out.println("");
                report();
                break;
        }

    }

    public void again() {
        MainMenu m = new MainMenu();
        System.out.println("");
        System.out.print("Do you want to continue? (Y/N) ");
        String a = scan.nextLine();
        String a1 = a.toLowerCase();
        switch (a1) {
            case "y":
                System.out.println("");
                m.staffMenu();
                break;

            case "n":
                System.out.println("");
                m.staffMenu();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid Input!");
                again();
                break;
        }
    }
}
