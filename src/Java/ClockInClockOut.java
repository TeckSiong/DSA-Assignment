/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import ADT.ADTOrder;
import ADT.DelManADT;
import Domain.ClockIO;
import Domain.ProductStatus;
import Domain.orders;
import static Java.AssignDeliverymen.od;
import static Java.AssignDeliverymen.ps;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author khosit
 */
public class ClockInClockOut {

    public static int sdate = 0;
    Scanner ans = new Scanner(System.in);

    public static DelManADT<Domain.DeliveryMan> dm = new DelManADT<>();
    public static DelManADT<Domain.ProductStatus> ps = new DelManADT<>();
    public static DelManADT<Domain.ClockIO> cio = new DelManADT<>();
    public static ADTOrder<orders> od = new ADTOrder<>();

    public static int hour;
    public static int min;

    public void ClockIn() {

        DMLogin dd = new DMLogin();
        //  AssignDeliveryJob ad = new AssignDeliveryJob();

        Calendar cal = Calendar.getInstance();
        dm = DelManMaintain.dList;

        if (DelManMaintain.dList.isEmpty()) {
            Domain.DeliveryMan.DeliveryMenDetails();
        }
        
        ps = DelManMaintain.sList;
        if (ps.isEmpty()) {
            Domain.ProductStatus.Status();
        }
        
        
        if (cio.isEmpty()) {
            Domain.ClockIO.WorkingDuration();
        }
        
        od = foodOrder.orders1;
        if(od.isEmpty()){
            Domain.orders.OrderList();
        }
        
        

        //   for (int i = 0; i <= dm.getSize(); i++) {
        //       dm.getData(i).setStatus("Available");
        //   }
        DateFormat h = new SimpleDateFormat(("HH"));
        DateFormat m = new SimpleDateFormat(("mm"));

        DateFormat dateFormat = new SimpleDateFormat("hh" + ":" + "mm" + " " + "a");
        DateFormat day = new SimpleDateFormat("dd-MM-YYYY");

        String currenttime = dateFormat.format(cal.getTime());
        Date date1 = new Date();
        String date = day.format(date1);

        if (sdate == 0) {
            String hh = h.format(cal.getTime());
            String mm = m.format(cal.getTime());

            hour = Integer.parseInt(hh);
            min = Integer.parseInt(mm);

            System.out.println("Date: " + date);
            System.out.println("Start working: " + currenttime);

            sdate = 1;
        }
        
        
        System.out.println();
        
        System.out.println("OrderID    Address");
        System.out.println("=======    ======================");
        
        
        int id1 = Integer.parseInt(dd.id);
    
        
           
        for (int o = 0; o < ps.getSize(); o++) {
            int idd =ps.getData(o).getDelManId(); 
            if(ps.getData(o).getStatus()=="Delivering"){
                if (idd == id1) {
                    System.out.println(ps.getData(o).getOrderID() + "       " + ps.getData(o).getAddress());
                } 
            }
            
            
        }

        
        System.out.println();
        System.out.println("0. Clock Out");
        System.out.println("1. Refresh");
        System.out.println("2. Exit");
        
        
        System.out.println();
        System.out.print("Enter Selection: ");
        int s2 = ans.nextInt();

        if (s2 == 1) {
            ClockIn();

        } else if (s2 == 0) {

            for (int a = 0; a < dm.getSize(); a++) {
                
                int id2 = dm.getData(a).getDelmenId();
                dm.getData(a).setStatus("Not Available");

                if (id1 == id2) {

                    String hh1 = h.format(cal.getTime());
                    String mm1 = m.format(cal.getTime());

                    int qhour = Integer.parseInt(hh1);
                    int qmin = Integer.parseInt(mm1);

                    if (qhour >= hour) {
                        if (qmin < min) {
                            qmin += 60;
                            qhour -= 1;

                        }
                        int rhour = qhour - hour;
                        int rminute = qmin - min;

                        System.out.println();
                        System.out.println("Your working duration today: " + rhour + "hours " + rminute + "minutes ");
                        System.out.println();

                        

                        for (int q = 0; q < cio.getSize(); q++) {
                            if (id1 == cio.getData(q).getDelmenId()) {
                                cio.getData(a).setHour(rhour);
                                cio.getData(a).setHour(rminute);
                            } else {
                                cio.addData(new ClockIO(id1, rhour, rminute));
                            }
                        }

                    }
                    

                }

            }
            
           

        } else if(s2 == 2){
            for (int a = 0; a < dm.getSize(); a++) {
                
                int id2 = dm.getData(a).getDelmenId();
                if(id1==id2){
                    dm.getData(a).setStatus("Available");
                }
            MainMenu mm = new MainMenu();
            mm.MainMenu();
            }
        }else
            System.out.println("Invalid !!");
        
        
        DelManMaintain.dList=dm;

    }

    public void DailyWorkOur() {

    }

    public void ClockInClockOut() {

        System.out.println("1.Clock in");
        System.out.println("2.Update Personal Details");
        System.out.println();

        System.out.print("Enter Selection: ");
        int s1 = ans.nextInt();
        System.out.println();

        if (s1 == 1) {
            ClockIn();
        } else if (s1 == 2) {
            System.out.println("Update personal details");
            System.out.println();
        } else {
            System.out.println("Invalid !!");
            System.out.println();
            ClockInClockOut();
        }

    }

    // public static void main(String[] args) {
    //     ClockInClockOut a = new ClockInClockOut();
    //      a.ClockInClockOut();
    //  }
}
