/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import ADT.ADTOrder;
import ADT.ADTTheList;
import ADT.ADTTheListInterface;
import java.util.*;
import Domain.Schedule;
import ADT.ScheduleADT;
import ADT.ScheduleInterface;
import Domain.Distance;
import Domain.Food;
import Domain.orders;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author KD
 */
public class ScheduleOrder {
    public Scanner scan = new Scanner(System.in);
    public static int Time;
    public static int count=0;
    public String temp;
    public static int id=7000;
    public static ScheduleInterface<Distance> distanceList = new ScheduleADT<>();
    public ScheduleInterface<String> input = new ScheduleADT<>();
    public ScheduleADT sc = new ScheduleADT();//call method
    public static ScheduleInterface<Schedule> SC = new ScheduleADT<>();
    public static ADTOrder<orders> orders1 = new ADTOrder<>();
    public static String RESTAURANT_NAME = "taman melawati";
    public Scanner scan1 = new Scanner(System.in);
    ADTTheListInterface<Food> flist = new ADTTheList<>();

    MainMenu main = new MainMenu();

    public int classify = 10001;
    
   public void MakeScheduleOrder()
    {
        sc.distanceBetweenPlaces();
        //order part
        classify++;
        System.out.print("Please input Receiver Name                    :");
        String recName="";
        recName=scan.nextLine();
        input.addItem(recName);
        
        System.out.print("Please input Receiver Address                 :");
        String recAddress="";
        recAddress=scan.nextLine();
        input.addItem(recAddress);
        
       count=0;
        do{
             if(count>0)
              {
                  System.out.println("Date Not Valid");
              }
         System.out.print("Please input correct date (Format yyyy-MM-dd) :");
          temp = scan.nextLine();
         count++;
         }while(!isValidDate(temp)||!isAfterTodayDate(temp));
        
       count=0;
         input.addItem(temp);
        
         do{
             if(count>0)
              {
                  System.out.println("Time Not Valid");
              }
         System.out.print("Please input Available Time  (Format HH:MM)   :");
          temp = scan.nextLine();
         count++;
         
         }while(!checkTime(temp));
         count=0;
         input.addItem(temp);
        
        
        
         count=0;
         input.addItem(temp);
        Schedule schedule = new Schedule(id,input.getIndexItem(0),input.getIndexItem(1),
                input.getIndexItem(2),input.getIndexItem(3),sc.calculateDistance(RESTAURANT_NAME,input.getIndexItem(1)),classify);
        SC.addItem(schedule);
         System.out.println("\nYou Are successfully Make a Schedule Order, Your ID Is "+id+"\n");
         id++;
        System.out.println("Summary Of Registration Of Restaurant Owner");
        System.out.println("Receiver Name   : "+input.getIndexItem(0) );
        System.out.println("Receiver Address: "+ input.getIndexItem(1));
        System.out.println("Deliver Date    : "+ input.getIndexItem(2));
        System.out.println("Deliver Time    :"+ input.getIndexItem(3));
        System.out.println("\nPress any key to continue");
        input.clearAll();
        scan.nextLine();
       
    }
   
   public void viewTodayScheduleOrder(){
        
        sc.sortByDate(SC);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(); 
        String currentDateFormat = dateFormat.format(currentDate);
        if(!SC.isEmpty()){
            System.out.printf("%15s %15s %15s %15s %15s %15s\n","Receiver Name","Receiver Address","Date","Time","Cost of Petrol","Time Spent");
            System.out.printf("=================================================================================================\n");
        for (int i = 0; i < SC.getSize(); i++) {
        try {
            Date comp1 = dateFormat.parse(SC.getIndexItem(i).getDate());
            Date comp2 = dateFormat.parse(currentDateFormat);
            if (comp1.compareTo(comp2) == 0)
            {
                System.out.printf("%15s %15s %15s %15s  RM%12.2f %12smin\n",SC.getIndexItem(i).getReceiverName(),
                SC.getIndexItem(i).getReceiverAddress(),SC.getIndexItem(i).getDate(),
                SC.getIndexItem(i).getTime(),(SC.getIndexItem(i).getDistance())*2.3,(SC.getIndexItem(i).getDistance())*2+5);
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
        }else
                System.out.println("Nothing to be deliver today");
       
       
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
   public static boolean isAfterTodayDate(String inDate){
       if(!isValidDate(inDate)){
           System.out.println("Is not Valid Date");
           return false;
       }else{
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(); 
        String currentDateFormat = dateFormat.format(currentDate);
        
        try {
            Date comp1 = dateFormat.parse(inDate);
            Date comp2 = dateFormat.parse(currentDateFormat);
            if (comp1.compareTo(comp2) > 0) {
                return true;
        } else{
                System.out.println("The time should be after today");
            return false;
                
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       }
       
   }
   
   public static boolean checkExit(ADTTheListInterface<String> l)
   {
       ADTTheList f = (ADTTheList) l ;
       boolean exit = false;
       if(f.contains("exit"))
          exit=true;
       return exit;
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
   
   
   
  
   
   
    
}
