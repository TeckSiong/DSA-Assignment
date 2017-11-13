/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

/**
 *
 * @author KD
 */
import Domain.Schedule;
import java.text.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author KD
 */
public class MakeSchedule {
    public Scanner scan = new Scanner(System.in);
    public static int Time;
    public static int count=0;
    public String temp;
    public ArrayList<String> input = new ArrayList<>();
    public ArrayList<Schedule> Ro = new ArrayList<>();
    
   public void MakeScheduleOrder()
    {
        System.out.println("Make Schedule Order\n(Type \"exit\" at any input to Cancel schedule order");
        System.out.println("--------------------------------");
        System.out.print("Please input orderID you want to schedule :");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
        System.out.print("Please input Receiver Name : ");
        input.add(scan.nextLine());
        if(checkExit(input))
            return;
       System.out.print("Please input Receiver Address : ");
        input.add(scan.nextLine());
        
        
        if(checkExit(input))
            return;
        do{
             if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input correct date : (Format yyyy-MM-dd)");
          temp = scan.nextLine();
          if(checkExit(input))
            return;
         count++;
         }while(!isValidDate(temp));
        
       count=0;
         input.add(temp);
        
         do{
             if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input Available Time : (Format HH:MM)");
          temp = scan.nextLine();
          if(checkExit(input))
            return;
         count++;
         }while(!checkTime(temp));
         count=0;
         input.add(temp);
         
         
        
        Schedule o = new Schedule(input.get(0),input.get(1),
                input.get(2),input.get(3),input.get(4));
        Ro.add(o);
         System.out.println("\nYou Are successfully Make an Schedule Order \n");
        System.out.println("Summary Of Schedule Order");
        System.out.println("OrderID         : "+ Ro.get(0).getOrderID());
        System.out.println("Receiver Name   : "+ Ro.get(0).getCustName());
        System.out.println("Receiver Address: "+ Ro.get(0).getCustAddress());
        System.out.println("Order Date      : "+ Ro.get(0).getScheduleOrderDate());
        System.out.println("Order Time      : "+ Ro.get(0).getScheduleOrderTime());
        System.out.println("\nPress any key to continue");
        scan.nextLine();
        
    }
   
   public static boolean isValidDate(String inDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }
   
   public boolean checkTime(String test)
   {
       boolean timeValid = true;
       if( test.length()==5)
       {  if(test.charAt(2)==':' )
         {
            String split[]  = test.split(":");
            try{
                    if(Integer.parseInt(split[0])>24||Integer.parseInt(split[0])<-1)
                       timeValid=false;
                    if(Integer.parseInt(split[1])>=60||Integer.parseInt(split[1])<-1)
                       timeValid=false;
            }catch(NumberFormatException ex)
            {
                timeValid=false;
            }
         }else
           timeValid=false;}else
           timeValid=false;
       return timeValid;
   }
   
   public boolean checkExit(ArrayList l)
   {
       boolean exit = false;
       if(l.contains("exit"))
          exit=true;
       return exit;
   }
}
