/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.ADTOrder;
import ADT.ADTTheList;
import ADT.ADTTheListInterface;
import ADT.DelManADT;
import ADT.TotalAssignJob;
import Domain.Food;
import Domain.ProductStatus;
import Domain.orders;
import static Client.AssignDeliverymen.od;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrackOrderStatus {

    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    public static DelManADT<Domain.ProductStatus> ps = new DelManADT<>();
    
    public static ADTOrder<orders> od = new ADTOrder<>();
    
    public static int cid;

    public void OrderStatus() {
        
        custLogin cl = new custLogin();
        
        ps = DelManMaintain.sList;
        if(ps.isEmpty()){
            Domain.ProductStatus.Status();
            ps = DelManMaintain.sList;
        }

        
        od = foodOrder.orders1;
        if(od.isEmpty()){
            Domain.orders.OrderList1();
        }
        

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

        int dd = cl.id1;
        for (int i = 0; i < ps.getSize(); i++) {
            
            if (ps.getData(i).getCustID() == dd) {                
               /* if(od.getEntry(i).getorderID() != od.getEntry(i+1).getorderID()){
                    System.out.println(od.getEntry(i).getorderID());
                }
*/
               System.out.println(ps.getData(i).getOrderID());
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
        
         foodOrder.orders1 = od;

    }

}
