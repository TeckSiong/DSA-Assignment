/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Domain.ProductStatus;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrackOrderStatus { 
    
    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    ArrayList<ProductStatus> ps = new ArrayList();
    
    private int eid;
    public int rhour;
    public int rminute;

    public void OrderStatus(){
        Calendar cal = Calendar.getInstance();
        
        
        
        DateFormat h = new SimpleDateFormat(("HH"));
        DateFormat m = new SimpleDateFormat(("mm"));
        DateFormat aa = new SimpleDateFormat(("a"));
        DateFormat dateFormat = new SimpleDateFormat("h"+":"+"m"+" "+"aa");
        
        String hh = h.format(cal.getTime());
        String mm = m.format(cal.getTime());
        int hour = Integer.parseInt(hh);
        int min = Integer.parseInt(mm);
        
        
        
        

        String currenttime = dateFormat.format(cal.getTime());
        System.out.println("Checking remaining time");

        
        System.out.println("Current Date Time : " + currenttime);

        enterid();
        System.out.println();
       
        System.out.println("OrderID       Delivery Status       Remaining time");
        System.out.println("=======       ===============       ==============");
        
        for(int i =0; i<ps.size();i++){
            int a = ps.get(i).getOrderID();
            
            if(eid == a){
                
                int sethour = ps.get(i).getHour();
                int setmin = ps.get(i).getMinute();

                if (sethour > hour) {
                    if (setmin < min) {
                        setmin += 60;
                        sethour -= 1;

                        rhour = sethour - hour;
                        rminute = setmin - min;

                        //System.out.println("Remaining timme: " + remainhour +" hrs"+ remainmin+"mins");
                    }
                }
                
                if (ps.get(i).getStatus() == "Delivering") {
                    if (rhour == 0 && rminute == 0) {
                        ps.get(i).setStatus("Delivered ");
                    }

                }

                System.out.println(ps.get(i).getOrderID()+"          "+ps.get(i).getStatus()+"            "+rhour+" hrs "+rminute+ " mins");
                System.out.println();
                System.out.println("Do you want to check other order? ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println();
                System.out.print("Enter selection: ");
                
                if(scanner1.nextInt()== 1){
                    OrderStatus();
                }
                
            }
        }
                
        
    }
    
    public void enterid(){
        
        if(ps.isEmpty()){
            ps.add (new ProductStatus(1001,"Delivering",12,54));
            ps.add (new ProductStatus(1002,"Preparing ",0,0));
            ps.add (new ProductStatus(1003,"Delivered ",0,0));
        }
        

        System.out.println();
        System.out.println("Order ID");
        System.out.println("========");
        
        
        for(int i =0; i<ps.size();i++){
            int a = ps.get(i).getOrderID();
            System.out.println(a);
        }
        
        
        System.out.println();
        
        System.out.print("Enter OrderID : ");
        eid = scanner1.nextInt();
        System.out.println();
    }
    
    
    
}
