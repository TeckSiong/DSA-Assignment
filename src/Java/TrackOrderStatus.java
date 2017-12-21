/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import ADT.ADTTheList;
import ADT.ADTTheListInterface;
import ADT.DelManADT;
import Domain.Food;
import Domain.ProductStatus;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrackOrderStatus {

    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    public static DelManADT<Domain.ProductStatus> ps = new DelManADT<>();
    public static DelManADT<Domain.foodDetails> od = new DelManADT<>();

    public void OrderStatus() {

        if (ps.isEmpty()) {
            Domain.ProductStatus.Status();
        }
        ps = DelManMaintain.sList;

        Calendar cal = Calendar.getInstance();

        DateFormat h = new SimpleDateFormat(("HH"));
        DateFormat m = new SimpleDateFormat(("mm"));

        DateFormat dateFormat = new SimpleDateFormat("hh" + ":" + "mm" + " " + "a");

        String hh = h.format(cal.getTime());
        String mm = m.format(cal.getTime());
        int hour = Integer.parseInt(hh);
        int min = Integer.parseInt(mm);

        String currenttime = dateFormat.format(cal.getTime());
        System.out.println("Checking remaining time");

        System.out.println("Current Date Time : " + currenttime);

        System.out.println();
        System.out.println("Order ID");
        System.out.println("========");
        
        if(od.isEmpty()){
            Domain.foodDetails.fDetail();
        }
        od = DelManMaintain.fList;

        for (int i = 0; i < od.getSize(); i++) {
            int cid = Integer.parseInt(od.getData(i).getCustID());
            if (cid == Java.custLogin.id1) {
                int a = ps.getData(i).getOrderID();
               System.out.println(a);
               

            }

        }

        System.out.println();

        System.out.print("Enter OrderID : ");
        int eid = scanner1.nextInt();
        System.out.println();
        System.out.println();

        for (int i = 0; i < ps.getSize(); i++) {
            int a = ps.getData(i).getOrderID();
            int rhour = 0;
            int rminute = 0;
            if (eid == a) {

                int sethour = ps.getData(i).getHour();
                int setmin = ps.getData(i).getMinute();

                if (sethour >= hour) {
                    if (setmin <= min) {
                        setmin += 60;
                        sethour -= 1;

                        //System.out.println("Remaining timme: " + remainhour +" hrs"+ remainmin+"mins");
                    }
                    rhour = sethour - hour;
                    rminute = setmin - min;

                    if (ps.getData(i).getStatus().equals("Delivering")) {
                        if (rhour < 0) {
                            ps.getData(i).setStatus("Delivered ");

                            rminute = 0;
                            rhour = 0;

                        }

                    }
                }

                System.out.println("OrderID       Delivery Status       Remaining time");
                System.out.println("=======       ===============       ==============");

                System.out.println(ps.getData(i).getOrderID() + "          " + ps.getData(i).getStatus() + "            " + rhour + " hrs " + rminute + " mins");
                System.out.println();

            }
        }
        System.out.println("Do you want to check other order? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println();
        System.out.print("Enter selection: ");

        if (scanner1.nextInt() == 1) {
            OrderStatus();
        }

    }

}
