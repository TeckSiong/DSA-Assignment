/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.ADTOrder;
import ADT.ADTTheList;
import ADT.ADTTheListInterface;
import ADT.BubbleSort;
import static Client.AssignDeliverymen.orders1;
import static Client.AssignDeliverymen.ps;
import Domain.Food;
import Domain.orders;
import static Client.FoodMenu.AllFood;
import Domain.ProductStatus;
/*
import static Java.FoodMenu.orders;*/
import java.util.*;

/**
 *
 * @author User
 */
public class foodOrder {

    public Scanner scan = new Scanner(System.in);
    ADTTheListInterface<Food> flist = new ADTTheList<>();

    public static ADTOrder<orders> orders1 = new ADTOrder<>();

    custLogin cust = new custLogin();
    MainMenu main = new MainMenu();

    int classify = 1;
    int chk1 = 1;

    public void order() {

        String options;
        int option = 0;
        int resno = 0;
        int CompanyName = 0;

        Calendar cal = Calendar.getInstance();
        int d = cal.get(Calendar.DAY_OF_WEEK);

        if (Restaurant.Ro.checkEmpty()) {
            Domain.RestaurantOwner.RestList();
        }

        // System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSelect Company Name : \n");
        for (int i = 0; i < Restaurant.Ro.getSize(); i++) {
            System.out.print(i + " " + Restaurant.Ro.returnItem(i).getRestaurantName() + "\n");
            resno++;
        }
        if (resno == 0) {

            System.out.println("Sorry, non restaurant is serving currently...");
            scan.nextLine();

            main.customer();
        } else {
            System.out.println();
            System.out.print("Select Company Name : ");
        }
        int x = 0;

        int count = 0;
        String status = "";
        ArrayList<Integer> show = new ArrayList<>();

        do {
            try {
                CompanyName = Restaurant.Ro.returnItem(scan.nextInt()).getId();
                scan.nextLine();
                x = 0;
            } catch (Exception e) {
                System.out.println("Please input again");
                x = 1;
                scan.nextLine();
            }
        } while (x == 1);
        //  System.out.println("Food Name        Category         Quantity           Price");
        // System.out.println("=========        ========         ========           =====");
        System.out.printf("%20s %20s %20s %20s\n", "Foodname", "Category", "Quantity", "Price(RM)");
        System.out.printf("%20s %20s %20s %20s\n\n", "========", "========", "========", "=====");
        for (int i = 0; i < Restaurant.Ro.getSize(); i++) {
            if (CompanyName == Restaurant.Ro.returnItem(i).getId()) {
                status = Restaurant.Ro.returnItem(i).getStatus();
            }
        }
        if (AllFood.checkEmpty()) {
            System.out.println("Empty Food List");
        }
        for (int i = 0; i < AllFood.getSize(); i++) {

            if (d == 1 && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && AllFood.returnItem(i).getDayAvailable().equals("Sunday")) {
                flist.addItem(AllFood.returnItem(i));
                //   System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());
                show.add(i);
                count = count + i;
            }
            if ((d == 2 || d == 3) && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && (AllFood.returnItem(i).getDayAvailable().equals("Monday & Tuesday"))) {
                flist.addItem(AllFood.returnItem(i));
                //  System.out.println(flist.size()+ i +"       "+AllFood.get(i).getFoodName()+"           "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());

                show.add(i);
                count = count + i;
            }
            if ((d == 4 || d == 5) && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && (AllFood.returnItem(i).getDayAvailable().equals("Wednesday & Thursday"))) {
                flist.addItem(AllFood.returnItem(i));
                //System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"             "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());

                show.add(i);
                count = count + i;
            }
            if ((d == 6 || d == 7) && AllFood.returnItem(i).getCompanyID() == CompanyName && status.equals("Activated") && (AllFood.returnItem(i).getDayAvailable().equals("Friday & Saturday"))) {
                flist.addItem(AllFood.returnItem(i));
                // System.out.println(flist.size()+ i +"      "+AllFood.get(i).getFoodName()+"            "+AllFood.get(i).getCategory()+"     "+AllFood.get(i).getQuantity()+"         RM"+AllFood.get(i).getPrice());
                System.out.printf("%10s %10s %20s %20s %20.2f\n", flist.getSize(), AllFood.returnItem(i).getFoodName(), AllFood.returnItem(i).getCategory(), AllFood.returnItem(i).getQuantity(), AllFood.returnItem(i).getPrice());

                show.add(i);
                count = count + i;
            }

        }

        int icount = 0;
        do {
            System.out.println("\nPress any key to continue");
            scan.nextLine();
            System.out.println("1. Place Order 2. Sort Order");
            try {
                option = scan.nextInt();
                scan.nextLine();
                icount = 1;
            } catch (Exception ex) {
                System.out.println("Invalid Input...");
                icount = 0;
            }
        } while (icount == 0);
        icount = 0;
        if (option == 1) {

            int aaa = 0;
            int abc;
            int quant;
            int subtotal = 0;
            double total = 0;

            do {
                System.out.print("\n\n\nPlease place your order :");
                abc = scan.nextInt();

                abc = abc - 1;
                String name = flist.returnItem(abc).getFoodName();

                if (name != " ") {
                    for (int s = 0; s < AllFood.getSize(); s++) {
                        if (name.equals(AllFood.returnItem(s).getFoodName())) {

                            System.out.print("Kindly key in quantity :");
                            quant = scan.nextInt();

                            orders od = new orders(classify, AllFood.returnItem(s).getFoodID(), AllFood.returnItem(s).getCompanyID(), AllFood.returnItem(s).getFoodName(), quant, AllFood.returnItem(s).getPrice(), "Pending", custLogin.id1);

                            orders1.add(od); //add to node

                            subtotal = subtotal + quant;
                            total = total + (quant * AllFood.returnItem(s).getPrice());

                        }
                    }
                } else {
                    System.out.println("Incorrect input...\n\n");
                }

                System.out.print("\n\n\nDo you wish to make another oder ? (1 = exit)");
                aaa = scan.nextInt();

            } while (aaa == 0);

            classify++;

            System.out.println("\n\n\n=============== Order Summary ===============\n\n\n");
            System.out.println("Food     " + "Quantity       " + "Price (RM)  \n");
            for (int y = 1; y <= orders1.getSize(); y++) {

                if (y == chk1) {
                    System.out.println(orders1.getEntry(y).getname() + "           " + orders1.getEntry(y).getquantity() + "              " + (orders1.getEntry(y).getprice() * orders1.getEntry(y).getquantity()) + "\n");
                    chk1 = chk1 + 1;
                }
            }

            System.out.println("=============== Total amount need to pay : ===============\n");
            System.out.println("                       SubTotal:" + subtotal + "(S)   RM" + total);

            do {

                System.out.print("\n\n\nCard No        :");
                String card = scan.nextLine();

                if (card.length() == 16) {

                    System.out.println("\n\n= = =Thank you and come again= = =\n\n");
                    aaa = 0;
                } else {
                    System.out.println("\n\n! ! !Invalid card! ! !\n\n");
                }

            } while (aaa == 1);
            
                for(int a =0;a<orders1.getSize();a++){
                ps.addData(new ProductStatus(0, orders1.getEntry(a).getorderID(), "Pending",5, 0, 0, "21/12/2017","Wangsa Maju",orders1.getEntry(a).getcustID()));
                
                }
            System.out.println("\nPress any key to continue");
            scan.nextLine();
            MainMenu m = new MainMenu();
            m.MainMenu();

        } else {
            System.out.println("Please choose a sort options : 1. Sort By Name 2. Sort By Categories 3. Sort By Price");
            options = scan.nextLine();
            BubbleSort bs = new BubbleSort();
            switch (options) {

                case "1":
                    if (!AllFood.checkEmpty()) {
                        bs.bubble_srt(AllFood, 1);
                    }
                    flist.clearAll();
                    order();
                    break;
                case "2":

                    if (!AllFood.checkEmpty()) {
                        bs.bubble_srt(AllFood, 2);
                    }
                    flist.clearAll();
                    order();
                    break;
                default:
                    if (!AllFood.checkEmpty()) {
                        bs.bubble_srt(AllFood, 3);
                    }
                    flist.clearAll();
                    order();
                    break;

            }
        }

    }

}
